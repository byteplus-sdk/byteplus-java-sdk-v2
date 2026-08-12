package com.byteplus.ark.runtime.model.content.generation;

import com.byteplus.ark.runtime.service.ArkService;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CreateContentGenerationTaskRequestTest {

    @Test
    public void serializesOutputFormatAndOmniReferenceTaskTypeWhenSet() throws Exception {
        CreateContentGenerationTaskRequest request = CreateContentGenerationTaskRequest.builder()
                .outputFormat("mp4")
                .omniReferenceTaskType("reference_to_video")
                .build();

        JsonNode json = ArkService.defaultObjectMapper().readTree(
                ArkService.defaultObjectMapper().writeValueAsString(request));

        assertEquals("mp4", json.get("output_format").asText());
        assertEquals("reference_to_video", json.get("omni_reference_task_type").asText());
    }

    @Test
    public void omitsOutputFormatAndOmniReferenceTaskTypeWhenUnset() throws Exception {
        JsonNode json = ArkService.defaultObjectMapper().readTree(
                ArkService.defaultObjectMapper().writeValueAsString(
                        CreateContentGenerationTaskRequest.builder().build()));

        assertFalse(json.has("output_format"));
        assertFalse(json.has("omni_reference_task_type"));
    }
}
