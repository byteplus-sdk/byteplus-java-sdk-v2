/*
 * billing
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.billing.model;

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
 * ListAvailableInstancesRequest
 */



public class ListAvailableInstancesRequest {
  @SerializedName("BeginTimeEnd")
  private String beginTimeEnd = null;

  @SerializedName("BeginTimeStart")
  private String beginTimeStart = null;

  @SerializedName("ExpiredTimeEnd")
  private String expiredTimeEnd = null;

  @SerializedName("ExpiredTimeStart")
  private String expiredTimeStart = null;

  @SerializedName("InstanceIDs")
  private List<String> instanceIDs = null;

  @SerializedName("MaxResults")
  private Integer maxResults = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("Product")
  private String product = null;

  @SerializedName("RenewType")
  private String renewType = null;

  public ListAvailableInstancesRequest beginTimeEnd(String beginTimeEnd) {
    this.beginTimeEnd = beginTimeEnd;
    return this;
  }

   /**
   * Get beginTimeEnd
   * @return beginTimeEnd
  **/
  @Schema(description = "")
  public String getBeginTimeEnd() {
    return beginTimeEnd;
  }

  public void setBeginTimeEnd(String beginTimeEnd) {
    this.beginTimeEnd = beginTimeEnd;
  }

  public ListAvailableInstancesRequest beginTimeStart(String beginTimeStart) {
    this.beginTimeStart = beginTimeStart;
    return this;
  }

   /**
   * Get beginTimeStart
   * @return beginTimeStart
  **/
  @Schema(description = "")
  public String getBeginTimeStart() {
    return beginTimeStart;
  }

  public void setBeginTimeStart(String beginTimeStart) {
    this.beginTimeStart = beginTimeStart;
  }

  public ListAvailableInstancesRequest expiredTimeEnd(String expiredTimeEnd) {
    this.expiredTimeEnd = expiredTimeEnd;
    return this;
  }

   /**
   * Get expiredTimeEnd
   * @return expiredTimeEnd
  **/
  @Schema(description = "")
  public String getExpiredTimeEnd() {
    return expiredTimeEnd;
  }

  public void setExpiredTimeEnd(String expiredTimeEnd) {
    this.expiredTimeEnd = expiredTimeEnd;
  }

  public ListAvailableInstancesRequest expiredTimeStart(String expiredTimeStart) {
    this.expiredTimeStart = expiredTimeStart;
    return this;
  }

   /**
   * Get expiredTimeStart
   * @return expiredTimeStart
  **/
  @Schema(description = "")
  public String getExpiredTimeStart() {
    return expiredTimeStart;
  }

  public void setExpiredTimeStart(String expiredTimeStart) {
    this.expiredTimeStart = expiredTimeStart;
  }

  public ListAvailableInstancesRequest instanceIDs(List<String> instanceIDs) {
    this.instanceIDs = instanceIDs;
    return this;
  }

  public ListAvailableInstancesRequest addInstanceIDsItem(String instanceIDsItem) {
    if (this.instanceIDs == null) {
      this.instanceIDs = new ArrayList<String>();
    }
    this.instanceIDs.add(instanceIDsItem);
    return this;
  }

   /**
   * Get instanceIDs
   * @return instanceIDs
  **/
  @Schema(description = "")
  public List<String> getInstanceIDs() {
    return instanceIDs;
  }

  public void setInstanceIDs(List<String> instanceIDs) {
    this.instanceIDs = instanceIDs;
  }

  public ListAvailableInstancesRequest maxResults(Integer maxResults) {
    this.maxResults = maxResults;
    return this;
  }

   /**
   * Get maxResults
   * @return maxResults
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Integer getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }

  public ListAvailableInstancesRequest nextToken(String nextToken) {
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

  public ListAvailableInstancesRequest product(String product) {
    this.product = product;
    return this;
  }

   /**
   * Get product
   * @return product
  **/
  @Schema(description = "")
  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public ListAvailableInstancesRequest renewType(String renewType) {
    this.renewType = renewType;
    return this;
  }

   /**
   * Get renewType
   * @return renewType
  **/
  @Schema(description = "")
  public String getRenewType() {
    return renewType;
  }

  public void setRenewType(String renewType) {
    this.renewType = renewType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAvailableInstancesRequest listAvailableInstancesRequest = (ListAvailableInstancesRequest) o;
    return Objects.equals(this.beginTimeEnd, listAvailableInstancesRequest.beginTimeEnd) &&
        Objects.equals(this.beginTimeStart, listAvailableInstancesRequest.beginTimeStart) &&
        Objects.equals(this.expiredTimeEnd, listAvailableInstancesRequest.expiredTimeEnd) &&
        Objects.equals(this.expiredTimeStart, listAvailableInstancesRequest.expiredTimeStart) &&
        Objects.equals(this.instanceIDs, listAvailableInstancesRequest.instanceIDs) &&
        Objects.equals(this.maxResults, listAvailableInstancesRequest.maxResults) &&
        Objects.equals(this.nextToken, listAvailableInstancesRequest.nextToken) &&
        Objects.equals(this.product, listAvailableInstancesRequest.product) &&
        Objects.equals(this.renewType, listAvailableInstancesRequest.renewType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beginTimeEnd, beginTimeStart, expiredTimeEnd, expiredTimeStart, instanceIDs, maxResults, nextToken, product, renewType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAvailableInstancesRequest {\n");
    
    sb.append("    beginTimeEnd: ").append(toIndentedString(beginTimeEnd)).append("\n");
    sb.append("    beginTimeStart: ").append(toIndentedString(beginTimeStart)).append("\n");
    sb.append("    expiredTimeEnd: ").append(toIndentedString(expiredTimeEnd)).append("\n");
    sb.append("    expiredTimeStart: ").append(toIndentedString(expiredTimeStart)).append("\n");
    sb.append("    instanceIDs: ").append(toIndentedString(instanceIDs)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    renewType: ").append(toIndentedString(renewType)).append("\n");
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
