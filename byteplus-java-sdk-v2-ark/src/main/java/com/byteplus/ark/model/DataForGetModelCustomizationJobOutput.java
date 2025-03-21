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
import com.byteplus.ark.model.TrainingSetForGetModelCustomizationJobOutput;
import com.byteplus.ark.model.ValidationSetForGetModelCustomizationJobOutput;
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
 * DataForGetModelCustomizationJobOutput
 */



public class DataForGetModelCustomizationJobOutput {
  /**
   * Gets or Sets encryptionKeyringType
   */
  @JsonAdapter(EncryptionKeyringTypeEnum.Adapter.class)
  public enum EncryptionKeyringTypeEnum {
    @SerializedName("ManagedKeyring")
    MANAGEDKEYRING("ManagedKeyring"),
    @SerializedName("CustomKeyring")
    CUSTOMKEYRING("CustomKeyring");

    private String value;

    EncryptionKeyringTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static EncryptionKeyringTypeEnum fromValue(String input) {
      for (EncryptionKeyringTypeEnum b : EncryptionKeyringTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<EncryptionKeyringTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EncryptionKeyringTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public EncryptionKeyringTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return EncryptionKeyringTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("EncryptionKeyringType")
  private EncryptionKeyringTypeEnum encryptionKeyringType = null;

  @SerializedName("KMSTrn")
  private String kmSTrn = null;

  @SerializedName("TrainingSet")
  private TrainingSetForGetModelCustomizationJobOutput trainingSet = null;

  @SerializedName("ValidationPercentage")
  private Integer validationPercentage = null;

  @SerializedName("ValidationSet")
  private ValidationSetForGetModelCustomizationJobOutput validationSet = null;

  public DataForGetModelCustomizationJobOutput encryptionKeyringType(EncryptionKeyringTypeEnum encryptionKeyringType) {
    this.encryptionKeyringType = encryptionKeyringType;
    return this;
  }

   /**
   * Get encryptionKeyringType
   * @return encryptionKeyringType
  **/
  @Schema(description = "")
  public EncryptionKeyringTypeEnum getEncryptionKeyringType() {
    return encryptionKeyringType;
  }

  public void setEncryptionKeyringType(EncryptionKeyringTypeEnum encryptionKeyringType) {
    this.encryptionKeyringType = encryptionKeyringType;
  }

  public DataForGetModelCustomizationJobOutput kmSTrn(String kmSTrn) {
    this.kmSTrn = kmSTrn;
    return this;
  }

   /**
   * Get kmSTrn
   * @return kmSTrn
  **/
  @Schema(description = "")
  public String getKmSTrn() {
    return kmSTrn;
  }

  public void setKmSTrn(String kmSTrn) {
    this.kmSTrn = kmSTrn;
  }

  public DataForGetModelCustomizationJobOutput trainingSet(TrainingSetForGetModelCustomizationJobOutput trainingSet) {
    this.trainingSet = trainingSet;
    return this;
  }

   /**
   * Get trainingSet
   * @return trainingSet
  **/
  @Valid
  @Schema(description = "")
  public TrainingSetForGetModelCustomizationJobOutput getTrainingSet() {
    return trainingSet;
  }

  public void setTrainingSet(TrainingSetForGetModelCustomizationJobOutput trainingSet) {
    this.trainingSet = trainingSet;
  }

  public DataForGetModelCustomizationJobOutput validationPercentage(Integer validationPercentage) {
    this.validationPercentage = validationPercentage;
    return this;
  }

   /**
   * Get validationPercentage
   * @return validationPercentage
  **/
  @Schema(description = "")
  public Integer getValidationPercentage() {
    return validationPercentage;
  }

  public void setValidationPercentage(Integer validationPercentage) {
    this.validationPercentage = validationPercentage;
  }

  public DataForGetModelCustomizationJobOutput validationSet(ValidationSetForGetModelCustomizationJobOutput validationSet) {
    this.validationSet = validationSet;
    return this;
  }

   /**
   * Get validationSet
   * @return validationSet
  **/
  @Valid
  @Schema(description = "")
  public ValidationSetForGetModelCustomizationJobOutput getValidationSet() {
    return validationSet;
  }

  public void setValidationSet(ValidationSetForGetModelCustomizationJobOutput validationSet) {
    this.validationSet = validationSet;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataForGetModelCustomizationJobOutput dataForGetModelCustomizationJobOutput = (DataForGetModelCustomizationJobOutput) o;
    return Objects.equals(this.encryptionKeyringType, dataForGetModelCustomizationJobOutput.encryptionKeyringType) &&
        Objects.equals(this.kmSTrn, dataForGetModelCustomizationJobOutput.kmSTrn) &&
        Objects.equals(this.trainingSet, dataForGetModelCustomizationJobOutput.trainingSet) &&
        Objects.equals(this.validationPercentage, dataForGetModelCustomizationJobOutput.validationPercentage) &&
        Objects.equals(this.validationSet, dataForGetModelCustomizationJobOutput.validationSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptionKeyringType, kmSTrn, trainingSet, validationPercentage, validationSet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataForGetModelCustomizationJobOutput {\n");
    
    sb.append("    encryptionKeyringType: ").append(toIndentedString(encryptionKeyringType)).append("\n");
    sb.append("    kmSTrn: ").append(toIndentedString(kmSTrn)).append("\n");
    sb.append("    trainingSet: ").append(toIndentedString(trainingSet)).append("\n");
    sb.append("    validationPercentage: ").append(toIndentedString(validationPercentage)).append("\n");
    sb.append("    validationSet: ").append(toIndentedString(validationSet)).append("\n");
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
