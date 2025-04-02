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
 * Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput
 */



public class Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput {
  @SerializedName("AllocationId")
  private String allocationId = null;

  @SerializedName("Bandwidth")
  private String bandwidth = null;

  @SerializedName("BandwidthPackageId")
  private String bandwidthPackageId = null;

  @SerializedName("BillingType")
  private Integer billingType = null;

  @SerializedName("BusinessStatus")
  private String businessStatus = null;

  @SerializedName("CreationTime")
  private String creationTime = null;

  @SerializedName("DeletedTime")
  private String deletedTime = null;

  @SerializedName("ISP")
  private String ISP = null;

  @SerializedName("InstanceId")
  private String instanceId = null;

  @SerializedName("InstanceType")
  private String instanceType = null;

  @SerializedName("Ipv6Address")
  private String ipv6Address = null;

  @SerializedName("Ipv6GatewayId")
  private String ipv6GatewayId = null;

  @SerializedName("LockReason")
  private String lockReason = null;

  @SerializedName("NetworkType")
  private String networkType = null;

  @SerializedName("OverdueTime")
  private String overdueTime = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("UpdatedAt")
  private String updatedAt = null;

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput allocationId(String allocationId) {
    this.allocationId = allocationId;
    return this;
  }

   /**
   * Get allocationId
   * @return allocationId
  **/
  @Schema(description = "")
  public String getAllocationId() {
    return allocationId;
  }

  public void setAllocationId(String allocationId) {
    this.allocationId = allocationId;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput bandwidth(String bandwidth) {
    this.bandwidth = bandwidth;
    return this;
  }

   /**
   * Get bandwidth
   * @return bandwidth
  **/
  @Schema(description = "")
  public String getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(String bandwidth) {
    this.bandwidth = bandwidth;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput bandwidthPackageId(String bandwidthPackageId) {
    this.bandwidthPackageId = bandwidthPackageId;
    return this;
  }

   /**
   * Get bandwidthPackageId
   * @return bandwidthPackageId
  **/
  @Schema(description = "")
  public String getBandwidthPackageId() {
    return bandwidthPackageId;
  }

  public void setBandwidthPackageId(String bandwidthPackageId) {
    this.bandwidthPackageId = bandwidthPackageId;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput billingType(Integer billingType) {
    this.billingType = billingType;
    return this;
  }

   /**
   * Get billingType
   * @return billingType
  **/
  @Schema(description = "")
  public Integer getBillingType() {
    return billingType;
  }

  public void setBillingType(Integer billingType) {
    this.billingType = billingType;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput businessStatus(String businessStatus) {
    this.businessStatus = businessStatus;
    return this;
  }

   /**
   * Get businessStatus
   * @return businessStatus
  **/
  @Schema(description = "")
  public String getBusinessStatus() {
    return businessStatus;
  }

  public void setBusinessStatus(String businessStatus) {
    this.businessStatus = businessStatus;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput creationTime(String creationTime) {
    this.creationTime = creationTime;
    return this;
  }

   /**
   * Get creationTime
   * @return creationTime
  **/
  @Schema(description = "")
  public String getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(String creationTime) {
    this.creationTime = creationTime;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput deletedTime(String deletedTime) {
    this.deletedTime = deletedTime;
    return this;
  }

   /**
   * Get deletedTime
   * @return deletedTime
  **/
  @Schema(description = "")
  public String getDeletedTime() {
    return deletedTime;
  }

  public void setDeletedTime(String deletedTime) {
    this.deletedTime = deletedTime;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput ISP(String ISP) {
    this.ISP = ISP;
    return this;
  }

   /**
   * Get ISP
   * @return ISP
  **/
  @Schema(description = "")
  public String getISP() {
    return ISP;
  }

  public void setISP(String ISP) {
    this.ISP = ISP;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * Get instanceId
   * @return instanceId
  **/
  @Schema(description = "")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput instanceType(String instanceType) {
    this.instanceType = instanceType;
    return this;
  }

   /**
   * Get instanceType
   * @return instanceType
  **/
  @Schema(description = "")
  public String getInstanceType() {
    return instanceType;
  }

  public void setInstanceType(String instanceType) {
    this.instanceType = instanceType;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput ipv6Address(String ipv6Address) {
    this.ipv6Address = ipv6Address;
    return this;
  }

   /**
   * Get ipv6Address
   * @return ipv6Address
  **/
  @Schema(description = "")
  public String getIpv6Address() {
    return ipv6Address;
  }

  public void setIpv6Address(String ipv6Address) {
    this.ipv6Address = ipv6Address;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput ipv6GatewayId(String ipv6GatewayId) {
    this.ipv6GatewayId = ipv6GatewayId;
    return this;
  }

   /**
   * Get ipv6GatewayId
   * @return ipv6GatewayId
  **/
  @Schema(description = "")
  public String getIpv6GatewayId() {
    return ipv6GatewayId;
  }

  public void setIpv6GatewayId(String ipv6GatewayId) {
    this.ipv6GatewayId = ipv6GatewayId;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput lockReason(String lockReason) {
    this.lockReason = lockReason;
    return this;
  }

   /**
   * Get lockReason
   * @return lockReason
  **/
  @Schema(description = "")
  public String getLockReason() {
    return lockReason;
  }

  public void setLockReason(String lockReason) {
    this.lockReason = lockReason;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput networkType(String networkType) {
    this.networkType = networkType;
    return this;
  }

   /**
   * Get networkType
   * @return networkType
  **/
  @Schema(description = "")
  public String getNetworkType() {
    return networkType;
  }

  public void setNetworkType(String networkType) {
    this.networkType = networkType;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput overdueTime(String overdueTime) {
    this.overdueTime = overdueTime;
    return this;
  }

   /**
   * Get overdueTime
   * @return overdueTime
  **/
  @Schema(description = "")
  public String getOverdueTime() {
    return overdueTime;
  }

  public void setOverdueTime(String overdueTime) {
    this.overdueTime = overdueTime;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

   /**
   * Get projectName
   * @return projectName
  **/
  @Schema(description = "")
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput status(String status) {
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

  public Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @Schema(description = "")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput = (Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput) o;
    return Objects.equals(this.allocationId, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.allocationId) &&
        Objects.equals(this.bandwidth, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.bandwidth) &&
        Objects.equals(this.bandwidthPackageId, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.bandwidthPackageId) &&
        Objects.equals(this.billingType, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.billingType) &&
        Objects.equals(this.businessStatus, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.businessStatus) &&
        Objects.equals(this.creationTime, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.creationTime) &&
        Objects.equals(this.deletedTime, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.deletedTime) &&
        Objects.equals(this.ISP, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.ISP) &&
        Objects.equals(this.instanceId, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.instanceId) &&
        Objects.equals(this.instanceType, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.instanceType) &&
        Objects.equals(this.ipv6Address, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.ipv6Address) &&
        Objects.equals(this.ipv6GatewayId, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.ipv6GatewayId) &&
        Objects.equals(this.lockReason, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.lockReason) &&
        Objects.equals(this.networkType, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.networkType) &&
        Objects.equals(this.overdueTime, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.overdueTime) &&
        Objects.equals(this.projectName, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.projectName) &&
        Objects.equals(this.status, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.status) &&
        Objects.equals(this.updatedAt, ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allocationId, bandwidth, bandwidthPackageId, billingType, businessStatus, creationTime, deletedTime, ISP, instanceId, instanceType, ipv6Address, ipv6GatewayId, lockReason, networkType, overdueTime, projectName, status, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ipv6AddressBandwidthForDescribeIpv6AddressBandwidthsOutput {\n");
    
    sb.append("    allocationId: ").append(toIndentedString(allocationId)).append("\n");
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    bandwidthPackageId: ").append(toIndentedString(bandwidthPackageId)).append("\n");
    sb.append("    billingType: ").append(toIndentedString(billingType)).append("\n");
    sb.append("    businessStatus: ").append(toIndentedString(businessStatus)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    deletedTime: ").append(toIndentedString(deletedTime)).append("\n");
    sb.append("    ISP: ").append(toIndentedString(ISP)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    ipv6Address: ").append(toIndentedString(ipv6Address)).append("\n");
    sb.append("    ipv6GatewayId: ").append(toIndentedString(ipv6GatewayId)).append("\n");
    sb.append("    lockReason: ").append(toIndentedString(lockReason)).append("\n");
    sb.append("    networkType: ").append(toIndentedString(networkType)).append("\n");
    sb.append("    overdueTime: ").append(toIndentedString(overdueTime)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
