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
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * DescribeSpotPriceHistoryRequest
 */



public class DescribeSpotPriceHistoryRequest {
  @SerializedName("InstanceTypeId")
  private String instanceTypeId = null;

  @SerializedName("MaxResults")
  private Integer maxResults = null;

  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("TimestampEnd")
  private String timestampEnd = null;

  @SerializedName("TimestampStart")
  private String timestampStart = null;

  @SerializedName("ZoneId")
  private String zoneId = null;

  public DescribeSpotPriceHistoryRequest instanceTypeId(String instanceTypeId) {
    this.instanceTypeId = instanceTypeId;
    return this;
  }

   /**
   * Get instanceTypeId
   * @return instanceTypeId
  **/
  @Schema(description = "")
  public String getInstanceTypeId() {
    return instanceTypeId;
  }

  public void setInstanceTypeId(String instanceTypeId) {
    this.instanceTypeId = instanceTypeId;
  }

  public DescribeSpotPriceHistoryRequest maxResults(Integer maxResults) {
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

  public DescribeSpotPriceHistoryRequest nextToken(String nextToken) {
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

  public DescribeSpotPriceHistoryRequest timestampEnd(String timestampEnd) {
    this.timestampEnd = timestampEnd;
    return this;
  }

   /**
   * Get timestampEnd
   * @return timestampEnd
  **/
  @Schema(description = "")
  public String getTimestampEnd() {
    return timestampEnd;
  }

  public void setTimestampEnd(String timestampEnd) {
    this.timestampEnd = timestampEnd;
  }

  public DescribeSpotPriceHistoryRequest timestampStart(String timestampStart) {
    this.timestampStart = timestampStart;
    return this;
  }

   /**
   * Get timestampStart
   * @return timestampStart
  **/
  @Schema(description = "")
  public String getTimestampStart() {
    return timestampStart;
  }

  public void setTimestampStart(String timestampStart) {
    this.timestampStart = timestampStart;
  }

  public DescribeSpotPriceHistoryRequest zoneId(String zoneId) {
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
    DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest = (DescribeSpotPriceHistoryRequest) o;
    return Objects.equals(this.instanceTypeId, describeSpotPriceHistoryRequest.instanceTypeId) &&
        Objects.equals(this.maxResults, describeSpotPriceHistoryRequest.maxResults) &&
        Objects.equals(this.nextToken, describeSpotPriceHistoryRequest.nextToken) &&
        Objects.equals(this.timestampEnd, describeSpotPriceHistoryRequest.timestampEnd) &&
        Objects.equals(this.timestampStart, describeSpotPriceHistoryRequest.timestampStart) &&
        Objects.equals(this.zoneId, describeSpotPriceHistoryRequest.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceTypeId, maxResults, nextToken, timestampEnd, timestampStart, zoneId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeSpotPriceHistoryRequest {\n");
    
    sb.append("    instanceTypeId: ").append(toIndentedString(instanceTypeId)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    timestampEnd: ").append(toIndentedString(timestampEnd)).append("\n");
    sb.append("    timestampStart: ").append(toIndentedString(timestampStart)).append("\n");
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
