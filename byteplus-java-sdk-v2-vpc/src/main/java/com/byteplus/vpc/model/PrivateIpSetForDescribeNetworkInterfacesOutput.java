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
import com.byteplus.vpc.model.AssociatedElasticIpForDescribeNetworkInterfacesOutput;
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
 * PrivateIpSetForDescribeNetworkInterfacesOutput
 */



public class PrivateIpSetForDescribeNetworkInterfacesOutput {
  @SerializedName("AssociatedElasticIp")
  private AssociatedElasticIpForDescribeNetworkInterfacesOutput associatedElasticIp = null;

  @SerializedName("Primary")
  private Boolean primary = null;

  @SerializedName("PrivateIpAddress")
  private String privateIpAddress = null;

  public PrivateIpSetForDescribeNetworkInterfacesOutput associatedElasticIp(AssociatedElasticIpForDescribeNetworkInterfacesOutput associatedElasticIp) {
    this.associatedElasticIp = associatedElasticIp;
    return this;
  }

   /**
   * Get associatedElasticIp
   * @return associatedElasticIp
  **/
  @Valid
  @Schema(description = "")
  public AssociatedElasticIpForDescribeNetworkInterfacesOutput getAssociatedElasticIp() {
    return associatedElasticIp;
  }

  public void setAssociatedElasticIp(AssociatedElasticIpForDescribeNetworkInterfacesOutput associatedElasticIp) {
    this.associatedElasticIp = associatedElasticIp;
  }

  public PrivateIpSetForDescribeNetworkInterfacesOutput primary(Boolean primary) {
    this.primary = primary;
    return this;
  }

   /**
   * Get primary
   * @return primary
  **/
  @Schema(description = "")
  public Boolean isPrimary() {
    return primary;
  }

  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }

  public PrivateIpSetForDescribeNetworkInterfacesOutput privateIpAddress(String privateIpAddress) {
    this.privateIpAddress = privateIpAddress;
    return this;
  }

   /**
   * Get privateIpAddress
   * @return privateIpAddress
  **/
  @Schema(description = "")
  public String getPrivateIpAddress() {
    return privateIpAddress;
  }

  public void setPrivateIpAddress(String privateIpAddress) {
    this.privateIpAddress = privateIpAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrivateIpSetForDescribeNetworkInterfacesOutput privateIpSetForDescribeNetworkInterfacesOutput = (PrivateIpSetForDescribeNetworkInterfacesOutput) o;
    return Objects.equals(this.associatedElasticIp, privateIpSetForDescribeNetworkInterfacesOutput.associatedElasticIp) &&
        Objects.equals(this.primary, privateIpSetForDescribeNetworkInterfacesOutput.primary) &&
        Objects.equals(this.privateIpAddress, privateIpSetForDescribeNetworkInterfacesOutput.privateIpAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(associatedElasticIp, primary, privateIpAddress);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrivateIpSetForDescribeNetworkInterfacesOutput {\n");
    
    sb.append("    associatedElasticIp: ").append(toIndentedString(associatedElasticIp)).append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    privateIpAddress: ").append(toIndentedString(privateIpAddress)).append("\n");
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
