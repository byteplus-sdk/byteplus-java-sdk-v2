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
 * DescribeSecurityGroupAttributesRequest
 */



public class DescribeSecurityGroupAttributesRequest {
  @SerializedName("CidrIp")
  private String cidrIp = null;

  @SerializedName("Direction")
  private String direction = null;

  @SerializedName("PrefixListId")
  private String prefixListId = null;

  @SerializedName("Protocol")
  private String protocol = null;

  @SerializedName("SecurityGroupId")
  private String securityGroupId = null;

  @SerializedName("SourceGroupId")
  private String sourceGroupId = null;

  public DescribeSecurityGroupAttributesRequest cidrIp(String cidrIp) {
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

  public DescribeSecurityGroupAttributesRequest direction(String direction) {
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

  public DescribeSecurityGroupAttributesRequest prefixListId(String prefixListId) {
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

  public DescribeSecurityGroupAttributesRequest protocol(String protocol) {
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

  public DescribeSecurityGroupAttributesRequest securityGroupId(String securityGroupId) {
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

  public DescribeSecurityGroupAttributesRequest sourceGroupId(String sourceGroupId) {
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
    DescribeSecurityGroupAttributesRequest describeSecurityGroupAttributesRequest = (DescribeSecurityGroupAttributesRequest) o;
    return Objects.equals(this.cidrIp, describeSecurityGroupAttributesRequest.cidrIp) &&
        Objects.equals(this.direction, describeSecurityGroupAttributesRequest.direction) &&
        Objects.equals(this.prefixListId, describeSecurityGroupAttributesRequest.prefixListId) &&
        Objects.equals(this.protocol, describeSecurityGroupAttributesRequest.protocol) &&
        Objects.equals(this.securityGroupId, describeSecurityGroupAttributesRequest.securityGroupId) &&
        Objects.equals(this.sourceGroupId, describeSecurityGroupAttributesRequest.sourceGroupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cidrIp, direction, prefixListId, protocol, securityGroupId, sourceGroupId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeSecurityGroupAttributesRequest {\n");
    
    sb.append("    cidrIp: ").append(toIndentedString(cidrIp)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    prefixListId: ").append(toIndentedString(prefixListId)).append("\n");
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
