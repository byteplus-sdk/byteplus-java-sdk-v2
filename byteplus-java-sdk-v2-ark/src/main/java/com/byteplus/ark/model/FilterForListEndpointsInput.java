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
 * FilterForListEndpointsInput
 */



public class FilterForListEndpointsInput {
  @SerializedName("CustomModelIds")
  private List<String> customModelIds = null;

  /**
   * Gets or Sets endpointModelTypes
   */
  @JsonAdapter(EndpointModelTypesEnum.Adapter.class)
  public enum EndpointModelTypesEnum {
    @SerializedName("FoundationModel")
    FOUNDATIONMODEL("FoundationModel"),
    @SerializedName("CustomModel")
    CUSTOMMODEL("CustomModel");

    private String value;

    EndpointModelTypesEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static EndpointModelTypesEnum fromValue(String input) {
      for (EndpointModelTypesEnum b : EndpointModelTypesEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<EndpointModelTypesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EndpointModelTypesEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public EndpointModelTypesEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return EndpointModelTypesEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("EndpointModelTypes")
  private List<EndpointModelTypesEnum> endpointModelTypes = null;

  @SerializedName("FoundationModelName")
  private String foundationModelName = null;

  @SerializedName("Ids")
  private List<String> ids = null;

  @SerializedName("ModelVersions")
  private List<String> modelVersions = null;

  @SerializedName("Name")
  private String name = null;

  /**
   * Gets or Sets statuses
   */
  @JsonAdapter(StatusesEnum.Adapter.class)
  public enum StatusesEnum {
    @SerializedName("Running")
    RUNNING("Running"),
    @SerializedName("Scheduling")
    SCHEDULING("Scheduling"),
    @SerializedName("Abnormal")
    ABNORMAL("Abnormal"),
    @SerializedName("Stopped")
    STOPPED("Stopped");

    private String value;

    StatusesEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StatusesEnum fromValue(String input) {
      for (StatusesEnum b : StatusesEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusesEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public StatusesEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return StatusesEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("Statuses")
  private List<StatusesEnum> statuses = null;

  public FilterForListEndpointsInput customModelIds(List<String> customModelIds) {
    this.customModelIds = customModelIds;
    return this;
  }

  public FilterForListEndpointsInput addCustomModelIdsItem(String customModelIdsItem) {
    if (this.customModelIds == null) {
      this.customModelIds = new ArrayList<String>();
    }
    this.customModelIds.add(customModelIdsItem);
    return this;
  }

   /**
   * Get customModelIds
   * @return customModelIds
  **/
  @Schema(description = "")
  public List<String> getCustomModelIds() {
    return customModelIds;
  }

  public void setCustomModelIds(List<String> customModelIds) {
    this.customModelIds = customModelIds;
  }

  public FilterForListEndpointsInput endpointModelTypes(List<EndpointModelTypesEnum> endpointModelTypes) {
    this.endpointModelTypes = endpointModelTypes;
    return this;
  }

  public FilterForListEndpointsInput addEndpointModelTypesItem(EndpointModelTypesEnum endpointModelTypesItem) {
    if (this.endpointModelTypes == null) {
      this.endpointModelTypes = new ArrayList<EndpointModelTypesEnum>();
    }
    this.endpointModelTypes.add(endpointModelTypesItem);
    return this;
  }

   /**
   * Get endpointModelTypes
   * @return endpointModelTypes
  **/
  @Schema(description = "")
  public List<EndpointModelTypesEnum> getEndpointModelTypes() {
    return endpointModelTypes;
  }

  public void setEndpointModelTypes(List<EndpointModelTypesEnum> endpointModelTypes) {
    this.endpointModelTypes = endpointModelTypes;
  }

  public FilterForListEndpointsInput foundationModelName(String foundationModelName) {
    this.foundationModelName = foundationModelName;
    return this;
  }

   /**
   * Get foundationModelName
   * @return foundationModelName
  **/
  @Schema(description = "")
  public String getFoundationModelName() {
    return foundationModelName;
  }

  public void setFoundationModelName(String foundationModelName) {
    this.foundationModelName = foundationModelName;
  }

  public FilterForListEndpointsInput ids(List<String> ids) {
    this.ids = ids;
    return this;
  }

  public FilterForListEndpointsInput addIdsItem(String idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<String>();
    }
    this.ids.add(idsItem);
    return this;
  }

   /**
   * Get ids
   * @return ids
  **/
  @Schema(description = "")
  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public FilterForListEndpointsInput modelVersions(List<String> modelVersions) {
    this.modelVersions = modelVersions;
    return this;
  }

  public FilterForListEndpointsInput addModelVersionsItem(String modelVersionsItem) {
    if (this.modelVersions == null) {
      this.modelVersions = new ArrayList<String>();
    }
    this.modelVersions.add(modelVersionsItem);
    return this;
  }

   /**
   * Get modelVersions
   * @return modelVersions
  **/
  @Schema(description = "")
  public List<String> getModelVersions() {
    return modelVersions;
  }

  public void setModelVersions(List<String> modelVersions) {
    this.modelVersions = modelVersions;
  }

  public FilterForListEndpointsInput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FilterForListEndpointsInput statuses(List<StatusesEnum> statuses) {
    this.statuses = statuses;
    return this;
  }

  public FilterForListEndpointsInput addStatusesItem(StatusesEnum statusesItem) {
    if (this.statuses == null) {
      this.statuses = new ArrayList<StatusesEnum>();
    }
    this.statuses.add(statusesItem);
    return this;
  }

   /**
   * Get statuses
   * @return statuses
  **/
  @Schema(description = "")
  public List<StatusesEnum> getStatuses() {
    return statuses;
  }

  public void setStatuses(List<StatusesEnum> statuses) {
    this.statuses = statuses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterForListEndpointsInput filterForListEndpointsInput = (FilterForListEndpointsInput) o;
    return Objects.equals(this.customModelIds, filterForListEndpointsInput.customModelIds) &&
        Objects.equals(this.endpointModelTypes, filterForListEndpointsInput.endpointModelTypes) &&
        Objects.equals(this.foundationModelName, filterForListEndpointsInput.foundationModelName) &&
        Objects.equals(this.ids, filterForListEndpointsInput.ids) &&
        Objects.equals(this.modelVersions, filterForListEndpointsInput.modelVersions) &&
        Objects.equals(this.name, filterForListEndpointsInput.name) &&
        Objects.equals(this.statuses, filterForListEndpointsInput.statuses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customModelIds, endpointModelTypes, foundationModelName, ids, modelVersions, name, statuses);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterForListEndpointsInput {\n");
    
    sb.append("    customModelIds: ").append(toIndentedString(customModelIds)).append("\n");
    sb.append("    endpointModelTypes: ").append(toIndentedString(endpointModelTypes)).append("\n");
    sb.append("    foundationModelName: ").append(toIndentedString(foundationModelName)).append("\n");
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    modelVersions: ").append(toIndentedString(modelVersions)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
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
