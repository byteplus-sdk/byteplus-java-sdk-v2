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
 * CreateSecretRequest
 */



public class CreateSecretRequest {
  @SerializedName("AutomaticRotation")
  private Boolean automaticRotation = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("EncryptionKey")
  private String encryptionKey = null;

  @SerializedName("ExtendedConfig")
  private String extendedConfig = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("RotationInterval")
  private String rotationInterval = null;

  @SerializedName("SecretName")
  private String secretName = null;

  /**
   * Gets or Sets secretType
   */
  @JsonAdapter(SecretTypeEnum.Adapter.class)
  public enum SecretTypeEnum {
    @SerializedName("Generic")
    GENERIC("Generic"),
    @SerializedName("IAM")
    IAM("IAM"),
    @SerializedName("RDS")
    RDS("RDS"),
    @SerializedName("Redis")
    REDIS("Redis"),
    @SerializedName("ECS")
    ECS("ECS");

    private String value;

    SecretTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static SecretTypeEnum fromValue(String input) {
      for (SecretTypeEnum b : SecretTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<SecretTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SecretTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public SecretTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return SecretTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("SecretType")
  private SecretTypeEnum secretType = null;

  @SerializedName("SecretValue")
  private String secretValue = null;

  public CreateSecretRequest automaticRotation(Boolean automaticRotation) {
    this.automaticRotation = automaticRotation;
    return this;
  }

   /**
   * Get automaticRotation
   * @return automaticRotation
  **/
  @Schema(description = "")
  public Boolean isAutomaticRotation() {
    return automaticRotation;
  }

  public void setAutomaticRotation(Boolean automaticRotation) {
    this.automaticRotation = automaticRotation;
  }

  public CreateSecretRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
 @Size(max=8192)  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateSecretRequest encryptionKey(String encryptionKey) {
    this.encryptionKey = encryptionKey;
    return this;
  }

   /**
   * Get encryptionKey
   * @return encryptionKey
  **/
  @Schema(description = "")
  public String getEncryptionKey() {
    return encryptionKey;
  }

  public void setEncryptionKey(String encryptionKey) {
    this.encryptionKey = encryptionKey;
  }

  public CreateSecretRequest extendedConfig(String extendedConfig) {
    this.extendedConfig = extendedConfig;
    return this;
  }

   /**
   * Get extendedConfig
   * @return extendedConfig
  **/
 @Size(max=1024)  @Schema(description = "")
  public String getExtendedConfig() {
    return extendedConfig;
  }

  public void setExtendedConfig(String extendedConfig) {
    this.extendedConfig = extendedConfig;
  }

  public CreateSecretRequest projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

   /**
   * Get projectName
   * @return projectName
  **/
  @Schema(description = "")
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public CreateSecretRequest rotationInterval(String rotationInterval) {
    this.rotationInterval = rotationInterval;
    return this;
  }

   /**
   * Get rotationInterval
   * @return rotationInterval
  **/
  @Schema(description = "")
  public String getRotationInterval() {
    return rotationInterval;
  }

  public void setRotationInterval(String rotationInterval) {
    this.rotationInterval = rotationInterval;
  }

  public CreateSecretRequest secretName(String secretName) {
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

  public CreateSecretRequest secretType(SecretTypeEnum secretType) {
    this.secretType = secretType;
    return this;
  }

   /**
   * Get secretType
   * @return secretType
  **/
  @NotNull
  @Schema(required = true, description = "")
  public SecretTypeEnum getSecretType() {
    return secretType;
  }

  public void setSecretType(SecretTypeEnum secretType) {
    this.secretType = secretType;
  }

  public CreateSecretRequest secretValue(String secretValue) {
    this.secretValue = secretValue;
    return this;
  }

   /**
   * Get secretValue
   * @return secretValue
  **/
  @NotNull
 @Size(max=30720)  @Schema(required = true, description = "")
  public String getSecretValue() {
    return secretValue;
  }

  public void setSecretValue(String secretValue) {
    this.secretValue = secretValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSecretRequest createSecretRequest = (CreateSecretRequest) o;
    return Objects.equals(this.automaticRotation, createSecretRequest.automaticRotation) &&
        Objects.equals(this.description, createSecretRequest.description) &&
        Objects.equals(this.encryptionKey, createSecretRequest.encryptionKey) &&
        Objects.equals(this.extendedConfig, createSecretRequest.extendedConfig) &&
        Objects.equals(this.projectName, createSecretRequest.projectName) &&
        Objects.equals(this.rotationInterval, createSecretRequest.rotationInterval) &&
        Objects.equals(this.secretName, createSecretRequest.secretName) &&
        Objects.equals(this.secretType, createSecretRequest.secretType) &&
        Objects.equals(this.secretValue, createSecretRequest.secretValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(automaticRotation, description, encryptionKey, extendedConfig, projectName, rotationInterval, secretName, secretType, secretValue);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSecretRequest {\n");
    
    sb.append("    automaticRotation: ").append(toIndentedString(automaticRotation)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    encryptionKey: ").append(toIndentedString(encryptionKey)).append("\n");
    sb.append("    extendedConfig: ").append(toIndentedString(extendedConfig)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    rotationInterval: ").append(toIndentedString(rotationInterval)).append("\n");
    sb.append("    secretName: ").append(toIndentedString(secretName)).append("\n");
    sb.append("    secretType: ").append(toIndentedString(secretType)).append("\n");
    sb.append("    secretValue: ").append(toIndentedString(secretValue)).append("\n");
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
