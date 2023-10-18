/*
 * iam
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.iam.model;

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
 * UpdatePolicyRequest
 */



public class UpdatePolicyRequest {
  @SerializedName("NewDescription")
  private String newDescription = null;

  @SerializedName("NewPolicyDocument")
  private String newPolicyDocument = null;

  @SerializedName("NewPolicyName")
  private String newPolicyName = null;

  @SerializedName("PolicyName")
  private String policyName = null;

  public UpdatePolicyRequest newDescription(String newDescription) {
    this.newDescription = newDescription;
    return this;
  }

   /**
   * Get newDescription
   * @return newDescription
  **/
  @Schema(description = "")
  public String getNewDescription() {
    return newDescription;
  }

  public void setNewDescription(String newDescription) {
    this.newDescription = newDescription;
  }

  public UpdatePolicyRequest newPolicyDocument(String newPolicyDocument) {
    this.newPolicyDocument = newPolicyDocument;
    return this;
  }

   /**
   * Get newPolicyDocument
   * @return newPolicyDocument
  **/
  @Schema(description = "")
  public String getNewPolicyDocument() {
    return newPolicyDocument;
  }

  public void setNewPolicyDocument(String newPolicyDocument) {
    this.newPolicyDocument = newPolicyDocument;
  }

  public UpdatePolicyRequest newPolicyName(String newPolicyName) {
    this.newPolicyName = newPolicyName;
    return this;
  }

   /**
   * Get newPolicyName
   * @return newPolicyName
  **/
  @Schema(description = "")
  public String getNewPolicyName() {
    return newPolicyName;
  }

  public void setNewPolicyName(String newPolicyName) {
    this.newPolicyName = newPolicyName;
  }

  public UpdatePolicyRequest policyName(String policyName) {
    this.policyName = policyName;
    return this;
  }

   /**
   * Get policyName
   * @return policyName
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getPolicyName() {
    return policyName;
  }

  public void setPolicyName(String policyName) {
    this.policyName = policyName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatePolicyRequest updatePolicyRequest = (UpdatePolicyRequest) o;
    return Objects.equals(this.newDescription, updatePolicyRequest.newDescription) &&
        Objects.equals(this.newPolicyDocument, updatePolicyRequest.newPolicyDocument) &&
        Objects.equals(this.newPolicyName, updatePolicyRequest.newPolicyName) &&
        Objects.equals(this.policyName, updatePolicyRequest.policyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newDescription, newPolicyDocument, newPolicyName, policyName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePolicyRequest {\n");
    
    sb.append("    newDescription: ").append(toIndentedString(newDescription)).append("\n");
    sb.append("    newPolicyDocument: ").append(toIndentedString(newPolicyDocument)).append("\n");
    sb.append("    newPolicyName: ").append(toIndentedString(newPolicyName)).append("\n");
    sb.append("    policyName: ").append(toIndentedString(policyName)).append("\n");
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
