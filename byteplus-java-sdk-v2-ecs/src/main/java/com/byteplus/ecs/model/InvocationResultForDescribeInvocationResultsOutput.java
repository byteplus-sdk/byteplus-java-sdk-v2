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
 * InvocationResultForDescribeInvocationResultsOutput
 */



public class InvocationResultForDescribeInvocationResultsOutput {
  @SerializedName("CommandId")
  private String commandId = null;

  @SerializedName("EndTime")
  private String endTime = null;

  @SerializedName("ErrorCode")
  private String errorCode = null;

  @SerializedName("ErrorMessage")
  private String errorMessage = null;

  @SerializedName("ExitCode")
  private Integer exitCode = null;

  @SerializedName("InstanceId")
  private String instanceId = null;

  @SerializedName("InvocationId")
  private String invocationId = null;

  @SerializedName("InvocationResultId")
  private String invocationResultId = null;

  @SerializedName("InvocationResultStatus")
  private String invocationResultStatus = null;

  @SerializedName("Output")
  private String output = null;

  @SerializedName("StartTime")
  private String startTime = null;

  @SerializedName("Username")
  private String username = null;

  public InvocationResultForDescribeInvocationResultsOutput commandId(String commandId) {
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

  public InvocationResultForDescribeInvocationResultsOutput endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @Schema(description = "")
  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public InvocationResultForDescribeInvocationResultsOutput errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

   /**
   * Get errorCode
   * @return errorCode
  **/
  @Schema(description = "")
  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public InvocationResultForDescribeInvocationResultsOutput errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

   /**
   * Get errorMessage
   * @return errorMessage
  **/
  @Schema(description = "")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public InvocationResultForDescribeInvocationResultsOutput exitCode(Integer exitCode) {
    this.exitCode = exitCode;
    return this;
  }

   /**
   * Get exitCode
   * @return exitCode
  **/
  @Schema(description = "")
  public Integer getExitCode() {
    return exitCode;
  }

  public void setExitCode(Integer exitCode) {
    this.exitCode = exitCode;
  }

  public InvocationResultForDescribeInvocationResultsOutput instanceId(String instanceId) {
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

  public InvocationResultForDescribeInvocationResultsOutput invocationId(String invocationId) {
    this.invocationId = invocationId;
    return this;
  }

   /**
   * Get invocationId
   * @return invocationId
  **/
  @Schema(description = "")
  public String getInvocationId() {
    return invocationId;
  }

  public void setInvocationId(String invocationId) {
    this.invocationId = invocationId;
  }

  public InvocationResultForDescribeInvocationResultsOutput invocationResultId(String invocationResultId) {
    this.invocationResultId = invocationResultId;
    return this;
  }

   /**
   * Get invocationResultId
   * @return invocationResultId
  **/
  @Schema(description = "")
  public String getInvocationResultId() {
    return invocationResultId;
  }

  public void setInvocationResultId(String invocationResultId) {
    this.invocationResultId = invocationResultId;
  }

  public InvocationResultForDescribeInvocationResultsOutput invocationResultStatus(String invocationResultStatus) {
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

  public InvocationResultForDescribeInvocationResultsOutput output(String output) {
    this.output = output;
    return this;
  }

   /**
   * Get output
   * @return output
  **/
  @Schema(description = "")
  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }

  public InvocationResultForDescribeInvocationResultsOutput startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @Schema(description = "")
  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public InvocationResultForDescribeInvocationResultsOutput username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @Schema(description = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvocationResultForDescribeInvocationResultsOutput invocationResultForDescribeInvocationResultsOutput = (InvocationResultForDescribeInvocationResultsOutput) o;
    return Objects.equals(this.commandId, invocationResultForDescribeInvocationResultsOutput.commandId) &&
        Objects.equals(this.endTime, invocationResultForDescribeInvocationResultsOutput.endTime) &&
        Objects.equals(this.errorCode, invocationResultForDescribeInvocationResultsOutput.errorCode) &&
        Objects.equals(this.errorMessage, invocationResultForDescribeInvocationResultsOutput.errorMessage) &&
        Objects.equals(this.exitCode, invocationResultForDescribeInvocationResultsOutput.exitCode) &&
        Objects.equals(this.instanceId, invocationResultForDescribeInvocationResultsOutput.instanceId) &&
        Objects.equals(this.invocationId, invocationResultForDescribeInvocationResultsOutput.invocationId) &&
        Objects.equals(this.invocationResultId, invocationResultForDescribeInvocationResultsOutput.invocationResultId) &&
        Objects.equals(this.invocationResultStatus, invocationResultForDescribeInvocationResultsOutput.invocationResultStatus) &&
        Objects.equals(this.output, invocationResultForDescribeInvocationResultsOutput.output) &&
        Objects.equals(this.startTime, invocationResultForDescribeInvocationResultsOutput.startTime) &&
        Objects.equals(this.username, invocationResultForDescribeInvocationResultsOutput.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commandId, endTime, errorCode, errorMessage, exitCode, instanceId, invocationId, invocationResultId, invocationResultStatus, output, startTime, username);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvocationResultForDescribeInvocationResultsOutput {\n");
    
    sb.append("    commandId: ").append(toIndentedString(commandId)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    exitCode: ").append(toIndentedString(exitCode)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    invocationId: ").append(toIndentedString(invocationId)).append("\n");
    sb.append("    invocationResultId: ").append(toIndentedString(invocationResultId)).append("\n");
    sb.append("    invocationResultStatus: ").append(toIndentedString(invocationResultStatus)).append("\n");
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
