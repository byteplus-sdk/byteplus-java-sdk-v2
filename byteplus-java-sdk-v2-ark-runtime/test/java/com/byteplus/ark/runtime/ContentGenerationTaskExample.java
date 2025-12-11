package com.byteplus.ark.runtime;

import com.byteplus.ark.runtime.model.content.generation.*;
import com.byteplus.ark.runtime.model.content.generation.CreateContentGenerationTaskRequest.Content;
import com.byteplus.ark.runtime.model.content.generation.DeleteContentGenerationTaskResponse;
import com.byteplus.ark.runtime.service.ArkService;
import com.byteplus.ark.runtime.exception.ArkHttpException;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContentGenerationTaskExample {

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
        String model = "${MODEL EP_ID HERE}";

        System.out.println("\n----- CREATE Task Request -----");
        List<Content> contents = new ArrayList<>();

        // Text content
        contents.add(Content.builder()
                .type("text")
                .text("Bird soaring above vast grasslands")
                .build());

        // Image URL content
        contents.add(Content.builder()
                .type("image_url")
                .imageUrl(CreateContentGenerationTaskRequest.ImageUrl.builder()
                        .url("${IMAGE URL HERE}")
                        .build())
                .build());

        CreateContentGenerationTaskRequest createRequest = CreateContentGenerationTaskRequest.builder()
                .model(model)
                .content(contents)
                .serviceTier("default")
                .executionExpiresAfter(3600L)
//                .callbackUrl("${YOUR_CALLBACK_URL}")
                .build();

        // send create request
        CreateContentGenerationTaskResult createResult = service.createContentGenerationTask(createRequest);
        System.out.println(createResult);

        System.out.println("\n----- GET Task Request -----");

        GetContentGenerationTaskRequest getRequest = GetContentGenerationTaskRequest.builder()
                .taskId(createResult.getId())
                .build();

        GetContentGenerationTaskResponse getResult = service.getContentGenerationTask(getRequest);
        System.out.println(getResult);

        System.out.println("\n----- LIST Task Request -----");

            ListContentGenerationTasksRequest listRequest = ListContentGenerationTasksRequest.builder()
                    .pageNum(1)
                    .pageSize(10)
                    .status(TaskStatus.RUNNING)
                    .addTaskId(createResult.getId())
                    .model(model)
                    .serviceTier("default")
                    .build();

        ListContentGenerationTasksResponse listResponse = service.listContentGenerationTasks(listRequest);
        System.out.println(listResponse);

        System.out.println("\n----- DELETE Task Request -----");

        DeleteContentGenerationTaskRequest deleteRequest = DeleteContentGenerationTaskRequest.builder()
                .taskId(getResult.getId())
                .build();

            try {
                DeleteContentGenerationTaskResponse deleteResult = service.deleteContentGenerationTask(deleteRequest);
                System.out.println(deleteResult);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (ArkHttpException e) {
            System.out.println("HTTP status=" + e.statusCode + ", code=" + e.code + ", msg=" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        System.out.println("\n----- CREATE Flex Task Request -----");
        List<Content> flexContents = new ArrayList<>();

        // Text content
        flexContents.add(Content.builder()
                .type("text")
                .text("Bird soaring above vast grasslands")
                .build());

        // Image URL content
        flexContents.add(Content.builder()
                .type("image_url")
                .imageUrl(CreateContentGenerationTaskRequest.ImageUrl.builder()
                        .url("${IMAGE URL HERE}")
                        .build())
                .build());

        CreateContentGenerationTaskRequest flexCreateRequest = CreateContentGenerationTaskRequest.builder()
                .model(model)
                .content(flexContents)
                .serviceTier("flex")
                .executionExpiresAfter(3600L)
//                .callbackUrl("${YOUR_CALLBACK_URL}")
                .build();

        // send create request
        CreateContentGenerationTaskResult flexCreateResult;
        try {
            flexCreateResult = service.createContentGenerationTask(flexCreateRequest);
            System.out.println(flexCreateResult);
        } catch (ArkHttpException e) {
            System.out.println("HTTP status=" + e.statusCode + ", code=" + e.code + ", msg=" + e.getMessage());
            service.shutdownExecutor();
            return;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            service.shutdownExecutor();
            return;
        }

        System.out.println("\n----- GET Flex Task Request -----");

        GetContentGenerationTaskRequest flexGetRequest = GetContentGenerationTaskRequest.builder()
                .taskId(flexCreateResult.getId())
                .build();

        try {
            GetContentGenerationTaskResponse flexGetResult = service.getContentGenerationTask(flexGetRequest);
            System.out.println(flexGetResult);
            System.out.println("service_tier=" + flexGetResult.getServiceTier() + ", execution_expires_after=" + flexGetResult.getExecutionExpiresAfter());

            System.out.println("\n----- LIST Flex Task Request -----");

            ListContentGenerationTasksRequest flexListRequest = ListContentGenerationTasksRequest.builder()
                    .pageNum(1)
                    .pageSize(10)
                    .status(TaskStatus.RUNNING)
                    .addTaskId(flexCreateResult.getId())
                    .model(model)
                    .serviceTier("flex")
                    .build();

            ListContentGenerationTasksResponse flexListResponse = service.listContentGenerationTasks(flexListRequest);
            System.out.println(flexListResponse);

            System.out.println("\n----- DELETE Flex Task Request -----");

            DeleteContentGenerationTaskRequest flexDeleteRequest = DeleteContentGenerationTaskRequest.builder()
                    .taskId(flexGetResult.getId())
                    .build();

            try {
                DeleteContentGenerationTaskResponse flexDeleteResult = service.deleteContentGenerationTask(flexDeleteRequest);
                System.out.println(flexDeleteResult);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (ArkHttpException e) {
            System.out.println("HTTP status=" + e.statusCode + ", code=" + e.code + ", msg=" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        service.shutdownExecutor();
    }
}
