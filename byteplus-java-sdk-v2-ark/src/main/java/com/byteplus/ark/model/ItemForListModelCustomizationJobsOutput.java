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
import com.byteplus.ark.model.DataForListModelCustomizationJobsOutput;
import com.byteplus.ark.model.HyperparameterForListModelCustomizationJobsOutput;
import com.byteplus.ark.model.ModelReferenceForListModelCustomizationJobsOutput;
import com.byteplus.ark.model.OutputForListModelCustomizationJobsOutput;
import com.byteplus.ark.model.StatusForListModelCustomizationJobsOutput;
import com.byteplus.ark.model.TagForListModelCustomizationJobsOutput;
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
 * ItemForListModelCustomizationJobsOutput
 */



public class ItemForListModelCustomizationJobsOutput {
  @SerializedName("CreateTime")
  private String createTime = null;

  /**
   * Gets or Sets customizationType
   */
  @JsonAdapter(CustomizationTypeEnum.Adapter.class)
  public enum CustomizationTypeEnum {
    @SerializedName("FinetuneSft")
    FINETUNESFT("FinetuneSft"),
    @SerializedName("FinetuneLoRA")
    FINETUNELORA("FinetuneLoRA"),
    @SerializedName("Pretrain")
    PRETRAIN("Pretrain"),
    @SerializedName("DPOLoRA")
    DPOLORA("DPOLoRA"),
    @SerializedName("DPO")
    DPO("DPO");

    private String value;

    CustomizationTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static CustomizationTypeEnum fromValue(String input) {
      for (CustomizationTypeEnum b : CustomizationTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<CustomizationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CustomizationTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public CustomizationTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return CustomizationTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("CustomizationType")
  private CustomizationTypeEnum customizationType = null;

  @SerializedName("Data")
  private DataForListModelCustomizationJobsOutput data = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("Hyperparameters")
  private List<HyperparameterForListModelCustomizationJobsOutput> hyperparameters = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("ModelReference")
  private ModelReferenceForListModelCustomizationJobsOutput modelReference = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Outputs")
  private List<OutputForListModelCustomizationJobsOutput> outputs = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("PublishedOutputCount")
  private Integer publishedOutputCount = null;

  @SerializedName("Reason")
  private String reason = null;

  @SerializedName("SaveModelLimit")
  private Integer saveModelLimit = null;

  @SerializedName("Status")
  private StatusForListModelCustomizationJobsOutput status = null;

  @SerializedName("Tags")
  private List<TagForListModelCustomizationJobsOutput> tags = null;

  @SerializedName("TotalOutputCount")
  private Integer totalOutputCount = null;

  @SerializedName("UpdateTime")
  private String updateTime = null;

  public ItemForListModelCustomizationJobsOutput createTime(String createTime) {
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

  public ItemForListModelCustomizationJobsOutput customizationType(CustomizationTypeEnum customizationType) {
    this.customizationType = customizationType;
    return this;
  }

   /**
   * Get customizationType
   * @return customizationType
  **/
  @Schema(description = "")
  public CustomizationTypeEnum getCustomizationType() {
    return customizationType;
  }

  public void setCustomizationType(CustomizationTypeEnum customizationType) {
    this.customizationType = customizationType;
  }

  public ItemForListModelCustomizationJobsOutput data(DataForListModelCustomizationJobsOutput data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Valid
  @Schema(description = "")
  public DataForListModelCustomizationJobsOutput getData() {
    return data;
  }

  public void setData(DataForListModelCustomizationJobsOutput data) {
    this.data = data;
  }

  public ItemForListModelCustomizationJobsOutput description(String description) {
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

  public ItemForListModelCustomizationJobsOutput hyperparameters(List<HyperparameterForListModelCustomizationJobsOutput> hyperparameters) {
    this.hyperparameters = hyperparameters;
    return this;
  }

  public ItemForListModelCustomizationJobsOutput addHyperparametersItem(HyperparameterForListModelCustomizationJobsOutput hyperparametersItem) {
    if (this.hyperparameters == null) {
      this.hyperparameters = new ArrayList<HyperparameterForListModelCustomizationJobsOutput>();
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
  public List<HyperparameterForListModelCustomizationJobsOutput> getHyperparameters() {
    return hyperparameters;
  }

  public void setHyperparameters(List<HyperparameterForListModelCustomizationJobsOutput> hyperparameters) {
    this.hyperparameters = hyperparameters;
  }

  public ItemForListModelCustomizationJobsOutput id(String id) {
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

  public ItemForListModelCustomizationJobsOutput modelReference(ModelReferenceForListModelCustomizationJobsOutput modelReference) {
    this.modelReference = modelReference;
    return this;
  }

   /**
   * Get modelReference
   * @return modelReference
  **/
  @Valid
  @Schema(description = "")
  public ModelReferenceForListModelCustomizationJobsOutput getModelReference() {
    return modelReference;
  }

  public void setModelReference(ModelReferenceForListModelCustomizationJobsOutput modelReference) {
    this.modelReference = modelReference;
  }

  public ItemForListModelCustomizationJobsOutput name(String name) {
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

  public ItemForListModelCustomizationJobsOutput outputs(List<OutputForListModelCustomizationJobsOutput> outputs) {
    this.outputs = outputs;
    return this;
  }

  public ItemForListModelCustomizationJobsOutput addOutputsItem(OutputForListModelCustomizationJobsOutput outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<OutputForListModelCustomizationJobsOutput>();
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
  public List<OutputForListModelCustomizationJobsOutput> getOutputs() {
    return outputs;
  }

  public void setOutputs(List<OutputForListModelCustomizationJobsOutput> outputs) {
    this.outputs = outputs;
  }

  public ItemForListModelCustomizationJobsOutput projectName(String projectName) {
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

  public ItemForListModelCustomizationJobsOutput publishedOutputCount(Integer publishedOutputCount) {
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

  public ItemForListModelCustomizationJobsOutput reason(String reason) {
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

  public ItemForListModelCustomizationJobsOutput saveModelLimit(Integer saveModelLimit) {
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

  public ItemForListModelCustomizationJobsOutput status(StatusForListModelCustomizationJobsOutput status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Valid
  @Schema(description = "")
  public StatusForListModelCustomizationJobsOutput getStatus() {
    return status;
  }

  public void setStatus(StatusForListModelCustomizationJobsOutput status) {
    this.status = status;
  }

  public ItemForListModelCustomizationJobsOutput tags(List<TagForListModelCustomizationJobsOutput> tags) {
    this.tags = tags;
    return this;
  }

  public ItemForListModelCustomizationJobsOutput addTagsItem(TagForListModelCustomizationJobsOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForListModelCustomizationJobsOutput>();
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
  public List<TagForListModelCustomizationJobsOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForListModelCustomizationJobsOutput> tags) {
    this.tags = tags;
  }

  public ItemForListModelCustomizationJobsOutput totalOutputCount(Integer totalOutputCount) {
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

  public ItemForListModelCustomizationJobsOutput updateTime(String updateTime) {
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
    ItemForListModelCustomizationJobsOutput itemForListModelCustomizationJobsOutput = (ItemForListModelCustomizationJobsOutput) o;
    return Objects.equals(this.createTime, itemForListModelCustomizationJobsOutput.createTime) &&
        Objects.equals(this.customizationType, itemForListModelCustomizationJobsOutput.customizationType) &&
        Objects.equals(this.data, itemForListModelCustomizationJobsOutput.data) &&
        Objects.equals(this.description, itemForListModelCustomizationJobsOutput.description) &&
        Objects.equals(this.hyperparameters, itemForListModelCustomizationJobsOutput.hyperparameters) &&
        Objects.equals(this.id, itemForListModelCustomizationJobsOutput.id) &&
        Objects.equals(this.modelReference, itemForListModelCustomizationJobsOutput.modelReference) &&
        Objects.equals(this.name, itemForListModelCustomizationJobsOutput.name) &&
        Objects.equals(this.outputs, itemForListModelCustomizationJobsOutput.outputs) &&
        Objects.equals(this.projectName, itemForListModelCustomizationJobsOutput.projectName) &&
        Objects.equals(this.publishedOutputCount, itemForListModelCustomizationJobsOutput.publishedOutputCount) &&
        Objects.equals(this.reason, itemForListModelCustomizationJobsOutput.reason) &&
        Objects.equals(this.saveModelLimit, itemForListModelCustomizationJobsOutput.saveModelLimit) &&
        Objects.equals(this.status, itemForListModelCustomizationJobsOutput.status) &&
        Objects.equals(this.tags, itemForListModelCustomizationJobsOutput.tags) &&
        Objects.equals(this.totalOutputCount, itemForListModelCustomizationJobsOutput.totalOutputCount) &&
        Objects.equals(this.updateTime, itemForListModelCustomizationJobsOutput.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createTime, customizationType, data, description, hyperparameters, id, modelReference, name, outputs, projectName, publishedOutputCount, reason, saveModelLimit, status, tags, totalOutputCount, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemForListModelCustomizationJobsOutput {\n");
    
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
