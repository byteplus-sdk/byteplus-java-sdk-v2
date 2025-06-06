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
 * FoundationModelForListBatchInferenceJobsInput
 */



public class FoundationModelForListBatchInferenceJobsInput {
  @SerializedName("ModelVersions")
  private List<String> modelVersions = null;

  @SerializedName("Name")
  private String name = null;

  public FoundationModelForListBatchInferenceJobsInput modelVersions(List<String> modelVersions) {
    this.modelVersions = modelVersions;
    return this;
  }

  public FoundationModelForListBatchInferenceJobsInput addModelVersionsItem(String modelVersionsItem) {
    if (this.modelVersions == null) {
      this.modelVersions = new ArrayList<String>();
    }
    this.modelVersions.add(modelVersionsItem);
    return this;
  }

   /**
   * Get modelVersions
   * @return modelVersions
  **/
  @Schema(description = "")
  public List<String> getModelVersions() {
    return modelVersions;
  }

  public void setModelVersions(List<String> modelVersions) {
    this.modelVersions = modelVersions;
  }

  public FoundationModelForListBatchInferenceJobsInput name(String name) {
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
    FoundationModelForListBatchInferenceJobsInput foundationModelForListBatchInferenceJobsInput = (FoundationModelForListBatchInferenceJobsInput) o;
    return Objects.equals(this.modelVersions, foundationModelForListBatchInferenceJobsInput.modelVersions) &&
        Objects.equals(this.name, foundationModelForListBatchInferenceJobsInput.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelVersions, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoundationModelForListBatchInferenceJobsInput {\n");
    
    sb.append("    modelVersions: ").append(toIndentedString(modelVersions)).append("\n");
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
