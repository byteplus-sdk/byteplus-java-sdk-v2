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
 * CreateSecurityGroupResponse
 */



public class CreateSecurityGroupResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("RequestId")
  private String requestId = null;

  @SerializedName("SecurityGroupId")
  private String securityGroupId = null;

  public CreateSecurityGroupResponse requestId(String requestId) {
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

  public CreateSecurityGroupResponse securityGroupId(String securityGroupId) {
    this.securityGroupId = securityGroupId;
    return this;
  }

   /**
   * Get securityGroupId
   * @return securityGroupId
  **/
  @Schema(description = "")
  public String getSecurityGroupId() {
    return securityGroupId;
  }

  public void setSecurityGroupId(String securityGroupId) {
    this.securityGroupId = securityGroupId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSecurityGroupResponse createSecurityGroupResponse = (CreateSecurityGroupResponse) o;
    return Objects.equals(this.requestId, createSecurityGroupResponse.requestId) &&
        Objects.equals(this.securityGroupId, createSecurityGroupResponse.securityGroupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, securityGroupId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSecurityGroupResponse {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    securityGroupId: ").append(toIndentedString(securityGroupId)).append("\n");
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
