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
 * ListSplitBillDetailRequest
 */



public class ListSplitBillDetailRequest {
  @SerializedName("BillCategory")
  private List<String> billCategory = null;

  @SerializedName("BillPeriod")
  private String billPeriod = null;

  @SerializedName("BillingMode")
  private List<String> billingMode = null;

  @SerializedName("ExpenseDate")
  private String expenseDate = null;

  @SerializedName("GroupPeriod")
  private Integer groupPeriod = null;

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

  @SerializedName("SplitItemID")
  private String splitItemID = null;

  public ListSplitBillDetailRequest billCategory(List<String> billCategory) {
    this.billCategory = billCategory;
    return this;
  }

  public ListSplitBillDetailRequest addBillCategoryItem(String billCategoryItem) {
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

  public ListSplitBillDetailRequest billPeriod(String billPeriod) {
    this.billPeriod = billPeriod;
    return this;
  }

   /**
   * Get billPeriod
   * @return billPeriod
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getBillPeriod() {
    return billPeriod;
  }

  public void setBillPeriod(String billPeriod) {
    this.billPeriod = billPeriod;
  }

  public ListSplitBillDetailRequest billingMode(List<String> billingMode) {
    this.billingMode = billingMode;
    return this;
  }

  public ListSplitBillDetailRequest addBillingModeItem(String billingModeItem) {
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

  public ListSplitBillDetailRequest expenseDate(String expenseDate) {
    this.expenseDate = expenseDate;
    return this;
  }

   /**
   * Get expenseDate
   * @return expenseDate
  **/
  @Schema(description = "")
  public String getExpenseDate() {
    return expenseDate;
  }

  public void setExpenseDate(String expenseDate) {
    this.expenseDate = expenseDate;
  }

  public ListSplitBillDetailRequest groupPeriod(Integer groupPeriod) {
    this.groupPeriod = groupPeriod;
    return this;
  }

   /**
   * Get groupPeriod
   * @return groupPeriod
  **/
  @Schema(description = "")
  public Integer getGroupPeriod() {
    return groupPeriod;
  }

  public void setGroupPeriod(Integer groupPeriod) {
    this.groupPeriod = groupPeriod;
  }

  public ListSplitBillDetailRequest ignoreZero(Integer ignoreZero) {
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

  public ListSplitBillDetailRequest instanceNo(String instanceNo) {
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

  public ListSplitBillDetailRequest limit(Integer limit) {
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

  public ListSplitBillDetailRequest needRecordNum(Integer needRecordNum) {
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

  public ListSplitBillDetailRequest offset(Integer offset) {
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

  public ListSplitBillDetailRequest ownerID(List<Long> ownerID) {
    this.ownerID = ownerID;
    return this;
  }

  public ListSplitBillDetailRequest addOwnerIDItem(Long ownerIDItem) {
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

  public ListSplitBillDetailRequest payerID(List<Long> payerID) {
    this.payerID = payerID;
    return this;
  }

  public ListSplitBillDetailRequest addPayerIDItem(Long payerIDItem) {
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

  public ListSplitBillDetailRequest product(List<String> product) {
    this.product = product;
    return this;
  }

  public ListSplitBillDetailRequest addProductItem(String productItem) {
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

  public ListSplitBillDetailRequest splitItemID(String splitItemID) {
    this.splitItemID = splitItemID;
    return this;
  }

   /**
   * Get splitItemID
   * @return splitItemID
  **/
  @Schema(description = "")
  public String getSplitItemID() {
    return splitItemID;
  }

  public void setSplitItemID(String splitItemID) {
    this.splitItemID = splitItemID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListSplitBillDetailRequest listSplitBillDetailRequest = (ListSplitBillDetailRequest) o;
    return Objects.equals(this.billCategory, listSplitBillDetailRequest.billCategory) &&
        Objects.equals(this.billPeriod, listSplitBillDetailRequest.billPeriod) &&
        Objects.equals(this.billingMode, listSplitBillDetailRequest.billingMode) &&
        Objects.equals(this.expenseDate, listSplitBillDetailRequest.expenseDate) &&
        Objects.equals(this.groupPeriod, listSplitBillDetailRequest.groupPeriod) &&
        Objects.equals(this.ignoreZero, listSplitBillDetailRequest.ignoreZero) &&
        Objects.equals(this.instanceNo, listSplitBillDetailRequest.instanceNo) &&
        Objects.equals(this.limit, listSplitBillDetailRequest.limit) &&
        Objects.equals(this.needRecordNum, listSplitBillDetailRequest.needRecordNum) &&
        Objects.equals(this.offset, listSplitBillDetailRequest.offset) &&
        Objects.equals(this.ownerID, listSplitBillDetailRequest.ownerID) &&
        Objects.equals(this.payerID, listSplitBillDetailRequest.payerID) &&
        Objects.equals(this.product, listSplitBillDetailRequest.product) &&
        Objects.equals(this.splitItemID, listSplitBillDetailRequest.splitItemID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billCategory, billPeriod, billingMode, expenseDate, groupPeriod, ignoreZero, instanceNo, limit, needRecordNum, offset, ownerID, payerID, product, splitItemID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListSplitBillDetailRequest {\n");
    
    sb.append("    billCategory: ").append(toIndentedString(billCategory)).append("\n");
    sb.append("    billPeriod: ").append(toIndentedString(billPeriod)).append("\n");
    sb.append("    billingMode: ").append(toIndentedString(billingMode)).append("\n");
    sb.append("    expenseDate: ").append(toIndentedString(expenseDate)).append("\n");
    sb.append("    groupPeriod: ").append(toIndentedString(groupPeriod)).append("\n");
    sb.append("    ignoreZero: ").append(toIndentedString(ignoreZero)).append("\n");
    sb.append("    instanceNo: ").append(toIndentedString(instanceNo)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    needRecordNum: ").append(toIndentedString(needRecordNum)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    ownerID: ").append(toIndentedString(ownerID)).append("\n");
    sb.append("    payerID: ").append(toIndentedString(payerID)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    splitItemID: ").append(toIndentedString(splitItemID)).append("\n");
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
