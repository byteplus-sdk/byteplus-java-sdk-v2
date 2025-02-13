package com.byteplus.ark.runtime.service;

import com.byteplus.ark.runtime.Const;
import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionResult;
import com.byteplus.ark.runtime.model.context.CreateContextRequest;
import com.byteplus.ark.runtime.model.context.CreateContextResult;
import com.byteplus.ark.runtime.model.context.chat.ContextChatCompletionRequest;
import okhttp3.ResponseBody;
import retrofit2.http.*;
import retrofit2.Call;
import io.reactivex.Single;

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
}
