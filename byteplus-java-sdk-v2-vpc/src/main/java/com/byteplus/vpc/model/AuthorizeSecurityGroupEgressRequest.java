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
 * AuthorizeSecurityGroupEgressRequest
 */



public class AuthorizeSecurityGroupEgressRequest {
  @SerializedName("CidrIp")
  private String cidrIp = null;

  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("Policy")
  private String policy = null;

  @SerializedName("PortEnd")
  private Integer portEnd = null;

  @SerializedName("PortStart")
  private Integer portStart = null;

  @SerializedName("PrefixListId")
  private String prefixListId = null;

  @SerializedName("Priority")
  private Integer priority = null;

  @SerializedName("Protocol")
  private String protocol = null;

  @SerializedName("SecurityGroupId")
  private String securityGroupId = null;

  @SerializedName("SourceGroupId")
  private String sourceGroupId = null;

  public AuthorizeSecurityGroupEgressRequest cidrIp(String cidrIp) {
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

  public AuthorizeSecurityGroupEgressRequest clientToken(String clientToken) {
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

  public AuthorizeSecurityGroupEgressRequest description(String description) {
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

  public AuthorizeSecurityGroupEgressRequest policy(String policy) {
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

  public AuthorizeSecurityGroupEgressRequest portEnd(Integer portEnd) {
    this.portEnd = portEnd;
    return this;
  }

   /**
   * Get portEnd
   * @return portEnd
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Integer getPortEnd() {
    return portEnd;
  }

  public void setPortEnd(Integer portEnd) {
    this.portEnd = portEnd;
  }

  public AuthorizeSecurityGroupEgressRequest portStart(Integer portStart) {
    this.portStart = portStart;
    return this;
  }

   /**
   * Get portStart
   * @return portStart
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Integer getPortStart() {
    return portStart;
  }

  public void setPortStart(Integer portStart) {
    this.portStart = portStart;
  }

  public AuthorizeSecurityGroupEgressRequest prefixListId(String prefixListId) {
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

  public AuthorizeSecurityGroupEgressRequest priority(Integer priority) {
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

  public AuthorizeSecurityGroupEgressRequest protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Get protocol
   * @return protocol
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public AuthorizeSecurityGroupEgressRequest securityGroupId(String securityGroupId) {
    this.securityGroupId = securityGroupId;
    return this;
  }

   /**
   * Get securityGroupId
   * @return securityGroupId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getSecurityGroupId() {
    return securityGroupId;
  }

  public void setSecurityGroupId(String securityGroupId) {
    this.securityGroupId = securityGroupId;
  }

  public AuthorizeSecurityGroupEgressRequest sourceGroupId(String sourceGroupId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizeSecurityGroupEgressRequest authorizeSecurityGroupEgressRequest = (AuthorizeSecurityGroupEgressRequest) o;
    return Objects.equals(this.cidrIp, authorizeSecurityGroupEgressRequest.cidrIp) &&
        Objects.equals(this.clientToken, authorizeSecurityGroupEgressRequest.clientToken) &&
        Objects.equals(this.description, authorizeSecurityGroupEgressRequest.description) &&
        Objects.equals(this.policy, authorizeSecurityGroupEgressRequest.policy) &&
        Objects.equals(this.portEnd, authorizeSecurityGroupEgressRequest.portEnd) &&
        Objects.equals(this.portStart, authorizeSecurityGroupEgressRequest.portStart) &&
        Objects.equals(this.prefixListId, authorizeSecurityGroupEgressRequest.prefixListId) &&
        Objects.equals(this.priority, authorizeSecurityGroupEgressRequest.priority) &&
        Objects.equals(this.protocol, authorizeSecurityGroupEgressRequest.protocol) &&
        Objects.equals(this.securityGroupId, authorizeSecurityGroupEgressRequest.securityGroupId) &&
        Objects.equals(this.sourceGroupId, authorizeSecurityGroupEgressRequest.sourceGroupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cidrIp, clientToken, description, policy, portEnd, portStart, prefixListId, priority, protocol, securityGroupId, sourceGroupId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizeSecurityGroupEgressRequest {\n");
    
    sb.append("    cidrIp: ").append(toIndentedString(cidrIp)).append("\n");
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    portEnd: ").append(toIndentedString(portEnd)).append("\n");
    sb.append("    portStart: ").append(toIndentedString(portStart)).append("\n");
    sb.append("    prefixListId: ").append(toIndentedString(prefixListId)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    securityGroupId: ").append(toIndentedString(securityGroupId)).append("\n");
    sb.append("    sourceGroupId: ").append(toIndentedString(sourceGroupId)).append("\n");
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
