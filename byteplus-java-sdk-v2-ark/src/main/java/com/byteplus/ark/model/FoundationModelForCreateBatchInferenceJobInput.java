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
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * FoundationModelForCreateBatchInferenceJobInput
 */



public class FoundationModelForCreateBatchInferenceJobInput {
  @SerializedName("ModelVersion")
  private String modelVersion = null;

  @SerializedName("Name")
  private String name = null;

  public FoundationModelForCreateBatchInferenceJobInput modelVersion(String modelVersion) {
    this.modelVersion = modelVersion;
    return this;
  }

   /**
   * Get modelVersion
   * @return modelVersion
  **/
  @Schema(description = "")
  public String getModelVersion() {
    return modelVersion;
  }

  public void setModelVersion(String modelVersion) {
    this.modelVersion = modelVersion;
  }

  public FoundationModelForCreateBatchInferenceJobInput name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoundationModelForCreateBatchInferenceJobInput foundationModelForCreateBatchInferenceJobInput = (FoundationModelForCreateBatchInferenceJobInput) o;
    return Objects.equals(this.modelVersion, foundationModelForCreateBatchInferenceJobInput.modelVersion) &&
        Objects.equals(this.name, foundationModelForCreateBatchInferenceJobInput.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelVersion, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoundationModelForCreateBatchInferenceJobInput {\n");
    
    sb.append("    modelVersion: ").append(toIndentedString(modelVersion)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
