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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * AssignIpv6AddressesRequest
 */



public class AssignIpv6AddressesRequest {
  @SerializedName("Ipv6Address")
  private List<String> ipv6Address = null;

  @SerializedName("Ipv6AddressCount")
  private Integer ipv6AddressCount = null;

  @SerializedName("NetworkInterfaceId")
  private String networkInterfaceId = null;

  public AssignIpv6AddressesRequest ipv6Address(List<String> ipv6Address) {
    this.ipv6Address = ipv6Address;
    return this;
  }

  public AssignIpv6AddressesRequest addIpv6AddressItem(String ipv6AddressItem) {
    if (this.ipv6Address == null) {
      this.ipv6Address = new ArrayList<String>();
    }
    this.ipv6Address.add(ipv6AddressItem);
    return this;
  }

   /**
   * Get ipv6Address
   * @return ipv6Address
  **/
  @Schema(description = "")
  public List<String> getIpv6Address() {
    return ipv6Address;
  }

  public void setIpv6Address(List<String> ipv6Address) {
    this.ipv6Address = ipv6Address;
  }

  public AssignIpv6AddressesRequest ipv6AddressCount(Integer ipv6AddressCount) {
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

  public AssignIpv6AddressesRequest networkInterfaceId(String networkInterfaceId) {
    this.networkInterfaceId = networkInterfaceId;
    return this;
  }

   /**
   * Get networkInterfaceId
   * @return networkInterfaceId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getNetworkInterfaceId() {
    return networkInterfaceId;
  }

  public void setNetworkInterfaceId(String networkInterfaceId) {
    this.networkInterfaceId = networkInterfaceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssignIpv6AddressesRequest assignIpv6AddressesRequest = (AssignIpv6AddressesRequest) o;
    return Objects.equals(this.ipv6Address, assignIpv6AddressesRequest.ipv6Address) &&
        Objects.equals(this.ipv6AddressCount, assignIpv6AddressesRequest.ipv6AddressCount) &&
        Objects.equals(this.networkInterfaceId, assignIpv6AddressesRequest.networkInterfaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipv6Address, ipv6AddressCount, networkInterfaceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssignIpv6AddressesRequest {\n");
    
    sb.append("    ipv6Address: ").append(toIndentedString(ipv6Address)).append("\n");
    sb.append("    ipv6AddressCount: ").append(toIndentedString(ipv6AddressCount)).append("\n");
    sb.append("    networkInterfaceId: ").append(toIndentedString(networkInterfaceId)).append("\n");
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
