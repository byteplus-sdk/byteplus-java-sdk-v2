/*
 * ark
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.ark.model;

import java.util.Objects;
import java.util.Arrays;
import com.byteplus.ark.model.FoundationModelForListEndpointsOutput;
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
 * ModelReferenceForListEndpointsOutput
 */



public class ModelReferenceForListEndpointsOutput {
  @SerializedName("CustomModelId")
  private String customModelId = null;

  @SerializedName("FoundationModel")
  private FoundationModelForListEndpointsOutput foundationModel = null;

  public ModelReferenceForListEndpointsOutput customModelId(String customModelId) {
    this.customModelId = customModelId;
    return this;
  }

   /**
   * Get customModelId
   * @return customModelId
  **/
  @Schema(description = "")
  public String getCustomModelId() {
    return customModelId;
  }

  public void setCustomModelId(String customModelId) {
    this.customModelId = customModelId;
  }

  public ModelReferenceForListEndpointsOutput foundationModel(FoundationModelForListEndpointsOutput foundationModel) {
    this.foundationModel = foundationModel;
    return this;
  }

   /**
   * Get foundationModel
   * @return foundationModel
  **/
  @Valid
  @Schema(description = "")
  public FoundationModelForListEndpointsOutput getFoundationModel() {
    return foundationModel;
  }

  public void setFoundationModel(FoundationModelForListEndpointsOutput foundationModel) {
    this.foundationModel = foundationModel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelReferenceForListEndpointsOutput modelReferenceForListEndpointsOutput = (ModelReferenceForListEndpointsOutput) o;
    return Objects.equals(this.customModelId, modelReferenceForListEndpointsOutput.customModelId) &&
        Objects.equals(this.foundationModel, modelReferenceForListEndpointsOutput.foundationModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customModelId, foundationModel);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelReferenceForListEndpointsOutput {\n");
    
    sb.append("    customModelId: ").append(toIndentedString(customModelId)).append("\n");
    sb.append("    foundationModel: ").append(toIndentedString(foundationModel)).append("\n");
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
