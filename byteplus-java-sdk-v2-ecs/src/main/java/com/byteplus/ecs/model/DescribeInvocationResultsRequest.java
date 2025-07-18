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
 * DescribeInvocationResultsRequest
 */



public class DescribeInvocationResultsRequest {
  @SerializedName("CommandId")
  private String commandId = null;

  @SerializedName("InstanceId")
  private String instanceId = null;

  @SerializedName("InvocationId")
  private String invocationId = null;

  @SerializedName("InvocationResultStatus")
  private String invocationResultStatus = null;

  @SerializedName("PageNumber")
  private Integer pageNumber = null;

  @SerializedName("PageSize")
  private Integer pageSize = null;

  public DescribeInvocationResultsRequest commandId(String commandId) {
    this.commandId = commandId;
    return this;
  }

   /**
   * Get commandId
   * @return commandId
  **/
  @Schema(description = "")
  public String getCommandId() {
    return commandId;
  }

  public void setCommandId(String commandId) {
    this.commandId = commandId;
  }

  public DescribeInvocationResultsRequest instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * Get instanceId
   * @return instanceId
  **/
  @Schema(description = "")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public DescribeInvocationResultsRequest invocationId(String invocationId) {
    this.invocationId = invocationId;
    return this;
  }

   /**
   * Get invocationId
   * @return invocationId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getInvocationId() {
    return invocationId;
  }

  public void setInvocationId(String invocationId) {
    this.invocationId = invocationId;
  }

  public DescribeInvocationResultsRequest invocationResultStatus(String invocationResultStatus) {
    this.invocationResultStatus = invocationResultStatus;
    return this;
  }

   /**
   * Get invocationResultStatus
   * @return invocationResultStatus
  **/
  @Schema(description = "")
  public String getInvocationResultStatus() {
    return invocationResultStatus;
  }

  public void setInvocationResultStatus(String invocationResultStatus) {
    this.invocationResultStatus = invocationResultStatus;
  }

  public DescribeInvocationResultsRequest pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

   /**
   * Get pageNumber
   * @return pageNumber
  **/
  @Schema(description = "")
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public DescribeInvocationResultsRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * Get pageSize
   * @return pageSize
  **/
  @Schema(description = "")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInvocationResultsRequest describeInvocationResultsRequest = (DescribeInvocationResultsRequest) o;
    return Objects.equals(this.commandId, describeInvocationResultsRequest.commandId) &&
        Objects.equals(this.instanceId, describeInvocationResultsRequest.instanceId) &&
        Objects.equals(this.invocationId, describeInvocationResultsRequest.invocationId) &&
        Objects.equals(this.invocationResultStatus, describeInvocationResultsRequest.invocationResultStatus) &&
        Objects.equals(this.pageNumber, describeInvocationResultsRequest.pageNumber) &&
        Objects.equals(this.pageSize, describeInvocationResultsRequest.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commandId, instanceId, invocationId, invocationResultStatus, pageNumber, pageSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInvocationResultsRequest {\n");
    
    sb.append("    commandId: ").append(toIndentedString(commandId)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    invocationId: ").append(toIndentedString(invocationId)).append("\n");
    sb.append("    invocationResultStatus: ").append(toIndentedString(invocationResultStatus)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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
