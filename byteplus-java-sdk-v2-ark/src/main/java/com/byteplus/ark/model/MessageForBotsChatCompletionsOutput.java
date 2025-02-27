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
import com.byteplus.ark.model.ConverttoolCallForBotsChatCompletionsOutput;
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
 * MessageForBotsChatCompletionsOutput
 */



public class MessageForBotsChatCompletionsOutput {
  @SerializedName("content")
  private String content = null;

  @SerializedName("role")
  private String role = null;

  @SerializedName("tool_calls")
  private List<ConverttoolCallForBotsChatCompletionsOutput> toolCalls = null;

  public MessageForBotsChatCompletionsOutput content(String content) {
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

  public MessageForBotsChatCompletionsOutput role(String role) {
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @Schema(description = "")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public MessageForBotsChatCompletionsOutput toolCalls(List<ConverttoolCallForBotsChatCompletionsOutput> toolCalls) {
    this.toolCalls = toolCalls;
    return this;
  }

  public MessageForBotsChatCompletionsOutput addToolCallsItem(ConverttoolCallForBotsChatCompletionsOutput toolCallsItem) {
    if (this.toolCalls == null) {
      this.toolCalls = new ArrayList<ConverttoolCallForBotsChatCompletionsOutput>();
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
  public List<ConverttoolCallForBotsChatCompletionsOutput> getToolCalls() {
    return toolCalls;
  }

  public void setToolCalls(List<ConverttoolCallForBotsChatCompletionsOutput> toolCalls) {
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
    MessageForBotsChatCompletionsOutput messageForBotsChatCompletionsOutput = (MessageForBotsChatCompletionsOutput) o;
    return Objects.equals(this.content, messageForBotsChatCompletionsOutput.content) &&
        Objects.equals(this.role, messageForBotsChatCompletionsOutput.role) &&
        Objects.equals(this.toolCalls, messageForBotsChatCompletionsOutput.toolCalls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, role, toolCalls);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageForBotsChatCompletionsOutput {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
