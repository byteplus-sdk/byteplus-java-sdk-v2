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
 * AsymmetricSignResponse
 */



public class AsymmetricSignResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("KeyID")
  private String keyID = null;

  @SerializedName("Signature")
  private String signature = null;

  public AsymmetricSignResponse keyID(String keyID) {
    this.keyID = keyID;
    return this;
  }

   /**
   * Get keyID
   * @return keyID
  **/
  @Schema(description = "")
  public String getKeyID() {
    return keyID;
  }

  public void setKeyID(String keyID) {
    this.keyID = keyID;
  }

  public AsymmetricSignResponse signature(String signature) {
    this.signature = signature;
    return this;
  }

   /**
   * Get signature
   * @return signature
  **/
  @Schema(description = "")
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsymmetricSignResponse asymmetricSignResponse = (AsymmetricSignResponse) o;
    return Objects.equals(this.keyID, asymmetricSignResponse.keyID) &&
        Objects.equals(this.signature, asymmetricSignResponse.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyID, signature);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsymmetricSignResponse {\n");
    
    sb.append("    keyID: ").append(toIndentedString(keyID)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
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
