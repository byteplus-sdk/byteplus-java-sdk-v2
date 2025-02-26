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
import com.byteplus.ark.model.ParametersForBatchChatCompletionsInput;
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
 * ConvertfunctionForBatchChatCompletionsInput
 */



public class ConvertfunctionForBatchChatCompletionsInput {
  @SerializedName("description")
  private String description = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("parameters")
  private ParametersForBatchChatCompletionsInput parameters = null;

  public ConvertfunctionForBatchChatCompletionsInput description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ConvertfunctionForBatchChatCompletionsInput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ConvertfunctionForBatchChatCompletionsInput parameters(ParametersForBatchChatCompletionsInput parameters) {
    this.parameters = parameters;
    return this;
  }

   /**
   * Get parameters
   * @return parameters
  **/
  @Valid
  @Schema(description = "")
  public ParametersForBatchChatCompletionsInput getParameters() {
    return parameters;
  }

  public void setParameters(ParametersForBatchChatCompletionsInput parameters) {
    this.parameters = parameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvertfunctionForBatchChatCompletionsInput convertfunctionForBatchChatCompletionsInput = (ConvertfunctionForBatchChatCompletionsInput) o;
    return Objects.equals(this.description, convertfunctionForBatchChatCompletionsInput.description) &&
        Objects.equals(this.name, convertfunctionForBatchChatCompletionsInput.name) &&
        Objects.equals(this.parameters, convertfunctionForBatchChatCompletionsInput.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, parameters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertfunctionForBatchChatCompletionsInput {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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
