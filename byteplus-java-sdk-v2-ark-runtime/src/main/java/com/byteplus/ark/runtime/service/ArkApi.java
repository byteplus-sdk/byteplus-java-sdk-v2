package com.byteplus.ark.runtime.service;

import com.byteplus.ark.runtime.Const;
import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionResult;
import com.byteplus.ark.runtime.model.content.generation.*;
import com.byteplus.ark.runtime.model.context.CreateContextRequest;
import com.byteplus.ark.runtime.model.context.CreateContextResult;
import com.byteplus.ark.runtime.model.context.chat.ContextChatCompletionRequest;
import com.byteplus.ark.runtime.model.images.generation.GenerateImagesRequest;
import com.byteplus.ark.runtime.model.images.generation.ImagesResponse;
import okhttp3.ResponseBody;
import retrofit2.http.*;
import retrofit2.Call;
import io.reactivex.Single;

import java.util.List;
import java.util.Map;

public interface ArkApi {

    @POST("/api/v3/chat/completions")
    Single<ChatCompletionResult> createChatCompletion(@Body ChatCompletionRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @POST("/api/v3/batch/chat/completions")
    Single<ChatCompletionResult> createBatchChatCompletion(@Body ChatCompletionRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @Streaming
    @POST("/api/v3/chat/completions")
    Call<ResponseBody> createChatCompletionStream(@Body ChatCompletionRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @POST("/api/v3/context/create")
    Single<CreateContextResult> createContext(@Body CreateContextRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @POST("/api/v3/context/chat/completions")
    Single<ChatCompletionResult> createContextChatCompletion(@Body ContextChatCompletionRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @Streaming
    @POST("/api/v3/context/chat/completions")
    Call<ResponseBody> createContextChatCompletionStream(@Body ContextChatCompletionRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @POST("/api/v3/images/generations")
    Single<ImagesResponse> generateImages(@Body GenerateImagesRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @POST("/api/v3/contents/generations/tasks")
    Single<CreateContentGenerationTaskResult> createContentGenerationTask(@Body CreateContentGenerationTaskRequest request, @Header(Const.REQUEST_MODEL) String model, @HeaderMap Map<String, String> customHeaders);

    @GET("/api/v3/contents/generations/tasks/{taskId}")
    Single<GetContentGenerationTaskResponse> getContentGenerationTask(@Path("taskId") String taskId, @HeaderMap Map<String, String> customHeaders);

    @GET("/api/v3/contents/generations/tasks")
    Single<ListContentGenerationTasksResponse> listContentGenerationTasks(
            @Query("page_num") int pageNum,
            @Query("page_size") int pageSize,
            @Query("filter.status") String status,
            @Query("filter.model") String model,
            @Query("filter.task_ids") List<String> taskIds,
            @HeaderMap Map<String, String> customHeaders
    );

    @DELETE("/api/v3/contents/generations/tasks/{taskId}")
    Single<DeleteContentGenerationTaskResponse> deleteContentGenerationTask(@Path("taskId") String taskId, @HeaderMap Map<String, String> customHeaders);
}
