/*
 * ecs
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.ecs.model;

import java.util.Objects;
import java.util.Arrays;
import com.byteplus.ecs.model.ErrorForCreateTagsOutput;
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
 * OperationDetailForCreateTagsOutput
 */



public class OperationDetailForCreateTagsOutput {
  @SerializedName("Error")
  private ErrorForCreateTagsOutput error = null;

  @SerializedName("ResourceId")
  private String resourceId = null;

  public OperationDetailForCreateTagsOutput error(ErrorForCreateTagsOutput error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @Valid
  @Schema(description = "")
  public ErrorForCreateTagsOutput getError() {
    return error;
  }

  public void setError(ErrorForCreateTagsOutput error) {
    this.error = error;
  }

  public OperationDetailForCreateTagsOutput resourceId(String resourceId) {
    this.resourceId = resourceId;
    return this;
  }

   /**
   * Get resourceId
   * @return resourceId
  **/
  @Schema(description = "")
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationDetailForCreateTagsOutput operationDetailForCreateTagsOutput = (OperationDetailForCreateTagsOutput) o;
    return Objects.equals(this.error, operationDetailForCreateTagsOutput.error) &&
        Objects.equals(this.resourceId, operationDetailForCreateTagsOutput.resourceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, resourceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationDetailForCreateTagsOutput {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
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
