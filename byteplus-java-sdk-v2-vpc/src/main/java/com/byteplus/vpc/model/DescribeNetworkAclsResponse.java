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
import com.byteplus.vpc.model.NetworkAclForDescribeNetworkAclsOutput;
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
 * DescribeNetworkAclsResponse
 */



public class DescribeNetworkAclsResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("NetworkAcls")
  private List<NetworkAclForDescribeNetworkAclsOutput> networkAcls = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("PageNumber")
  private Integer pageNumber = null;

  @SerializedName("PageSize")
  private Integer pageSize = null;

  @SerializedName("RequestId")
  private String requestId = null;

  @SerializedName("TotalCount")
  private Integer totalCount = null;

  public DescribeNetworkAclsResponse networkAcls(List<NetworkAclForDescribeNetworkAclsOutput> networkAcls) {
    this.networkAcls = networkAcls;
    return this;
  }

  public DescribeNetworkAclsResponse addNetworkAclsItem(NetworkAclForDescribeNetworkAclsOutput networkAclsItem) {
    if (this.networkAcls == null) {
      this.networkAcls = new ArrayList<NetworkAclForDescribeNetworkAclsOutput>();
    }
    this.networkAcls.add(networkAclsItem);
    return this;
  }

   /**
   * Get networkAcls
   * @return networkAcls
  **/
  @Valid
  @Schema(description = "")
  public List<NetworkAclForDescribeNetworkAclsOutput> getNetworkAcls() {
    return networkAcls;
  }

  public void setNetworkAcls(List<NetworkAclForDescribeNetworkAclsOutput> networkAcls) {
    this.networkAcls = networkAcls;
  }

  public DescribeNetworkAclsResponse nextToken(String nextToken) {
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

  public DescribeNetworkAclsResponse pageNumber(Integer pageNumber) {
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

  public DescribeNetworkAclsResponse pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * Get pageSize
   * @return pageSize
  **/
  @Schema(description = "")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public DescribeNetworkAclsResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @Schema(description = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public DescribeNetworkAclsResponse totalCount(Integer totalCount) {
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
    DescribeNetworkAclsResponse describeNetworkAclsResponse = (DescribeNetworkAclsResponse) o;
    return Objects.equals(this.networkAcls, describeNetworkAclsResponse.networkAcls) &&
        Objects.equals(this.nextToken, describeNetworkAclsResponse.nextToken) &&
        Objects.equals(this.pageNumber, describeNetworkAclsResponse.pageNumber) &&
        Objects.equals(this.pageSize, describeNetworkAclsResponse.pageSize) &&
        Objects.equals(this.requestId, describeNetworkAclsResponse.requestId) &&
        Objects.equals(this.totalCount, describeNetworkAclsResponse.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkAcls, nextToken, pageNumber, pageSize, requestId, totalCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeNetworkAclsResponse {\n");
    
    sb.append("    networkAcls: ").append(toIndentedString(networkAcls)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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
