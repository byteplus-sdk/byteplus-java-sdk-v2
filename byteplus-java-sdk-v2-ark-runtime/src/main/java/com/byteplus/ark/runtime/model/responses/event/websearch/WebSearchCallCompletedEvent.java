package com.byteplus.ark.runtime.model.responses.event.websearch;

import com.byteplus.ark.runtime.model.responses.constant.ResponsesConstants;
import com.byteplus.ark.runtime.model.responses.event.ItemEvent;
import com.byteplus.ark.runtime.model.responses.event.OutputEvent;

public class WebSearchCallCompletedEvent extends ItemEvent {

    public WebSearchCallCompletedEvent() {
        super(ResponsesConstants.EVENT_TYPE_RESPONSE_WEB_SEARCH_CALL_COMPLETED);
    }

    @Override
    public String toString() {
        return "WebSearchCallCompletedEvent{" +
                "type='" + getType() + '\'' +
                ", sequenceNumber=" + getSequenceNumber() +
                ", itemId='" + getItemId() + '\'' +
                ", outputIndex=" + getOutputIndex() +
                '}';
    }


}