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
import com.byteplus.ark.model.DataForGetModelCustomizationJobOutput;
import com.byteplus.ark.model.HyperparameterForGetModelCustomizationJobOutput;
import com.byteplus.ark.model.ModelReferenceForGetModelCustomizationJobOutput;
import com.byteplus.ark.model.OutputForGetModelCustomizationJobOutput;
import com.byteplus.ark.model.StatusForGetModelCustomizationJobOutput;
import com.byteplus.ark.model.TagForGetModelCustomizationJobOutput;
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
 * GetModelCustomizationJobResponse
 */



public class GetModelCustomizationJobResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("CreateTime")
  private String createTime = null;

  @SerializedName("CustomizationType")
  private String customizationType = null;

  @SerializedName("Data")
  private DataForGetModelCustomizationJobOutput data = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("Hyperparameters")
  private List<HyperparameterForGetModelCustomizationJobOutput> hyperparameters = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("ModelReference")
  private ModelReferenceForGetModelCustomizationJobOutput modelReference = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Outputs")
  private List<OutputForGetModelCustomizationJobOutput> outputs = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("PublishedOutputCount")
  private Integer publishedOutputCount = null;

  @SerializedName("Reason")
  private String reason = null;

  @SerializedName("SaveModelLimit")
  private Integer saveModelLimit = null;

  @SerializedName("Status")
  private StatusForGetModelCustomizationJobOutput status = null;

  @SerializedName("Tags")
  private List<TagForGetModelCustomizationJobOutput> tags = null;

  @SerializedName("TotalOutputCount")
  private Integer totalOutputCount = null;

  @SerializedName("UpdateTime")
  private String updateTime = null;

  public GetModelCustomizationJobResponse createTime(String createTime) {
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

  public GetModelCustomizationJobResponse customizationType(String customizationType) {
    this.customizationType = customizationType;
    return this;
  }

   /**
   * Get customizationType
   * @return customizationType
  **/
  @Schema(description = "")
  public String getCustomizationType() {
    return customizationType;
  }

  public void setCustomizationType(String customizationType) {
    this.customizationType = customizationType;
  }

  public GetModelCustomizationJobResponse data(DataForGetModelCustomizationJobOutput data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Valid
  @Schema(description = "")
  public DataForGetModelCustomizationJobOutput getData() {
    return data;
  }

  public void setData(DataForGetModelCustomizationJobOutput data) {
    this.data = data;
  }

  public GetModelCustomizationJobResponse description(String description) {
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

  public GetModelCustomizationJobResponse hyperparameters(List<HyperparameterForGetModelCustomizationJobOutput> hyperparameters) {
    this.hyperparameters = hyperparameters;
    return this;
  }

  public GetModelCustomizationJobResponse addHyperparametersItem(HyperparameterForGetModelCustomizationJobOutput hyperparametersItem) {
    if (this.hyperparameters == null) {
      this.hyperparameters = new ArrayList<HyperparameterForGetModelCustomizationJobOutput>();
    }
    this.hyperparameters.add(hyperparametersItem);
    return this;
  }

   /**
   * Get hyperparameters
   * @return hyperparameters
  **/
  @Valid
  @Schema(description = "")
  public List<HyperparameterForGetModelCustomizationJobOutput> getHyperparameters() {
    return hyperparameters;
  }

  public void setHyperparameters(List<HyperparameterForGetModelCustomizationJobOutput> hyperparameters) {
    this.hyperparameters = hyperparameters;
  }

  public GetModelCustomizationJobResponse id(String id) {
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

  public GetModelCustomizationJobResponse modelReference(ModelReferenceForGetModelCustomizationJobOutput modelReference) {
    this.modelReference = modelReference;
    return this;
  }

   /**
   * Get modelReference
   * @return modelReference
  **/
  @Valid
  @Schema(description = "")
  public ModelReferenceForGetModelCustomizationJobOutput getModelReference() {
    return modelReference;
  }

  public void setModelReference(ModelReferenceForGetModelCustomizationJobOutput modelReference) {
    this.modelReference = modelReference;
  }

  public GetModelCustomizationJobResponse name(String name) {
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

  public GetModelCustomizationJobResponse outputs(List<OutputForGetModelCustomizationJobOutput> outputs) {
    this.outputs = outputs;
    return this;
  }

  public GetModelCustomizationJobResponse addOutputsItem(OutputForGetModelCustomizationJobOutput outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<OutputForGetModelCustomizationJobOutput>();
    }
    this.outputs.add(outputsItem);
    return this;
  }

   /**
   * Get outputs
   * @return outputs
  **/
  @Valid
  @Schema(description = "")
  public List<OutputForGetModelCustomizationJobOutput> getOutputs() {
    return outputs;
  }

  public void setOutputs(List<OutputForGetModelCustomizationJobOutput> outputs) {
    this.outputs = outputs;
  }

  public GetModelCustomizationJobResponse projectName(String projectName) {
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

  public GetModelCustomizationJobResponse publishedOutputCount(Integer publishedOutputCount) {
    this.publishedOutputCount = publishedOutputCount;
    return this;
  }

   /**
   * Get publishedOutputCount
   * @return publishedOutputCount
  **/
  @Schema(description = "")
  public Integer getPublishedOutputCount() {
    return publishedOutputCount;
  }

  public void setPublishedOutputCount(Integer publishedOutputCount) {
    this.publishedOutputCount = publishedOutputCount;
  }

  public GetModelCustomizationJobResponse reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Get reason
   * @return reason
  **/
  @Schema(description = "")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public GetModelCustomizationJobResponse saveModelLimit(Integer saveModelLimit) {
    this.saveModelLimit = saveModelLimit;
    return this;
  }

   /**
   * Get saveModelLimit
   * @return saveModelLimit
  **/
  @Schema(description = "")
  public Integer getSaveModelLimit() {
    return saveModelLimit;
  }

  public void setSaveModelLimit(Integer saveModelLimit) {
    this.saveModelLimit = saveModelLimit;
  }

  public GetModelCustomizationJobResponse status(StatusForGetModelCustomizationJobOutput status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Valid
  @Schema(description = "")
  public StatusForGetModelCustomizationJobOutput getStatus() {
    return status;
  }

  public void setStatus(StatusForGetModelCustomizationJobOutput status) {
    this.status = status;
  }

  public GetModelCustomizationJobResponse tags(List<TagForGetModelCustomizationJobOutput> tags) {
    this.tags = tags;
    return this;
  }

  public GetModelCustomizationJobResponse addTagsItem(TagForGetModelCustomizationJobOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForGetModelCustomizationJobOutput>();
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
  public List<TagForGetModelCustomizationJobOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForGetModelCustomizationJobOutput> tags) {
    this.tags = tags;
  }

  public GetModelCustomizationJobResponse totalOutputCount(Integer totalOutputCount) {
    this.totalOutputCount = totalOutputCount;
    return this;
  }

   /**
   * Get totalOutputCount
   * @return totalOutputCount
  **/
  @Schema(description = "")
  public Integer getTotalOutputCount() {
    return totalOutputCount;
  }

  public void setTotalOutputCount(Integer totalOutputCount) {
    this.totalOutputCount = totalOutputCount;
  }

  public GetModelCustomizationJobResponse updateTime(String updateTime) {
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
    GetModelCustomizationJobResponse getModelCustomizationJobResponse = (GetModelCustomizationJobResponse) o;
    return Objects.equals(this.createTime, getModelCustomizationJobResponse.createTime) &&
        Objects.equals(this.customizationType, getModelCustomizationJobResponse.customizationType) &&
        Objects.equals(this.data, getModelCustomizationJobResponse.data) &&
        Objects.equals(this.description, getModelCustomizationJobResponse.description) &&
        Objects.equals(this.hyperparameters, getModelCustomizationJobResponse.hyperparameters) &&
        Objects.equals(this.id, getModelCustomizationJobResponse.id) &&
        Objects.equals(this.modelReference, getModelCustomizationJobResponse.modelReference) &&
        Objects.equals(this.name, getModelCustomizationJobResponse.name) &&
        Objects.equals(this.outputs, getModelCustomizationJobResponse.outputs) &&
        Objects.equals(this.projectName, getModelCustomizationJobResponse.projectName) &&
        Objects.equals(this.publishedOutputCount, getModelCustomizationJobResponse.publishedOutputCount) &&
        Objects.equals(this.reason, getModelCustomizationJobResponse.reason) &&
        Objects.equals(this.saveModelLimit, getModelCustomizationJobResponse.saveModelLimit) &&
        Objects.equals(this.status, getModelCustomizationJobResponse.status) &&
        Objects.equals(this.tags, getModelCustomizationJobResponse.tags) &&
        Objects.equals(this.totalOutputCount, getModelCustomizationJobResponse.totalOutputCount) &&
        Objects.equals(this.updateTime, getModelCustomizationJobResponse.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createTime, customizationType, data, description, hyperparameters, id, modelReference, name, outputs, projectName, publishedOutputCount, reason, saveModelLimit, status, tags, totalOutputCount, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetModelCustomizationJobResponse {\n");
    
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    customizationType: ").append(toIndentedString(customizationType)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    hyperparameters: ").append(toIndentedString(hyperparameters)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    modelReference: ").append(toIndentedString(modelReference)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    publishedOutputCount: ").append(toIndentedString(publishedOutputCount)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    saveModelLimit: ").append(toIndentedString(saveModelLimit)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    totalOutputCount: ").append(toIndentedString(totalOutputCount)).append("\n");
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
