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
 * DescribeInstanceGroupsRequest
 */



public class DescribeInstanceGroupsRequest {
  @SerializedName("InstanceGroupIds")
  private List<String> instanceGroupIds = null;

  @SerializedName("InstanceGroupName")
  private String instanceGroupName = null;

  @SerializedName("MaxResults")
  private Integer maxResults = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("PageNumber")
  private Integer pageNumber = null;

  @SerializedName("PageSize")
  private Integer pageSize = null;

  @SerializedName("VpcId")
  private String vpcId = null;

  public DescribeInstanceGroupsRequest instanceGroupIds(List<String> instanceGroupIds) {
    this.instanceGroupIds = instanceGroupIds;
    return this;
  }

  public DescribeInstanceGroupsRequest addInstanceGroupIdsItem(String instanceGroupIdsItem) {
    if (this.instanceGroupIds == null) {
      this.instanceGroupIds = new ArrayList<String>();
    }
    this.instanceGroupIds.add(instanceGroupIdsItem);
    return this;
  }

   /**
   * Get instanceGroupIds
   * @return instanceGroupIds
  **/
  @Schema(description = "")
  public List<String> getInstanceGroupIds() {
    return instanceGroupIds;
  }

  public void setInstanceGroupIds(List<String> instanceGroupIds) {
    this.instanceGroupIds = instanceGroupIds;
  }

  public DescribeInstanceGroupsRequest instanceGroupName(String instanceGroupName) {
    this.instanceGroupName = instanceGroupName;
    return this;
  }

   /**
   * Get instanceGroupName
   * @return instanceGroupName
  **/
  @Schema(description = "")
  public String getInstanceGroupName() {
    return instanceGroupName;
  }

  public void setInstanceGroupName(String instanceGroupName) {
    this.instanceGroupName = instanceGroupName;
  }

  public DescribeInstanceGroupsRequest maxResults(Integer maxResults) {
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

  public DescribeInstanceGroupsRequest nextToken(String nextToken) {
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

  public DescribeInstanceGroupsRequest pageNumber(Integer pageNumber) {
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

  public DescribeInstanceGroupsRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * Get pageSize
   * maximum: 100
   * @return pageSize
  **/
 @Max(100)  @Schema(description = "")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public DescribeInstanceGroupsRequest vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * Get vpcId
   * @return vpcId
  **/
  @Schema(description = "")
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstanceGroupsRequest describeInstanceGroupsRequest = (DescribeInstanceGroupsRequest) o;
    return Objects.equals(this.instanceGroupIds, describeInstanceGroupsRequest.instanceGroupIds) &&
        Objects.equals(this.instanceGroupName, describeInstanceGroupsRequest.instanceGroupName) &&
        Objects.equals(this.maxResults, describeInstanceGroupsRequest.maxResults) &&
        Objects.equals(this.nextToken, describeInstanceGroupsRequest.nextToken) &&
        Objects.equals(this.pageNumber, describeInstanceGroupsRequest.pageNumber) &&
        Objects.equals(this.pageSize, describeInstanceGroupsRequest.pageSize) &&
        Objects.equals(this.vpcId, describeInstanceGroupsRequest.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceGroupIds, instanceGroupName, maxResults, nextToken, pageNumber, pageSize, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstanceGroupsRequest {\n");
    
    sb.append("    instanceGroupIds: ").append(toIndentedString(instanceGroupIds)).append("\n");
    sb.append("    instanceGroupName: ").append(toIndentedString(instanceGroupName)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
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
