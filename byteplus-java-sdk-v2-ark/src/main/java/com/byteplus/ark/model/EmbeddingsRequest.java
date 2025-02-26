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
 * EmbeddingsRequest
 */



public class EmbeddingsRequest {
  @SerializedName("encoding_format")
  private String encodingFormat = null;

  @SerializedName("input")
  private List<String> input = null;

  @SerializedName("model")
  private String model = null;

  public EmbeddingsRequest encodingFormat(String encodingFormat) {
    this.encodingFormat = encodingFormat;
    return this;
  }

   /**
   * Get encodingFormat
   * @return encodingFormat
  **/
  @Schema(description = "")
  public String getEncodingFormat() {
    return encodingFormat;
  }

  public void setEncodingFormat(String encodingFormat) {
    this.encodingFormat = encodingFormat;
  }

  public EmbeddingsRequest input(List<String> input) {
    this.input = input;
    return this;
  }

  public EmbeddingsRequest addInputItem(String inputItem) {
    if (this.input == null) {
      this.input = new ArrayList<String>();
    }
    this.input.add(inputItem);
    return this;
  }

   /**
   * Get input
   * @return input
  **/
  @Schema(description = "")
  public List<String> getInput() {
    return input;
  }

  public void setInput(List<String> input) {
    this.input = input;
  }

  public EmbeddingsRequest model(String model) {
    this.model = model;
    return this;
  }

   /**
   * Get model
   * @return model
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmbeddingsRequest embeddingsRequest = (EmbeddingsRequest) o;
    return Objects.equals(this.encodingFormat, embeddingsRequest.encodingFormat) &&
        Objects.equals(this.input, embeddingsRequest.input) &&
        Objects.equals(this.model, embeddingsRequest.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encodingFormat, input, model);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmbeddingsRequest {\n");
    
    sb.append("    encodingFormat: ").append(toIndentedString(encodingFormat)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
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
