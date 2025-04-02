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
import com.byteplus.vpc.model.EipAddressForDescribeBandwidthPackagesOutput;
import com.byteplus.vpc.model.TagForDescribeBandwidthPackagesOutput;
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
 * BandwidthPackageForDescribeBandwidthPackagesOutput
 */



public class BandwidthPackageForDescribeBandwidthPackagesOutput {
  @SerializedName("Bandwidth")
  private Integer bandwidth = null;

  @SerializedName("BandwidthPackageId")
  private String bandwidthPackageId = null;

  @SerializedName("BandwidthPackageName")
  private String bandwidthPackageName = null;

  @SerializedName("BillingType")
  private Integer billingType = null;

  @SerializedName("BusinessStatus")
  private String businessStatus = null;

  @SerializedName("CreationTime")
  private String creationTime = null;

  @SerializedName("DeletedTime")
  private String deletedTime = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("EipAddresses")
  private List<EipAddressForDescribeBandwidthPackagesOutput> eipAddresses = null;

  @SerializedName("ExpiredTime")
  private String expiredTime = null;

  @SerializedName("ISP")
  private String ISP = null;

  @SerializedName("OverdueTime")
  private String overdueTime = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("Protocol")
  private String protocol = null;

  @SerializedName("Ratio")
  private Integer ratio = null;

  @SerializedName("SecurityProtectionTypes")
  private List<String> securityProtectionTypes = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("Tags")
  private List<TagForDescribeBandwidthPackagesOutput> tags = null;

  @SerializedName("UpdateTime")
  private String updateTime = null;

  public BandwidthPackageForDescribeBandwidthPackagesOutput bandwidth(Integer bandwidth) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput bandwidthPackageId(String bandwidthPackageId) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput bandwidthPackageName(String bandwidthPackageName) {
    this.bandwidthPackageName = bandwidthPackageName;
    return this;
  }

   /**
   * Get bandwidthPackageName
   * @return bandwidthPackageName
  **/
  @Schema(description = "")
  public String getBandwidthPackageName() {
    return bandwidthPackageName;
  }

  public void setBandwidthPackageName(String bandwidthPackageName) {
    this.bandwidthPackageName = bandwidthPackageName;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput billingType(Integer billingType) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput businessStatus(String businessStatus) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput creationTime(String creationTime) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput deletedTime(String deletedTime) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput description(String description) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput eipAddresses(List<EipAddressForDescribeBandwidthPackagesOutput> eipAddresses) {
    this.eipAddresses = eipAddresses;
    return this;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput addEipAddressesItem(EipAddressForDescribeBandwidthPackagesOutput eipAddressesItem) {
    if (this.eipAddresses == null) {
      this.eipAddresses = new ArrayList<EipAddressForDescribeBandwidthPackagesOutput>();
    }
    this.eipAddresses.add(eipAddressesItem);
    return this;
  }

   /**
   * Get eipAddresses
   * @return eipAddresses
  **/
  @Valid
  @Schema(description = "")
  public List<EipAddressForDescribeBandwidthPackagesOutput> getEipAddresses() {
    return eipAddresses;
  }

  public void setEipAddresses(List<EipAddressForDescribeBandwidthPackagesOutput> eipAddresses) {
    this.eipAddresses = eipAddresses;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput expiredTime(String expiredTime) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput ISP(String ISP) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput overdueTime(String overdueTime) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput projectName(String projectName) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Get protocol
   * @return protocol
  **/
  @Schema(description = "")
  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput ratio(Integer ratio) {
    this.ratio = ratio;
    return this;
  }

   /**
   * Get ratio
   * @return ratio
  **/
  @Schema(description = "")
  public Integer getRatio() {
    return ratio;
  }

  public void setRatio(Integer ratio) {
    this.ratio = ratio;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput securityProtectionTypes(List<String> securityProtectionTypes) {
    this.securityProtectionTypes = securityProtectionTypes;
    return this;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput addSecurityProtectionTypesItem(String securityProtectionTypesItem) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput status(String status) {
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

  public BandwidthPackageForDescribeBandwidthPackagesOutput tags(List<TagForDescribeBandwidthPackagesOutput> tags) {
    this.tags = tags;
    return this;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput addTagsItem(TagForDescribeBandwidthPackagesOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForDescribeBandwidthPackagesOutput>();
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
  public List<TagForDescribeBandwidthPackagesOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForDescribeBandwidthPackagesOutput> tags) {
    this.tags = tags;
  }

  public BandwidthPackageForDescribeBandwidthPackagesOutput updateTime(String updateTime) {
    this.updateTime = updateTime;
    return this;
  }

   /**
   * Get updateTime
   * @return updateTime
  **/
  @Schema(description = "")
  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BandwidthPackageForDescribeBandwidthPackagesOutput bandwidthPackageForDescribeBandwidthPackagesOutput = (BandwidthPackageForDescribeBandwidthPackagesOutput) o;
    return Objects.equals(this.bandwidth, bandwidthPackageForDescribeBandwidthPackagesOutput.bandwidth) &&
        Objects.equals(this.bandwidthPackageId, bandwidthPackageForDescribeBandwidthPackagesOutput.bandwidthPackageId) &&
        Objects.equals(this.bandwidthPackageName, bandwidthPackageForDescribeBandwidthPackagesOutput.bandwidthPackageName) &&
        Objects.equals(this.billingType, bandwidthPackageForDescribeBandwidthPackagesOutput.billingType) &&
        Objects.equals(this.businessStatus, bandwidthPackageForDescribeBandwidthPackagesOutput.businessStatus) &&
        Objects.equals(this.creationTime, bandwidthPackageForDescribeBandwidthPackagesOutput.creationTime) &&
        Objects.equals(this.deletedTime, bandwidthPackageForDescribeBandwidthPackagesOutput.deletedTime) &&
        Objects.equals(this.description, bandwidthPackageForDescribeBandwidthPackagesOutput.description) &&
        Objects.equals(this.eipAddresses, bandwidthPackageForDescribeBandwidthPackagesOutput.eipAddresses) &&
        Objects.equals(this.expiredTime, bandwidthPackageForDescribeBandwidthPackagesOutput.expiredTime) &&
        Objects.equals(this.ISP, bandwidthPackageForDescribeBandwidthPackagesOutput.ISP) &&
        Objects.equals(this.overdueTime, bandwidthPackageForDescribeBandwidthPackagesOutput.overdueTime) &&
        Objects.equals(this.projectName, bandwidthPackageForDescribeBandwidthPackagesOutput.projectName) &&
        Objects.equals(this.protocol, bandwidthPackageForDescribeBandwidthPackagesOutput.protocol) &&
        Objects.equals(this.ratio, bandwidthPackageForDescribeBandwidthPackagesOutput.ratio) &&
        Objects.equals(this.securityProtectionTypes, bandwidthPackageForDescribeBandwidthPackagesOutput.securityProtectionTypes) &&
        Objects.equals(this.status, bandwidthPackageForDescribeBandwidthPackagesOutput.status) &&
        Objects.equals(this.tags, bandwidthPackageForDescribeBandwidthPackagesOutput.tags) &&
        Objects.equals(this.updateTime, bandwidthPackageForDescribeBandwidthPackagesOutput.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bandwidth, bandwidthPackageId, bandwidthPackageName, billingType, businessStatus, creationTime, deletedTime, description, eipAddresses, expiredTime, ISP, overdueTime, projectName, protocol, ratio, securityProtectionTypes, status, tags, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BandwidthPackageForDescribeBandwidthPackagesOutput {\n");
    
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    bandwidthPackageId: ").append(toIndentedString(bandwidthPackageId)).append("\n");
    sb.append("    bandwidthPackageName: ").append(toIndentedString(bandwidthPackageName)).append("\n");
    sb.append("    billingType: ").append(toIndentedString(billingType)).append("\n");
    sb.append("    businessStatus: ").append(toIndentedString(businessStatus)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    deletedTime: ").append(toIndentedString(deletedTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    eipAddresses: ").append(toIndentedString(eipAddresses)).append("\n");
    sb.append("    expiredTime: ").append(toIndentedString(expiredTime)).append("\n");
    sb.append("    ISP: ").append(toIndentedString(ISP)).append("\n");
    sb.append("    overdueTime: ").append(toIndentedString(overdueTime)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    ratio: ").append(toIndentedString(ratio)).append("\n");
    sb.append("    securityProtectionTypes: ").append(toIndentedString(securityProtectionTypes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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
