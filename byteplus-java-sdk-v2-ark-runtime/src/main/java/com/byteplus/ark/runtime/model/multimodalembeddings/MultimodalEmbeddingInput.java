package com.byteplus.ark.runtime.model.multimodalembeddings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultimodalEmbeddingInput {

    private String type;

    private String text;

    MultiModalEmbeddingContentPartImageURL imageUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultiModalEmbeddingContentPartImageURL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(MultiModalEmbeddingContentPartImageURL imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "MultiModalEmbeddingInput{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", imageUrl=" + imageUrl +
                '}';
    }

    public static class MultiModalEmbeddingContentPartImageURL {
        String url;

        String detail;

        public MultiModalEmbeddingContentPartImageURL(String url, String detail) {
            this.url = url;
            this.detail = detail;
        }

        public MultiModalEmbeddingContentPartImageURL(String url) {
            this.url = url;
        }

        public MultiModalEmbeddingContentPartImageURL() {
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @Override
        public String toString() {
            return "MultiModalEmbeddingContentPartImageURL{" +
                    "url='" + url + '\'' +
                    ", detail='" + detail + '\'' +
                    '}';
        }
    }

    public static final class Builder {
        private String type;
        private String text;
        private MultiModalEmbeddingContentPartImageURL imageUrl;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder imageUrl(MultiModalEmbeddingContentPartImageURL imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public MultimodalEmbeddingInput build() {
            MultimodalEmbeddingInput multiModalEmbeddingInput = new MultimodalEmbeddingInput();
            multiModalEmbeddingInput.setType(type);
            multiModalEmbeddingInput.setText(text);
            multiModalEmbeddingInput.setImageUrl(imageUrl);
            return multiModalEmbeddingInput;
        }
    }
}
