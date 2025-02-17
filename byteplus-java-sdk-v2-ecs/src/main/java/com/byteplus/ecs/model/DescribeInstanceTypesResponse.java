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
import com.byteplus.ecs.model.InstanceTypeForDescribeInstanceTypesOutput;
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
 * DescribeInstanceTypesResponse
 */



public class DescribeInstanceTypesResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("InstanceTypes")
  private List<InstanceTypeForDescribeInstanceTypesOutput> instanceTypes = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("TotalCount")
  private Integer totalCount = null;

  public DescribeInstanceTypesResponse instanceTypes(List<InstanceTypeForDescribeInstanceTypesOutput> instanceTypes) {
    this.instanceTypes = instanceTypes;
    return this;
  }

  public DescribeInstanceTypesResponse addInstanceTypesItem(InstanceTypeForDescribeInstanceTypesOutput instanceTypesItem) {
    if (this.instanceTypes == null) {
      this.instanceTypes = new ArrayList<InstanceTypeForDescribeInstanceTypesOutput>();
    }
    this.instanceTypes.add(instanceTypesItem);
    return this;
  }

   /**
   * Get instanceTypes
   * @return instanceTypes
  **/
  @Valid
  @Schema(description = "")
  public List<InstanceTypeForDescribeInstanceTypesOutput> getInstanceTypes() {
    return instanceTypes;
  }

  public void setInstanceTypes(List<InstanceTypeForDescribeInstanceTypesOutput> instanceTypes) {
    this.instanceTypes = instanceTypes;
  }

  public DescribeInstanceTypesResponse nextToken(String nextToken) {
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

  public DescribeInstanceTypesResponse totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

   /**
   * Get totalCount
   * @return totalCount
  **/
  @Schema(description = "")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeInstanceTypesResponse describeInstanceTypesResponse = (DescribeInstanceTypesResponse) o;
    return Objects.equals(this.instanceTypes, describeInstanceTypesResponse.instanceTypes) &&
        Objects.equals(this.nextToken, describeInstanceTypesResponse.nextToken) &&
        Objects.equals(this.totalCount, describeInstanceTypesResponse.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceTypes, nextToken, totalCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeInstanceTypesResponse {\n");
    
    sb.append("    instanceTypes: ").append(toIndentedString(instanceTypes)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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
