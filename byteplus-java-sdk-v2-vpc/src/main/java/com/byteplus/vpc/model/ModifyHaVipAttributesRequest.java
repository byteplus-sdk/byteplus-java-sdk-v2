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
 * ModifyHaVipAttributesRequest
 */



public class ModifyHaVipAttributesRequest {
  @SerializedName("Description")
  private String description = null;

  @SerializedName("HaVipId")
  private String haVipId = null;

  @SerializedName("HaVipName")
  private String haVipName = null;

  public ModifyHaVipAttributesRequest description(String description) {
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

  public ModifyHaVipAttributesRequest haVipId(String haVipId) {
    this.haVipId = haVipId;
    return this;
  }

   /**
   * Get haVipId
   * @return haVipId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getHaVipId() {
    return haVipId;
  }

  public void setHaVipId(String haVipId) {
    this.haVipId = haVipId;
  }

  public ModifyHaVipAttributesRequest haVipName(String haVipName) {
    this.haVipName = haVipName;
    return this;
  }

   /**
   * Get haVipName
   * @return haVipName
  **/
 @Size(min=1,max=128)  @Schema(description = "")
  public String getHaVipName() {
    return haVipName;
  }

  public void setHaVipName(String haVipName) {
    this.haVipName = haVipName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyHaVipAttributesRequest modifyHaVipAttributesRequest = (ModifyHaVipAttributesRequest) o;
    return Objects.equals(this.description, modifyHaVipAttributesRequest.description) &&
        Objects.equals(this.haVipId, modifyHaVipAttributesRequest.haVipId) &&
        Objects.equals(this.haVipName, modifyHaVipAttributesRequest.haVipName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, haVipId, haVipName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyHaVipAttributesRequest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    haVipId: ").append(toIndentedString(haVipId)).append("\n");
    sb.append("    haVipName: ").append(toIndentedString(haVipName)).append("\n");
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
