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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * DescribeInstanceTypesRequest
 */



public class DescribeInstanceTypesRequest {
  @SerializedName("ImageId")
  private String imageId = null;

  @SerializedName("InstanceTypeIds")
  private List<String> instanceTypeIds = null;

  @SerializedName("InstanceTypes")
  private List<String> instanceTypes = null;

  @SerializedName("MaxResults")
  private Integer maxResults = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  public DescribeInstanceTypesRequest imageId(String imageId) {
    this.imageId = imageId;
    return this;
  }

   /**
   * Get imageId
   * @return imageId
  **/
  @Schema(description = "")
  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  public DescribeInstanceTypesRequest instanceTypeIds(List<String> instanceTypeIds) {
    this.instanceTypeIds = instanceTypeIds;
    return this;
  }

  public DescribeInstanceTypesRequest addInstanceTypeIdsItem(String instanceTypeIdsItem) {
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

  public DescribeInstanceTypesRequest instanceTypes(List<String> instanceTypes) {
    this.instanceTypes = instanceTypes;
    return this;
  }

  public DescribeInstanceTypesRequest addInstanceTypesItem(String instanceTypesItem) {
    if (this.instanceTypes == null) {
      this.instanceTypes = new ArrayList<String>();
    }
    this.instanceTypes.add(instanceTypesItem);
    return this;
  }

   /**
   * Get instanceTypes
   * @return instanceTypes
  **/
  @Schema(description = "")
  public List<String> getInstanceTypes() {
    return instanceTypes;
  }

  public void setInstanceTypes(List<String> instanceTypes) {
    this.instanceTypes = instanceTypes;
  }

  public DescribeInstanceTypesRequest maxResults(Integer maxResults) {
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

  public DescribeInstanceTypesRequest nextToken(String nextToken) {
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
    DescribeInstanceTypesRequest describeInstanceTypesRequest = (DescribeInstanceTypesRequest) o;
    return Objects.equals(this.imageId, describeInstanceTypesRequest.imageId) &&
        Objects.equals(this.instanceTypeIds, describeInstanceTypesRequest.instanceTypeIds) &&
        Objects.equals(this.instanceTypes, describeInstanceTypesRequest.instanceTypes) &&
        Objects.equals(this.maxResults, describeInstanceTypesRequest.maxResults) &&
        Objects.equals(this.nextToken, describeInstanceTypesRequest.nextToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, instanceTypeIds, instanceTypes, maxResults, nextToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstanceTypesRequest {\n");
    
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    instanceTypeIds: ").append(toIndentedString(instanceTypeIds)).append("\n");
    sb.append("    instanceTypes: ").append(toIndentedString(instanceTypes)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
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
