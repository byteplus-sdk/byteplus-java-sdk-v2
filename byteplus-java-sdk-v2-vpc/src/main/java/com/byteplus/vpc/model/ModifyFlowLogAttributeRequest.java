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
 * ModifyFlowLogAttributeRequest
 */



public class ModifyFlowLogAttributeRequest {
  @SerializedName("AggregationInterval")
  private Integer aggregationInterval = null;

  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("FlowLogId")
  private String flowLogId = null;

  @SerializedName("FlowLogName")
  private String flowLogName = null;

  public ModifyFlowLogAttributeRequest aggregationInterval(Integer aggregationInterval) {
    this.aggregationInterval = aggregationInterval;
    return this;
  }

   /**
   * Get aggregationInterval
   * @return aggregationInterval
  **/
  @Schema(description = "")
  public Integer getAggregationInterval() {
    return aggregationInterval;
  }

  public void setAggregationInterval(Integer aggregationInterval) {
    this.aggregationInterval = aggregationInterval;
  }

  public ModifyFlowLogAttributeRequest clientToken(String clientToken) {
    this.clientToken = clientToken;
    return this;
  }

   /**
   * Get clientToken
   * @return clientToken
  **/
  @Schema(description = "")
  public String getClientToken() {
    return clientToken;
  }

  public void setClientToken(String clientToken) {
    this.clientToken = clientToken;
  }

  public ModifyFlowLogAttributeRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
 @Size(max=255)  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ModifyFlowLogAttributeRequest flowLogId(String flowLogId) {
    this.flowLogId = flowLogId;
    return this;
  }

   /**
   * Get flowLogId
   * @return flowLogId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getFlowLogId() {
    return flowLogId;
  }

  public void setFlowLogId(String flowLogId) {
    this.flowLogId = flowLogId;
  }

  public ModifyFlowLogAttributeRequest flowLogName(String flowLogName) {
    this.flowLogName = flowLogName;
    return this;
  }

   /**
   * Get flowLogName
   * @return flowLogName
  **/
 @Size(min=1,max=128)  @Schema(description = "")
  public String getFlowLogName() {
    return flowLogName;
  }

  public void setFlowLogName(String flowLogName) {
    this.flowLogName = flowLogName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyFlowLogAttributeRequest modifyFlowLogAttributeRequest = (ModifyFlowLogAttributeRequest) o;
    return Objects.equals(this.aggregationInterval, modifyFlowLogAttributeRequest.aggregationInterval) &&
        Objects.equals(this.clientToken, modifyFlowLogAttributeRequest.clientToken) &&
        Objects.equals(this.description, modifyFlowLogAttributeRequest.description) &&
        Objects.equals(this.flowLogId, modifyFlowLogAttributeRequest.flowLogId) &&
        Objects.equals(this.flowLogName, modifyFlowLogAttributeRequest.flowLogName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregationInterval, clientToken, description, flowLogId, flowLogName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyFlowLogAttributeRequest {\n");
    
    sb.append("    aggregationInterval: ").append(toIndentedString(aggregationInterval)).append("\n");
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    flowLogId: ").append(toIndentedString(flowLogId)).append("\n");
    sb.append("    flowLogName: ").append(toIndentedString(flowLogName)).append("\n");
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
