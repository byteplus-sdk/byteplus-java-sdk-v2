package com.byteplus.ark.runtime;

import com.byteplus.ark.runtime.model.multimodalembeddings.MultimodalEmbeddingInput;
import com.byteplus.ark.runtime.model.multimodalembeddings.MultimodalEmbeddingRequest;
import com.byteplus.ark.runtime.service.ArkService;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BatchMultiModalEmbeddingsExample {

    public static void main(String[] args) {
        // set a timeout for batch inference
        Duration timeout = Duration.ofHours(1);
        int maxConcurrency = 3;
        int taskNumPerWorker = 10;
        String apiKey = System.getenv("ARK_API_KEY");
        ConnectionPool connectionPool = new ConnectionPool(maxConcurrency, 10, TimeUnit.MINUTES);

        Dispatcher dispatcher = new Dispatcher();
        // set max parallel for batch inference
        dispatcher.setMaxRequests(maxConcurrency);
        dispatcher.setMaxRequestsPerHost(maxConcurrency);

        // Please create a separate service instance specifically for batch chat,
        // and ensure that multiple Endpoints do not reuse the same service instance
        // to prevent mutual interference.
        // Each individual service will start a corresponding thread pool based on
        // the maximum concurrency limit, which will occupy a certain amount of resources.
        ArkService service = ArkService.builder()
                .dispatcher(dispatcher)
                .timeout(timeout)
                .connectionPool(connectionPool)
                .apiKey(apiKey)
                .build();

        ExecutorService executorService = Executors.newFixedThreadPool(maxConcurrency);
        CountDownLatch latch = new CountDownLatch(maxConcurrency);
        Runnable batchEmbeddingTask = () -> {
            System.out.println("Executing task in " + Thread.currentThread().getName());
            for (int i = 0; i < taskNumPerWorker; i++) {
                try {
                    final List<MultimodalEmbeddingInput> input = new ArrayList<>();
                    input.add(MultimodalEmbeddingInput.builder()
                            .type("text")
                            .text("What is the weather like today?")
                            .build()
                    );
                    input.add(MultimodalEmbeddingInput.builder()
                            .type("image_url")
                            .imageUrl(new MultimodalEmbeddingInput.MultiModalEmbeddingContentPartImageURL("https://ark-project.tos-cn-beijing.volces.com/images/view.jpeg"))
                            .build()
                    );

                    MultimodalEmbeddingRequest batchEmbeddingsRequest = MultimodalEmbeddingRequest.builder()
                            .model("${YOUR_ENDPOINT_ID}")
                            .input(input)
                            .build();

                    service.createBatchMultiModalEmbeddings(batchEmbeddingsRequest);
                    System.out.println(Thread.currentThread().getName() + ": request " + i + " succeed");
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + ": request " + i + " failed " + e.getMessage());
                }
            }
            System.out.println(Thread.currentThread().getName() + " done");
            latch.countDown();
        };
        for (int i = 0; i < maxConcurrency; i++) {
            executorService.submit(batchEmbeddingTask);
        }
        try {
            latch.await();
        } catch (InterruptedException ignored) {
        }
        System.out.println("all threads finished");
        executorService.shutdown();
        System.out.println("thread pool shutdown");

        // shutdown service after all requests is finished
        service.shutdownExecutor();
    }

}
