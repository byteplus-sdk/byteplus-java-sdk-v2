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
import com.byteplus.vpc.model.TagForDescribeEipAddressesOutput;
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
 * EipAddressForDescribeEipAddressesOutput
 */



public class EipAddressForDescribeEipAddressesOutput {
  @SerializedName("AllocationId")
  private String allocationId = null;

  @SerializedName("AllocationTime")
  private String allocationTime = null;

  @SerializedName("Bandwidth")
  private Integer bandwidth = null;

  @SerializedName("BandwidthPackageId")
  private String bandwidthPackageId = null;

  @SerializedName("BillingType")
  private Integer billingType = null;

  @SerializedName("BusinessStatus")
  private String businessStatus = null;

  @SerializedName("DeletedTime")
  private String deletedTime = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("EipAddress")
  private String eipAddress = null;

  @SerializedName("ExpiredTime")
  private String expiredTime = null;

  @SerializedName("ISP")
  private String ISP = null;

  @SerializedName("InstanceId")
  private String instanceId = null;

  @SerializedName("InstanceType")
  private String instanceType = null;

  @SerializedName("IpAddressPoolId")
  private String ipAddressPoolId = null;

  @SerializedName("LockReason")
  private String lockReason = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("OverdueTime")
  private String overdueTime = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("ReleaseWithInstance")
  private Boolean releaseWithInstance = null;

  @SerializedName("SecurityProtectionTypes")
  private List<String> securityProtectionTypes = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("Tags")
  private List<TagForDescribeEipAddressesOutput> tags = null;

  @SerializedName("UpdatedAt")
  private String updatedAt = null;

  public EipAddressForDescribeEipAddressesOutput allocationId(String allocationId) {
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

  public EipAddressForDescribeEipAddressesOutput allocationTime(String allocationTime) {
    this.allocationTime = allocationTime;
    return this;
  }

   /**
   * Get allocationTime
   * @return allocationTime
  **/
  @Schema(description = "")
  public String getAllocationTime() {
    return allocationTime;
  }

  public void setAllocationTime(String allocationTime) {
    this.allocationTime = allocationTime;
  }

  public EipAddressForDescribeEipAddressesOutput bandwidth(Integer bandwidth) {
    this.bandwidth = bandwidth;
    return this;
  }

   /**
   * Get bandwidth
   * @return bandwidth
  **/
  @Schema(description = "")
  public Integer getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(Integer bandwidth) {
    this.bandwidth = bandwidth;
  }

  public EipAddressForDescribeEipAddressesOutput bandwidthPackageId(String bandwidthPackageId) {
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

  public EipAddressForDescribeEipAddressesOutput billingType(Integer billingType) {
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

  public EipAddressForDescribeEipAddressesOutput businessStatus(String businessStatus) {
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

  public EipAddressForDescribeEipAddressesOutput deletedTime(String deletedTime) {
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

  public EipAddressForDescribeEipAddressesOutput description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EipAddressForDescribeEipAddressesOutput eipAddress(String eipAddress) {
    this.eipAddress = eipAddress;
    return this;
  }

   /**
   * Get eipAddress
   * @return eipAddress
  **/
  @Schema(description = "")
  public String getEipAddress() {
    return eipAddress;
  }

  public void setEipAddress(String eipAddress) {
    this.eipAddress = eipAddress;
  }

  public EipAddressForDescribeEipAddressesOutput expiredTime(String expiredTime) {
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

  public EipAddressForDescribeEipAddressesOutput ISP(String ISP) {
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

  public EipAddressForDescribeEipAddressesOutput instanceId(String instanceId) {
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

  public EipAddressForDescribeEipAddressesOutput instanceType(String instanceType) {
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

  public EipAddressForDescribeEipAddressesOutput ipAddressPoolId(String ipAddressPoolId) {
    this.ipAddressPoolId = ipAddressPoolId;
    return this;
  }

   /**
   * Get ipAddressPoolId
   * @return ipAddressPoolId
  **/
  @Schema(description = "")
  public String getIpAddressPoolId() {
    return ipAddressPoolId;
  }

  public void setIpAddressPoolId(String ipAddressPoolId) {
    this.ipAddressPoolId = ipAddressPoolId;
  }

  public EipAddressForDescribeEipAddressesOutput lockReason(String lockReason) {
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

  public EipAddressForDescribeEipAddressesOutput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EipAddressForDescribeEipAddressesOutput overdueTime(String overdueTime) {
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

  public EipAddressForDescribeEipAddressesOutput projectName(String projectName) {
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

  public EipAddressForDescribeEipAddressesOutput releaseWithInstance(Boolean releaseWithInstance) {
    this.releaseWithInstance = releaseWithInstance;
    return this;
  }

   /**
   * Get releaseWithInstance
   * @return releaseWithInstance
  **/
  @Schema(description = "")
  public Boolean isReleaseWithInstance() {
    return releaseWithInstance;
  }

  public void setReleaseWithInstance(Boolean releaseWithInstance) {
    this.releaseWithInstance = releaseWithInstance;
  }

  public EipAddressForDescribeEipAddressesOutput securityProtectionTypes(List<String> securityProtectionTypes) {
    this.securityProtectionTypes = securityProtectionTypes;
    return this;
  }

  public EipAddressForDescribeEipAddressesOutput addSecurityProtectionTypesItem(String securityProtectionTypesItem) {
    if (this.securityProtectionTypes == null) {
      this.securityProtectionTypes = new ArrayList<String>();
    }
    this.securityProtectionTypes.add(securityProtectionTypesItem);
    return this;
  }

   /**
   * Get securityProtectionTypes
   * @return securityProtectionTypes
  **/
  @Schema(description = "")
  public List<String> getSecurityProtectionTypes() {
    return securityProtectionTypes;
  }

  public void setSecurityProtectionTypes(List<String> securityProtectionTypes) {
    this.securityProtectionTypes = securityProtectionTypes;
  }

  public EipAddressForDescribeEipAddressesOutput status(String status) {
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

  public EipAddressForDescribeEipAddressesOutput tags(List<TagForDescribeEipAddressesOutput> tags) {
    this.tags = tags;
    return this;
  }

  public EipAddressForDescribeEipAddressesOutput addTagsItem(TagForDescribeEipAddressesOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForDescribeEipAddressesOutput>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @Valid
  @Schema(description = "")
  public List<TagForDescribeEipAddressesOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForDescribeEipAddressesOutput> tags) {
    this.tags = tags;
  }

  public EipAddressForDescribeEipAddressesOutput updatedAt(String updatedAt) {
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
    EipAddressForDescribeEipAddressesOutput eipAddressForDescribeEipAddressesOutput = (EipAddressForDescribeEipAddressesOutput) o;
    return Objects.equals(this.allocationId, eipAddressForDescribeEipAddressesOutput.allocationId) &&
        Objects.equals(this.allocationTime, eipAddressForDescribeEipAddressesOutput.allocationTime) &&
        Objects.equals(this.bandwidth, eipAddressForDescribeEipAddressesOutput.bandwidth) &&
        Objects.equals(this.bandwidthPackageId, eipAddressForDescribeEipAddressesOutput.bandwidthPackageId) &&
        Objects.equals(this.billingType, eipAddressForDescribeEipAddressesOutput.billingType) &&
        Objects.equals(this.businessStatus, eipAddressForDescribeEipAddressesOutput.businessStatus) &&
        Objects.equals(this.deletedTime, eipAddressForDescribeEipAddressesOutput.deletedTime) &&
        Objects.equals(this.description, eipAddressForDescribeEipAddressesOutput.description) &&
        Objects.equals(this.eipAddress, eipAddressForDescribeEipAddressesOutput.eipAddress) &&
        Objects.equals(this.expiredTime, eipAddressForDescribeEipAddressesOutput.expiredTime) &&
        Objects.equals(this.ISP, eipAddressForDescribeEipAddressesOutput.ISP) &&
        Objects.equals(this.instanceId, eipAddressForDescribeEipAddressesOutput.instanceId) &&
        Objects.equals(this.instanceType, eipAddressForDescribeEipAddressesOutput.instanceType) &&
        Objects.equals(this.ipAddressPoolId, eipAddressForDescribeEipAddressesOutput.ipAddressPoolId) &&
        Objects.equals(this.lockReason, eipAddressForDescribeEipAddressesOutput.lockReason) &&
        Objects.equals(this.name, eipAddressForDescribeEipAddressesOutput.name) &&
        Objects.equals(this.overdueTime, eipAddressForDescribeEipAddressesOutput.overdueTime) &&
        Objects.equals(this.projectName, eipAddressForDescribeEipAddressesOutput.projectName) &&
        Objects.equals(this.releaseWithInstance, eipAddressForDescribeEipAddressesOutput.releaseWithInstance) &&
        Objects.equals(this.securityProtectionTypes, eipAddressForDescribeEipAddressesOutput.securityProtectionTypes) &&
        Objects.equals(this.status, eipAddressForDescribeEipAddressesOutput.status) &&
        Objects.equals(this.tags, eipAddressForDescribeEipAddressesOutput.tags) &&
        Objects.equals(this.updatedAt, eipAddressForDescribeEipAddressesOutput.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allocationId, allocationTime, bandwidth, bandwidthPackageId, billingType, businessStatus, deletedTime, description, eipAddress, expiredTime, ISP, instanceId, instanceType, ipAddressPoolId, lockReason, name, overdueTime, projectName, releaseWithInstance, securityProtectionTypes, status, tags, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EipAddressForDescribeEipAddressesOutput {\n");
    
    sb.append("    allocationId: ").append(toIndentedString(allocationId)).append("\n");
    sb.append("    allocationTime: ").append(toIndentedString(allocationTime)).append("\n");
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    bandwidthPackageId: ").append(toIndentedString(bandwidthPackageId)).append("\n");
    sb.append("    billingType: ").append(toIndentedString(billingType)).append("\n");
    sb.append("    businessStatus: ").append(toIndentedString(businessStatus)).append("\n");
    sb.append("    deletedTime: ").append(toIndentedString(deletedTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    eipAddress: ").append(toIndentedString(eipAddress)).append("\n");
    sb.append("    expiredTime: ").append(toIndentedString(expiredTime)).append("\n");
    sb.append("    ISP: ").append(toIndentedString(ISP)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    ipAddressPoolId: ").append(toIndentedString(ipAddressPoolId)).append("\n");
    sb.append("    lockReason: ").append(toIndentedString(lockReason)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    overdueTime: ").append(toIndentedString(overdueTime)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    releaseWithInstance: ").append(toIndentedString(releaseWithInstance)).append("\n");
    sb.append("    securityProtectionTypes: ").append(toIndentedString(securityProtectionTypes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
