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
 * CreateDedicatedHostClusterRequest
 */



public class CreateDedicatedHostClusterRequest {
  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("DedicatedHostClusterName")
  private String dedicatedHostClusterName = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("ZoneId")
  private String zoneId = null;

  public CreateDedicatedHostClusterRequest clientToken(String clientToken) {
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

  public CreateDedicatedHostClusterRequest dedicatedHostClusterName(String dedicatedHostClusterName) {
    this.dedicatedHostClusterName = dedicatedHostClusterName;
    return this;
  }

   /**
   * Get dedicatedHostClusterName
   * @return dedicatedHostClusterName
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getDedicatedHostClusterName() {
    return dedicatedHostClusterName;
  }

  public void setDedicatedHostClusterName(String dedicatedHostClusterName) {
    this.dedicatedHostClusterName = dedicatedHostClusterName;
  }

  public CreateDedicatedHostClusterRequest description(String description) {
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

  public CreateDedicatedHostClusterRequest zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * Get zoneId
   * @return zoneId
  **/
  @NotNull
  @Schema(required = true, description = "")
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
    CreateDedicatedHostClusterRequest createDedicatedHostClusterRequest = (CreateDedicatedHostClusterRequest) o;
    return Objects.equals(this.clientToken, createDedicatedHostClusterRequest.clientToken) &&
        Objects.equals(this.dedicatedHostClusterName, createDedicatedHostClusterRequest.dedicatedHostClusterName) &&
        Objects.equals(this.description, createDedicatedHostClusterRequest.description) &&
        Objects.equals(this.zoneId, createDedicatedHostClusterRequest.zoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientToken, dedicatedHostClusterName, description, zoneId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDedicatedHostClusterRequest {\n");
    
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    dedicatedHostClusterName: ").append(toIndentedString(dedicatedHostClusterName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
