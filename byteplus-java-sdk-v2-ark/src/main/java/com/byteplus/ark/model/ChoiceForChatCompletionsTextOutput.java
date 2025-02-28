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
import com.byteplus.ark.model.DeltaForChatCompletionsTextOutput;
import com.byteplus.ark.model.LogprobsForChatCompletionsTextOutput;
import com.byteplus.ark.model.MessageForChatCompletionsTextOutput;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * ChoiceForChatCompletionsTextOutput
 */



public class ChoiceForChatCompletionsTextOutput {
  @SerializedName("delta")
  private DeltaForChatCompletionsTextOutput delta = null;

  @SerializedName("finish_reason")
  private String finishReason = null;

  @SerializedName("index")
  private Integer index = null;

  @SerializedName("logprobs")
  private LogprobsForChatCompletionsTextOutput logprobs = null;

  @SerializedName("message")
  private MessageForChatCompletionsTextOutput message = null;

  public ChoiceForChatCompletionsTextOutput delta(DeltaForChatCompletionsTextOutput delta) {
    this.delta = delta;
    return this;
  }

   /**
   * Get delta
   * @return delta
  **/
  @Valid
  @Schema(description = "")
  public DeltaForChatCompletionsTextOutput getDelta() {
    return delta;
  }

  public void setDelta(DeltaForChatCompletionsTextOutput delta) {
    this.delta = delta;
  }

  public ChoiceForChatCompletionsTextOutput finishReason(String finishReason) {
    this.finishReason = finishReason;
    return this;
  }

   /**
   * Get finishReason
   * @return finishReason
  **/
  @Schema(description = "")
  public String getFinishReason() {
    return finishReason;
  }

  public void setFinishReason(String finishReason) {
    this.finishReason = finishReason;
  }

  public ChoiceForChatCompletionsTextOutput index(Integer index) {
    this.index = index;
    return this;
  }

   /**
   * Get index
   * @return index
  **/
  @Schema(description = "")
  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  public ChoiceForChatCompletionsTextOutput logprobs(LogprobsForChatCompletionsTextOutput logprobs) {
    this.logprobs = logprobs;
    return this;
  }

   /**
   * Get logprobs
   * @return logprobs
  **/
  @Valid
  @Schema(description = "")
  public LogprobsForChatCompletionsTextOutput getLogprobs() {
    return logprobs;
  }

  public void setLogprobs(LogprobsForChatCompletionsTextOutput logprobs) {
    this.logprobs = logprobs;
  }

  public ChoiceForChatCompletionsTextOutput message(MessageForChatCompletionsTextOutput message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @Valid
  @Schema(description = "")
  public MessageForChatCompletionsTextOutput getMessage() {
    return message;
  }

  public void setMessage(MessageForChatCompletionsTextOutput message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceForChatCompletionsTextOutput choiceForChatCompletionsTextOutput = (ChoiceForChatCompletionsTextOutput) o;
    return Objects.equals(this.delta, choiceForChatCompletionsTextOutput.delta) &&
        Objects.equals(this.finishReason, choiceForChatCompletionsTextOutput.finishReason) &&
        Objects.equals(this.index, choiceForChatCompletionsTextOutput.index) &&
        Objects.equals(this.logprobs, choiceForChatCompletionsTextOutput.logprobs) &&
        Objects.equals(this.message, choiceForChatCompletionsTextOutput.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delta, finishReason, index, logprobs, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceForChatCompletionsTextOutput {\n");
    
    sb.append("    delta: ").append(toIndentedString(delta)).append("\n");
    sb.append("    finishReason: ").append(toIndentedString(finishReason)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    logprobs: ").append(toIndentedString(logprobs)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
