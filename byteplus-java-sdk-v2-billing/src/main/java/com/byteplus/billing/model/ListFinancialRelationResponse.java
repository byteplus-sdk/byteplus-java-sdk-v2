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
import com.byteplus.billing.model.ListForListFinancialRelationOutput;
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
 * ListFinancialRelationResponse
 */



public class ListFinancialRelationResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("Limit")
  private Integer limit = null;

  @SerializedName("List")
  private List<ListForListFinancialRelationOutput> list = null;

  @SerializedName("Offset")
  private Integer offset = null;

  @SerializedName("Total")
  private Integer total = null;

  public ListFinancialRelationResponse limit(Integer limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @Schema(description = "")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public ListFinancialRelationResponse list(List<ListForListFinancialRelationOutput> list) {
    this.list = list;
    return this;
  }

  public ListFinancialRelationResponse addListItem(ListForListFinancialRelationOutput listItem) {
    if (this.list == null) {
      this.list = new ArrayList<ListForListFinancialRelationOutput>();
    }
    this.list.add(listItem);
    return this;
  }

   /**
   * Get list
   * @return list
  **/
  @Valid
  @Schema(description = "")
  public List<ListForListFinancialRelationOutput> getList() {
    return list;
  }

  public void setList(List<ListForListFinancialRelationOutput> list) {
    this.list = list;
  }

  public ListFinancialRelationResponse offset(Integer offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @Schema(description = "")
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public ListFinancialRelationResponse total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @Schema(description = "")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListFinancialRelationResponse listFinancialRelationResponse = (ListFinancialRelationResponse) o;
    return Objects.equals(this.limit, listFinancialRelationResponse.limit) &&
        Objects.equals(this.list, listFinancialRelationResponse.list) &&
        Objects.equals(this.offset, listFinancialRelationResponse.offset) &&
        Objects.equals(this.total, listFinancialRelationResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(limit, list, offset, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListFinancialRelationResponse {\n");
    
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
