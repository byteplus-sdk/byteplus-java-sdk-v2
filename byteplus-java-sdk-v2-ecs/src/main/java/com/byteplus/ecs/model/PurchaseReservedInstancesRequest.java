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
import com.byteplus.ecs.model.TagForPurchaseReservedInstancesInput;
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
 * PurchaseReservedInstancesRequest
 */



public class PurchaseReservedInstancesRequest {
  @SerializedName("AutoRenew")
  private Boolean autoRenew = null;

  @SerializedName("AutoRenewPeriod")
  private Integer autoRenewPeriod = null;

  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("HpcClusterId")
  private String hpcClusterId = null;

  @SerializedName("InstanceCount")
  private Integer instanceCount = null;

  @SerializedName("InstanceTypeId")
  private String instanceTypeId = null;

  @SerializedName("Period")
  private Integer period = null;

  @SerializedName("PeriodUnit")
  private String periodUnit = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("RegionId")
  private String regionId = null;

  @SerializedName("ReservedCapacity")
  private Integer reservedCapacity = null;

  @SerializedName("ReservedInstanceName")
  private String reservedInstanceName = null;

  @SerializedName("ReservedStorageCapacityName")
  private String reservedStorageCapacityName = null;

  @SerializedName("RscAutoRenew")
  private Boolean rscAutoRenew = null;

  @SerializedName("RscAutoRenewPeriod")
  private Integer rscAutoRenewPeriod = null;

  @SerializedName("Scope")
  private String scope = null;

  @SerializedName("Tags")
  private List<TagForPurchaseReservedInstancesInput> tags = null;

  @SerializedName("VolumeType")
  private String volumeType = null;

  @SerializedName("ZoneId")
  private String zoneId = null;

  public PurchaseReservedInstancesRequest autoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   * Get autoRenew
   * @return autoRenew
  **/
  @Schema(description = "")
  public Boolean isAutoRenew() {
    return autoRenew;
  }

  public void setAutoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
  }

  public PurchaseReservedInstancesRequest autoRenewPeriod(Integer autoRenewPeriod) {
    this.autoRenewPeriod = autoRenewPeriod;
    return this;
  }

   /**
   * Get autoRenewPeriod
   * @return autoRenewPeriod
  **/
  @Schema(description = "")
  public Integer getAutoRenewPeriod() {
    return autoRenewPeriod;
  }

  public void setAutoRenewPeriod(Integer autoRenewPeriod) {
    this.autoRenewPeriod = autoRenewPeriod;
  }

  public PurchaseReservedInstancesRequest clientToken(String clientToken) {
    this.clientToken = clientToken;
    return this;
  }

   /**
   * Get clientToken
   * @return clientToken
  **/
  @Schema(description = "")
  public String getClientToken() {
    return clientToken;
  }

  public void setClientToken(String clientToken) {
    this.clientToken = clientToken;
  }

  public PurchaseReservedInstancesRequest description(String description) {
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

  public PurchaseReservedInstancesRequest hpcClusterId(String hpcClusterId) {
    this.hpcClusterId = hpcClusterId;
    return this;
  }

   /**
   * Get hpcClusterId
   * @return hpcClusterId
  **/
  @Schema(description = "")
  public String getHpcClusterId() {
    return hpcClusterId;
  }

  public void setHpcClusterId(String hpcClusterId) {
    this.hpcClusterId = hpcClusterId;
  }

  public PurchaseReservedInstancesRequest instanceCount(Integer instanceCount) {
    this.instanceCount = instanceCount;
    return this;
  }

   /**
   * Get instanceCount
   * @return instanceCount
  **/
  @Schema(description = "")
  public Integer getInstanceCount() {
    return instanceCount;
  }

  public void setInstanceCount(Integer instanceCount) {
    this.instanceCount = instanceCount;
  }

  public PurchaseReservedInstancesRequest instanceTypeId(String instanceTypeId) {
    this.instanceTypeId = instanceTypeId;
    return this;
  }

   /**
   * Get instanceTypeId
   * @return instanceTypeId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getInstanceTypeId() {
    return instanceTypeId;
  }

  public void setInstanceTypeId(String instanceTypeId) {
    this.instanceTypeId = instanceTypeId;
  }

  public PurchaseReservedInstancesRequest period(Integer period) {
    this.period = period;
    return this;
  }

   /**
   * Get period
   * @return period
  **/
  @Schema(description = "")
  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public PurchaseReservedInstancesRequest periodUnit(String periodUnit) {
    this.periodUnit = periodUnit;
    return this;
  }

   /**
   * Get periodUnit
   * @return periodUnit
  **/
  @Schema(description = "")
  public String getPeriodUnit() {
    return periodUnit;
  }

  public void setPeriodUnit(String periodUnit) {
    this.periodUnit = periodUnit;
  }

  public PurchaseReservedInstancesRequest projectName(String projectName) {
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

  public PurchaseReservedInstancesRequest regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

   /**
   * Get regionId
   * @return regionId
  **/
  @Schema(description = "")
  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public PurchaseReservedInstancesRequest reservedCapacity(Integer reservedCapacity) {
    this.reservedCapacity = reservedCapacity;
    return this;
  }

   /**
   * Get reservedCapacity
   * @return reservedCapacity
  **/
  @Schema(description = "")
  public Integer getReservedCapacity() {
    return reservedCapacity;
  }

  public void setReservedCapacity(Integer reservedCapacity) {
    this.reservedCapacity = reservedCapacity;
  }

  public PurchaseReservedInstancesRequest reservedInstanceName(String reservedInstanceName) {
    this.reservedInstanceName = reservedInstanceName;
    return this;
  }

   /**
   * Get reservedInstanceName
   * @return reservedInstanceName
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getReservedInstanceName() {
    return reservedInstanceName;
  }

  public void setReservedInstanceName(String reservedInstanceName) {
    this.reservedInstanceName = reservedInstanceName;
  }

  public PurchaseReservedInstancesRequest reservedStorageCapacityName(String reservedStorageCapacityName) {
    this.reservedStorageCapacityName = reservedStorageCapacityName;
    return this;
  }

   /**
   * Get reservedStorageCapacityName
   * @return reservedStorageCapacityName
  **/
  @Schema(description = "")
  public String getReservedStorageCapacityName() {
    return reservedStorageCapacityName;
  }

  public void setReservedStorageCapacityName(String reservedStorageCapacityName) {
    this.reservedStorageCapacityName = reservedStorageCapacityName;
  }

  public PurchaseReservedInstancesRequest rscAutoRenew(Boolean rscAutoRenew) {
    this.rscAutoRenew = rscAutoRenew;
    return this;
  }

   /**
   * Get rscAutoRenew
   * @return rscAutoRenew
  **/
  @Schema(description = "")
  public Boolean isRscAutoRenew() {
    return rscAutoRenew;
  }

  public void setRscAutoRenew(Boolean rscAutoRenew) {
    this.rscAutoRenew = rscAutoRenew;
  }

  public PurchaseReservedInstancesRequest rscAutoRenewPeriod(Integer rscAutoRenewPeriod) {
    this.rscAutoRenewPeriod = rscAutoRenewPeriod;
    return this;
  }

   /**
   * Get rscAutoRenewPeriod
   * @return rscAutoRenewPeriod
  **/
  @Schema(description = "")
  public Integer getRscAutoRenewPeriod() {
    return rscAutoRenewPeriod;
  }

  public void setRscAutoRenewPeriod(Integer rscAutoRenewPeriod) {
    this.rscAutoRenewPeriod = rscAutoRenewPeriod;
  }

  public PurchaseReservedInstancesRequest scope(String scope) {
    this.scope = scope;
    return this;
  }

   /**
   * Get scope
   * @return scope
  **/
  @Schema(description = "")
  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public PurchaseReservedInstancesRequest tags(List<TagForPurchaseReservedInstancesInput> tags) {
    this.tags = tags;
    return this;
  }

  public PurchaseReservedInstancesRequest addTagsItem(TagForPurchaseReservedInstancesInput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForPurchaseReservedInstancesInput>();
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
  public List<TagForPurchaseReservedInstancesInput> getTags() {
    return tags;
  }

  public void setTags(List<TagForPurchaseReservedInstancesInput> tags) {
    this.tags = tags;
  }

  public PurchaseReservedInstancesRequest volumeType(String volumeType) {
    this.volumeType = volumeType;
    return this;
  }

   /**
   * Get volumeType
   * @return volumeType
  **/
  @Schema(description = "")
  public String getVolumeType() {
    return volumeType;
  }

  public void setVolumeType(String volumeType) {
    this.volumeType = volumeType;
  }

  public PurchaseReservedInstancesRequest zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * Get zoneId
   * @return zoneId
  **/
  @Schema(description = "")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchaseReservedInstancesRequest purchaseReservedInstancesRequest = (PurchaseReservedInstancesRequest) o;
    return Objects.equals(this.autoRenew, purchaseReservedInstancesRequest.autoRenew) &&
        Objects.equals(this.autoRenewPeriod, purchaseReservedInstancesRequest.autoRenewPeriod) &&
        Objects.equals(this.clientToken, purchaseReservedInstancesRequest.clientToken) &&
        Objects.equals(this.description, purchaseReservedInstancesRequest.description) &&
        Objects.equals(this.hpcClusterId, purchaseReservedInstancesRequest.hpcClusterId) &&
        Objects.equals(this.instanceCount, purchaseReservedInstancesRequest.instanceCount) &&
        Objects.equals(this.instanceTypeId, purchaseReservedInstancesRequest.instanceTypeId) &&
        Objects.equals(this.period, purchaseReservedInstancesRequest.period) &&
        Objects.equals(this.periodUnit, purchaseReservedInstancesRequest.periodUnit) &&
        Objects.equals(this.projectName, purchaseReservedInstancesRequest.projectName) &&
        Objects.equals(this.regionId, purchaseReservedInstancesRequest.regionId) &&
        Objects.equals(this.reservedCapacity, purchaseReservedInstancesRequest.reservedCapacity) &&
        Objects.equals(this.reservedInstanceName, purchaseReservedInstancesRequest.reservedInstanceName) &&
        Objects.equals(this.reservedStorageCapacityName, purchaseReservedInstancesRequest.reservedStorageCapacityName) &&
        Objects.equals(this.rscAutoRenew, purchaseReservedInstancesRequest.rscAutoRenew) &&
        Objects.equals(this.rscAutoRenewPeriod, purchaseReservedInstancesRequest.rscAutoRenewPeriod) &&
        Objects.equals(this.scope, purchaseReservedInstancesRequest.scope) &&
        Objects.equals(this.tags, purchaseReservedInstancesRequest.tags) &&
        Objects.equals(this.volumeType, purchaseReservedInstancesRequest.volumeType) &&
        Objects.equals(this.zoneId, purchaseReservedInstancesRequest.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoRenew, autoRenewPeriod, clientToken, description, hpcClusterId, instanceCount, instanceTypeId, period, periodUnit, projectName, regionId, reservedCapacity, reservedInstanceName, reservedStorageCapacityName, rscAutoRenew, rscAutoRenewPeriod, scope, tags, volumeType, zoneId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurchaseReservedInstancesRequest {\n");
    
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    autoRenewPeriod: ").append(toIndentedString(autoRenewPeriod)).append("\n");
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    hpcClusterId: ").append(toIndentedString(hpcClusterId)).append("\n");
    sb.append("    instanceCount: ").append(toIndentedString(instanceCount)).append("\n");
    sb.append("    instanceTypeId: ").append(toIndentedString(instanceTypeId)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    periodUnit: ").append(toIndentedString(periodUnit)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    reservedCapacity: ").append(toIndentedString(reservedCapacity)).append("\n");
    sb.append("    reservedInstanceName: ").append(toIndentedString(reservedInstanceName)).append("\n");
    sb.append("    reservedStorageCapacityName: ").append(toIndentedString(reservedStorageCapacityName)).append("\n");
    sb.append("    rscAutoRenew: ").append(toIndentedString(rscAutoRenew)).append("\n");
    sb.append("    rscAutoRenewPeriod: ").append(toIndentedString(rscAutoRenewPeriod)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    volumeType: ").append(toIndentedString(volumeType)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
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
