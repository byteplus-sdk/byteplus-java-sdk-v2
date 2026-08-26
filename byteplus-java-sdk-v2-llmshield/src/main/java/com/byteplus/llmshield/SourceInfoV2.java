package com.byteplus.llmshield;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SourceInfoV2 {
    @JsonProperty("Source")
    private String source;

    @JsonProperty("SourceDetail")
    private Map<String, String> sourceDetail;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, String> getSourceDetail() {
        return sourceDetail;
    }

    public void setSourceDetail(Map<String, String> sourceDetail) {
        this.sourceDetail = sourceDetail;
    }
}
