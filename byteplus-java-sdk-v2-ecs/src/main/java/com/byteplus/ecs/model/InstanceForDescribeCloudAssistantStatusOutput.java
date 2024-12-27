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
 * InstanceForDescribeCloudAssistantStatusOutput
 */



public class InstanceForDescribeCloudAssistantStatusOutput {
  @SerializedName("ClientVersion")
  private String clientVersion = null;

  @SerializedName("HostName")
  private String hostName = null;

  @SerializedName("InstanceId")
  private String instanceId = null;

  @SerializedName("InstanceName")
  private String instanceName = null;

  @SerializedName("LastHeartbeatTime")
  private String lastHeartbeatTime = null;

  @SerializedName("OSType")
  private String osType = null;

  @SerializedName("OSVersion")
  private String osVersion = null;

  @SerializedName("Status")
  private String status = null;

  public InstanceForDescribeCloudAssistantStatusOutput clientVersion(String clientVersion) {
    this.clientVersion = clientVersion;
    return this;
  }

   /**
   * Get clientVersion
   * @return clientVersion
  **/
  @Schema(description = "")
  public String getClientVersion() {
    return clientVersion;
  }

  public void setClientVersion(String clientVersion) {
    this.clientVersion = clientVersion;
  }

  public InstanceForDescribeCloudAssistantStatusOutput hostName(String hostName) {
    this.hostName = hostName;
    return this;
  }

   /**
   * Get hostName
   * @return hostName
  **/
  @Schema(description = "")
  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public InstanceForDescribeCloudAssistantStatusOutput instanceId(String instanceId) {
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

  public InstanceForDescribeCloudAssistantStatusOutput instanceName(String instanceName) {
    this.instanceName = instanceName;
    return this;
  }

   /**
   * Get instanceName
   * @return instanceName
  **/
  @Schema(description = "")
  public String getInstanceName() {
    return instanceName;
  }

  public void setInstanceName(String instanceName) {
    this.instanceName = instanceName;
  }

  public InstanceForDescribeCloudAssistantStatusOutput lastHeartbeatTime(String lastHeartbeatTime) {
    this.lastHeartbeatTime = lastHeartbeatTime;
    return this;
  }

   /**
   * Get lastHeartbeatTime
   * @return lastHeartbeatTime
  **/
  @Schema(description = "")
  public String getLastHeartbeatTime() {
    return lastHeartbeatTime;
  }

  public void setLastHeartbeatTime(String lastHeartbeatTime) {
    this.lastHeartbeatTime = lastHeartbeatTime;
  }

  public InstanceForDescribeCloudAssistantStatusOutput osType(String osType) {
    this.osType = osType;
    return this;
  }

   /**
   * Get osType
   * @return osType
  **/
  @Schema(description = "")
  public String getOsType() {
    return osType;
  }

  public void setOsType(String osType) {
    this.osType = osType;
  }

  public InstanceForDescribeCloudAssistantStatusOutput osVersion(String osVersion) {
    this.osVersion = osVersion;
    return this;
  }

   /**
   * Get osVersion
   * @return osVersion
  **/
  @Schema(description = "")
  public String getOsVersion() {
    return osVersion;
  }

  public void setOsVersion(String osVersion) {
    this.osVersion = osVersion;
  }

  public InstanceForDescribeCloudAssistantStatusOutput status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(description = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceForDescribeCloudAssistantStatusOutput instanceForDescribeCloudAssistantStatusOutput = (InstanceForDescribeCloudAssistantStatusOutput) o;
    return Objects.equals(this.clientVersion, instanceForDescribeCloudAssistantStatusOutput.clientVersion) &&
        Objects.equals(this.hostName, instanceForDescribeCloudAssistantStatusOutput.hostName) &&
        Objects.equals(this.instanceId, instanceForDescribeCloudAssistantStatusOutput.instanceId) &&
        Objects.equals(this.instanceName, instanceForDescribeCloudAssistantStatusOutput.instanceName) &&
        Objects.equals(this.lastHeartbeatTime, instanceForDescribeCloudAssistantStatusOutput.lastHeartbeatTime) &&
        Objects.equals(this.osType, instanceForDescribeCloudAssistantStatusOutput.osType) &&
        Objects.equals(this.osVersion, instanceForDescribeCloudAssistantStatusOutput.osVersion) &&
        Objects.equals(this.status, instanceForDescribeCloudAssistantStatusOutput.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientVersion, hostName, instanceId, instanceName, lastHeartbeatTime, osType, osVersion, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstanceForDescribeCloudAssistantStatusOutput {\n");
    
    sb.append("    clientVersion: ").append(toIndentedString(clientVersion)).append("\n");
    sb.append("    hostName: ").append(toIndentedString(hostName)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    instanceName: ").append(toIndentedString(instanceName)).append("\n");
    sb.append("    lastHeartbeatTime: ").append(toIndentedString(lastHeartbeatTime)).append("\n");
    sb.append("    osType: ").append(toIndentedString(osType)).append("\n");
    sb.append("    osVersion: ").append(toIndentedString(osVersion)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
