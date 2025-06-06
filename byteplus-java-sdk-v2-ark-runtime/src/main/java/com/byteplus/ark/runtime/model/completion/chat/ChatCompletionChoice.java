package com.byteplus.ark.runtime.model.completion.chat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatCompletionChoice {

    /**
     * This index of this completion in the returned list.
     */
    Integer index;

    /**
     * The assistant message or delta (when streaming) which was generated
     */
    @JsonAlias("delta")
    ChatMessage message;

    /**
     * The reason why GPT stopped generating, for example "length".
     */
    @JsonProperty("finish_reason")
    String finishReason;

    /**
     * The type of content moderation service hit.
     */
    @JsonProperty("moderation_hit_type")
    String moderationHitType;

    /**
     * Log probability information for the choice.
     */
    @JsonProperty("logprobs")
    ChatCompletionChoiceLogprob logprobs;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public void setModerationHitType(String moderationHitType) {
        this.moderationHitType = moderationHitType;
    }

    public String getModerationHitType() {
        return moderationHitType;
    }

    public ChatCompletionChoiceLogprob getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(ChatCompletionChoiceLogprob logprobs) {
        this.logprobs = logprobs;
    }

    @Override
    public String toString() {
        return "ChatCompletionChoice{" +
                "index=" + index +
                ", message=" + message +
                ", finishReason='" + finishReason + '\'' +
                ", moderationHitType='" + moderationHitType + '\'' +
                ", logprobs=" + logprobs +
                '}';
    }
}
