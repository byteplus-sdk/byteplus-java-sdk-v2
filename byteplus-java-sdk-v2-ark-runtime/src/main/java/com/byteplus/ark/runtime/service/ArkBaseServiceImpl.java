package com.byteplus.ark.runtime.service;


import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionChunk;
import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionResult;
import com.byteplus.ark.runtime.model.content.generation.*;
import com.byteplus.ark.runtime.model.context.CreateContextRequest;
import com.byteplus.ark.runtime.model.context.CreateContextResult;
import com.byteplus.ark.runtime.model.context.chat.ContextChatCompletionRequest;
import com.byteplus.ark.runtime.model.images.generation.GenerateImagesRequest;
import com.byteplus.ark.runtime.model.images.generation.ImagesResponse;
import io.reactivex.Flowable;


public interface ArkBaseServiceImpl {

    ChatCompletionResult createChatCompletion(ChatCompletionRequest request);

    ChatCompletionResult createBatchChatCompletion(ChatCompletionRequest request);

    Flowable<ChatCompletionChunk> streamChatCompletion(ChatCompletionRequest request);

    CreateContextResult createContext(CreateContextRequest request);

    ChatCompletionResult createContextChatCompletion(ContextChatCompletionRequest request);

    Flowable<ChatCompletionChunk> streamContextChatCompletion(ContextChatCompletionRequest request);

    ImagesResponse generateImages(GenerateImagesRequest request);

    CreateContentGenerationTaskResult createContentGenerationTask(CreateContentGenerationTaskRequest request);

    GetContentGenerationTaskResponse getContentGenerationTask(GetContentGenerationTaskRequest request);

    ListContentGenerationTasksResponse listContentGenerationTasks(ListContentGenerationTasksRequest request);

    DeleteContentGenerationTaskResponse deleteContentGenerationTask(DeleteContentGenerationTaskRequest request);
}
