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
 * ListAmortizedCostBillDailyRequest
 */



public class ListAmortizedCostBillDailyRequest {
  @SerializedName("AmortizedDay")
  private String amortizedDay = null;

  @SerializedName("AmortizedMonth")
  private String amortizedMonth = null;

  @SerializedName("AmortizedType")
  private List<String> amortizedType = null;

  @SerializedName("BillCategory")
  private List<String> billCategory = null;

  @SerializedName("BillPeriod")
  private String billPeriod = null;

  @SerializedName("BillingMode")
  private List<String> billingMode = null;

  @SerializedName("IgnoreZero")
  private Integer ignoreZero = null;

  @SerializedName("InstanceNo")
  private String instanceNo = null;

  @SerializedName("Limit")
  private Integer limit = null;

  @SerializedName("NeedRecordNum")
  private Integer needRecordNum = null;

  @SerializedName("Offset")
  private Integer offset = null;

  @SerializedName("OwnerID")
  private List<Long> ownerID = null;

  @SerializedName("PayerID")
  private List<Long> payerID = null;

  @SerializedName("Product")
  private List<String> product = null;

  public ListAmortizedCostBillDailyRequest amortizedDay(String amortizedDay) {
    this.amortizedDay = amortizedDay;
    return this;
  }

   /**
   * Get amortizedDay
   * @return amortizedDay
  **/
  @Schema(description = "")
  public String getAmortizedDay() {
    return amortizedDay;
  }

  public void setAmortizedDay(String amortizedDay) {
    this.amortizedDay = amortizedDay;
  }

  public ListAmortizedCostBillDailyRequest amortizedMonth(String amortizedMonth) {
    this.amortizedMonth = amortizedMonth;
    return this;
  }

   /**
   * Get amortizedMonth
   * @return amortizedMonth
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getAmortizedMonth() {
    return amortizedMonth;
  }

  public void setAmortizedMonth(String amortizedMonth) {
    this.amortizedMonth = amortizedMonth;
  }

  public ListAmortizedCostBillDailyRequest amortizedType(List<String> amortizedType) {
    this.amortizedType = amortizedType;
    return this;
  }

  public ListAmortizedCostBillDailyRequest addAmortizedTypeItem(String amortizedTypeItem) {
    if (this.amortizedType == null) {
      this.amortizedType = new ArrayList<String>();
    }
    this.amortizedType.add(amortizedTypeItem);
    return this;
  }

   /**
   * Get amortizedType
   * @return amortizedType
  **/
  @Schema(description = "")
  public List<String> getAmortizedType() {
    return amortizedType;
  }

  public void setAmortizedType(List<String> amortizedType) {
    this.amortizedType = amortizedType;
  }

  public ListAmortizedCostBillDailyRequest billCategory(List<String> billCategory) {
    this.billCategory = billCategory;
    return this;
  }

  public ListAmortizedCostBillDailyRequest addBillCategoryItem(String billCategoryItem) {
    if (this.billCategory == null) {
      this.billCategory = new ArrayList<String>();
    }
    this.billCategory.add(billCategoryItem);
    return this;
  }

   /**
   * Get billCategory
   * @return billCategory
  **/
  @Schema(description = "")
  public List<String> getBillCategory() {
    return billCategory;
  }

  public void setBillCategory(List<String> billCategory) {
    this.billCategory = billCategory;
  }

  public ListAmortizedCostBillDailyRequest billPeriod(String billPeriod) {
    this.billPeriod = billPeriod;
    return this;
  }

   /**
   * Get billPeriod
   * @return billPeriod
  **/
  @Schema(description = "")
  public String getBillPeriod() {
    return billPeriod;
  }

  public void setBillPeriod(String billPeriod) {
    this.billPeriod = billPeriod;
  }

  public ListAmortizedCostBillDailyRequest billingMode(List<String> billingMode) {
    this.billingMode = billingMode;
    return this;
  }

  public ListAmortizedCostBillDailyRequest addBillingModeItem(String billingModeItem) {
    if (this.billingMode == null) {
      this.billingMode = new ArrayList<String>();
    }
    this.billingMode.add(billingModeItem);
    return this;
  }

   /**
   * Get billingMode
   * @return billingMode
  **/
  @Schema(description = "")
  public List<String> getBillingMode() {
    return billingMode;
  }

  public void setBillingMode(List<String> billingMode) {
    this.billingMode = billingMode;
  }

  public ListAmortizedCostBillDailyRequest ignoreZero(Integer ignoreZero) {
    this.ignoreZero = ignoreZero;
    return this;
  }

   /**
   * Get ignoreZero
   * @return ignoreZero
  **/
  @Schema(description = "")
  public Integer getIgnoreZero() {
    return ignoreZero;
  }

  public void setIgnoreZero(Integer ignoreZero) {
    this.ignoreZero = ignoreZero;
  }

  public ListAmortizedCostBillDailyRequest instanceNo(String instanceNo) {
    this.instanceNo = instanceNo;
    return this;
  }

   /**
   * Get instanceNo
   * @return instanceNo
  **/
  @Schema(description = "")
  public String getInstanceNo() {
    return instanceNo;
  }

  public void setInstanceNo(String instanceNo) {
    this.instanceNo = instanceNo;
  }

  public ListAmortizedCostBillDailyRequest limit(Integer limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public ListAmortizedCostBillDailyRequest needRecordNum(Integer needRecordNum) {
    this.needRecordNum = needRecordNum;
    return this;
  }

   /**
   * Get needRecordNum
   * @return needRecordNum
  **/
  @Schema(description = "")
  public Integer getNeedRecordNum() {
    return needRecordNum;
  }

  public void setNeedRecordNum(Integer needRecordNum) {
    this.needRecordNum = needRecordNum;
  }

  public ListAmortizedCostBillDailyRequest offset(Integer offset) {
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

  public ListAmortizedCostBillDailyRequest ownerID(List<Long> ownerID) {
    this.ownerID = ownerID;
    return this;
  }

  public ListAmortizedCostBillDailyRequest addOwnerIDItem(Long ownerIDItem) {
    if (this.ownerID == null) {
      this.ownerID = new ArrayList<Long>();
    }
    this.ownerID.add(ownerIDItem);
    return this;
  }

   /**
   * Get ownerID
   * @return ownerID
  **/
  @Schema(description = "")
  public List<Long> getOwnerID() {
    return ownerID;
  }

  public void setOwnerID(List<Long> ownerID) {
    this.ownerID = ownerID;
  }

  public ListAmortizedCostBillDailyRequest payerID(List<Long> payerID) {
    this.payerID = payerID;
    return this;
  }

  public ListAmortizedCostBillDailyRequest addPayerIDItem(Long payerIDItem) {
    if (this.payerID == null) {
      this.payerID = new ArrayList<Long>();
    }
    this.payerID.add(payerIDItem);
    return this;
  }

   /**
   * Get payerID
   * @return payerID
  **/
  @Schema(description = "")
  public List<Long> getPayerID() {
    return payerID;
  }

  public void setPayerID(List<Long> payerID) {
    this.payerID = payerID;
  }

  public ListAmortizedCostBillDailyRequest product(List<String> product) {
    this.product = product;
    return this;
  }

  public ListAmortizedCostBillDailyRequest addProductItem(String productItem) {
    if (this.product == null) {
      this.product = new ArrayList<String>();
    }
    this.product.add(productItem);
    return this;
  }

   /**
   * Get product
   * @return product
  **/
  @Schema(description = "")
  public List<String> getProduct() {
    return product;
  }

  public void setProduct(List<String> product) {
    this.product = product;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAmortizedCostBillDailyRequest listAmortizedCostBillDailyRequest = (ListAmortizedCostBillDailyRequest) o;
    return Objects.equals(this.amortizedDay, listAmortizedCostBillDailyRequest.amortizedDay) &&
        Objects.equals(this.amortizedMonth, listAmortizedCostBillDailyRequest.amortizedMonth) &&
        Objects.equals(this.amortizedType, listAmortizedCostBillDailyRequest.amortizedType) &&
        Objects.equals(this.billCategory, listAmortizedCostBillDailyRequest.billCategory) &&
        Objects.equals(this.billPeriod, listAmortizedCostBillDailyRequest.billPeriod) &&
        Objects.equals(this.billingMode, listAmortizedCostBillDailyRequest.billingMode) &&
        Objects.equals(this.ignoreZero, listAmortizedCostBillDailyRequest.ignoreZero) &&
        Objects.equals(this.instanceNo, listAmortizedCostBillDailyRequest.instanceNo) &&
        Objects.equals(this.limit, listAmortizedCostBillDailyRequest.limit) &&
        Objects.equals(this.needRecordNum, listAmortizedCostBillDailyRequest.needRecordNum) &&
        Objects.equals(this.offset, listAmortizedCostBillDailyRequest.offset) &&
        Objects.equals(this.ownerID, listAmortizedCostBillDailyRequest.ownerID) &&
        Objects.equals(this.payerID, listAmortizedCostBillDailyRequest.payerID) &&
        Objects.equals(this.product, listAmortizedCostBillDailyRequest.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amortizedDay, amortizedMonth, amortizedType, billCategory, billPeriod, billingMode, ignoreZero, instanceNo, limit, needRecordNum, offset, ownerID, payerID, product);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAmortizedCostBillDailyRequest {\n");
    
    sb.append("    amortizedDay: ").append(toIndentedString(amortizedDay)).append("\n");
    sb.append("    amortizedMonth: ").append(toIndentedString(amortizedMonth)).append("\n");
    sb.append("    amortizedType: ").append(toIndentedString(amortizedType)).append("\n");
    sb.append("    billCategory: ").append(toIndentedString(billCategory)).append("\n");
    sb.append("    billPeriod: ").append(toIndentedString(billPeriod)).append("\n");
    sb.append("    billingMode: ").append(toIndentedString(billingMode)).append("\n");
    sb.append("    ignoreZero: ").append(toIndentedString(ignoreZero)).append("\n");
    sb.append("    instanceNo: ").append(toIndentedString(instanceNo)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    needRecordNum: ").append(toIndentedString(needRecordNum)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    ownerID: ").append(toIndentedString(ownerID)).append("\n");
    sb.append("    payerID: ").append(toIndentedString(payerID)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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
