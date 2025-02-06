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
import com.byteplus.ark.model.DatasetForCreateModelCustomizationJobInput;
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
 * ValidationSetForCreateModelCustomizationJobInput
 */



public class ValidationSetForCreateModelCustomizationJobInput {
  @SerializedName("Datasets")
  private List<DatasetForCreateModelCustomizationJobInput> datasets = null;

  @SerializedName("TosBucket")
  private String tosBucket = null;

  @SerializedName("TosPaths")
  private List<String> tosPaths = null;

  public ValidationSetForCreateModelCustomizationJobInput datasets(List<DatasetForCreateModelCustomizationJobInput> datasets) {
    this.datasets = datasets;
    return this;
  }

  public ValidationSetForCreateModelCustomizationJobInput addDatasetsItem(DatasetForCreateModelCustomizationJobInput datasetsItem) {
    if (this.datasets == null) {
      this.datasets = new ArrayList<DatasetForCreateModelCustomizationJobInput>();
    }
    this.datasets.add(datasetsItem);
    return this;
  }

   /**
   * Get datasets
   * @return datasets
  **/
  @Valid
  @Schema(description = "")
  public List<DatasetForCreateModelCustomizationJobInput> getDatasets() {
    return datasets;
  }

  public void setDatasets(List<DatasetForCreateModelCustomizationJobInput> datasets) {
    this.datasets = datasets;
  }

  public ValidationSetForCreateModelCustomizationJobInput tosBucket(String tosBucket) {
    this.tosBucket = tosBucket;
    return this;
  }

   /**
   * Get tosBucket
   * @return tosBucket
  **/
  @Schema(description = "")
  public String getTosBucket() {
    return tosBucket;
  }

  public void setTosBucket(String tosBucket) {
    this.tosBucket = tosBucket;
  }

  public ValidationSetForCreateModelCustomizationJobInput tosPaths(List<String> tosPaths) {
    this.tosPaths = tosPaths;
    return this;
  }

  public ValidationSetForCreateModelCustomizationJobInput addTosPathsItem(String tosPathsItem) {
    if (this.tosPaths == null) {
      this.tosPaths = new ArrayList<String>();
    }
    this.tosPaths.add(tosPathsItem);
    return this;
  }

   /**
   * Get tosPaths
   * @return tosPaths
  **/
  @Schema(description = "")
  public List<String> getTosPaths() {
    return tosPaths;
  }

  public void setTosPaths(List<String> tosPaths) {
    this.tosPaths = tosPaths;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationSetForCreateModelCustomizationJobInput validationSetForCreateModelCustomizationJobInput = (ValidationSetForCreateModelCustomizationJobInput) o;
    return Objects.equals(this.datasets, validationSetForCreateModelCustomizationJobInput.datasets) &&
        Objects.equals(this.tosBucket, validationSetForCreateModelCustomizationJobInput.tosBucket) &&
        Objects.equals(this.tosPaths, validationSetForCreateModelCustomizationJobInput.tosPaths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datasets, tosBucket, tosPaths);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationSetForCreateModelCustomizationJobInput {\n");
    
    sb.append("    datasets: ").append(toIndentedString(datasets)).append("\n");
    sb.append("    tosBucket: ").append(toIndentedString(tosBucket)).append("\n");
    sb.append("    tosPaths: ").append(toIndentedString(tosPaths)).append("\n");
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
