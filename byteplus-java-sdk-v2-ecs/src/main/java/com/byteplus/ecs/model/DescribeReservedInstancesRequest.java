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
import com.byteplus.ecs.model.TagFilterForDescribeReservedInstancesInput;
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
 * DescribeReservedInstancesRequest
 */



public class DescribeReservedInstancesRequest {
  @SerializedName("HpcClusterId")
  private String hpcClusterId = null;

  @SerializedName("InstanceTypeFamilies")
  private List<String> instanceTypeFamilies = null;

  @SerializedName("InstanceTypeIds")
  private List<String> instanceTypeIds = null;

  @SerializedName("MaxResults")
  private Integer maxResults = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("ReservedInstanceIds")
  private List<String> reservedInstanceIds = null;

  @SerializedName("ReservedInstanceName")
  private String reservedInstanceName = null;

  @SerializedName("Scope")
  private String scope = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("SupportModify")
  private String supportModify = null;

  @SerializedName("TagFilters")
  private List<TagFilterForDescribeReservedInstancesInput> tagFilters = null;

  @SerializedName("ZoneId")
  private String zoneId = null;

  public DescribeReservedInstancesRequest hpcClusterId(String hpcClusterId) {
    this.hpcClusterId = hpcClusterId;
    return this;
  }

   /**
   * Get hpcClusterId
   * @return hpcClusterId
  **/
  @Schema(description = "")
  public String getHpcClusterId() {
    return hpcClusterId;
  }

  public void setHpcClusterId(String hpcClusterId) {
    this.hpcClusterId = hpcClusterId;
  }

  public DescribeReservedInstancesRequest instanceTypeFamilies(List<String> instanceTypeFamilies) {
    this.instanceTypeFamilies = instanceTypeFamilies;
    return this;
  }

  public DescribeReservedInstancesRequest addInstanceTypeFamiliesItem(String instanceTypeFamiliesItem) {
    if (this.instanceTypeFamilies == null) {
      this.instanceTypeFamilies = new ArrayList<String>();
    }
    this.instanceTypeFamilies.add(instanceTypeFamiliesItem);
    return this;
  }

   /**
   * Get instanceTypeFamilies
   * @return instanceTypeFamilies
  **/
  @Schema(description = "")
  public List<String> getInstanceTypeFamilies() {
    return instanceTypeFamilies;
  }

  public void setInstanceTypeFamilies(List<String> instanceTypeFamilies) {
    this.instanceTypeFamilies = instanceTypeFamilies;
  }

  public DescribeReservedInstancesRequest instanceTypeIds(List<String> instanceTypeIds) {
    this.instanceTypeIds = instanceTypeIds;
    return this;
  }

  public DescribeReservedInstancesRequest addInstanceTypeIdsItem(String instanceTypeIdsItem) {
    if (this.instanceTypeIds == null) {
      this.instanceTypeIds = new ArrayList<String>();
    }
    this.instanceTypeIds.add(instanceTypeIdsItem);
    return this;
  }

   /**
   * Get instanceTypeIds
   * @return instanceTypeIds
  **/
  @Schema(description = "")
  public List<String> getInstanceTypeIds() {
    return instanceTypeIds;
  }

  public void setInstanceTypeIds(List<String> instanceTypeIds) {
    this.instanceTypeIds = instanceTypeIds;
  }

  public DescribeReservedInstancesRequest maxResults(Integer maxResults) {
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

  public DescribeReservedInstancesRequest nextToken(String nextToken) {
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

  public DescribeReservedInstancesRequest projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

   /**
   * Get projectName
   * @return projectName
  **/
  @Schema(description = "")
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public DescribeReservedInstancesRequest reservedInstanceIds(List<String> reservedInstanceIds) {
    this.reservedInstanceIds = reservedInstanceIds;
    return this;
  }

  public DescribeReservedInstancesRequest addReservedInstanceIdsItem(String reservedInstanceIdsItem) {
    if (this.reservedInstanceIds == null) {
      this.reservedInstanceIds = new ArrayList<String>();
    }
    this.reservedInstanceIds.add(reservedInstanceIdsItem);
    return this;
  }

   /**
   * Get reservedInstanceIds
   * @return reservedInstanceIds
  **/
  @Schema(description = "")
  public List<String> getReservedInstanceIds() {
    return reservedInstanceIds;
  }

  public void setReservedInstanceIds(List<String> reservedInstanceIds) {
    this.reservedInstanceIds = reservedInstanceIds;
  }

  public DescribeReservedInstancesRequest reservedInstanceName(String reservedInstanceName) {
    this.reservedInstanceName = reservedInstanceName;
    return this;
  }

   /**
   * Get reservedInstanceName
   * @return reservedInstanceName
  **/
  @Schema(description = "")
  public String getReservedInstanceName() {
    return reservedInstanceName;
  }

  public void setReservedInstanceName(String reservedInstanceName) {
    this.reservedInstanceName = reservedInstanceName;
  }

  public DescribeReservedInstancesRequest scope(String scope) {
    this.scope = scope;
    return this;
  }

   /**
   * Get scope
   * @return scope
  **/
  @Schema(description = "")
  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public DescribeReservedInstancesRequest status(String status) {
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

  public DescribeReservedInstancesRequest supportModify(String supportModify) {
    this.supportModify = supportModify;
    return this;
  }

   /**
   * Get supportModify
   * @return supportModify
  **/
  @Schema(description = "")
  public String getSupportModify() {
    return supportModify;
  }

  public void setSupportModify(String supportModify) {
    this.supportModify = supportModify;
  }

  public DescribeReservedInstancesRequest tagFilters(List<TagFilterForDescribeReservedInstancesInput> tagFilters) {
    this.tagFilters = tagFilters;
    return this;
  }

  public DescribeReservedInstancesRequest addTagFiltersItem(TagFilterForDescribeReservedInstancesInput tagFiltersItem) {
    if (this.tagFilters == null) {
      this.tagFilters = new ArrayList<TagFilterForDescribeReservedInstancesInput>();
    }
    this.tagFilters.add(tagFiltersItem);
    return this;
  }

   /**
   * Get tagFilters
   * @return tagFilters
  **/
  @Valid
  @Schema(description = "")
  public List<TagFilterForDescribeReservedInstancesInput> getTagFilters() {
    return tagFilters;
  }

  public void setTagFilters(List<TagFilterForDescribeReservedInstancesInput> tagFilters) {
    this.tagFilters = tagFilters;
  }

  public DescribeReservedInstancesRequest zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * Get zoneId
   * @return zoneId
  **/
  @Schema(description = "")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeReservedInstancesRequest describeReservedInstancesRequest = (DescribeReservedInstancesRequest) o;
    return Objects.equals(this.hpcClusterId, describeReservedInstancesRequest.hpcClusterId) &&
        Objects.equals(this.instanceTypeFamilies, describeReservedInstancesRequest.instanceTypeFamilies) &&
        Objects.equals(this.instanceTypeIds, describeReservedInstancesRequest.instanceTypeIds) &&
        Objects.equals(this.maxResults, describeReservedInstancesRequest.maxResults) &&
        Objects.equals(this.nextToken, describeReservedInstancesRequest.nextToken) &&
        Objects.equals(this.projectName, describeReservedInstancesRequest.projectName) &&
        Objects.equals(this.reservedInstanceIds, describeReservedInstancesRequest.reservedInstanceIds) &&
        Objects.equals(this.reservedInstanceName, describeReservedInstancesRequest.reservedInstanceName) &&
        Objects.equals(this.scope, describeReservedInstancesRequest.scope) &&
        Objects.equals(this.status, describeReservedInstancesRequest.status) &&
        Objects.equals(this.supportModify, describeReservedInstancesRequest.supportModify) &&
        Objects.equals(this.tagFilters, describeReservedInstancesRequest.tagFilters) &&
        Objects.equals(this.zoneId, describeReservedInstancesRequest.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hpcClusterId, instanceTypeFamilies, instanceTypeIds, maxResults, nextToken, projectName, reservedInstanceIds, reservedInstanceName, scope, status, supportModify, tagFilters, zoneId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeReservedInstancesRequest {\n");
    
    sb.append("    hpcClusterId: ").append(toIndentedString(hpcClusterId)).append("\n");
    sb.append("    instanceTypeFamilies: ").append(toIndentedString(instanceTypeFamilies)).append("\n");
    sb.append("    instanceTypeIds: ").append(toIndentedString(instanceTypeIds)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    reservedInstanceIds: ").append(toIndentedString(reservedInstanceIds)).append("\n");
    sb.append("    reservedInstanceName: ").append(toIndentedString(reservedInstanceName)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    supportModify: ").append(toIndentedString(supportModify)).append("\n");
    sb.append("    tagFilters: ").append(toIndentedString(tagFilters)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
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
