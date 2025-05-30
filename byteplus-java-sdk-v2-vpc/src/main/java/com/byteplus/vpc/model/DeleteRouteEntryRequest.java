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
 * DeleteRouteEntryRequest
 */



public class DeleteRouteEntryRequest {
  @SerializedName("RouteEntryId")
  private String routeEntryId = null;

  public DeleteRouteEntryRequest routeEntryId(String routeEntryId) {
    this.routeEntryId = routeEntryId;
    return this;
  }

   /**
   * Get routeEntryId
   * @return routeEntryId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getRouteEntryId() {
    return routeEntryId;
  }

  public void setRouteEntryId(String routeEntryId) {
    this.routeEntryId = routeEntryId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteRouteEntryRequest deleteRouteEntryRequest = (DeleteRouteEntryRequest) o;
    return Objects.equals(this.routeEntryId, deleteRouteEntryRequest.routeEntryId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routeEntryId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteRouteEntryRequest {\n");
    
    sb.append("    routeEntryId: ").append(toIndentedString(routeEntryId)).append("\n");
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
