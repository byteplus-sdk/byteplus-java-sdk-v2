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
import com.byteplus.kms.model.ConvertReplicaKeyForReplicateKeyOutput;
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
 * ReplicateKeyResponse
 */



public class ReplicateKeyResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("ReplicaKey")
  private ConvertReplicaKeyForReplicateKeyOutput replicaKey = null;

  public ReplicateKeyResponse replicaKey(ConvertReplicaKeyForReplicateKeyOutput replicaKey) {
    this.replicaKey = replicaKey;
    return this;
  }

   /**
   * Get replicaKey
   * @return replicaKey
  **/
  @Valid
  @Schema(description = "")
  public ConvertReplicaKeyForReplicateKeyOutput getReplicaKey() {
    return replicaKey;
  }

  public void setReplicaKey(ConvertReplicaKeyForReplicateKeyOutput replicaKey) {
    this.replicaKey = replicaKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplicateKeyResponse replicateKeyResponse = (ReplicateKeyResponse) o;
    return Objects.equals(this.replicaKey, replicateKeyResponse.replicaKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replicaKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplicateKeyResponse {\n");
    
    sb.append("    replicaKey: ").append(toIndentedString(replicaKey)).append("\n");
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
