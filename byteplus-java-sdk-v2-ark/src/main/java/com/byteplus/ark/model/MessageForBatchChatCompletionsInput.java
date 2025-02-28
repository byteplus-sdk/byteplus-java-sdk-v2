/*
 * ark
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.ark.model;

import java.util.Objects;
import java.util.Arrays;
import com.byteplus.ark.model.ToolCallForBatchChatCompletionsInput;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * MessageForBatchChatCompletionsInput
 */



public class MessageForBatchChatCompletionsInput {
  @SerializedName("content")
  private String content = null;

  /**
   * Gets or Sets role
   */
  @JsonAdapter(RoleEnum.Adapter.class)
  public enum RoleEnum {
    @SerializedName("system")
    SYSTEM("system"),
    @SerializedName("user")
    USER("user"),
    @SerializedName("assistant")
    ASSISTANT("assistant"),
    @SerializedName("tool")
    TOOL("tool");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static RoleEnum fromValue(String input) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<RoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public RoleEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return RoleEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("role")
  private RoleEnum role = null;

  @SerializedName("tool_call_id")
  private String toolCallId = null;

  @SerializedName("tool_calls")
  private List<ToolCallForBatchChatCompletionsInput> toolCalls = null;

  public MessageForBatchChatCompletionsInput content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Get content
   * @return content
  **/
  @Schema(description = "")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public MessageForBatchChatCompletionsInput role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @Schema(description = "")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public MessageForBatchChatCompletionsInput toolCallId(String toolCallId) {
    this.toolCallId = toolCallId;
    return this;
  }

   /**
   * Get toolCallId
   * @return toolCallId
  **/
  @Schema(description = "")
  public String getToolCallId() {
    return toolCallId;
  }

  public void setToolCallId(String toolCallId) {
    this.toolCallId = toolCallId;
  }

  public MessageForBatchChatCompletionsInput toolCalls(List<ToolCallForBatchChatCompletionsInput> toolCalls) {
    this.toolCalls = toolCalls;
    return this;
  }

  public MessageForBatchChatCompletionsInput addToolCallsItem(ToolCallForBatchChatCompletionsInput toolCallsItem) {
    if (this.toolCalls == null) {
      this.toolCalls = new ArrayList<ToolCallForBatchChatCompletionsInput>();
    }
    this.toolCalls.add(toolCallsItem);
    return this;
  }

   /**
   * Get toolCalls
   * @return toolCalls
  **/
  @Valid
  @Schema(description = "")
  public List<ToolCallForBatchChatCompletionsInput> getToolCalls() {
    return toolCalls;
  }

  public void setToolCalls(List<ToolCallForBatchChatCompletionsInput> toolCalls) {
    this.toolCalls = toolCalls;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageForBatchChatCompletionsInput messageForBatchChatCompletionsInput = (MessageForBatchChatCompletionsInput) o;
    return Objects.equals(this.content, messageForBatchChatCompletionsInput.content) &&
        Objects.equals(this.role, messageForBatchChatCompletionsInput.role) &&
        Objects.equals(this.toolCallId, messageForBatchChatCompletionsInput.toolCallId) &&
        Objects.equals(this.toolCalls, messageForBatchChatCompletionsInput.toolCalls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, role, toolCallId, toolCalls);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageForBatchChatCompletionsInput {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    toolCallId: ").append(toIndentedString(toolCallId)).append("\n");
    sb.append("    toolCalls: ").append(toIndentedString(toolCalls)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
