package com.byteplus.ark.runtime.service;


import com.byteplus.ark.runtime.model.content.generation.ListContentGenerationTasksRequest;
import com.byteplus.ark.runtime.model.content.generation.ListContentGenerationTasksResponse;

import java.time.Duration;


/**
 * The interface ark service.
 */
public abstract class ArkBaseService {

    public static final String BASE_URL = "https://ark.ap-southeast.bytepluses.com";
    public static final String BASE_REGION = "ap-southeast-1";
    public static final Duration DEFAULT_TIMEOUT = Duration.ofMinutes(10);
    public static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofMinutes(1);
    public static final int DEFAULT_RETRY_TIMES = 2;
}
