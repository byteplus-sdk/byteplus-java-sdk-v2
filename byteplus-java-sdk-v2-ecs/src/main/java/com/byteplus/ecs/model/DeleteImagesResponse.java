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
import com.byteplus.ecs.model.OperationDetailForDeleteImagesOutput;
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
 * DeleteImagesResponse
 */



public class DeleteImagesResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("OperationDetails")
  private List<OperationDetailForDeleteImagesOutput> operationDetails = null;

  public DeleteImagesResponse operationDetails(List<OperationDetailForDeleteImagesOutput> operationDetails) {
    this.operationDetails = operationDetails;
    return this;
  }

  public DeleteImagesResponse addOperationDetailsItem(OperationDetailForDeleteImagesOutput operationDetailsItem) {
    if (this.operationDetails == null) {
      this.operationDetails = new ArrayList<OperationDetailForDeleteImagesOutput>();
    }
    this.operationDetails.add(operationDetailsItem);
    return this;
  }

   /**
   * Get operationDetails
   * @return operationDetails
  **/
  @Valid
  @Schema(description = "")
  public List<OperationDetailForDeleteImagesOutput> getOperationDetails() {
    return operationDetails;
  }

  public void setOperationDetails(List<OperationDetailForDeleteImagesOutput> operationDetails) {
    this.operationDetails = operationDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteImagesResponse deleteImagesResponse = (DeleteImagesResponse) o;
    return Objects.equals(this.operationDetails, deleteImagesResponse.operationDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationDetails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteImagesResponse {\n");
    
    sb.append("    operationDetails: ").append(toIndentedString(operationDetails)).append("\n");
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
