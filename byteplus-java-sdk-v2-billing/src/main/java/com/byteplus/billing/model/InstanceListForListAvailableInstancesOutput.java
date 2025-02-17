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
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * InstanceListForListAvailableInstancesOutput
 */



public class InstanceListForListAvailableInstancesOutput {
  @SerializedName("AccountID")
  private Integer accountID = null;

  @SerializedName("BeginTime")
  private String beginTime = null;

  @SerializedName("ConfigurationCode")
  private String configurationCode = null;

  @SerializedName("ExpiredTime")
  private String expiredTime = null;

  @SerializedName("InstanceID")
  private String instanceID = null;

  @SerializedName("InstanceName")
  private String instanceName = null;

  @SerializedName("PaymentMethod")
  private String paymentMethod = null;

  @SerializedName("Product")
  private String product = null;

  @SerializedName("RemainRenewTimes")
  private String remainRenewTimes = null;

  @SerializedName("RenewType")
  private String renewType = null;

  @SerializedName("RenewalDurationUnit")
  private String renewalDurationUnit = null;

  @SerializedName("RenewalTimes")
  private String renewalTimes = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("SubStatus")
  private String subStatus = null;

  public InstanceListForListAvailableInstancesOutput accountID(Integer accountID) {
    this.accountID = accountID;
    return this;
  }

   /**
   * Get accountID
   * @return accountID
  **/
  @Schema(description = "")
  public Integer getAccountID() {
    return accountID;
  }

  public void setAccountID(Integer accountID) {
    this.accountID = accountID;
  }

  public InstanceListForListAvailableInstancesOutput beginTime(String beginTime) {
    this.beginTime = beginTime;
    return this;
  }

   /**
   * Get beginTime
   * @return beginTime
  **/
  @Schema(description = "")
  public String getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }

  public InstanceListForListAvailableInstancesOutput configurationCode(String configurationCode) {
    this.configurationCode = configurationCode;
    return this;
  }

   /**
   * Get configurationCode
   * @return configurationCode
  **/
  @Schema(description = "")
  public String getConfigurationCode() {
    return configurationCode;
  }

  public void setConfigurationCode(String configurationCode) {
    this.configurationCode = configurationCode;
  }

  public InstanceListForListAvailableInstancesOutput expiredTime(String expiredTime) {
    this.expiredTime = expiredTime;
    return this;
  }

   /**
   * Get expiredTime
   * @return expiredTime
  **/
  @Schema(description = "")
  public String getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(String expiredTime) {
    this.expiredTime = expiredTime;
  }

  public InstanceListForListAvailableInstancesOutput instanceID(String instanceID) {
    this.instanceID = instanceID;
    return this;
  }

   /**
   * Get instanceID
   * @return instanceID
  **/
  @Schema(description = "")
  public String getInstanceID() {
    return instanceID;
  }

  public void setInstanceID(String instanceID) {
    this.instanceID = instanceID;
  }

  public InstanceListForListAvailableInstancesOutput instanceName(String instanceName) {
    this.instanceName = instanceName;
    return this;
  }

   /**
   * Get instanceName
   * @return instanceName
  **/
  @Schema(description = "")
  public String getInstanceName() {
    return instanceName;
  }

  public void setInstanceName(String instanceName) {
    this.instanceName = instanceName;
  }

  public InstanceListForListAvailableInstancesOutput paymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @Schema(description = "")
  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public InstanceListForListAvailableInstancesOutput product(String product) {
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

  public InstanceListForListAvailableInstancesOutput remainRenewTimes(String remainRenewTimes) {
    this.remainRenewTimes = remainRenewTimes;
    return this;
  }

   /**
   * Get remainRenewTimes
   * @return remainRenewTimes
  **/
  @Schema(description = "")
  public String getRemainRenewTimes() {
    return remainRenewTimes;
  }

  public void setRemainRenewTimes(String remainRenewTimes) {
    this.remainRenewTimes = remainRenewTimes;
  }

  public InstanceListForListAvailableInstancesOutput renewType(String renewType) {
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

  public InstanceListForListAvailableInstancesOutput renewalDurationUnit(String renewalDurationUnit) {
    this.renewalDurationUnit = renewalDurationUnit;
    return this;
  }

   /**
   * Get renewalDurationUnit
   * @return renewalDurationUnit
  **/
  @Schema(description = "")
  public String getRenewalDurationUnit() {
    return renewalDurationUnit;
  }

  public void setRenewalDurationUnit(String renewalDurationUnit) {
    this.renewalDurationUnit = renewalDurationUnit;
  }

  public InstanceListForListAvailableInstancesOutput renewalTimes(String renewalTimes) {
    this.renewalTimes = renewalTimes;
    return this;
  }

   /**
   * Get renewalTimes
   * @return renewalTimes
  **/
  @Schema(description = "")
  public String getRenewalTimes() {
    return renewalTimes;
  }

  public void setRenewalTimes(String renewalTimes) {
    this.renewalTimes = renewalTimes;
  }

  public InstanceListForListAvailableInstancesOutput status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(description = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public InstanceListForListAvailableInstancesOutput subStatus(String subStatus) {
    this.subStatus = subStatus;
    return this;
  }

   /**
   * Get subStatus
   * @return subStatus
  **/
  @Schema(description = "")
  public String getSubStatus() {
    return subStatus;
  }

  public void setSubStatus(String subStatus) {
    this.subStatus = subStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceListForListAvailableInstancesOutput instanceListForListAvailableInstancesOutput = (InstanceListForListAvailableInstancesOutput) o;
    return Objects.equals(this.accountID, instanceListForListAvailableInstancesOutput.accountID) &&
        Objects.equals(this.beginTime, instanceListForListAvailableInstancesOutput.beginTime) &&
        Objects.equals(this.configurationCode, instanceListForListAvailableInstancesOutput.configurationCode) &&
        Objects.equals(this.expiredTime, instanceListForListAvailableInstancesOutput.expiredTime) &&
        Objects.equals(this.instanceID, instanceListForListAvailableInstancesOutput.instanceID) &&
        Objects.equals(this.instanceName, instanceListForListAvailableInstancesOutput.instanceName) &&
        Objects.equals(this.paymentMethod, instanceListForListAvailableInstancesOutput.paymentMethod) &&
        Objects.equals(this.product, instanceListForListAvailableInstancesOutput.product) &&
        Objects.equals(this.remainRenewTimes, instanceListForListAvailableInstancesOutput.remainRenewTimes) &&
        Objects.equals(this.renewType, instanceListForListAvailableInstancesOutput.renewType) &&
        Objects.equals(this.renewalDurationUnit, instanceListForListAvailableInstancesOutput.renewalDurationUnit) &&
        Objects.equals(this.renewalTimes, instanceListForListAvailableInstancesOutput.renewalTimes) &&
        Objects.equals(this.status, instanceListForListAvailableInstancesOutput.status) &&
        Objects.equals(this.subStatus, instanceListForListAvailableInstancesOutput.subStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountID, beginTime, configurationCode, expiredTime, instanceID, instanceName, paymentMethod, product, remainRenewTimes, renewType, renewalDurationUnit, renewalTimes, status, subStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstanceListForListAvailableInstancesOutput {\n");
    
    sb.append("    accountID: ").append(toIndentedString(accountID)).append("\n");
    sb.append("    beginTime: ").append(toIndentedString(beginTime)).append("\n");
    sb.append("    configurationCode: ").append(toIndentedString(configurationCode)).append("\n");
    sb.append("    expiredTime: ").append(toIndentedString(expiredTime)).append("\n");
    sb.append("    instanceID: ").append(toIndentedString(instanceID)).append("\n");
    sb.append("    instanceName: ").append(toIndentedString(instanceName)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    remainRenewTimes: ").append(toIndentedString(remainRenewTimes)).append("\n");
    sb.append("    renewType: ").append(toIndentedString(renewType)).append("\n");
    sb.append("    renewalDurationUnit: ").append(toIndentedString(renewalDurationUnit)).append("\n");
    sb.append("    renewalTimes: ").append(toIndentedString(renewalTimes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subStatus: ").append(toIndentedString(subStatus)).append("\n");
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
