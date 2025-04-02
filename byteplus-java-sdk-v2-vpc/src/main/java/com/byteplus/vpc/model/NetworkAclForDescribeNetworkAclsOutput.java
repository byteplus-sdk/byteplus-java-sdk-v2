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
import com.byteplus.vpc.model.EgressAclEntryForDescribeNetworkAclsOutput;
import com.byteplus.vpc.model.IngressAclEntryForDescribeNetworkAclsOutput;
import com.byteplus.vpc.model.ResourceForDescribeNetworkAclsOutput;
import com.byteplus.vpc.model.TagForDescribeNetworkAclsOutput;
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
 * NetworkAclForDescribeNetworkAclsOutput
 */



public class NetworkAclForDescribeNetworkAclsOutput {
  @SerializedName("CreationTime")
  private String creationTime = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("EgressAclEntries")
  private List<EgressAclEntryForDescribeNetworkAclsOutput> egressAclEntries = null;

  @SerializedName("IngressAclEntries")
  private List<IngressAclEntryForDescribeNetworkAclsOutput> ingressAclEntries = null;

  @SerializedName("NetworkAclId")
  private String networkAclId = null;

  @SerializedName("NetworkAclName")
  private String networkAclName = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("Resources")
  private List<ResourceForDescribeNetworkAclsOutput> resources = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("Tags")
  private List<TagForDescribeNetworkAclsOutput> tags = null;

  @SerializedName("UpdateTime")
  private String updateTime = null;

  @SerializedName("VpcId")
  private String vpcId = null;

  public NetworkAclForDescribeNetworkAclsOutput creationTime(String creationTime) {
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

  public NetworkAclForDescribeNetworkAclsOutput description(String description) {
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

  public NetworkAclForDescribeNetworkAclsOutput egressAclEntries(List<EgressAclEntryForDescribeNetworkAclsOutput> egressAclEntries) {
    this.egressAclEntries = egressAclEntries;
    return this;
  }

  public NetworkAclForDescribeNetworkAclsOutput addEgressAclEntriesItem(EgressAclEntryForDescribeNetworkAclsOutput egressAclEntriesItem) {
    if (this.egressAclEntries == null) {
      this.egressAclEntries = new ArrayList<EgressAclEntryForDescribeNetworkAclsOutput>();
    }
    this.egressAclEntries.add(egressAclEntriesItem);
    return this;
  }

   /**
   * Get egressAclEntries
   * @return egressAclEntries
  **/
  @Valid
  @Schema(description = "")
  public List<EgressAclEntryForDescribeNetworkAclsOutput> getEgressAclEntries() {
    return egressAclEntries;
  }

  public void setEgressAclEntries(List<EgressAclEntryForDescribeNetworkAclsOutput> egressAclEntries) {
    this.egressAclEntries = egressAclEntries;
  }

  public NetworkAclForDescribeNetworkAclsOutput ingressAclEntries(List<IngressAclEntryForDescribeNetworkAclsOutput> ingressAclEntries) {
    this.ingressAclEntries = ingressAclEntries;
    return this;
  }

  public NetworkAclForDescribeNetworkAclsOutput addIngressAclEntriesItem(IngressAclEntryForDescribeNetworkAclsOutput ingressAclEntriesItem) {
    if (this.ingressAclEntries == null) {
      this.ingressAclEntries = new ArrayList<IngressAclEntryForDescribeNetworkAclsOutput>();
    }
    this.ingressAclEntries.add(ingressAclEntriesItem);
    return this;
  }

   /**
   * Get ingressAclEntries
   * @return ingressAclEntries
  **/
  @Valid
  @Schema(description = "")
  public List<IngressAclEntryForDescribeNetworkAclsOutput> getIngressAclEntries() {
    return ingressAclEntries;
  }

  public void setIngressAclEntries(List<IngressAclEntryForDescribeNetworkAclsOutput> ingressAclEntries) {
    this.ingressAclEntries = ingressAclEntries;
  }

  public NetworkAclForDescribeNetworkAclsOutput networkAclId(String networkAclId) {
    this.networkAclId = networkAclId;
    return this;
  }

   /**
   * Get networkAclId
   * @return networkAclId
  **/
  @Schema(description = "")
  public String getNetworkAclId() {
    return networkAclId;
  }

  public void setNetworkAclId(String networkAclId) {
    this.networkAclId = networkAclId;
  }

  public NetworkAclForDescribeNetworkAclsOutput networkAclName(String networkAclName) {
    this.networkAclName = networkAclName;
    return this;
  }

   /**
   * Get networkAclName
   * @return networkAclName
  **/
  @Schema(description = "")
  public String getNetworkAclName() {
    return networkAclName;
  }

  public void setNetworkAclName(String networkAclName) {
    this.networkAclName = networkAclName;
  }

  public NetworkAclForDescribeNetworkAclsOutput projectName(String projectName) {
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

  public NetworkAclForDescribeNetworkAclsOutput resources(List<ResourceForDescribeNetworkAclsOutput> resources) {
    this.resources = resources;
    return this;
  }

  public NetworkAclForDescribeNetworkAclsOutput addResourcesItem(ResourceForDescribeNetworkAclsOutput resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<ResourceForDescribeNetworkAclsOutput>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Get resources
   * @return resources
  **/
  @Valid
  @Schema(description = "")
  public List<ResourceForDescribeNetworkAclsOutput> getResources() {
    return resources;
  }

  public void setResources(List<ResourceForDescribeNetworkAclsOutput> resources) {
    this.resources = resources;
  }

  public NetworkAclForDescribeNetworkAclsOutput status(String status) {
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

  public NetworkAclForDescribeNetworkAclsOutput tags(List<TagForDescribeNetworkAclsOutput> tags) {
    this.tags = tags;
    return this;
  }

  public NetworkAclForDescribeNetworkAclsOutput addTagsItem(TagForDescribeNetworkAclsOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForDescribeNetworkAclsOutput>();
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
  public List<TagForDescribeNetworkAclsOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForDescribeNetworkAclsOutput> tags) {
    this.tags = tags;
  }

  public NetworkAclForDescribeNetworkAclsOutput updateTime(String updateTime) {
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

  public NetworkAclForDescribeNetworkAclsOutput vpcId(String vpcId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkAclForDescribeNetworkAclsOutput networkAclForDescribeNetworkAclsOutput = (NetworkAclForDescribeNetworkAclsOutput) o;
    return Objects.equals(this.creationTime, networkAclForDescribeNetworkAclsOutput.creationTime) &&
        Objects.equals(this.description, networkAclForDescribeNetworkAclsOutput.description) &&
        Objects.equals(this.egressAclEntries, networkAclForDescribeNetworkAclsOutput.egressAclEntries) &&
        Objects.equals(this.ingressAclEntries, networkAclForDescribeNetworkAclsOutput.ingressAclEntries) &&
        Objects.equals(this.networkAclId, networkAclForDescribeNetworkAclsOutput.networkAclId) &&
        Objects.equals(this.networkAclName, networkAclForDescribeNetworkAclsOutput.networkAclName) &&
        Objects.equals(this.projectName, networkAclForDescribeNetworkAclsOutput.projectName) &&
        Objects.equals(this.resources, networkAclForDescribeNetworkAclsOutput.resources) &&
        Objects.equals(this.status, networkAclForDescribeNetworkAclsOutput.status) &&
        Objects.equals(this.tags, networkAclForDescribeNetworkAclsOutput.tags) &&
        Objects.equals(this.updateTime, networkAclForDescribeNetworkAclsOutput.updateTime) &&
        Objects.equals(this.vpcId, networkAclForDescribeNetworkAclsOutput.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationTime, description, egressAclEntries, ingressAclEntries, networkAclId, networkAclName, projectName, resources, status, tags, updateTime, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkAclForDescribeNetworkAclsOutput {\n");
    
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    egressAclEntries: ").append(toIndentedString(egressAclEntries)).append("\n");
    sb.append("    ingressAclEntries: ").append(toIndentedString(ingressAclEntries)).append("\n");
    sb.append("    networkAclId: ").append(toIndentedString(networkAclId)).append("\n");
    sb.append("    networkAclName: ").append(toIndentedString(networkAclName)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
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
