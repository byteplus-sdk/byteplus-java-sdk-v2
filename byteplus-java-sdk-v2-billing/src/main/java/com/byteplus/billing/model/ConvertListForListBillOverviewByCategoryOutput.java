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
import com.byteplus.billing.model.ListForListBillOverviewByCategoryOutput;
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
 * ConvertListForListBillOverviewByCategoryOutput
 */



public class ConvertListForListBillOverviewByCategoryOutput {
  @SerializedName("List")
  private List<ListForListBillOverviewByCategoryOutput> list = null;

  public ConvertListForListBillOverviewByCategoryOutput list(List<ListForListBillOverviewByCategoryOutput> list) {
    this.list = list;
    return this;
  }

  public ConvertListForListBillOverviewByCategoryOutput addListItem(ListForListBillOverviewByCategoryOutput listItem) {
    if (this.list == null) {
      this.list = new ArrayList<ListForListBillOverviewByCategoryOutput>();
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
  public List<ListForListBillOverviewByCategoryOutput> getList() {
    return list;
  }

  public void setList(List<ListForListBillOverviewByCategoryOutput> list) {
    this.list = list;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvertListForListBillOverviewByCategoryOutput convertListForListBillOverviewByCategoryOutput = (ConvertListForListBillOverviewByCategoryOutput) o;
    return Objects.equals(this.list, convertListForListBillOverviewByCategoryOutput.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertListForListBillOverviewByCategoryOutput {\n");
    
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
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
