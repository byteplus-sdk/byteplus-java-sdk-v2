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
import com.byteplus.vpc.model.AssociateCenForDescribeVpcAttributesOutput;
import com.byteplus.vpc.model.TagForDescribeVpcAttributesOutput;
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
 * DescribeVpcAttributesResponse
 */



public class DescribeVpcAttributesResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("AccountId")
  private String accountId = null;

  @SerializedName("AssociateCens")
  private List<AssociateCenForDescribeVpcAttributesOutput> associateCens = null;

  @SerializedName("CidrBlock")
  private String cidrBlock = null;

  @SerializedName("CreationTime")
  private String creationTime = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("DnsServers")
  private List<String> dnsServers = null;

  @SerializedName("Ipv4GatewayId")
  private String ipv4GatewayId = null;

  @SerializedName("Ipv6CidrBlock")
  private String ipv6CidrBlock = null;

  @SerializedName("IsDefault")
  private Boolean isDefault = null;

  @SerializedName("NatGatewayIds")
  private List<String> natGatewayIds = null;

  @SerializedName("NetworkAclNum")
  private String networkAclNum = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("RequestId")
  private String requestId = null;

  @SerializedName("RouteTableIds")
  private List<String> routeTableIds = null;

  @SerializedName("SecondaryCidrBlocks")
  private List<String> secondaryCidrBlocks = null;

  @SerializedName("SecurityGroupIds")
  private List<String> securityGroupIds = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("SubnetIds")
  private List<String> subnetIds = null;

  @SerializedName("SupportIpv4Gateway")
  private Boolean supportIpv4Gateway = null;

  @SerializedName("Tags")
  private List<TagForDescribeVpcAttributesOutput> tags = null;

  @SerializedName("UpdateTime")
  private String updateTime = null;

  @SerializedName("UserCidrBlocks")
  private List<String> userCidrBlocks = null;

  @SerializedName("VpcId")
  private String vpcId = null;

  @SerializedName("VpcName")
  private String vpcName = null;

  public DescribeVpcAttributesResponse accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Get accountId
   * @return accountId
  **/
  @Schema(description = "")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public DescribeVpcAttributesResponse associateCens(List<AssociateCenForDescribeVpcAttributesOutput> associateCens) {
    this.associateCens = associateCens;
    return this;
  }

  public DescribeVpcAttributesResponse addAssociateCensItem(AssociateCenForDescribeVpcAttributesOutput associateCensItem) {
    if (this.associateCens == null) {
      this.associateCens = new ArrayList<AssociateCenForDescribeVpcAttributesOutput>();
    }
    this.associateCens.add(associateCensItem);
    return this;
  }

   /**
   * Get associateCens
   * @return associateCens
  **/
  @Valid
  @Schema(description = "")
  public List<AssociateCenForDescribeVpcAttributesOutput> getAssociateCens() {
    return associateCens;
  }

  public void setAssociateCens(List<AssociateCenForDescribeVpcAttributesOutput> associateCens) {
    this.associateCens = associateCens;
  }

  public DescribeVpcAttributesResponse cidrBlock(String cidrBlock) {
    this.cidrBlock = cidrBlock;
    return this;
  }

   /**
   * Get cidrBlock
   * @return cidrBlock
  **/
  @Schema(description = "")
  public String getCidrBlock() {
    return cidrBlock;
  }

  public void setCidrBlock(String cidrBlock) {
    this.cidrBlock = cidrBlock;
  }

  public DescribeVpcAttributesResponse creationTime(String creationTime) {
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

  public DescribeVpcAttributesResponse description(String description) {
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

  public DescribeVpcAttributesResponse dnsServers(List<String> dnsServers) {
    this.dnsServers = dnsServers;
    return this;
  }

  public DescribeVpcAttributesResponse addDnsServersItem(String dnsServersItem) {
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

  public DescribeVpcAttributesResponse ipv4GatewayId(String ipv4GatewayId) {
    this.ipv4GatewayId = ipv4GatewayId;
    return this;
  }

   /**
   * Get ipv4GatewayId
   * @return ipv4GatewayId
  **/
  @Schema(description = "")
  public String getIpv4GatewayId() {
    return ipv4GatewayId;
  }

  public void setIpv4GatewayId(String ipv4GatewayId) {
    this.ipv4GatewayId = ipv4GatewayId;
  }

  public DescribeVpcAttributesResponse ipv6CidrBlock(String ipv6CidrBlock) {
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

  public DescribeVpcAttributesResponse isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Get isDefault
   * @return isDefault
  **/
  @Schema(description = "")
  public Boolean isIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public DescribeVpcAttributesResponse natGatewayIds(List<String> natGatewayIds) {
    this.natGatewayIds = natGatewayIds;
    return this;
  }

  public DescribeVpcAttributesResponse addNatGatewayIdsItem(String natGatewayIdsItem) {
    if (this.natGatewayIds == null) {
      this.natGatewayIds = new ArrayList<String>();
    }
    this.natGatewayIds.add(natGatewayIdsItem);
    return this;
  }

   /**
   * Get natGatewayIds
   * @return natGatewayIds
  **/
  @Schema(description = "")
  public List<String> getNatGatewayIds() {
    return natGatewayIds;
  }

  public void setNatGatewayIds(List<String> natGatewayIds) {
    this.natGatewayIds = natGatewayIds;
  }

  public DescribeVpcAttributesResponse networkAclNum(String networkAclNum) {
    this.networkAclNum = networkAclNum;
    return this;
  }

   /**
   * Get networkAclNum
   * @return networkAclNum
  **/
  @Schema(description = "")
  public String getNetworkAclNum() {
    return networkAclNum;
  }

  public void setNetworkAclNum(String networkAclNum) {
    this.networkAclNum = networkAclNum;
  }

  public DescribeVpcAttributesResponse projectName(String projectName) {
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

  public DescribeVpcAttributesResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Get requestId
   * @return requestId
  **/
  @Schema(description = "")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public DescribeVpcAttributesResponse routeTableIds(List<String> routeTableIds) {
    this.routeTableIds = routeTableIds;
    return this;
  }

  public DescribeVpcAttributesResponse addRouteTableIdsItem(String routeTableIdsItem) {
    if (this.routeTableIds == null) {
      this.routeTableIds = new ArrayList<String>();
    }
    this.routeTableIds.add(routeTableIdsItem);
    return this;
  }

   /**
   * Get routeTableIds
   * @return routeTableIds
  **/
  @Schema(description = "")
  public List<String> getRouteTableIds() {
    return routeTableIds;
  }

  public void setRouteTableIds(List<String> routeTableIds) {
    this.routeTableIds = routeTableIds;
  }

  public DescribeVpcAttributesResponse secondaryCidrBlocks(List<String> secondaryCidrBlocks) {
    this.secondaryCidrBlocks = secondaryCidrBlocks;
    return this;
  }

  public DescribeVpcAttributesResponse addSecondaryCidrBlocksItem(String secondaryCidrBlocksItem) {
    if (this.secondaryCidrBlocks == null) {
      this.secondaryCidrBlocks = new ArrayList<String>();
    }
    this.secondaryCidrBlocks.add(secondaryCidrBlocksItem);
    return this;
  }

   /**
   * Get secondaryCidrBlocks
   * @return secondaryCidrBlocks
  **/
  @Schema(description = "")
  public List<String> getSecondaryCidrBlocks() {
    return secondaryCidrBlocks;
  }

  public void setSecondaryCidrBlocks(List<String> secondaryCidrBlocks) {
    this.secondaryCidrBlocks = secondaryCidrBlocks;
  }

  public DescribeVpcAttributesResponse securityGroupIds(List<String> securityGroupIds) {
    this.securityGroupIds = securityGroupIds;
    return this;
  }

  public DescribeVpcAttributesResponse addSecurityGroupIdsItem(String securityGroupIdsItem) {
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

  public DescribeVpcAttributesResponse status(String status) {
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

  public DescribeVpcAttributesResponse subnetIds(List<String> subnetIds) {
    this.subnetIds = subnetIds;
    return this;
  }

  public DescribeVpcAttributesResponse addSubnetIdsItem(String subnetIdsItem) {
    if (this.subnetIds == null) {
      this.subnetIds = new ArrayList<String>();
    }
    this.subnetIds.add(subnetIdsItem);
    return this;
  }

   /**
   * Get subnetIds
   * @return subnetIds
  **/
  @Schema(description = "")
  public List<String> getSubnetIds() {
    return subnetIds;
  }

  public void setSubnetIds(List<String> subnetIds) {
    this.subnetIds = subnetIds;
  }

  public DescribeVpcAttributesResponse supportIpv4Gateway(Boolean supportIpv4Gateway) {
    this.supportIpv4Gateway = supportIpv4Gateway;
    return this;
  }

   /**
   * Get supportIpv4Gateway
   * @return supportIpv4Gateway
  **/
  @Schema(description = "")
  public Boolean isSupportIpv4Gateway() {
    return supportIpv4Gateway;
  }

  public void setSupportIpv4Gateway(Boolean supportIpv4Gateway) {
    this.supportIpv4Gateway = supportIpv4Gateway;
  }

  public DescribeVpcAttributesResponse tags(List<TagForDescribeVpcAttributesOutput> tags) {
    this.tags = tags;
    return this;
  }

  public DescribeVpcAttributesResponse addTagsItem(TagForDescribeVpcAttributesOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForDescribeVpcAttributesOutput>();
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
  public List<TagForDescribeVpcAttributesOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForDescribeVpcAttributesOutput> tags) {
    this.tags = tags;
  }

  public DescribeVpcAttributesResponse updateTime(String updateTime) {
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

  public DescribeVpcAttributesResponse userCidrBlocks(List<String> userCidrBlocks) {
    this.userCidrBlocks = userCidrBlocks;
    return this;
  }

  public DescribeVpcAttributesResponse addUserCidrBlocksItem(String userCidrBlocksItem) {
    if (this.userCidrBlocks == null) {
      this.userCidrBlocks = new ArrayList<String>();
    }
    this.userCidrBlocks.add(userCidrBlocksItem);
    return this;
  }

   /**
   * Get userCidrBlocks
   * @return userCidrBlocks
  **/
  @Schema(description = "")
  public List<String> getUserCidrBlocks() {
    return userCidrBlocks;
  }

  public void setUserCidrBlocks(List<String> userCidrBlocks) {
    this.userCidrBlocks = userCidrBlocks;
  }

  public DescribeVpcAttributesResponse vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * Get vpcId
   * @return vpcId
  **/
  @Schema(description = "")
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }

  public DescribeVpcAttributesResponse vpcName(String vpcName) {
    this.vpcName = vpcName;
    return this;
  }

   /**
   * Get vpcName
   * @return vpcName
  **/
  @Schema(description = "")
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
    DescribeVpcAttributesResponse describeVpcAttributesResponse = (DescribeVpcAttributesResponse) o;
    return Objects.equals(this.accountId, describeVpcAttributesResponse.accountId) &&
        Objects.equals(this.associateCens, describeVpcAttributesResponse.associateCens) &&
        Objects.equals(this.cidrBlock, describeVpcAttributesResponse.cidrBlock) &&
        Objects.equals(this.creationTime, describeVpcAttributesResponse.creationTime) &&
        Objects.equals(this.description, describeVpcAttributesResponse.description) &&
        Objects.equals(this.dnsServers, describeVpcAttributesResponse.dnsServers) &&
        Objects.equals(this.ipv4GatewayId, describeVpcAttributesResponse.ipv4GatewayId) &&
        Objects.equals(this.ipv6CidrBlock, describeVpcAttributesResponse.ipv6CidrBlock) &&
        Objects.equals(this.isDefault, describeVpcAttributesResponse.isDefault) &&
        Objects.equals(this.natGatewayIds, describeVpcAttributesResponse.natGatewayIds) &&
        Objects.equals(this.networkAclNum, describeVpcAttributesResponse.networkAclNum) &&
        Objects.equals(this.projectName, describeVpcAttributesResponse.projectName) &&
        Objects.equals(this.requestId, describeVpcAttributesResponse.requestId) &&
        Objects.equals(this.routeTableIds, describeVpcAttributesResponse.routeTableIds) &&
        Objects.equals(this.secondaryCidrBlocks, describeVpcAttributesResponse.secondaryCidrBlocks) &&
        Objects.equals(this.securityGroupIds, describeVpcAttributesResponse.securityGroupIds) &&
        Objects.equals(this.status, describeVpcAttributesResponse.status) &&
        Objects.equals(this.subnetIds, describeVpcAttributesResponse.subnetIds) &&
        Objects.equals(this.supportIpv4Gateway, describeVpcAttributesResponse.supportIpv4Gateway) &&
        Objects.equals(this.tags, describeVpcAttributesResponse.tags) &&
        Objects.equals(this.updateTime, describeVpcAttributesResponse.updateTime) &&
        Objects.equals(this.userCidrBlocks, describeVpcAttributesResponse.userCidrBlocks) &&
        Objects.equals(this.vpcId, describeVpcAttributesResponse.vpcId) &&
        Objects.equals(this.vpcName, describeVpcAttributesResponse.vpcName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, associateCens, cidrBlock, creationTime, description, dnsServers, ipv4GatewayId, ipv6CidrBlock, isDefault, natGatewayIds, networkAclNum, projectName, requestId, routeTableIds, secondaryCidrBlocks, securityGroupIds, status, subnetIds, supportIpv4Gateway, tags, updateTime, userCidrBlocks, vpcId, vpcName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeVpcAttributesResponse {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    associateCens: ").append(toIndentedString(associateCens)).append("\n");
    sb.append("    cidrBlock: ").append(toIndentedString(cidrBlock)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dnsServers: ").append(toIndentedString(dnsServers)).append("\n");
    sb.append("    ipv4GatewayId: ").append(toIndentedString(ipv4GatewayId)).append("\n");
    sb.append("    ipv6CidrBlock: ").append(toIndentedString(ipv6CidrBlock)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    natGatewayIds: ").append(toIndentedString(natGatewayIds)).append("\n");
    sb.append("    networkAclNum: ").append(toIndentedString(networkAclNum)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    routeTableIds: ").append(toIndentedString(routeTableIds)).append("\n");
    sb.append("    secondaryCidrBlocks: ").append(toIndentedString(secondaryCidrBlocks)).append("\n");
    sb.append("    securityGroupIds: ").append(toIndentedString(securityGroupIds)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subnetIds: ").append(toIndentedString(subnetIds)).append("\n");
    sb.append("    supportIpv4Gateway: ").append(toIndentedString(supportIpv4Gateway)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    userCidrBlocks: ").append(toIndentedString(userCidrBlocks)).append("\n");
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
