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
 * ModifyTrafficMirrorFilterAttributesRequest
 */



public class ModifyTrafficMirrorFilterAttributesRequest {
  @SerializedName("Description")
  private String description = null;

  @SerializedName("TrafficMirrorFilterId")
  private String trafficMirrorFilterId = null;

  @SerializedName("TrafficMirrorFilterName")
  private String trafficMirrorFilterName = null;

  public ModifyTrafficMirrorFilterAttributesRequest description(String description) {
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

  public ModifyTrafficMirrorFilterAttributesRequest trafficMirrorFilterId(String trafficMirrorFilterId) {
    this.trafficMirrorFilterId = trafficMirrorFilterId;
    return this;
  }

   /**
   * Get trafficMirrorFilterId
   * @return trafficMirrorFilterId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getTrafficMirrorFilterId() {
    return trafficMirrorFilterId;
  }

  public void setTrafficMirrorFilterId(String trafficMirrorFilterId) {
    this.trafficMirrorFilterId = trafficMirrorFilterId;
  }

  public ModifyTrafficMirrorFilterAttributesRequest trafficMirrorFilterName(String trafficMirrorFilterName) {
    this.trafficMirrorFilterName = trafficMirrorFilterName;
    return this;
  }

   /**
   * Get trafficMirrorFilterName
   * @return trafficMirrorFilterName
  **/
  @Schema(description = "")
  public String getTrafficMirrorFilterName() {
    return trafficMirrorFilterName;
  }

  public void setTrafficMirrorFilterName(String trafficMirrorFilterName) {
    this.trafficMirrorFilterName = trafficMirrorFilterName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyTrafficMirrorFilterAttributesRequest modifyTrafficMirrorFilterAttributesRequest = (ModifyTrafficMirrorFilterAttributesRequest) o;
    return Objects.equals(this.description, modifyTrafficMirrorFilterAttributesRequest.description) &&
        Objects.equals(this.trafficMirrorFilterId, modifyTrafficMirrorFilterAttributesRequest.trafficMirrorFilterId) &&
        Objects.equals(this.trafficMirrorFilterName, modifyTrafficMirrorFilterAttributesRequest.trafficMirrorFilterName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, trafficMirrorFilterId, trafficMirrorFilterName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyTrafficMirrorFilterAttributesRequest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    trafficMirrorFilterId: ").append(toIndentedString(trafficMirrorFilterId)).append("\n");
    sb.append("    trafficMirrorFilterName: ").append(toIndentedString(trafficMirrorFilterName)).append("\n");
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
