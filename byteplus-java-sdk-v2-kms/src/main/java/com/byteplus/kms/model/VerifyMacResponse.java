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
 * VerifyMacResponse
 */



public class VerifyMacResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("KeyID")
  private String keyID = null;

  @SerializedName("MacValid")
  private Boolean macValid = null;

  public VerifyMacResponse keyID(String keyID) {
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

  public VerifyMacResponse macValid(Boolean macValid) {
    this.macValid = macValid;
    return this;
  }

   /**
   * Get macValid
   * @return macValid
  **/
  @Schema(description = "")
  public Boolean isMacValid() {
    return macValid;
  }

  public void setMacValid(Boolean macValid) {
    this.macValid = macValid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerifyMacResponse verifyMacResponse = (VerifyMacResponse) o;
    return Objects.equals(this.keyID, verifyMacResponse.keyID) &&
        Objects.equals(this.macValid, verifyMacResponse.macValid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyID, macValid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerifyMacResponse {\n");
    
    sb.append("    keyID: ").append(toIndentedString(keyID)).append("\n");
    sb.append("    macValid: ").append(toIndentedString(macValid)).append("\n");
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
