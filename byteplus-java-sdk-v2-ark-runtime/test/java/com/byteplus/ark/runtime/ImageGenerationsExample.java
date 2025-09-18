package com.byteplus.ark.runtime;

import com.byteplus.ark.runtime.model.images.generation.GenerateImagesRequest;
import com.byteplus.ark.runtime.model.images.generation.ImagesResponse;
import com.byteplus.ark.runtime.model.images.generation.ResponseFormat;
import com.byteplus.ark.runtime.model.images.generation.Size;
import com.byteplus.ark.runtime.service.ArkService;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ImageGenerationsExample {

    /**
     * Authentication
     * 1. If you authorize your endpoint using an API key, set the API key to environment variable "ARK_API_KEY"
     *    String apiKey = System.getenv("ARK_API_KEY");
     *    ArkService service = new ArkService(apiKey);
     *    Note: Choose an API key with no expiration date to prevent failures due to expiration.
     */

    static String apiKey = System.getenv("ARK_API_KEY");
    static ConnectionPool connectionPool = new ConnectionPool(5, 1, TimeUnit.SECONDS);
    static Dispatcher dispatcher = new Dispatcher();
    static ArkService service = ArkService.builder().dispatcher(dispatcher).connectionPool(connectionPool).apiKey(apiKey).build();

    public static void main(String[] args) {
        String model = "YOUR_ENDPOINT_ID";

        System.out.println("\n----- [Seedream] Generate Images Request -----");

        GenerateImagesRequest generateRequest = GenerateImagesRequest.builder()
                .model(model)   // Replace with your Seedream endpoint ID
                .prompt("Bird soaring above vast grasslands")
                .responseFormat(ResponseFormat.Url)
                .seed(1234567890)
                .watermark(true)
                .size("1024x1024")
                .build();

        System.out.println(generateRequest.toString());
        // send create request
        ImagesResponse imagesResponse = service.generateImages(generateRequest);
        System.out.println(imagesResponse.getData().get(0).getUrl());

        System.out.println("\n----- [Seededit] Generate Images Request -----");

        generateRequest = GenerateImagesRequest.builder()
               .model(model)   // Replace with your Seededit endpoint ID
               .prompt("Bird soaring above vast grasslands")
               .image("YOUR_IMAGE_URL")
               .responseFormat(ResponseFormat.Url)
               .seed(1234567890)
               .watermark(true)
               .size("1024x1024")
               .build();

        System.out.println(generateRequest.toString());
        // send create request
        imagesResponse = service.generateImages(generateRequest);
        System.out.println(imagesResponse.getData().get(0).getUrl());

        System.out.println("\n----- [Seedream] Streaming Generate Images Request -----");

        GenerateImagesRequest.SequentialImageGenerationOptions sequentialImageGenerationOptions = new GenerateImagesRequest.SequentialImageGenerationOptions();
        sequentialImageGenerationOptions.setMaxImages(9);

        // If you use this parameter, Seededit will be used instead of Seedream.
        String[] imageUrls = {
                "YOUR_IMAGE_URL_HERE",
                "YOUR_IMAGE_URL_HERE"
        };

        generateRequest = GenerateImagesRequest.builder()
                .model(model)    // Replace with your Seedream endpoint ID
                .prompt("Bird soaring above vast grasslands")
                .responseFormat(ResponseFormat.Url)
                .image(Arrays.asList(imageUrls))    // If you use this function, Seededit will be used instead of Seedream.
                .seed(1234567890)
                .watermark(true)
                .size("1024x1024")
                .sequentialImageGeneration("auto")
                .sequentialImageGenerationOptions(sequentialImageGenerationOptions)
                .stream(true)
                .build();

        System.out.println(generateRequest.toString());

        service.streamGenerateImages(generateRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(
                        choice -> {
                            if (choice == null) return;

                            if ("image_generation.partial_failed".equals(choice.getType())) {
                                if (choice.getError() != null) {
                                    System.err.println("Stream generate images error: " + choice.getError());
                                    if (choice.getError().getCode() != null && choice.getError().getCode().equals("InternalServiceError")) {
                                        throw new RuntimeException("Server error, terminating stream.");
                                    }
                                }
                            }

                            else if ("image_generation.partial_succeeded".equals(choice.getType())) {
                                if (choice.getError() == null && choice.getUrl() != null && !choice.getUrl().isEmpty()) {
                                    System.out.printf("recv.Size: %s, recv.Url: %s%n", choice.getSize(), choice.getUrl());
                                }
                            }

                            else if ("image_generation.completed".equals(choice.getType())) {
                                if (choice.getError() == null && choice.getUsage() != null) {
                                    System.out.println("recv.Usage: " + choice.getUsage().toString());
                                }
                            }
                        }
                );

        service.shutdownExecutor();
    }
}
