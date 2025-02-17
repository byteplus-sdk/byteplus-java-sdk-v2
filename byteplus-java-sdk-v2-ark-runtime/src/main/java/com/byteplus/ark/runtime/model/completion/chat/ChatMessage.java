package com.byteplus.ark.runtime.model.completion.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.byteplus.ark.runtime.utils.Converter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {

	ChatMessageRole role;

	Object content;

	private String name;
	@JsonProperty("function_call")
	ChatFunctionCall functionCall;

	@JsonProperty("tool_calls")
	List<ChatToolCall> toolCalls;

	@JsonProperty("tool_call_id")
	String toolCallId;

	public ChatMessageRole getRole() {
		return role;
	}

	public void setRole(ChatMessageRole role) {
		this.role = role;
	}

	public Object getContent() {
		return content;
	}

	public String stringContent() {
		return String.class.cast(content);
	}

	public List<ChatCompletionContentPart> multiContent() {
		return Converter.castList(content, ChatCompletionContentPart.class);
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChatFunctionCall getFunctionCall() {
		return functionCall;
	}

	public void setFunctionCall(ChatFunctionCall functionCall) {
		this.functionCall = functionCall;
	}

	public List<ChatToolCall> getToolCalls() {
		return toolCalls;
	}

	public void setToolCalls(List<ChatToolCall> toolCalls) {
		this.toolCalls = toolCalls;
	}

	public String getToolCallId() {
		return toolCallId;
	}

	public void setToolCallId(String toolCallId) {
		this.toolCallId = toolCallId;
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "ChatMessage{" +
				"role=" + role +
				", content='" + content + '\'' +
				", name='" + name + '\'' +
				", functionCall=" + functionCall +
				", toolCalls=" + toolCalls +
				", toolCallId='" + toolCallId + '\'' +
				'}';
	}

	public static class Builder {

		private ChatMessageRole role;

		private Object content;

		private String name;
		@JsonProperty("function_call")
		private ChatFunctionCall functionCall;

		@JsonProperty("tool_calls")
		private List<ChatToolCall> toolCalls;

		@JsonProperty("tool_call_id")
		private String toolCallId;

		public Builder role(ChatMessageRole role) {
			this.role = role;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public Builder multiContent(List<ChatCompletionContentPart> multiContent) {
			this.content = multiContent;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder functionCall(ChatFunctionCall functionCall) {
			this.functionCall = functionCall;
			return this;
		}

		public Builder toolCalls(List<ChatToolCall> toolCalls) {
			this.toolCalls = toolCalls;
			return this;
		}

		public Builder toolCallId(String toolCallId) {
			this.toolCallId = toolCallId;
			return this;
		}

		public ChatMessage build() {
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setRole(role);
			chatMessage.setContent(content);
			chatMessage.setName(name);
			chatMessage.setFunctionCall(functionCall);
			chatMessage.setToolCalls(toolCalls);
			chatMessage.setToolCallId(toolCallId);
			return chatMessage;
		}
	}
}
