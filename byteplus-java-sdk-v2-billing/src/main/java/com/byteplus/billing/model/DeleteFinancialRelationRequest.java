/*
 * billing
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.billing.model;

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
 * DeleteFinancialRelationRequest
 */



public class DeleteFinancialRelationRequest {
  @SerializedName("Relation")
  private Integer relation = null;

  @SerializedName("RelationID")
  private String relationID = null;

  @SerializedName("SubAccountID")
  private Long subAccountID = null;

  public DeleteFinancialRelationRequest relation(Integer relation) {
    this.relation = relation;
    return this;
  }

   /**
   * Get relation
   * @return relation
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Integer getRelation() {
    return relation;
  }

  public void setRelation(Integer relation) {
    this.relation = relation;
  }

  public DeleteFinancialRelationRequest relationID(String relationID) {
    this.relationID = relationID;
    return this;
  }

   /**
   * Get relationID
   * @return relationID
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getRelationID() {
    return relationID;
  }

  public void setRelationID(String relationID) {
    this.relationID = relationID;
  }

  public DeleteFinancialRelationRequest subAccountID(Long subAccountID) {
    this.subAccountID = subAccountID;
    return this;
  }

   /**
   * Get subAccountID
   * @return subAccountID
  **/
  @NotNull
  @Schema(required = true, description = "")
  public Long getSubAccountID() {
    return subAccountID;
  }

  public void setSubAccountID(Long subAccountID) {
    this.subAccountID = subAccountID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteFinancialRelationRequest deleteFinancialRelationRequest = (DeleteFinancialRelationRequest) o;
    return Objects.equals(this.relation, deleteFinancialRelationRequest.relation) &&
        Objects.equals(this.relationID, deleteFinancialRelationRequest.relationID) &&
        Objects.equals(this.subAccountID, deleteFinancialRelationRequest.subAccountID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relation, relationID, subAccountID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteFinancialRelationRequest {\n");
    
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
    sb.append("    relationID: ").append(toIndentedString(relationID)).append("\n");
    sb.append("    subAccountID: ").append(toIndentedString(subAccountID)).append("\n");
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
