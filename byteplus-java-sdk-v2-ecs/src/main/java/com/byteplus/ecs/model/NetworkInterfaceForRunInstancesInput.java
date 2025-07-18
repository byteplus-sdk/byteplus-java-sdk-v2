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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * NetworkInterfaceForRunInstancesInput
 */



public class NetworkInterfaceForRunInstancesInput {
  @SerializedName("Ipv6AddressCount")
  private Integer ipv6AddressCount = null;

  @SerializedName("PrimaryIpAddress")
  private String primaryIpAddress = null;

  @SerializedName("PrivateIpAddresses")
  private List<String> privateIpAddresses = null;

  @SerializedName("SecurityGroupIds")
  private List<String> securityGroupIds = null;

  @SerializedName("SubnetId")
  private String subnetId = null;

  public NetworkInterfaceForRunInstancesInput ipv6AddressCount(Integer ipv6AddressCount) {
    this.ipv6AddressCount = ipv6AddressCount;
    return this;
  }

   /**
   * Get ipv6AddressCount
   * @return ipv6AddressCount
  **/
  @Schema(description = "")
  public Integer getIpv6AddressCount() {
    return ipv6AddressCount;
  }

  public void setIpv6AddressCount(Integer ipv6AddressCount) {
    this.ipv6AddressCount = ipv6AddressCount;
  }

  public NetworkInterfaceForRunInstancesInput primaryIpAddress(String primaryIpAddress) {
    this.primaryIpAddress = primaryIpAddress;
    return this;
  }

   /**
   * Get primaryIpAddress
   * @return primaryIpAddress
  **/
  @Schema(description = "")
  public String getPrimaryIpAddress() {
    return primaryIpAddress;
  }

  public void setPrimaryIpAddress(String primaryIpAddress) {
    this.primaryIpAddress = primaryIpAddress;
  }

  public NetworkInterfaceForRunInstancesInput privateIpAddresses(List<String> privateIpAddresses) {
    this.privateIpAddresses = privateIpAddresses;
    return this;
  }

  public NetworkInterfaceForRunInstancesInput addPrivateIpAddressesItem(String privateIpAddressesItem) {
    if (this.privateIpAddresses == null) {
      this.privateIpAddresses = new ArrayList<String>();
    }
    this.privateIpAddresses.add(privateIpAddressesItem);
    return this;
  }

   /**
   * Get privateIpAddresses
   * @return privateIpAddresses
  **/
  @Schema(description = "")
  public List<String> getPrivateIpAddresses() {
    return privateIpAddresses;
  }

  public void setPrivateIpAddresses(List<String> privateIpAddresses) {
    this.privateIpAddresses = privateIpAddresses;
  }

  public NetworkInterfaceForRunInstancesInput securityGroupIds(List<String> securityGroupIds) {
    this.securityGroupIds = securityGroupIds;
    return this;
  }

  public NetworkInterfaceForRunInstancesInput addSecurityGroupIdsItem(String securityGroupIdsItem) {
    if (this.securityGroupIds == null) {
      this.securityGroupIds = new ArrayList<String>();
    }
    this.securityGroupIds.add(securityGroupIdsItem);
    return this;
  }

   /**
   * Get securityGroupIds
   * @return securityGroupIds
  **/
  @Schema(description = "")
  public List<String> getSecurityGroupIds() {
    return securityGroupIds;
  }

  public void setSecurityGroupIds(List<String> securityGroupIds) {
    this.securityGroupIds = securityGroupIds;
  }

  public NetworkInterfaceForRunInstancesInput subnetId(String subnetId) {
    this.subnetId = subnetId;
    return this;
  }

   /**
   * Get subnetId
   * @return subnetId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkInterfaceForRunInstancesInput networkInterfaceForRunInstancesInput = (NetworkInterfaceForRunInstancesInput) o;
    return Objects.equals(this.ipv6AddressCount, networkInterfaceForRunInstancesInput.ipv6AddressCount) &&
        Objects.equals(this.primaryIpAddress, networkInterfaceForRunInstancesInput.primaryIpAddress) &&
        Objects.equals(this.privateIpAddresses, networkInterfaceForRunInstancesInput.privateIpAddresses) &&
        Objects.equals(this.securityGroupIds, networkInterfaceForRunInstancesInput.securityGroupIds) &&
        Objects.equals(this.subnetId, networkInterfaceForRunInstancesInput.subnetId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipv6AddressCount, primaryIpAddress, privateIpAddresses, securityGroupIds, subnetId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkInterfaceForRunInstancesInput {\n");
    
    sb.append("    ipv6AddressCount: ").append(toIndentedString(ipv6AddressCount)).append("\n");
    sb.append("    primaryIpAddress: ").append(toIndentedString(primaryIpAddress)).append("\n");
    sb.append("    privateIpAddresses: ").append(toIndentedString(privateIpAddresses)).append("\n");
    sb.append("    securityGroupIds: ").append(toIndentedString(securityGroupIds)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
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
