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
import com.byteplus.vpc.model.IpAddressPoolCidrBlockForDescribeIpAddressPoolCidrBlocksOutput;
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
 * DescribeIpAddressPoolCidrBlocksResponse
 */



public class DescribeIpAddressPoolCidrBlocksResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("IpAddressPoolCidrBlocks")
  private List<IpAddressPoolCidrBlockForDescribeIpAddressPoolCidrBlocksOutput> ipAddressPoolCidrBlocks = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("RequestId")
  private String requestId = null;

  public DescribeIpAddressPoolCidrBlocksResponse ipAddressPoolCidrBlocks(List<IpAddressPoolCidrBlockForDescribeIpAddressPoolCidrBlocksOutput> ipAddressPoolCidrBlocks) {
    this.ipAddressPoolCidrBlocks = ipAddressPoolCidrBlocks;
    return this;
  }

  public DescribeIpAddressPoolCidrBlocksResponse addIpAddressPoolCidrBlocksItem(IpAddressPoolCidrBlockForDescribeIpAddressPoolCidrBlocksOutput ipAddressPoolCidrBlocksItem) {
    if (this.ipAddressPoolCidrBlocks == null) {
      this.ipAddressPoolCidrBlocks = new ArrayList<IpAddressPoolCidrBlockForDescribeIpAddressPoolCidrBlocksOutput>();
    }
    this.ipAddressPoolCidrBlocks.add(ipAddressPoolCidrBlocksItem);
    return this;
  }

   /**
   * Get ipAddressPoolCidrBlocks
   * @return ipAddressPoolCidrBlocks
  **/
  @Valid
  @Schema(description = "")
  public List<IpAddressPoolCidrBlockForDescribeIpAddressPoolCidrBlocksOutput> getIpAddressPoolCidrBlocks() {
    return ipAddressPoolCidrBlocks;
  }

  public void setIpAddressPoolCidrBlocks(List<IpAddressPoolCidrBlockForDescribeIpAddressPoolCidrBlocksOutput> ipAddressPoolCidrBlocks) {
    this.ipAddressPoolCidrBlocks = ipAddressPoolCidrBlocks;
  }

  public DescribeIpAddressPoolCidrBlocksResponse nextToken(String nextToken) {
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

  public DescribeIpAddressPoolCidrBlocksResponse requestId(String requestId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeIpAddressPoolCidrBlocksResponse describeIpAddressPoolCidrBlocksResponse = (DescribeIpAddressPoolCidrBlocksResponse) o;
    return Objects.equals(this.ipAddressPoolCidrBlocks, describeIpAddressPoolCidrBlocksResponse.ipAddressPoolCidrBlocks) &&
        Objects.equals(this.nextToken, describeIpAddressPoolCidrBlocksResponse.nextToken) &&
        Objects.equals(this.requestId, describeIpAddressPoolCidrBlocksResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipAddressPoolCidrBlocks, nextToken, requestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeIpAddressPoolCidrBlocksResponse {\n");
    
    sb.append("    ipAddressPoolCidrBlocks: ").append(toIndentedString(ipAddressPoolCidrBlocks)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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
