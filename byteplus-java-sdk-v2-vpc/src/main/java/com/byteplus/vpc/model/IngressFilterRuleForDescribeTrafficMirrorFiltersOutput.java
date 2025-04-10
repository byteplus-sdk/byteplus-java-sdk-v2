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
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * IngressFilterRuleForDescribeTrafficMirrorFiltersOutput
 */



public class IngressFilterRuleForDescribeTrafficMirrorFiltersOutput {
  @SerializedName("Description")
  private String description = null;

  @SerializedName("DestinationCidrBlock")
  private String destinationCidrBlock = null;

  @SerializedName("DestinationPortRange")
  private String destinationPortRange = null;

  @SerializedName("Policy")
  private String policy = null;

  @SerializedName("Priority")
  private Integer priority = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("Protocol")
  private String protocol = null;

  @SerializedName("SourceCidrBlock")
  private String sourceCidrBlock = null;

  @SerializedName("SourcePortRange")
  private String sourcePortRange = null;

  @SerializedName("Status")
  private String status = null;

  @SerializedName("TrafficDirection")
  private String trafficDirection = null;

  @SerializedName("TrafficMirrorFilterId")
  private String trafficMirrorFilterId = null;

  @SerializedName("TrafficMirrorFilterRuleId")
  private String trafficMirrorFilterRuleId = null;

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput description(String description) {
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

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput destinationCidrBlock(String destinationCidrBlock) {
    this.destinationCidrBlock = destinationCidrBlock;
    return this;
  }

   /**
   * Get destinationCidrBlock
   * @return destinationCidrBlock
  **/
  @Schema(description = "")
  public String getDestinationCidrBlock() {
    return destinationCidrBlock;
  }

  public void setDestinationCidrBlock(String destinationCidrBlock) {
    this.destinationCidrBlock = destinationCidrBlock;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput destinationPortRange(String destinationPortRange) {
    this.destinationPortRange = destinationPortRange;
    return this;
  }

   /**
   * Get destinationPortRange
   * @return destinationPortRange
  **/
  @Schema(description = "")
  public String getDestinationPortRange() {
    return destinationPortRange;
  }

  public void setDestinationPortRange(String destinationPortRange) {
    this.destinationPortRange = destinationPortRange;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput policy(String policy) {
    this.policy = policy;
    return this;
  }

   /**
   * Get policy
   * @return policy
  **/
  @Schema(description = "")
  public String getPolicy() {
    return policy;
  }

  public void setPolicy(String policy) {
    this.policy = policy;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput priority(Integer priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @Schema(description = "")
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput projectName(String projectName) {
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

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput protocol(String protocol) {
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

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput sourceCidrBlock(String sourceCidrBlock) {
    this.sourceCidrBlock = sourceCidrBlock;
    return this;
  }

   /**
   * Get sourceCidrBlock
   * @return sourceCidrBlock
  **/
  @Schema(description = "")
  public String getSourceCidrBlock() {
    return sourceCidrBlock;
  }

  public void setSourceCidrBlock(String sourceCidrBlock) {
    this.sourceCidrBlock = sourceCidrBlock;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput sourcePortRange(String sourcePortRange) {
    this.sourcePortRange = sourcePortRange;
    return this;
  }

   /**
   * Get sourcePortRange
   * @return sourcePortRange
  **/
  @Schema(description = "")
  public String getSourcePortRange() {
    return sourcePortRange;
  }

  public void setSourcePortRange(String sourcePortRange) {
    this.sourcePortRange = sourcePortRange;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput status(String status) {
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

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput trafficDirection(String trafficDirection) {
    this.trafficDirection = trafficDirection;
    return this;
  }

   /**
   * Get trafficDirection
   * @return trafficDirection
  **/
  @Schema(description = "")
  public String getTrafficDirection() {
    return trafficDirection;
  }

  public void setTrafficDirection(String trafficDirection) {
    this.trafficDirection = trafficDirection;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput trafficMirrorFilterId(String trafficMirrorFilterId) {
    this.trafficMirrorFilterId = trafficMirrorFilterId;
    return this;
  }

   /**
   * Get trafficMirrorFilterId
   * @return trafficMirrorFilterId
  **/
  @Schema(description = "")
  public String getTrafficMirrorFilterId() {
    return trafficMirrorFilterId;
  }

  public void setTrafficMirrorFilterId(String trafficMirrorFilterId) {
    this.trafficMirrorFilterId = trafficMirrorFilterId;
  }

  public IngressFilterRuleForDescribeTrafficMirrorFiltersOutput trafficMirrorFilterRuleId(String trafficMirrorFilterRuleId) {
    this.trafficMirrorFilterRuleId = trafficMirrorFilterRuleId;
    return this;
  }

   /**
   * Get trafficMirrorFilterRuleId
   * @return trafficMirrorFilterRuleId
  **/
  @Schema(description = "")
  public String getTrafficMirrorFilterRuleId() {
    return trafficMirrorFilterRuleId;
  }

  public void setTrafficMirrorFilterRuleId(String trafficMirrorFilterRuleId) {
    this.trafficMirrorFilterRuleId = trafficMirrorFilterRuleId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngressFilterRuleForDescribeTrafficMirrorFiltersOutput ingressFilterRuleForDescribeTrafficMirrorFiltersOutput = (IngressFilterRuleForDescribeTrafficMirrorFiltersOutput) o;
    return Objects.equals(this.description, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.description) &&
        Objects.equals(this.destinationCidrBlock, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.destinationCidrBlock) &&
        Objects.equals(this.destinationPortRange, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.destinationPortRange) &&
        Objects.equals(this.policy, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.policy) &&
        Objects.equals(this.priority, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.priority) &&
        Objects.equals(this.projectName, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.projectName) &&
        Objects.equals(this.protocol, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.protocol) &&
        Objects.equals(this.sourceCidrBlock, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.sourceCidrBlock) &&
        Objects.equals(this.sourcePortRange, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.sourcePortRange) &&
        Objects.equals(this.status, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.status) &&
        Objects.equals(this.trafficDirection, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.trafficDirection) &&
        Objects.equals(this.trafficMirrorFilterId, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.trafficMirrorFilterId) &&
        Objects.equals(this.trafficMirrorFilterRuleId, ingressFilterRuleForDescribeTrafficMirrorFiltersOutput.trafficMirrorFilterRuleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, destinationCidrBlock, destinationPortRange, policy, priority, projectName, protocol, sourceCidrBlock, sourcePortRange, status, trafficDirection, trafficMirrorFilterId, trafficMirrorFilterRuleId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IngressFilterRuleForDescribeTrafficMirrorFiltersOutput {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    destinationCidrBlock: ").append(toIndentedString(destinationCidrBlock)).append("\n");
    sb.append("    destinationPortRange: ").append(toIndentedString(destinationPortRange)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    sourceCidrBlock: ").append(toIndentedString(sourceCidrBlock)).append("\n");
    sb.append("    sourcePortRange: ").append(toIndentedString(sourcePortRange)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    trafficDirection: ").append(toIndentedString(trafficDirection)).append("\n");
    sb.append("    trafficMirrorFilterId: ").append(toIndentedString(trafficMirrorFilterId)).append("\n");
    sb.append("    trafficMirrorFilterRuleId: ").append(toIndentedString(trafficMirrorFilterRuleId)).append("\n");
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
