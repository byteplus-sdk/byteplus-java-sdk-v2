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
 * ModifyTrafficMirrorTargetAttributesRequest
 */



public class ModifyTrafficMirrorTargetAttributesRequest {
  @SerializedName("Description")
  private String description = null;

  @SerializedName("TrafficMirrorTargetId")
  private String trafficMirrorTargetId = null;

  @SerializedName("TrafficMirrorTargetName")
  private String trafficMirrorTargetName = null;

  public ModifyTrafficMirrorTargetAttributesRequest description(String description) {
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

  public ModifyTrafficMirrorTargetAttributesRequest trafficMirrorTargetId(String trafficMirrorTargetId) {
    this.trafficMirrorTargetId = trafficMirrorTargetId;
    return this;
  }

   /**
   * Get trafficMirrorTargetId
   * @return trafficMirrorTargetId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getTrafficMirrorTargetId() {
    return trafficMirrorTargetId;
  }

  public void setTrafficMirrorTargetId(String trafficMirrorTargetId) {
    this.trafficMirrorTargetId = trafficMirrorTargetId;
  }

  public ModifyTrafficMirrorTargetAttributesRequest trafficMirrorTargetName(String trafficMirrorTargetName) {
    this.trafficMirrorTargetName = trafficMirrorTargetName;
    return this;
  }

   /**
   * Get trafficMirrorTargetName
   * @return trafficMirrorTargetName
  **/
  @Schema(description = "")
  public String getTrafficMirrorTargetName() {
    return trafficMirrorTargetName;
  }

  public void setTrafficMirrorTargetName(String trafficMirrorTargetName) {
    this.trafficMirrorTargetName = trafficMirrorTargetName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyTrafficMirrorTargetAttributesRequest modifyTrafficMirrorTargetAttributesRequest = (ModifyTrafficMirrorTargetAttributesRequest) o;
    return Objects.equals(this.description, modifyTrafficMirrorTargetAttributesRequest.description) &&
        Objects.equals(this.trafficMirrorTargetId, modifyTrafficMirrorTargetAttributesRequest.trafficMirrorTargetId) &&
        Objects.equals(this.trafficMirrorTargetName, modifyTrafficMirrorTargetAttributesRequest.trafficMirrorTargetName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, trafficMirrorTargetId, trafficMirrorTargetName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyTrafficMirrorTargetAttributesRequest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    trafficMirrorTargetId: ").append(toIndentedString(trafficMirrorTargetId)).append("\n");
    sb.append("    trafficMirrorTargetName: ").append(toIndentedString(trafficMirrorTargetName)).append("\n");
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
