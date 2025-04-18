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
 * CreateScheduledInstancesResponse
 */



public class CreateScheduledInstancesResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("ScheduledInstanceId")
  private String scheduledInstanceId = null;

  public CreateScheduledInstancesResponse scheduledInstanceId(String scheduledInstanceId) {
    this.scheduledInstanceId = scheduledInstanceId;
    return this;
  }

   /**
   * Get scheduledInstanceId
   * @return scheduledInstanceId
  **/
  @Schema(description = "")
  public String getScheduledInstanceId() {
    return scheduledInstanceId;
  }

  public void setScheduledInstanceId(String scheduledInstanceId) {
    this.scheduledInstanceId = scheduledInstanceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateScheduledInstancesResponse createScheduledInstancesResponse = (CreateScheduledInstancesResponse) o;
    return Objects.equals(this.scheduledInstanceId, createScheduledInstancesResponse.scheduledInstanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scheduledInstanceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateScheduledInstancesResponse {\n");
    
    sb.append("    scheduledInstanceId: ").append(toIndentedString(scheduledInstanceId)).append("\n");
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
