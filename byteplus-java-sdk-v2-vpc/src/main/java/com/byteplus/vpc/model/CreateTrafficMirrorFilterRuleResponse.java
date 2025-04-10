/*
 * vpc
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.vpc.model;

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
 * CreateTrafficMirrorFilterRuleResponse
 */



public class CreateTrafficMirrorFilterRuleResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("RequestId")
  private String requestId = null;

  @SerializedName("TrafficMirrorFilterRuleId")
  private String trafficMirrorFilterRuleId = null;

  public CreateTrafficMirrorFilterRuleResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @Schema(description = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public CreateTrafficMirrorFilterRuleResponse trafficMirrorFilterRuleId(String trafficMirrorFilterRuleId) {
    this.trafficMirrorFilterRuleId = trafficMirrorFilterRuleId;
    return this;
  }

   /**
   * Get trafficMirrorFilterRuleId
   * @return trafficMirrorFilterRuleId
  **/
  @Schema(description = "")
  public String getTrafficMirrorFilterRuleId() {
    return trafficMirrorFilterRuleId;
  }

  public void setTrafficMirrorFilterRuleId(String trafficMirrorFilterRuleId) {
    this.trafficMirrorFilterRuleId = trafficMirrorFilterRuleId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTrafficMirrorFilterRuleResponse createTrafficMirrorFilterRuleResponse = (CreateTrafficMirrorFilterRuleResponse) o;
    return Objects.equals(this.requestId, createTrafficMirrorFilterRuleResponse.requestId) &&
        Objects.equals(this.trafficMirrorFilterRuleId, createTrafficMirrorFilterRuleResponse.trafficMirrorFilterRuleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, trafficMirrorFilterRuleId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTrafficMirrorFilterRuleResponse {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    trafficMirrorFilterRuleId: ").append(toIndentedString(trafficMirrorFilterRuleId)).append("\n");
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
