/*
 * kms
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.kms.model;

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
 * ScheduleSecretDeletionRequest
 */



public class ScheduleSecretDeletionRequest {
  @SerializedName("ForceDelete")
  private Boolean forceDelete = null;

  @SerializedName("PendingWindowInDays")
  private Integer pendingWindowInDays = null;

  @SerializedName("SecretName")
  private String secretName = null;

  public ScheduleSecretDeletionRequest forceDelete(Boolean forceDelete) {
    this.forceDelete = forceDelete;
    return this;
  }

   /**
   * Get forceDelete
   * @return forceDelete
  **/
  @Schema(description = "")
  public Boolean isForceDelete() {
    return forceDelete;
  }

  public void setForceDelete(Boolean forceDelete) {
    this.forceDelete = forceDelete;
  }

  public ScheduleSecretDeletionRequest pendingWindowInDays(Integer pendingWindowInDays) {
    this.pendingWindowInDays = pendingWindowInDays;
    return this;
  }

   /**
   * Get pendingWindowInDays
   * minimum: 7
   * maximum: 30
   * @return pendingWindowInDays
  **/
 @Min(7) @Max(30)  @Schema(description = "")
  public Integer getPendingWindowInDays() {
    return pendingWindowInDays;
  }

  public void setPendingWindowInDays(Integer pendingWindowInDays) {
    this.pendingWindowInDays = pendingWindowInDays;
  }

  public ScheduleSecretDeletionRequest secretName(String secretName) {
    this.secretName = secretName;
    return this;
  }

   /**
   * Get secretName
   * @return secretName
  **/
  @NotNull
 @Size(min=2,max=128)  @Schema(required = true, description = "")
  public String getSecretName() {
    return secretName;
  }

  public void setSecretName(String secretName) {
    this.secretName = secretName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduleSecretDeletionRequest scheduleSecretDeletionRequest = (ScheduleSecretDeletionRequest) o;
    return Objects.equals(this.forceDelete, scheduleSecretDeletionRequest.forceDelete) &&
        Objects.equals(this.pendingWindowInDays, scheduleSecretDeletionRequest.pendingWindowInDays) &&
        Objects.equals(this.secretName, scheduleSecretDeletionRequest.secretName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forceDelete, pendingWindowInDays, secretName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduleSecretDeletionRequest {\n");
    
    sb.append("    forceDelete: ").append(toIndentedString(forceDelete)).append("\n");
    sb.append("    pendingWindowInDays: ").append(toIndentedString(pendingWindowInDays)).append("\n");
    sb.append("    secretName: ").append(toIndentedString(secretName)).append("\n");
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
