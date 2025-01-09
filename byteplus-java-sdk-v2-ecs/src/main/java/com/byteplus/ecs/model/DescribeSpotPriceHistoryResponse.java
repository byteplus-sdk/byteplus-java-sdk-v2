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
import com.byteplus.ecs.model.SpotPriceForDescribeSpotPriceHistoryOutput;
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
 * DescribeSpotPriceHistoryResponse
 */



public class DescribeSpotPriceHistoryResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("SpotPrices")
  private List<SpotPriceForDescribeSpotPriceHistoryOutput> spotPrices = null;

  public DescribeSpotPriceHistoryResponse nextToken(String nextToken) {
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

  public DescribeSpotPriceHistoryResponse spotPrices(List<SpotPriceForDescribeSpotPriceHistoryOutput> spotPrices) {
    this.spotPrices = spotPrices;
    return this;
  }

  public DescribeSpotPriceHistoryResponse addSpotPricesItem(SpotPriceForDescribeSpotPriceHistoryOutput spotPricesItem) {
    if (this.spotPrices == null) {
      this.spotPrices = new ArrayList<SpotPriceForDescribeSpotPriceHistoryOutput>();
    }
    this.spotPrices.add(spotPricesItem);
    return this;
  }

   /**
   * Get spotPrices
   * @return spotPrices
  **/
  @Valid
  @Schema(description = "")
  public List<SpotPriceForDescribeSpotPriceHistoryOutput> getSpotPrices() {
    return spotPrices;
  }

  public void setSpotPrices(List<SpotPriceForDescribeSpotPriceHistoryOutput> spotPrices) {
    this.spotPrices = spotPrices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeSpotPriceHistoryResponse describeSpotPriceHistoryResponse = (DescribeSpotPriceHistoryResponse) o;
    return Objects.equals(this.nextToken, describeSpotPriceHistoryResponse.nextToken) &&
        Objects.equals(this.spotPrices, describeSpotPriceHistoryResponse.spotPrices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextToken, spotPrices);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeSpotPriceHistoryResponse {\n");
    
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    spotPrices: ").append(toIndentedString(spotPrices)).append("\n");
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
