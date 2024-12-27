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
 * DescribeDeploymentSetSupportedInstanceTypeFamilyResponse
 */



public class DescribeDeploymentSetSupportedInstanceTypeFamilyResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("DeploymentSetCreateInstanceTypeFamilies")
  private List<String> deploymentSetCreateInstanceTypeFamilies = null;

  @SerializedName("DeploymentSetModifyInstanceTypeFamilies")
  private List<String> deploymentSetModifyInstanceTypeFamilies = null;

  public DescribeDeploymentSetSupportedInstanceTypeFamilyResponse deploymentSetCreateInstanceTypeFamilies(List<String> deploymentSetCreateInstanceTypeFamilies) {
    this.deploymentSetCreateInstanceTypeFamilies = deploymentSetCreateInstanceTypeFamilies;
    return this;
  }

  public DescribeDeploymentSetSupportedInstanceTypeFamilyResponse addDeploymentSetCreateInstanceTypeFamiliesItem(String deploymentSetCreateInstanceTypeFamiliesItem) {
    if (this.deploymentSetCreateInstanceTypeFamilies == null) {
      this.deploymentSetCreateInstanceTypeFamilies = new ArrayList<String>();
    }
    this.deploymentSetCreateInstanceTypeFamilies.add(deploymentSetCreateInstanceTypeFamiliesItem);
    return this;
  }

   /**
   * Get deploymentSetCreateInstanceTypeFamilies
   * @return deploymentSetCreateInstanceTypeFamilies
  **/
  @Schema(description = "")
  public List<String> getDeploymentSetCreateInstanceTypeFamilies() {
    return deploymentSetCreateInstanceTypeFamilies;
  }

  public void setDeploymentSetCreateInstanceTypeFamilies(List<String> deploymentSetCreateInstanceTypeFamilies) {
    this.deploymentSetCreateInstanceTypeFamilies = deploymentSetCreateInstanceTypeFamilies;
  }

  public DescribeDeploymentSetSupportedInstanceTypeFamilyResponse deploymentSetModifyInstanceTypeFamilies(List<String> deploymentSetModifyInstanceTypeFamilies) {
    this.deploymentSetModifyInstanceTypeFamilies = deploymentSetModifyInstanceTypeFamilies;
    return this;
  }

  public DescribeDeploymentSetSupportedInstanceTypeFamilyResponse addDeploymentSetModifyInstanceTypeFamiliesItem(String deploymentSetModifyInstanceTypeFamiliesItem) {
    if (this.deploymentSetModifyInstanceTypeFamilies == null) {
      this.deploymentSetModifyInstanceTypeFamilies = new ArrayList<String>();
    }
    this.deploymentSetModifyInstanceTypeFamilies.add(deploymentSetModifyInstanceTypeFamiliesItem);
    return this;
  }

   /**
   * Get deploymentSetModifyInstanceTypeFamilies
   * @return deploymentSetModifyInstanceTypeFamilies
  **/
  @Schema(description = "")
  public List<String> getDeploymentSetModifyInstanceTypeFamilies() {
    return deploymentSetModifyInstanceTypeFamilies;
  }

  public void setDeploymentSetModifyInstanceTypeFamilies(List<String> deploymentSetModifyInstanceTypeFamilies) {
    this.deploymentSetModifyInstanceTypeFamilies = deploymentSetModifyInstanceTypeFamilies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeDeploymentSetSupportedInstanceTypeFamilyResponse describeDeploymentSetSupportedInstanceTypeFamilyResponse = (DescribeDeploymentSetSupportedInstanceTypeFamilyResponse) o;
    return Objects.equals(this.deploymentSetCreateInstanceTypeFamilies, describeDeploymentSetSupportedInstanceTypeFamilyResponse.deploymentSetCreateInstanceTypeFamilies) &&
        Objects.equals(this.deploymentSetModifyInstanceTypeFamilies, describeDeploymentSetSupportedInstanceTypeFamilyResponse.deploymentSetModifyInstanceTypeFamilies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deploymentSetCreateInstanceTypeFamilies, deploymentSetModifyInstanceTypeFamilies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeDeploymentSetSupportedInstanceTypeFamilyResponse {\n");
    
    sb.append("    deploymentSetCreateInstanceTypeFamilies: ").append(toIndentedString(deploymentSetCreateInstanceTypeFamilies)).append("\n");
    sb.append("    deploymentSetModifyInstanceTypeFamilies: ").append(toIndentedString(deploymentSetModifyInstanceTypeFamilies)).append("\n");
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
