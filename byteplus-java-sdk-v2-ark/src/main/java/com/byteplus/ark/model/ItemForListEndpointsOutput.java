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
import com.byteplus.ark.model.ModelReferenceForListEndpointsOutput;
import com.byteplus.ark.model.RateLimitForListEndpointsOutput;
import com.byteplus.ark.model.TagForListEndpointsOutput;
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
 * ItemForListEndpointsOutput
 */



public class ItemForListEndpointsOutput {
  @SerializedName("CreateTime")
  private String createTime = null;

  @SerializedName("Description")
  private String description = null;

  /**
   * Gets or Sets endpointModelType
   */
  @JsonAdapter(EndpointModelTypeEnum.Adapter.class)
  public enum EndpointModelTypeEnum {
    @SerializedName("FoundationModel")
    FOUNDATIONMODEL("FoundationModel"),
    @SerializedName("CustomModel")
    CUSTOMMODEL("CustomModel");

    private String value;

    EndpointModelTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static EndpointModelTypeEnum fromValue(String input) {
      for (EndpointModelTypeEnum b : EndpointModelTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<EndpointModelTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EndpointModelTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public EndpointModelTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return EndpointModelTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("EndpointModelType")
  private EndpointModelTypeEnum endpointModelType = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("ModelReference")
  private ModelReferenceForListEndpointsOutput modelReference = null;

  @SerializedName("ModelUnitId")
  private String modelUnitId = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("RateLimit")
  private RateLimitForListEndpointsOutput rateLimit = null;

  @SerializedName("RollingId")
  private String rollingId = null;

  @SerializedName("ScaleTierId")
  private String scaleTierId = null;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    @SerializedName("Running")
    RUNNING("Running"),
    @SerializedName("Scheduling")
    SCHEDULING("Scheduling"),
    @SerializedName("Abnormal")
    ABNORMAL("Abnormal"),
    @SerializedName("Stopped")
    STOPPED("Stopped");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StatusEnum fromValue(String input) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return StatusEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("Status")
  private StatusEnum status = null;

  @SerializedName("StatusReason")
  private String statusReason = null;

  @SerializedName("SupportRolling")
  private Boolean supportRolling = null;

  @SerializedName("SupportScaleTier")
  private Boolean supportScaleTier = null;

  @SerializedName("Tags")
  private List<TagForListEndpointsOutput> tags = null;

  @SerializedName("UpdateTime")
  private String updateTime = null;

  public ItemForListEndpointsOutput createTime(String createTime) {
    this.createTime = createTime;
    return this;
  }

   /**
   * Get createTime
   * @return createTime
  **/
  @Schema(description = "")
  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public ItemForListEndpointsOutput description(String description) {
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

  public ItemForListEndpointsOutput endpointModelType(EndpointModelTypeEnum endpointModelType) {
    this.endpointModelType = endpointModelType;
    return this;
  }

   /**
   * Get endpointModelType
   * @return endpointModelType
  **/
  @Schema(description = "")
  public EndpointModelTypeEnum getEndpointModelType() {
    return endpointModelType;
  }

  public void setEndpointModelType(EndpointModelTypeEnum endpointModelType) {
    this.endpointModelType = endpointModelType;
  }

  public ItemForListEndpointsOutput id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ItemForListEndpointsOutput modelReference(ModelReferenceForListEndpointsOutput modelReference) {
    this.modelReference = modelReference;
    return this;
  }

   /**
   * Get modelReference
   * @return modelReference
  **/
  @Valid
  @Schema(description = "")
  public ModelReferenceForListEndpointsOutput getModelReference() {
    return modelReference;
  }

  public void setModelReference(ModelReferenceForListEndpointsOutput modelReference) {
    this.modelReference = modelReference;
  }

  public ItemForListEndpointsOutput modelUnitId(String modelUnitId) {
    this.modelUnitId = modelUnitId;
    return this;
  }

   /**
   * Get modelUnitId
   * @return modelUnitId
  **/
  @Schema(description = "")
  public String getModelUnitId() {
    return modelUnitId;
  }

  public void setModelUnitId(String modelUnitId) {
    this.modelUnitId = modelUnitId;
  }

  public ItemForListEndpointsOutput name(String name) {
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

  public ItemForListEndpointsOutput projectName(String projectName) {
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

  public ItemForListEndpointsOutput rateLimit(RateLimitForListEndpointsOutput rateLimit) {
    this.rateLimit = rateLimit;
    return this;
  }

   /**
   * Get rateLimit
   * @return rateLimit
  **/
  @Valid
  @Schema(description = "")
  public RateLimitForListEndpointsOutput getRateLimit() {
    return rateLimit;
  }

  public void setRateLimit(RateLimitForListEndpointsOutput rateLimit) {
    this.rateLimit = rateLimit;
  }

  public ItemForListEndpointsOutput rollingId(String rollingId) {
    this.rollingId = rollingId;
    return this;
  }

   /**
   * Get rollingId
   * @return rollingId
  **/
  @Schema(description = "")
  public String getRollingId() {
    return rollingId;
  }

  public void setRollingId(String rollingId) {
    this.rollingId = rollingId;
  }

  public ItemForListEndpointsOutput scaleTierId(String scaleTierId) {
    this.scaleTierId = scaleTierId;
    return this;
  }

   /**
   * Get scaleTierId
   * @return scaleTierId
  **/
  @Schema(description = "")
  public String getScaleTierId() {
    return scaleTierId;
  }

  public void setScaleTierId(String scaleTierId) {
    this.scaleTierId = scaleTierId;
  }

  public ItemForListEndpointsOutput status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(description = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ItemForListEndpointsOutput statusReason(String statusReason) {
    this.statusReason = statusReason;
    return this;
  }

   /**
   * Get statusReason
   * @return statusReason
  **/
  @Schema(description = "")
  public String getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(String statusReason) {
    this.statusReason = statusReason;
  }

  public ItemForListEndpointsOutput supportRolling(Boolean supportRolling) {
    this.supportRolling = supportRolling;
    return this;
  }

   /**
   * Get supportRolling
   * @return supportRolling
  **/
  @Schema(description = "")
  public Boolean isSupportRolling() {
    return supportRolling;
  }

  public void setSupportRolling(Boolean supportRolling) {
    this.supportRolling = supportRolling;
  }

  public ItemForListEndpointsOutput supportScaleTier(Boolean supportScaleTier) {
    this.supportScaleTier = supportScaleTier;
    return this;
  }

   /**
   * Get supportScaleTier
   * @return supportScaleTier
  **/
  @Schema(description = "")
  public Boolean isSupportScaleTier() {
    return supportScaleTier;
  }

  public void setSupportScaleTier(Boolean supportScaleTier) {
    this.supportScaleTier = supportScaleTier;
  }

  public ItemForListEndpointsOutput tags(List<TagForListEndpointsOutput> tags) {
    this.tags = tags;
    return this;
  }

  public ItemForListEndpointsOutput addTagsItem(TagForListEndpointsOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForListEndpointsOutput>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @Valid
  @Schema(description = "")
  public List<TagForListEndpointsOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForListEndpointsOutput> tags) {
    this.tags = tags;
  }

  public ItemForListEndpointsOutput updateTime(String updateTime) {
    this.updateTime = updateTime;
    return this;
  }

   /**
   * Get updateTime
   * @return updateTime
  **/
  @Schema(description = "")
  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemForListEndpointsOutput itemForListEndpointsOutput = (ItemForListEndpointsOutput) o;
    return Objects.equals(this.createTime, itemForListEndpointsOutput.createTime) &&
        Objects.equals(this.description, itemForListEndpointsOutput.description) &&
        Objects.equals(this.endpointModelType, itemForListEndpointsOutput.endpointModelType) &&
        Objects.equals(this.id, itemForListEndpointsOutput.id) &&
        Objects.equals(this.modelReference, itemForListEndpointsOutput.modelReference) &&
        Objects.equals(this.modelUnitId, itemForListEndpointsOutput.modelUnitId) &&
        Objects.equals(this.name, itemForListEndpointsOutput.name) &&
        Objects.equals(this.projectName, itemForListEndpointsOutput.projectName) &&
        Objects.equals(this.rateLimit, itemForListEndpointsOutput.rateLimit) &&
        Objects.equals(this.rollingId, itemForListEndpointsOutput.rollingId) &&
        Objects.equals(this.scaleTierId, itemForListEndpointsOutput.scaleTierId) &&
        Objects.equals(this.status, itemForListEndpointsOutput.status) &&
        Objects.equals(this.statusReason, itemForListEndpointsOutput.statusReason) &&
        Objects.equals(this.supportRolling, itemForListEndpointsOutput.supportRolling) &&
        Objects.equals(this.supportScaleTier, itemForListEndpointsOutput.supportScaleTier) &&
        Objects.equals(this.tags, itemForListEndpointsOutput.tags) &&
        Objects.equals(this.updateTime, itemForListEndpointsOutput.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createTime, description, endpointModelType, id, modelReference, modelUnitId, name, projectName, rateLimit, rollingId, scaleTierId, status, statusReason, supportRolling, supportScaleTier, tags, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemForListEndpointsOutput {\n");
    
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endpointModelType: ").append(toIndentedString(endpointModelType)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    modelReference: ").append(toIndentedString(modelReference)).append("\n");
    sb.append("    modelUnitId: ").append(toIndentedString(modelUnitId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    rateLimit: ").append(toIndentedString(rateLimit)).append("\n");
    sb.append("    rollingId: ").append(toIndentedString(rollingId)).append("\n");
    sb.append("    scaleTierId: ").append(toIndentedString(scaleTierId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
    sb.append("    supportRolling: ").append(toIndentedString(supportRolling)).append("\n");
    sb.append("    supportScaleTier: ").append(toIndentedString(supportScaleTier)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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
