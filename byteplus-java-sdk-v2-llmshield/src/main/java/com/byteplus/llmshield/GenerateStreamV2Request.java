package com.byteplus.llmshield;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// 生成请求类
public class GenerateStreamV2Request {
    @JsonProperty("MsgID")
    private String msgID;

    @JsonIgnore
    private boolean useStream;

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    @Deprecated
    @JsonIgnore
    public boolean isUseStream() {
        return useStream;
    }

    @Deprecated
    @JsonIgnore
    public void setUseStream(boolean useStream) {
        this.useStream = useStream;
    }
}














