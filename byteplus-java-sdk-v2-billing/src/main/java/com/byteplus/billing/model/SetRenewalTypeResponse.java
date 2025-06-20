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
import com.byteplus.billing.model.SuccessInstanceListForSetRenewalTypeOutput;
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
 * SetRenewalTypeResponse
 */



public class SetRenewalTypeResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("SuccessInstanceList")
  private List<SuccessInstanceListForSetRenewalTypeOutput> successInstanceList = null;

  public SetRenewalTypeResponse successInstanceList(List<SuccessInstanceListForSetRenewalTypeOutput> successInstanceList) {
    this.successInstanceList = successInstanceList;
    return this;
  }

  public SetRenewalTypeResponse addSuccessInstanceListItem(SuccessInstanceListForSetRenewalTypeOutput successInstanceListItem) {
    if (this.successInstanceList == null) {
      this.successInstanceList = new ArrayList<SuccessInstanceListForSetRenewalTypeOutput>();
    }
    this.successInstanceList.add(successInstanceListItem);
    return this;
  }

   /**
   * Get successInstanceList
   * @return successInstanceList
  **/
  @Valid
  @Schema(description = "")
  public List<SuccessInstanceListForSetRenewalTypeOutput> getSuccessInstanceList() {
    return successInstanceList;
  }

  public void setSuccessInstanceList(List<SuccessInstanceListForSetRenewalTypeOutput> successInstanceList) {
    this.successInstanceList = successInstanceList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetRenewalTypeResponse setRenewalTypeResponse = (SetRenewalTypeResponse) o;
    return Objects.equals(this.successInstanceList, setRenewalTypeResponse.successInstanceList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(successInstanceList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetRenewalTypeResponse {\n");
    
    sb.append("    successInstanceList: ").append(toIndentedString(successInstanceList)).append("\n");
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
