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
 * ModifyVpcAttributesRequest
 */



public class ModifyVpcAttributesRequest {
  @SerializedName("Description")
  private String description = null;

  @SerializedName("DnsServers")
  private List<String> dnsServers = null;

  @SerializedName("EnableIpv6")
  private Boolean enableIpv6 = null;

  @SerializedName("Ipv6CidrBlock")
  private String ipv6CidrBlock = null;

  @SerializedName("VpcId")
  private String vpcId = null;

  @SerializedName("VpcName")
  private String vpcName = null;

  public ModifyVpcAttributesRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
 @Size(min=1,max=255)  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ModifyVpcAttributesRequest dnsServers(List<String> dnsServers) {
    this.dnsServers = dnsServers;
    return this;
  }

  public ModifyVpcAttributesRequest addDnsServersItem(String dnsServersItem) {
    if (this.dnsServers == null) {
      this.dnsServers = new ArrayList<String>();
    }
    this.dnsServers.add(dnsServersItem);
    return this;
  }

   /**
   * Get dnsServers
   * @return dnsServers
  **/
  @Schema(description = "")
  public List<String> getDnsServers() {
    return dnsServers;
  }

  public void setDnsServers(List<String> dnsServers) {
    this.dnsServers = dnsServers;
  }

  public ModifyVpcAttributesRequest enableIpv6(Boolean enableIpv6) {
    this.enableIpv6 = enableIpv6;
    return this;
  }

   /**
   * Get enableIpv6
   * @return enableIpv6
  **/
  @Schema(description = "")
  public Boolean isEnableIpv6() {
    return enableIpv6;
  }

  public void setEnableIpv6(Boolean enableIpv6) {
    this.enableIpv6 = enableIpv6;
  }

  public ModifyVpcAttributesRequest ipv6CidrBlock(String ipv6CidrBlock) {
    this.ipv6CidrBlock = ipv6CidrBlock;
    return this;
  }

   /**
   * Get ipv6CidrBlock
   * @return ipv6CidrBlock
  **/
  @Schema(description = "")
  public String getIpv6CidrBlock() {
    return ipv6CidrBlock;
  }

  public void setIpv6CidrBlock(String ipv6CidrBlock) {
    this.ipv6CidrBlock = ipv6CidrBlock;
  }

  public ModifyVpcAttributesRequest vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * Get vpcId
   * @return vpcId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }

  public ModifyVpcAttributesRequest vpcName(String vpcName) {
    this.vpcName = vpcName;
    return this;
  }

   /**
   * Get vpcName
   * @return vpcName
  **/
 @Size(min=1,max=128)  @Schema(description = "")
  public String getVpcName() {
    return vpcName;
  }

  public void setVpcName(String vpcName) {
    this.vpcName = vpcName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyVpcAttributesRequest modifyVpcAttributesRequest = (ModifyVpcAttributesRequest) o;
    return Objects.equals(this.description, modifyVpcAttributesRequest.description) &&
        Objects.equals(this.dnsServers, modifyVpcAttributesRequest.dnsServers) &&
        Objects.equals(this.enableIpv6, modifyVpcAttributesRequest.enableIpv6) &&
        Objects.equals(this.ipv6CidrBlock, modifyVpcAttributesRequest.ipv6CidrBlock) &&
        Objects.equals(this.vpcId, modifyVpcAttributesRequest.vpcId) &&
        Objects.equals(this.vpcName, modifyVpcAttributesRequest.vpcName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, dnsServers, enableIpv6, ipv6CidrBlock, vpcId, vpcName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyVpcAttributesRequest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dnsServers: ").append(toIndentedString(dnsServers)).append("\n");
    sb.append("    enableIpv6: ").append(toIndentedString(enableIpv6)).append("\n");
    sb.append("    ipv6CidrBlock: ").append(toIndentedString(ipv6CidrBlock)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
    sb.append("    vpcName: ").append(toIndentedString(vpcName)).append("\n");
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
