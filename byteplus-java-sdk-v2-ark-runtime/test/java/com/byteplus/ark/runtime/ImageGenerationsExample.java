package com.byteplus.ark.runtime;

import com.byteplus.ark.runtime.model.content.generation.*;
import com.byteplus.ark.runtime.model.images.generation.GenerateImagesRequest;
import com.byteplus.ark.runtime.model.images.generation.ImagesResponse;
import com.byteplus.ark.runtime.model.images.generation.ResponseFormat;
import com.byteplus.ark.runtime.service.ArkService;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;

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

        System.out.println("\n----- Generate Images Request -----");

        GenerateImagesRequest generateRequest = GenerateImagesRequest.builder()
                .model(model)
                .prompt("Dragon soaring above vast grasslands")
                .responseFormat(ResponseFormat.Url)
                .seed(1234567890)
                .watermark(true)
                .size("512x512")
                .guidanceScale(2.5)
                .build();

        System.out.println(generateRequest.toString());
        // send create request
        ImagesResponse imagesResponse = service.generateImages(generateRequest);
        System.out.println(imagesResponse.getData().get(0).getUrl());

        service.shutdownExecutor();
    }
}
