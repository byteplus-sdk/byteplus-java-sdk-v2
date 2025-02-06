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
 * InputFileTosLocationForListBatchInferenceJobsOutput
 */



public class InputFileTosLocationForListBatchInferenceJobsOutput {
  @SerializedName("BucketName")
  private String bucketName = null;

  @SerializedName("ObjectKey")
  private String objectKey = null;

  public InputFileTosLocationForListBatchInferenceJobsOutput bucketName(String bucketName) {
    this.bucketName = bucketName;
    return this;
  }

   /**
   * Get bucketName
   * @return bucketName
  **/
  @Schema(description = "")
  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }

  public InputFileTosLocationForListBatchInferenceJobsOutput objectKey(String objectKey) {
    this.objectKey = objectKey;
    return this;
  }

   /**
   * Get objectKey
   * @return objectKey
  **/
  @Schema(description = "")
  public String getObjectKey() {
    return objectKey;
  }

  public void setObjectKey(String objectKey) {
    this.objectKey = objectKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputFileTosLocationForListBatchInferenceJobsOutput inputFileTosLocationForListBatchInferenceJobsOutput = (InputFileTosLocationForListBatchInferenceJobsOutput) o;
    return Objects.equals(this.bucketName, inputFileTosLocationForListBatchInferenceJobsOutput.bucketName) &&
        Objects.equals(this.objectKey, inputFileTosLocationForListBatchInferenceJobsOutput.objectKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketName, objectKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputFileTosLocationForListBatchInferenceJobsOutput {\n");
    
    sb.append("    bucketName: ").append(toIndentedString(bucketName)).append("\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
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
