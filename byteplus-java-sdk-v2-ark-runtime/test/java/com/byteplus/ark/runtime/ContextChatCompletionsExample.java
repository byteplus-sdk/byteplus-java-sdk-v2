package com.byteplus.ark.runtime;

import com.byteplus.ark.runtime.model.completion.chat.ChatCompletionResult;
import com.byteplus.ark.runtime.model.completion.chat.ChatMessage;
import com.byteplus.ark.runtime.model.completion.chat.ChatMessageRole;
import com.byteplus.ark.runtime.model.context.CreateContextRequest;
import com.byteplus.ark.runtime.model.context.CreateContextResult;
import com.byteplus.ark.runtime.model.context.chat.ContextChatCompletionRequest;
import com.byteplus.ark.runtime.service.ArkService;

import java.util.Collections;

public class ContextChatCompletionsExample {

    /**
     * Authentication
     * 1.If you authorize your endpoint using an API key, you can set your api key to environment variable "ARK_API_KEY"
     * String apiKey = System.getenv("ARK_API_KEY");
     * ArkService service = new ArkService(apiKey);
     * Note: If you use an API key, this API key will not be refreshed.
     * To prevent the API from expiring and failing after some time, choose an API key with no expiration date.
     *
     * 2.If you authorize your endpoint with Byteplus Identity and Access Management（IAM), set your api key to environment variable "BYTEPLUS_ACCESSKEY", "BYTEPLUS_SECRETKEY"
     * String ak = System.getenv("BYTEPLUS_ACCESSKEY");
     * String sk = System.getenv("BYTEPLUS_SECRETKEY");
     * ArkService service = new ArkService(ak, sk);
     * To get your ak&sk, please refer to this document(https://www.volcengine.com/docs/6291/65568)
     * For more information，please check this document（https://www.volcengine.com/docs/82379/1263279）
     */
    public static void main(String[] args) {

        String apiKey =  System.getenv("ARK_API_KEY");
        ArkService service = new ArkService(apiKey);

        System.out.println("\n----- create context -----");
        CreateContextRequest createContextRequest = CreateContextRequest.builder()
                .model("${YOUR_ENDPOINT_ID}")
                .mode(Const.CONTEXT_MODE_SESSION)
                .messages(Collections.singletonList(ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("You are Francis, a helpful AI assistant").build()))
                .ttl(3600)
                .build();

        CreateContextResult createContextResult = service.createContext(createContextRequest);
        System.out.println("created context, id = " + createContextResult.getId());

        System.out.println("\n----- chat round 1 (non-stream) -----");

        ContextChatCompletionRequest chatCompletionRequest = ContextChatCompletionRequest.builder()
                .contextId(createContextResult.getId())
                .model("${YOUR_ENDPOINT_ID}")
                .messages(Collections.singletonList(ChatMessage.builder().role(ChatMessageRole.USER).content("I am Jack.").build()))
                .build();

        ChatCompletionResult chatCompletionResult =  service.createContextChatCompletion(chatCompletionRequest);
        chatCompletionResult.getChoices().forEach(choice -> System.out.println(choice.getMessage().getContent()));

        System.out.println("\n----- chat round 2 (stream) -----");
        ContextChatCompletionRequest streamChatCompletionRequest = ContextChatCompletionRequest.builder()
                .contextId(createContextResult.getId())
                .model("YOUR_ENDPOINT_ID")
                .messages(Collections.singletonList(ChatMessage.builder().role(ChatMessageRole.USER).content("Who am I?").build()))
                .build();

        service.streamContextChatCompletion(streamChatCompletionRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(
                        choice -> {
                            if (!choice.getChoices().isEmpty()) {
                                System.out.print(choice.getChoices().get(0).getMessage().getContent());
                            }
                        }
                );

        // shutdown service
        service.shutdownExecutor();
    }
}
