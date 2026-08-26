package com.byteplus.llmshield;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionInfo {
    @JsonProperty("ImagePosition")
    private ImagePositionInfo imagePosition;

    public ImagePositionInfo getImagePosition() {
        return imagePosition;
    }

    public void setImagePosition(ImagePositionInfo imagePosition) {
        this.imagePosition = imagePosition;
    }
}
