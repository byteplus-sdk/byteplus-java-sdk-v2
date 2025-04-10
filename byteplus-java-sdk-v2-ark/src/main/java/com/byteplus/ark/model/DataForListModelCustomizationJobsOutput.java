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
import com.byteplus.ark.model.TrainingSetForListModelCustomizationJobsOutput;
import com.byteplus.ark.model.ValidationSetForListModelCustomizationJobsOutput;
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
 * DataForListModelCustomizationJobsOutput
 */



public class DataForListModelCustomizationJobsOutput {
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
  private TrainingSetForListModelCustomizationJobsOutput trainingSet = null;

  @SerializedName("ValidationPercentage")
  private Integer validationPercentage = null;

  @SerializedName("ValidationSet")
  private ValidationSetForListModelCustomizationJobsOutput validationSet = null;

  public DataForListModelCustomizationJobsOutput encryptionKeyringType(EncryptionKeyringTypeEnum encryptionKeyringType) {
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

  public DataForListModelCustomizationJobsOutput kmSTrn(String kmSTrn) {
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

  public DataForListModelCustomizationJobsOutput trainingSet(TrainingSetForListModelCustomizationJobsOutput trainingSet) {
    this.trainingSet = trainingSet;
    return this;
  }

   /**
   * Get trainingSet
   * @return trainingSet
  **/
  @Valid
  @Schema(description = "")
  public TrainingSetForListModelCustomizationJobsOutput getTrainingSet() {
    return trainingSet;
  }

  public void setTrainingSet(TrainingSetForListModelCustomizationJobsOutput trainingSet) {
    this.trainingSet = trainingSet;
  }

  public DataForListModelCustomizationJobsOutput validationPercentage(Integer validationPercentage) {
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

  public DataForListModelCustomizationJobsOutput validationSet(ValidationSetForListModelCustomizationJobsOutput validationSet) {
    this.validationSet = validationSet;
    return this;
  }

   /**
   * Get validationSet
   * @return validationSet
  **/
  @Valid
  @Schema(description = "")
  public ValidationSetForListModelCustomizationJobsOutput getValidationSet() {
    return validationSet;
  }

  public void setValidationSet(ValidationSetForListModelCustomizationJobsOutput validationSet) {
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
    DataForListModelCustomizationJobsOutput dataForListModelCustomizationJobsOutput = (DataForListModelCustomizationJobsOutput) o;
    return Objects.equals(this.encryptionKeyringType, dataForListModelCustomizationJobsOutput.encryptionKeyringType) &&
        Objects.equals(this.kmSTrn, dataForListModelCustomizationJobsOutput.kmSTrn) &&
        Objects.equals(this.trainingSet, dataForListModelCustomizationJobsOutput.trainingSet) &&
        Objects.equals(this.validationPercentage, dataForListModelCustomizationJobsOutput.validationPercentage) &&
        Objects.equals(this.validationSet, dataForListModelCustomizationJobsOutput.validationSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptionKeyringType, kmSTrn, trainingSet, validationPercentage, validationSet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataForListModelCustomizationJobsOutput {\n");
    
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
