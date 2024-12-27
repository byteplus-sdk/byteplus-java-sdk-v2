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
 * ModifyDeploymentSetAttributeRequest
 */



public class ModifyDeploymentSetAttributeRequest {
  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("DeploymentSetId")
  private String deploymentSetId = null;

  @SerializedName("DeploymentSetName")
  private String deploymentSetName = null;

  @SerializedName("Description")
  private String description = null;

  public ModifyDeploymentSetAttributeRequest clientToken(String clientToken) {
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

  public ModifyDeploymentSetAttributeRequest deploymentSetId(String deploymentSetId) {
    this.deploymentSetId = deploymentSetId;
    return this;
  }

   /**
   * Get deploymentSetId
   * @return deploymentSetId
  **/
  @Schema(description = "")
  public String getDeploymentSetId() {
    return deploymentSetId;
  }

  public void setDeploymentSetId(String deploymentSetId) {
    this.deploymentSetId = deploymentSetId;
  }

  public ModifyDeploymentSetAttributeRequest deploymentSetName(String deploymentSetName) {
    this.deploymentSetName = deploymentSetName;
    return this;
  }

   /**
   * Get deploymentSetName
   * @return deploymentSetName
  **/
  @Schema(description = "")
  public String getDeploymentSetName() {
    return deploymentSetName;
  }

  public void setDeploymentSetName(String deploymentSetName) {
    this.deploymentSetName = deploymentSetName;
  }

  public ModifyDeploymentSetAttributeRequest description(String description) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyDeploymentSetAttributeRequest modifyDeploymentSetAttributeRequest = (ModifyDeploymentSetAttributeRequest) o;
    return Objects.equals(this.clientToken, modifyDeploymentSetAttributeRequest.clientToken) &&
        Objects.equals(this.deploymentSetId, modifyDeploymentSetAttributeRequest.deploymentSetId) &&
        Objects.equals(this.deploymentSetName, modifyDeploymentSetAttributeRequest.deploymentSetName) &&
        Objects.equals(this.description, modifyDeploymentSetAttributeRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientToken, deploymentSetId, deploymentSetName, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyDeploymentSetAttributeRequest {\n");
    
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    deploymentSetId: ").append(toIndentedString(deploymentSetId)).append("\n");
    sb.append("    deploymentSetName: ").append(toIndentedString(deploymentSetName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
