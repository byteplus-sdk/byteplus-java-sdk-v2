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
 * ConfigurationForModifyReservedInstancesInput
 */



public class ConfigurationForModifyReservedInstancesInput {
  @SerializedName("HpcClusterId")
  private String hpcClusterId = null;

  @SerializedName("InstanceCount")
  private Integer instanceCount = null;

  @SerializedName("InstanceTypeId")
  private String instanceTypeId = null;

  @SerializedName("ReservedInstanceName")
  private String reservedInstanceName = null;

  @SerializedName("Scope")
  private String scope = null;

  @SerializedName("ZoneId")
  private String zoneId = null;

  public ConfigurationForModifyReservedInstancesInput hpcClusterId(String hpcClusterId) {
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

  public ConfigurationForModifyReservedInstancesInput instanceCount(Integer instanceCount) {
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

  public ConfigurationForModifyReservedInstancesInput instanceTypeId(String instanceTypeId) {
    this.instanceTypeId = instanceTypeId;
    return this;
  }

   /**
   * Get instanceTypeId
   * @return instanceTypeId
  **/
  @Schema(description = "")
  public String getInstanceTypeId() {
    return instanceTypeId;
  }

  public void setInstanceTypeId(String instanceTypeId) {
    this.instanceTypeId = instanceTypeId;
  }

  public ConfigurationForModifyReservedInstancesInput reservedInstanceName(String reservedInstanceName) {
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

  public ConfigurationForModifyReservedInstancesInput scope(String scope) {
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

  public ConfigurationForModifyReservedInstancesInput zoneId(String zoneId) {
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
    ConfigurationForModifyReservedInstancesInput configurationForModifyReservedInstancesInput = (ConfigurationForModifyReservedInstancesInput) o;
    return Objects.equals(this.hpcClusterId, configurationForModifyReservedInstancesInput.hpcClusterId) &&
        Objects.equals(this.instanceCount, configurationForModifyReservedInstancesInput.instanceCount) &&
        Objects.equals(this.instanceTypeId, configurationForModifyReservedInstancesInput.instanceTypeId) &&
        Objects.equals(this.reservedInstanceName, configurationForModifyReservedInstancesInput.reservedInstanceName) &&
        Objects.equals(this.scope, configurationForModifyReservedInstancesInput.scope) &&
        Objects.equals(this.zoneId, configurationForModifyReservedInstancesInput.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hpcClusterId, instanceCount, instanceTypeId, reservedInstanceName, scope, zoneId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationForModifyReservedInstancesInput {\n");
    
    sb.append("    hpcClusterId: ").append(toIndentedString(hpcClusterId)).append("\n");
    sb.append("    instanceCount: ").append(toIndentedString(instanceCount)).append("\n");
    sb.append("    instanceTypeId: ").append(toIndentedString(instanceTypeId)).append("\n");
    sb.append("    reservedInstanceName: ").append(toIndentedString(reservedInstanceName)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
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
