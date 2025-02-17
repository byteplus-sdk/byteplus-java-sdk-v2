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
import com.byteplus.ecs.model.ErrorForUpdateSystemEventsOutput;
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
 * OperationDetailForUpdateSystemEventsOutput
 */



public class OperationDetailForUpdateSystemEventsOutput {
  @SerializedName("Error")
  private ErrorForUpdateSystemEventsOutput error = null;

  @SerializedName("EventId")
  private String eventId = null;

  public OperationDetailForUpdateSystemEventsOutput error(ErrorForUpdateSystemEventsOutput error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @Valid
  @Schema(description = "")
  public ErrorForUpdateSystemEventsOutput getError() {
    return error;
  }

  public void setError(ErrorForUpdateSystemEventsOutput error) {
    this.error = error;
  }

  public OperationDetailForUpdateSystemEventsOutput eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

   /**
   * Get eventId
   * @return eventId
  **/
  @Schema(description = "")
  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationDetailForUpdateSystemEventsOutput operationDetailForUpdateSystemEventsOutput = (OperationDetailForUpdateSystemEventsOutput) o;
    return Objects.equals(this.error, operationDetailForUpdateSystemEventsOutput.error) &&
        Objects.equals(this.eventId, operationDetailForUpdateSystemEventsOutput.eventId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, eventId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationDetailForUpdateSystemEventsOutput {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
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
