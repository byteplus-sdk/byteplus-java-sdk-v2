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
 * CreateTrafficMirrorSessionResponse
 */



public class CreateTrafficMirrorSessionResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("OrderId")
  private String orderId = null;

  @SerializedName("RequestId")
  private String requestId = null;

  @SerializedName("TrafficMirrorSessionId")
  private String trafficMirrorSessionId = null;

  public CreateTrafficMirrorSessionResponse orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * Get orderId
   * @return orderId
  **/
  @Schema(description = "")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public CreateTrafficMirrorSessionResponse requestId(String requestId) {
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

  public CreateTrafficMirrorSessionResponse trafficMirrorSessionId(String trafficMirrorSessionId) {
    this.trafficMirrorSessionId = trafficMirrorSessionId;
    return this;
  }

   /**
   * Get trafficMirrorSessionId
   * @return trafficMirrorSessionId
  **/
  @Schema(description = "")
  public String getTrafficMirrorSessionId() {
    return trafficMirrorSessionId;
  }

  public void setTrafficMirrorSessionId(String trafficMirrorSessionId) {
    this.trafficMirrorSessionId = trafficMirrorSessionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTrafficMirrorSessionResponse createTrafficMirrorSessionResponse = (CreateTrafficMirrorSessionResponse) o;
    return Objects.equals(this.orderId, createTrafficMirrorSessionResponse.orderId) &&
        Objects.equals(this.requestId, createTrafficMirrorSessionResponse.requestId) &&
        Objects.equals(this.trafficMirrorSessionId, createTrafficMirrorSessionResponse.trafficMirrorSessionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, requestId, trafficMirrorSessionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTrafficMirrorSessionResponse {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    trafficMirrorSessionId: ").append(toIndentedString(trafficMirrorSessionId)).append("\n");
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
