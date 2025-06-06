package com.byteplus.ark.runtime.model.completion.chat;

import com.byteplus.ark.runtime.model.Usage;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatCompletionChunk {
    /**
     * Unique id assigned to this chat completion.
     */
    String id;

    /**
     * The type of object returned, should be "chat.completion.chunk"
     */
    String object;

    /**
     * The creation time in epoch seconds.
     */
    long created;

    /**
     * The model used.
     */
    String model;

    /**
     * Specifies the latency tier to use for processing the request.
     *
     *     This parameter is relevant for customers subscribed to the scale tier service:
     *
     *     - If set to 'auto', and the endpoint is Scale tier enabled, the system will
     *       utilize scale tier credits until they are exhausted.
     *     - If set to 'auto', and the endpoint is not Scale tier enabled, the request will
     *       be processed using the default service tier with a lower uptime SLA and no
     *       latency guarentee.
     *     - If set to 'default', the request will be processed using the default service
     *       tier with a lower uptime SLA and no latency guarentee.
     *     - When not set, the default behavior is 'auto'.
     *
     *     When this parameter is set, the response body will include the `service_tier`
     *     utilized.
     */
    @JsonAlias("service_tier")
    String serviceTier;

    /**
     * A list of all generated completions.
     */
    List<ChatCompletionChoice> choices;

    /**
     * The API usage for this request.
     */
    Usage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getServiceTier() {
        return serviceTier;
    }

    public void setServiceTier(String serviceTier) {
        this.serviceTier = serviceTier;
    }

    public List<ChatCompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ChatCompletionChoice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "ChatCompletionChunk{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", model='" + model + '\'' +
                ", service_tier='" + serviceTier + '\'' +
                ", choices=" + choices +
                ", usage=" + usage +
                '}';
    }
}