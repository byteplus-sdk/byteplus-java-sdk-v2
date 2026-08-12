package com.byteplus.ark.runtime.model.content.generation;

import com.byteplus.ark.runtime.service.ArkService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetContentGenerationTaskResponseTest {

    @Test
    public void deserializesOutputFormatAndKeepsIntegerDuration() throws Exception {
        GetContentGenerationTaskResponse response = ArkService.defaultObjectMapper().readValue(
                "{\"output_format\":\"mp4\",\"duration\":5}",
                GetContentGenerationTaskResponse.class);

        assertEquals("mp4", response.getOutputFormat());
        assertEquals(Long.valueOf(5L), response.getDuration());
    }
}
