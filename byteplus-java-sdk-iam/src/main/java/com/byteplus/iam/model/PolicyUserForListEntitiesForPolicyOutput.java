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
import com.byteplus.iam.model.PolicyScopeForListEntitiesForPolicyOutput;
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
 * PolicyUserForListEntitiesForPolicyOutput
 */



public class PolicyUserForListEntitiesForPolicyOutput {
  @SerializedName("AttachDate")
  private String attachDate = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("DisplayName")
  private String displayName = null;

  @SerializedName("PolicyScope")
  private List<PolicyScopeForListEntitiesForPolicyOutput> policyScope = null;

  @SerializedName("UserName")
  private String userName = null;

  public PolicyUserForListEntitiesForPolicyOutput attachDate(String attachDate) {
    this.attachDate = attachDate;
    return this;
  }

   /**
   * Get attachDate
   * @return attachDate
  **/
  @Schema(description = "")
  public String getAttachDate() {
    return attachDate;
  }

  public void setAttachDate(String attachDate) {
    this.attachDate = attachDate;
  }

  public PolicyUserForListEntitiesForPolicyOutput description(String description) {
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

  public PolicyUserForListEntitiesForPolicyOutput displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @Schema(description = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public PolicyUserForListEntitiesForPolicyOutput policyScope(List<PolicyScopeForListEntitiesForPolicyOutput> policyScope) {
    this.policyScope = policyScope;
    return this;
  }

  public PolicyUserForListEntitiesForPolicyOutput addPolicyScopeItem(PolicyScopeForListEntitiesForPolicyOutput policyScopeItem) {
    if (this.policyScope == null) {
      this.policyScope = new ArrayList<PolicyScopeForListEntitiesForPolicyOutput>();
    }
    this.policyScope.add(policyScopeItem);
    return this;
  }

   /**
   * Get policyScope
   * @return policyScope
  **/
  @Valid
  @Schema(description = "")
  public List<PolicyScopeForListEntitiesForPolicyOutput> getPolicyScope() {
    return policyScope;
  }

  public void setPolicyScope(List<PolicyScopeForListEntitiesForPolicyOutput> policyScope) {
    this.policyScope = policyScope;
  }

  public PolicyUserForListEntitiesForPolicyOutput userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * Get userName
   * @return userName
  **/
  @Schema(description = "")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyUserForListEntitiesForPolicyOutput policyUserForListEntitiesForPolicyOutput = (PolicyUserForListEntitiesForPolicyOutput) o;
    return Objects.equals(this.attachDate, policyUserForListEntitiesForPolicyOutput.attachDate) &&
        Objects.equals(this.description, policyUserForListEntitiesForPolicyOutput.description) &&
        Objects.equals(this.displayName, policyUserForListEntitiesForPolicyOutput.displayName) &&
        Objects.equals(this.policyScope, policyUserForListEntitiesForPolicyOutput.policyScope) &&
        Objects.equals(this.userName, policyUserForListEntitiesForPolicyOutput.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachDate, description, displayName, policyScope, userName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyUserForListEntitiesForPolicyOutput {\n");
    
    sb.append("    attachDate: ").append(toIndentedString(attachDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    policyScope: ").append(toIndentedString(policyScope)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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
