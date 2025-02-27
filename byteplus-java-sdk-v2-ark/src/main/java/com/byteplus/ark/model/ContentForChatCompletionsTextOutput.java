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
import com.byteplus.ark.model.TopLogprobForChatCompletionsTextOutput;
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
 * ContentForChatCompletionsTextOutput
 */



public class ContentForChatCompletionsTextOutput {
  @SerializedName("bytes")
  private List<Integer> bytes = null;

  @SerializedName("logprob")
  private Float logprob = null;

  @SerializedName("token")
  private String token = null;

  @SerializedName("top_logprobs")
  private List<TopLogprobForChatCompletionsTextOutput> topLogprobs = null;

  public ContentForChatCompletionsTextOutput bytes(List<Integer> bytes) {
    this.bytes = bytes;
    return this;
  }

  public ContentForChatCompletionsTextOutput addBytesItem(Integer bytesItem) {
    if (this.bytes == null) {
      this.bytes = new ArrayList<Integer>();
    }
    this.bytes.add(bytesItem);
    return this;
  }

   /**
   * Get bytes
   * @return bytes
  **/
  @Schema(description = "")
  public List<Integer> getBytes() {
    return bytes;
  }

  public void setBytes(List<Integer> bytes) {
    this.bytes = bytes;
  }

  public ContentForChatCompletionsTextOutput logprob(Float logprob) {
    this.logprob = logprob;
    return this;
  }

   /**
   * Get logprob
   * @return logprob
  **/
  @Schema(description = "")
  public Float getLogprob() {
    return logprob;
  }

  public void setLogprob(Float logprob) {
    this.logprob = logprob;
  }

  public ContentForChatCompletionsTextOutput token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  @Schema(description = "")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ContentForChatCompletionsTextOutput topLogprobs(List<TopLogprobForChatCompletionsTextOutput> topLogprobs) {
    this.topLogprobs = topLogprobs;
    return this;
  }

  public ContentForChatCompletionsTextOutput addTopLogprobsItem(TopLogprobForChatCompletionsTextOutput topLogprobsItem) {
    if (this.topLogprobs == null) {
      this.topLogprobs = new ArrayList<TopLogprobForChatCompletionsTextOutput>();
    }
    this.topLogprobs.add(topLogprobsItem);
    return this;
  }

   /**
   * Get topLogprobs
   * @return topLogprobs
  **/
  @Valid
  @Schema(description = "")
  public List<TopLogprobForChatCompletionsTextOutput> getTopLogprobs() {
    return topLogprobs;
  }

  public void setTopLogprobs(List<TopLogprobForChatCompletionsTextOutput> topLogprobs) {
    this.topLogprobs = topLogprobs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentForChatCompletionsTextOutput contentForChatCompletionsTextOutput = (ContentForChatCompletionsTextOutput) o;
    return Objects.equals(this.bytes, contentForChatCompletionsTextOutput.bytes) &&
        Objects.equals(this.logprob, contentForChatCompletionsTextOutput.logprob) &&
        Objects.equals(this.token, contentForChatCompletionsTextOutput.token) &&
        Objects.equals(this.topLogprobs, contentForChatCompletionsTextOutput.topLogprobs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bytes, logprob, token, topLogprobs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentForChatCompletionsTextOutput {\n");
    
    sb.append("    bytes: ").append(toIndentedString(bytes)).append("\n");
    sb.append("    logprob: ").append(toIndentedString(logprob)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    topLogprobs: ").append(toIndentedString(topLogprobs)).append("\n");
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
