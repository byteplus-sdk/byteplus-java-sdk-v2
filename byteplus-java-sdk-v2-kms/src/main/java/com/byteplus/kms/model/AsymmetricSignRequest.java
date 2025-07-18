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
 * AsymmetricSignRequest
 */



public class AsymmetricSignRequest {
  @SerializedName("Algorithm")
  private String algorithm = null;

  @SerializedName("KeyID")
  private String keyID = null;

  @SerializedName("KeyName")
  private String keyName = null;

  @SerializedName("KeyringName")
  private String keyringName = null;

  @SerializedName("Message")
  private String message = null;

  @SerializedName("MessageType")
  private String messageType = null;

  public AsymmetricSignRequest algorithm(String algorithm) {
    this.algorithm = algorithm;
    return this;
  }

   /**
   * Get algorithm
   * @return algorithm
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public AsymmetricSignRequest keyID(String keyID) {
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

  public AsymmetricSignRequest keyName(String keyName) {
    this.keyName = keyName;
    return this;
  }

   /**
   * Get keyName
   * @return keyName
  **/
 @Size(min=2,max=31)  @Schema(description = "")
  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public AsymmetricSignRequest keyringName(String keyringName) {
    this.keyringName = keyringName;
    return this;
  }

   /**
   * Get keyringName
   * @return keyringName
  **/
 @Size(min=2,max=31)  @Schema(description = "")
  public String getKeyringName() {
    return keyringName;
  }

  public void setKeyringName(String keyringName) {
    this.keyringName = keyringName;
  }

  public AsymmetricSignRequest message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AsymmetricSignRequest messageType(String messageType) {
    this.messageType = messageType;
    return this;
  }

   /**
   * Get messageType
   * @return messageType
  **/
  @Schema(description = "")
  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsymmetricSignRequest asymmetricSignRequest = (AsymmetricSignRequest) o;
    return Objects.equals(this.algorithm, asymmetricSignRequest.algorithm) &&
        Objects.equals(this.keyID, asymmetricSignRequest.keyID) &&
        Objects.equals(this.keyName, asymmetricSignRequest.keyName) &&
        Objects.equals(this.keyringName, asymmetricSignRequest.keyringName) &&
        Objects.equals(this.message, asymmetricSignRequest.message) &&
        Objects.equals(this.messageType, asymmetricSignRequest.messageType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithm, keyID, keyName, keyringName, message, messageType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsymmetricSignRequest {\n");
    
    sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
    sb.append("    keyID: ").append(toIndentedString(keyID)).append("\n");
    sb.append("    keyName: ").append(toIndentedString(keyName)).append("\n");
    sb.append("    keyringName: ").append(toIndentedString(keyringName)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
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
