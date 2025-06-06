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
 * DescribeIpv6EgressOnlyRulesRequest
 */



public class DescribeIpv6EgressOnlyRulesRequest {
  @SerializedName("InstanceId")
  private String instanceId = null;

  @SerializedName("Ipv6Address")
  private String ipv6Address = null;

  @SerializedName("Ipv6EgressOnlyRuleIds")
  private String ipv6EgressOnlyRuleIds = null;

  @SerializedName("Ipv6GatewayId")
  private String ipv6GatewayId = null;

  @SerializedName("MaxResults")
  private Integer maxResults = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  public DescribeIpv6EgressOnlyRulesRequest instanceId(String instanceId) {
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

  public DescribeIpv6EgressOnlyRulesRequest ipv6Address(String ipv6Address) {
    this.ipv6Address = ipv6Address;
    return this;
  }

   /**
   * Get ipv6Address
   * @return ipv6Address
  **/
  @Schema(description = "")
  public String getIpv6Address() {
    return ipv6Address;
  }

  public void setIpv6Address(String ipv6Address) {
    this.ipv6Address = ipv6Address;
  }

  public DescribeIpv6EgressOnlyRulesRequest ipv6EgressOnlyRuleIds(String ipv6EgressOnlyRuleIds) {
    this.ipv6EgressOnlyRuleIds = ipv6EgressOnlyRuleIds;
    return this;
  }

   /**
   * Get ipv6EgressOnlyRuleIds
   * @return ipv6EgressOnlyRuleIds
  **/
  @Schema(description = "")
  public String getIpv6EgressOnlyRuleIds() {
    return ipv6EgressOnlyRuleIds;
  }

  public void setIpv6EgressOnlyRuleIds(String ipv6EgressOnlyRuleIds) {
    this.ipv6EgressOnlyRuleIds = ipv6EgressOnlyRuleIds;
  }

  public DescribeIpv6EgressOnlyRulesRequest ipv6GatewayId(String ipv6GatewayId) {
    this.ipv6GatewayId = ipv6GatewayId;
    return this;
  }

   /**
   * Get ipv6GatewayId
   * @return ipv6GatewayId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getIpv6GatewayId() {
    return ipv6GatewayId;
  }

  public void setIpv6GatewayId(String ipv6GatewayId) {
    this.ipv6GatewayId = ipv6GatewayId;
  }

  public DescribeIpv6EgressOnlyRulesRequest maxResults(Integer maxResults) {
    this.maxResults = maxResults;
    return this;
  }

   /**
   * Get maxResults
   * @return maxResults
  **/
  @Schema(description = "")
  public Integer getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }

  public DescribeIpv6EgressOnlyRulesRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DescribeIpv6EgressOnlyRulesRequest nextToken(String nextToken) {
    this.nextToken = nextToken;
    return this;
  }

   /**
   * Get nextToken
   * @return nextToken
  **/
  @Schema(description = "")
  public String getNextToken() {
    return nextToken;
  }

  public void setNextToken(String nextToken) {
    this.nextToken = nextToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeIpv6EgressOnlyRulesRequest describeIpv6EgressOnlyRulesRequest = (DescribeIpv6EgressOnlyRulesRequest) o;
    return Objects.equals(this.instanceId, describeIpv6EgressOnlyRulesRequest.instanceId) &&
        Objects.equals(this.ipv6Address, describeIpv6EgressOnlyRulesRequest.ipv6Address) &&
        Objects.equals(this.ipv6EgressOnlyRuleIds, describeIpv6EgressOnlyRulesRequest.ipv6EgressOnlyRuleIds) &&
        Objects.equals(this.ipv6GatewayId, describeIpv6EgressOnlyRulesRequest.ipv6GatewayId) &&
        Objects.equals(this.maxResults, describeIpv6EgressOnlyRulesRequest.maxResults) &&
        Objects.equals(this.name, describeIpv6EgressOnlyRulesRequest.name) &&
        Objects.equals(this.nextToken, describeIpv6EgressOnlyRulesRequest.nextToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId, ipv6Address, ipv6EgressOnlyRuleIds, ipv6GatewayId, maxResults, name, nextToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeIpv6EgressOnlyRulesRequest {\n");
    
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    ipv6Address: ").append(toIndentedString(ipv6Address)).append("\n");
    sb.append("    ipv6EgressOnlyRuleIds: ").append(toIndentedString(ipv6EgressOnlyRuleIds)).append("\n");
    sb.append("    ipv6GatewayId: ").append(toIndentedString(ipv6GatewayId)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
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
