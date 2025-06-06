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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * PermissionForDescribeSecurityGroupAttributesOutput
 */



public class PermissionForDescribeSecurityGroupAttributesOutput {
  @SerializedName("CidrIp")
  private String cidrIp = null;

  @SerializedName("CreationTime")
  private String creationTime = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("Direction")
  private String direction = null;

  @SerializedName("Policy")
  private String policy = null;

  @SerializedName("PortEnd")
  private Integer portEnd = null;

  @SerializedName("PortStart")
  private Integer portStart = null;

  @SerializedName("PrefixListCidrs")
  private List<String> prefixListCidrs = null;

  @SerializedName("PrefixListId")
  private String prefixListId = null;

  @SerializedName("Priority")
  private Integer priority = null;

  @SerializedName("Protocol")
  private String protocol = null;

  @SerializedName("SourceGroupId")
  private String sourceGroupId = null;

  @SerializedName("UpdateTime")
  private String updateTime = null;

  public PermissionForDescribeSecurityGroupAttributesOutput cidrIp(String cidrIp) {
    this.cidrIp = cidrIp;
    return this;
  }

   /**
   * Get cidrIp
   * @return cidrIp
  **/
  @Schema(description = "")
  public String getCidrIp() {
    return cidrIp;
  }

  public void setCidrIp(String cidrIp) {
    this.cidrIp = cidrIp;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput creationTime(String creationTime) {
    this.creationTime = creationTime;
    return this;
  }

   /**
   * Get creationTime
   * @return creationTime
  **/
  @Schema(description = "")
  public String getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(String creationTime) {
    this.creationTime = creationTime;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput direction(String direction) {
    this.direction = direction;
    return this;
  }

   /**
   * Get direction
   * @return direction
  **/
  @Schema(description = "")
  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput policy(String policy) {
    this.policy = policy;
    return this;
  }

   /**
   * Get policy
   * @return policy
  **/
  @Schema(description = "")
  public String getPolicy() {
    return policy;
  }

  public void setPolicy(String policy) {
    this.policy = policy;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput portEnd(Integer portEnd) {
    this.portEnd = portEnd;
    return this;
  }

   /**
   * Get portEnd
   * @return portEnd
  **/
  @Schema(description = "")
  public Integer getPortEnd() {
    return portEnd;
  }

  public void setPortEnd(Integer portEnd) {
    this.portEnd = portEnd;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput portStart(Integer portStart) {
    this.portStart = portStart;
    return this;
  }

   /**
   * Get portStart
   * @return portStart
  **/
  @Schema(description = "")
  public Integer getPortStart() {
    return portStart;
  }

  public void setPortStart(Integer portStart) {
    this.portStart = portStart;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput prefixListCidrs(List<String> prefixListCidrs) {
    this.prefixListCidrs = prefixListCidrs;
    return this;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput addPrefixListCidrsItem(String prefixListCidrsItem) {
    if (this.prefixListCidrs == null) {
      this.prefixListCidrs = new ArrayList<String>();
    }
    this.prefixListCidrs.add(prefixListCidrsItem);
    return this;
  }

   /**
   * Get prefixListCidrs
   * @return prefixListCidrs
  **/
  @Schema(description = "")
  public List<String> getPrefixListCidrs() {
    return prefixListCidrs;
  }

  public void setPrefixListCidrs(List<String> prefixListCidrs) {
    this.prefixListCidrs = prefixListCidrs;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput prefixListId(String prefixListId) {
    this.prefixListId = prefixListId;
    return this;
  }

   /**
   * Get prefixListId
   * @return prefixListId
  **/
  @Schema(description = "")
  public String getPrefixListId() {
    return prefixListId;
  }

  public void setPrefixListId(String prefixListId) {
    this.prefixListId = prefixListId;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput priority(Integer priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @Schema(description = "")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Get protocol
   * @return protocol
  **/
  @Schema(description = "")
  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput sourceGroupId(String sourceGroupId) {
    this.sourceGroupId = sourceGroupId;
    return this;
  }

   /**
   * Get sourceGroupId
   * @return sourceGroupId
  **/
  @Schema(description = "")
  public String getSourceGroupId() {
    return sourceGroupId;
  }

  public void setSourceGroupId(String sourceGroupId) {
    this.sourceGroupId = sourceGroupId;
  }

  public PermissionForDescribeSecurityGroupAttributesOutput updateTime(String updateTime) {
    this.updateTime = updateTime;
    return this;
  }

   /**
   * Get updateTime
   * @return updateTime
  **/
  @Schema(description = "")
  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PermissionForDescribeSecurityGroupAttributesOutput permissionForDescribeSecurityGroupAttributesOutput = (PermissionForDescribeSecurityGroupAttributesOutput) o;
    return Objects.equals(this.cidrIp, permissionForDescribeSecurityGroupAttributesOutput.cidrIp) &&
        Objects.equals(this.creationTime, permissionForDescribeSecurityGroupAttributesOutput.creationTime) &&
        Objects.equals(this.description, permissionForDescribeSecurityGroupAttributesOutput.description) &&
        Objects.equals(this.direction, permissionForDescribeSecurityGroupAttributesOutput.direction) &&
        Objects.equals(this.policy, permissionForDescribeSecurityGroupAttributesOutput.policy) &&
        Objects.equals(this.portEnd, permissionForDescribeSecurityGroupAttributesOutput.portEnd) &&
        Objects.equals(this.portStart, permissionForDescribeSecurityGroupAttributesOutput.portStart) &&
        Objects.equals(this.prefixListCidrs, permissionForDescribeSecurityGroupAttributesOutput.prefixListCidrs) &&
        Objects.equals(this.prefixListId, permissionForDescribeSecurityGroupAttributesOutput.prefixListId) &&
        Objects.equals(this.priority, permissionForDescribeSecurityGroupAttributesOutput.priority) &&
        Objects.equals(this.protocol, permissionForDescribeSecurityGroupAttributesOutput.protocol) &&
        Objects.equals(this.sourceGroupId, permissionForDescribeSecurityGroupAttributesOutput.sourceGroupId) &&
        Objects.equals(this.updateTime, permissionForDescribeSecurityGroupAttributesOutput.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cidrIp, creationTime, description, direction, policy, portEnd, portStart, prefixListCidrs, prefixListId, priority, protocol, sourceGroupId, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PermissionForDescribeSecurityGroupAttributesOutput {\n");
    
    sb.append("    cidrIp: ").append(toIndentedString(cidrIp)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    portEnd: ").append(toIndentedString(portEnd)).append("\n");
    sb.append("    portStart: ").append(toIndentedString(portStart)).append("\n");
    sb.append("    prefixListCidrs: ").append(toIndentedString(prefixListCidrs)).append("\n");
    sb.append("    prefixListId: ").append(toIndentedString(prefixListId)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    sourceGroupId: ").append(toIndentedString(sourceGroupId)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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
