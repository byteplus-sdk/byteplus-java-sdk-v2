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
 * ModifyIpv6GatewayAttributeRequest
 */



public class ModifyIpv6GatewayAttributeRequest {
  @SerializedName("Description")
  private String description = null;

  @SerializedName("Ipv6GatewayId")
  private String ipv6GatewayId = null;

  @SerializedName("Name")
  private String name = null;

  public ModifyIpv6GatewayAttributeRequest description(String description) {
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

  public ModifyIpv6GatewayAttributeRequest ipv6GatewayId(String ipv6GatewayId) {
    this.ipv6GatewayId = ipv6GatewayId;
    return this;
  }

   /**
   * Get ipv6GatewayId
   * @return ipv6GatewayId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getIpv6GatewayId() {
    return ipv6GatewayId;
  }

  public void setIpv6GatewayId(String ipv6GatewayId) {
    this.ipv6GatewayId = ipv6GatewayId;
  }

  public ModifyIpv6GatewayAttributeRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyIpv6GatewayAttributeRequest modifyIpv6GatewayAttributeRequest = (ModifyIpv6GatewayAttributeRequest) o;
    return Objects.equals(this.description, modifyIpv6GatewayAttributeRequest.description) &&
        Objects.equals(this.ipv6GatewayId, modifyIpv6GatewayAttributeRequest.ipv6GatewayId) &&
        Objects.equals(this.name, modifyIpv6GatewayAttributeRequest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, ipv6GatewayId, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyIpv6GatewayAttributeRequest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    ipv6GatewayId: ").append(toIndentedString(ipv6GatewayId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
