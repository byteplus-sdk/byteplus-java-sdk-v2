package com.byteplus.ark.runtime.service;


import com.byteplus.ark.runtime.model.content.generation.*;
import com.byteplus.ark.runtime.model.images.generation.GenerateImagesRequest;
import com.byteplus.ark.runtime.model.images.generation.ImagesResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.byteplus.ark.runtime.*;
import com.byteplus.ark.runtime.exception.ArkAPIError;
import com.byteplus.ark.runtime.exception.ArkException;
import com.byteplus.ark.runtime.exception.ArkHttpException;
import com.byteplus.ark.runtime.interceptor.AuthenticationInterceptor;
import com.byteplus.ark.runtime.interceptor.ArkResourceStsAuthenticationInterceptor;
import com.byteplus.ark.runtime.interceptor.RequestIdInterceptor;
import com.byteplus.ark.runtime.interceptor.RetryInterceptor;
import com.byteplus.ark.runtime.interceptor.*;
import com.byteplus.ark.runtime.model.completion.chat.*;
import com.byteplus.ark.runtime.model.context.CreateContextRequest;
import com.byteplus.ark.runtime.model.context.CreateContextResult;
import com.byteplus.ark.runtime.model.context.chat.ContextChatCompletionRequest;
import com.byteplus.ark.runtime.utils.ResponseBodyCallback;
import com.byteplus.ark.runtime.utils.SSE;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Single;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.Retrofit;

import java.io.IOException;
import java.net.Proxy;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public class ArkService extends ArkBaseService implements ArkBaseServiceImpl {
    private static final ObjectMapper mapper = defaultObjectMapper();
    private final ArkApi api;
    private final ExecutorService executorService;

    public ArkService(final String apiKey) {
        this(apiKey, DEFAULT_TIMEOUT);
    }

    public ArkService(final String apiKey, final Duration timeout) {
        ObjectMapper mapper = defaultObjectMapper();
        OkHttpClient client = defaultApiKeyClient(apiKey, timeout);
        Retrofit retrofit = defaultRetrofit(client, mapper, BASE_URL);

        this.api = retrofit.create(ArkApi.class);
        this.executorService = client.dispatcher().executorService();
    }

    public ArkService(final String ak, final String sk) {
        this(ak, sk, DEFAULT_TIMEOUT);
    }

    public ArkService(final String ak, final String sk, final Duration timeout) {
        ObjectMapper mapper = defaultObjectMapper();
        OkHttpClient client = defaultResourceStsClient(ak, sk, timeout, BASE_REGION);
        Retrofit retrofit = defaultRetrofit(client, mapper, BASE_URL);

        this.api = retrofit.create(ArkApi.class);
        this.executorService = client.dispatcher().executorService();
    }

    public ArkService(final ArkApi api) {
        this.api = api;
        this.executorService = null;
    }

    public ArkService(final ArkApi api, final ExecutorService executorService) {
        this.api = api;
        this.executorService = executorService;
    }

    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return mapper;
    }

    public static OkHttpClient defaultApiKeyClient(String apiKey, Duration timeout) {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(apiKey))
                .addInterceptor(new RequestIdInterceptor())
                .addInterceptor(new RetryInterceptor(DEFAULT_RETRY_TIMES))
                .connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
                .readTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                .build();
    }

    public static OkHttpClient defaultResourceStsClient(String ak, String sk, Duration timeout, String region) {
        return new OkHttpClient.Builder()
                .addInterceptor(new ArkResourceStsAuthenticationInterceptor(ak, sk, region))
                .addInterceptor(new RequestIdInterceptor())
                .addInterceptor(new RetryInterceptor(DEFAULT_RETRY_TIMES))
                .connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
                .readTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                .build();
    }

    public static Retrofit defaultRetrofit(OkHttpClient client, ObjectMapper mapper, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static <T> T execute(Single<T> apiCall) {
        try {
            T resp = apiCall.blockingGet();
            return resp;
        } catch (HttpException e) {
            String requestId = "";
            try {
                Headers headers = e.response().raw().request().headers();
                requestId = headers.get(Const.CLIENT_REQUEST_HEADER);
            } catch (Exception ignored) {}

            try {
                if (e.response() == null || e.response().errorBody() == null) {
                    throw e;
                }
                String errorBody = e.response().errorBody().string();

                ArkAPIError error = mapper.readValue(errorBody, ArkAPIError.class);
                throw new ArkHttpException(error, e, e.code(), requestId);
            } catch (IOException ex) {
                throw e;
            }
        }
    }

    public static Flowable<SSE> stream(Call<ResponseBody> apiCall) {
        return stream(apiCall, false);
    }

    public static Flowable<SSE> stream(Call<ResponseBody> apiCall, boolean emitDone) {
        return Flowable.create(emitter -> apiCall.enqueue(new ResponseBodyCallback(emitter, emitDone)), BackpressureStrategy.BUFFER);
    }

    public static <T> Flowable<T> stream(Call<ResponseBody> apiCall, Class<T> cl) {
        return stream(apiCall).map(sse -> mapper.readValue(sse.getData(), cl));
    }

    public ChatCompletionResult createChatCompletion(ChatCompletionRequest request) {
        return execute(api.createChatCompletion(request, request.getModel(), new HashMap<>()));
    }

    public ChatCompletionResult createChatCompletion(ChatCompletionRequest request, Map<String, String> customHeaders) {
        return execute(api.createChatCompletion(request, request.getModel(), customHeaders));
    }

    public ChatCompletionResult createBatchChatCompletion(ChatCompletionRequest request) {
        return execute(api.createBatchChatCompletion(request, request.getModel(), new HashMap<>()));
    }

    public Flowable<ChatCompletionChunk> streamChatCompletion(ChatCompletionRequest request) {
        request.setStream(true);

        return stream(api.createChatCompletionStream(request, request.getModel(), new HashMap<>()), ChatCompletionChunk.class);
    }

    public Flowable<ChatCompletionChunk> streamChatCompletion(ChatCompletionRequest request, Map<String, String> customHeaders) {
        request.setStream(true);

        return stream(api.createChatCompletionStream(request, request.getModel(), customHeaders), ChatCompletionChunk.class);
    }

    @Override
    public CreateContextResult createContext(CreateContextRequest request) {
        return execute(api.createContext(request, request.getModel(), new HashMap<>()));
    }

    public CreateContextResult createContext(CreateContextRequest request, Map<String, String> customHeaders) {
        return execute(api.createContext(request, request.getModel(), customHeaders));
    }

    @Override
    public ChatCompletionResult createContextChatCompletion(ContextChatCompletionRequest request) {
        return execute(api.createContextChatCompletion(request, request.getModel(), new HashMap<>()));
    }

    public ChatCompletionResult createContextChatCompletion(ContextChatCompletionRequest request, Map<String, String> customHeaders) {
        return execute(api.createContextChatCompletion(request, request.getModel(), customHeaders));
    }

    @Override
    public Flowable<ChatCompletionChunk> streamContextChatCompletion(ContextChatCompletionRequest request) {
        request.setStream(true);
        return stream(api.createContextChatCompletionStream(request, request.getModel(), new HashMap<>()), ChatCompletionChunk.class);
    }

    public Flowable<ChatCompletionChunk> streamContextChatCompletion(ContextChatCompletionRequest request, Map<String, String> customHeaders) {
        request.setStream(true);
        return stream(api.createContextChatCompletionStream(request, request.getModel(), customHeaders), ChatCompletionChunk.class);
    }


    public ImagesResponse generateImages(GenerateImagesRequest request) {
        return execute(api.generateImages(request, request.getModel(), new HashMap<>()));
    }

    public CreateContentGenerationTaskResult createContentGenerationTask(CreateContentGenerationTaskRequest request) {
        return execute(api.createContentGenerationTask(request, request.getModel(), new HashMap<>()));
    }

    public CreateContentGenerationTaskResult createContentGenerationTask(CreateContentGenerationTaskRequest request, Map<String, String> customHeaders) {
        return execute(api.createContentGenerationTask(request, request.getModel(), customHeaders));
    }


    public GetContentGenerationTaskResponse getContentGenerationTask(GetContentGenerationTaskRequest request) {
        return execute(api.getContentGenerationTask(request.getTaskId(), new HashMap<>()));
    }

    public GetContentGenerationTaskResponse getContentGenerationTask(GetContentGenerationTaskRequest request, Map<String, String> customHeaders) {
        return execute(api.getContentGenerationTask(request.getTaskId(), customHeaders));
    }

    @Override
    public ListContentGenerationTasksResponse listContentGenerationTasks(ListContentGenerationTasksRequest request) {
        return execute(
                api.listContentGenerationTasks(
                        request.getPageNum(),
                        request.getPageSize(),
                        request.getStatus(),
                        request.getModel(),
                        request.getTaskIds(),
                        new HashMap<>()
                )
        );
    }

    public ListContentGenerationTasksResponse listContentGenerationTasks(
            ListContentGenerationTasksRequest request,
            Map<String, String> customHeaders
    ) {
        return execute(
                api.listContentGenerationTasks(
                        request.getPageNum(),
                        request.getPageSize(),
                        request.getStatus(),
                        request.getModel(),
                        request.getTaskIds(),
                        customHeaders
                )
        );
    }


    public DeleteContentGenerationTaskResponse deleteContentGenerationTask(DeleteContentGenerationTaskRequest request) {
        return execute(api.deleteContentGenerationTask(request.getTaskId(), new HashMap<>()));
    }

    public DeleteContentGenerationTaskResponse deleteContentGenerationTask(DeleteContentGenerationTaskRequest request, Map<String, String> customHeaders) {
        return execute(api.deleteContentGenerationTask(request.getTaskId(), customHeaders));
    }


    public void shutdownExecutor() {
        Objects.requireNonNull(this.executorService, "executorService must be set in order to shut down");
        this.executorService.shutdown();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String ak;
        private String sk;
        private String apiKey;
        private String region = BASE_REGION;
        private String baseUrl = BASE_URL;
        private Duration timeout = DEFAULT_TIMEOUT;
        private Duration connectTimeout = DEFAULT_CONNECT_TIMEOUT;
        private int retryTimes = DEFAULT_RETRY_TIMES;
        private Proxy proxy;
        private ConnectionPool connectionPool;
        private Dispatcher dispatcher;

        public Builder ak(String ak) {
            this.ak = ak;
            return this;
        }

        public Builder sk(String sk) {
            this.sk = sk;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            if (!baseUrl.endsWith("/")) {
                this.baseUrl = baseUrl + "/";
            }
            return this;
        }

        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder retryTimes(int retryTimes) {
            this.retryTimes = retryTimes;
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public ArkService build() {
            ObjectMapper mapper = defaultObjectMapper();
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            if (apiKey != null && apiKey.length() > 0) {
                clientBuilder.addInterceptor(new AuthenticationInterceptor(apiKey));
            } else if (ak != null && sk != null && ak.length() > 0 && sk.length() > 0) {
                clientBuilder.addInterceptor(new ArkResourceStsAuthenticationInterceptor(ak, sk, region));
            } else {
                throw new ArkException("missing api_key or ak&sk.");
            }

            if (proxy != null) {
                clientBuilder.proxy(proxy);
            }

            if (connectionPool != null) {
                clientBuilder.connectionPool(connectionPool);
            } else {
                clientBuilder.connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS));
            }

            if (dispatcher != null) {
                clientBuilder.dispatcher(dispatcher);
            }

            OkHttpClient client = clientBuilder
                    .addInterceptor(new RequestIdInterceptor())
                    .addInterceptor(new RetryInterceptor(retryTimes))
                    .addInterceptor(new BatchInterceptor())
                    .readTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                    .callTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                    .connectTimeout(connectTimeout)
                    .build();
            Retrofit retrofit = defaultRetrofit(client, mapper, baseUrl);

            return new ArkService(
                    retrofit.create(ArkApi.class),
                    client.dispatcher().executorService()
            );
        }
    }
}
