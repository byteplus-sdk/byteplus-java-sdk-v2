/*
 * ecs
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.ecs.model;

import java.util.Objects;
import java.util.Arrays;
import com.byteplus.ecs.model.ParameterDefinitionForDescribeCommandsOutput;
import com.byteplus.ecs.model.TagForDescribeCommandsOutput;
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
 * CommandForDescribeCommandsOutput
 */



public class CommandForDescribeCommandsOutput {
  @SerializedName("CommandContent")
  private String commandContent = null;

  @SerializedName("CommandId")
  private String commandId = null;

  @SerializedName("CreatedAt")
  private String createdAt = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("EnableParameter")
  private Boolean enableParameter = null;

  @SerializedName("InvocationTimes")
  private Integer invocationTimes = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("ParameterDefinitions")
  private List<ParameterDefinitionForDescribeCommandsOutput> parameterDefinitions = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("Provider")
  private String provider = null;

  @SerializedName("Tags")
  private List<TagForDescribeCommandsOutput> tags = null;

  @SerializedName("Timeout")
  private Integer timeout = null;

  @SerializedName("Type")
  private String type = null;

  @SerializedName("UpdatedAt")
  private String updatedAt = null;

  @SerializedName("Username")
  private String username = null;

  @SerializedName("WorkingDir")
  private String workingDir = null;

  public CommandForDescribeCommandsOutput commandContent(String commandContent) {
    this.commandContent = commandContent;
    return this;
  }

   /**
   * Get commandContent
   * @return commandContent
  **/
  @Schema(description = "")
  public String getCommandContent() {
    return commandContent;
  }

  public void setCommandContent(String commandContent) {
    this.commandContent = commandContent;
  }

  public CommandForDescribeCommandsOutput commandId(String commandId) {
    this.commandId = commandId;
    return this;
  }

   /**
   * Get commandId
   * @return commandId
  **/
  @Schema(description = "")
  public String getCommandId() {
    return commandId;
  }

  public void setCommandId(String commandId) {
    this.commandId = commandId;
  }

  public CommandForDescribeCommandsOutput createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @Schema(description = "")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public CommandForDescribeCommandsOutput description(String description) {
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

  public CommandForDescribeCommandsOutput enableParameter(Boolean enableParameter) {
    this.enableParameter = enableParameter;
    return this;
  }

   /**
   * Get enableParameter
   * @return enableParameter
  **/
  @Schema(description = "")
  public Boolean isEnableParameter() {
    return enableParameter;
  }

  public void setEnableParameter(Boolean enableParameter) {
    this.enableParameter = enableParameter;
  }

  public CommandForDescribeCommandsOutput invocationTimes(Integer invocationTimes) {
    this.invocationTimes = invocationTimes;
    return this;
  }

   /**
   * Get invocationTimes
   * @return invocationTimes
  **/
  @Schema(description = "")
  public Integer getInvocationTimes() {
    return invocationTimes;
  }

  public void setInvocationTimes(Integer invocationTimes) {
    this.invocationTimes = invocationTimes;
  }

  public CommandForDescribeCommandsOutput name(String name) {
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

  public CommandForDescribeCommandsOutput parameterDefinitions(List<ParameterDefinitionForDescribeCommandsOutput> parameterDefinitions) {
    this.parameterDefinitions = parameterDefinitions;
    return this;
  }

  public CommandForDescribeCommandsOutput addParameterDefinitionsItem(ParameterDefinitionForDescribeCommandsOutput parameterDefinitionsItem) {
    if (this.parameterDefinitions == null) {
      this.parameterDefinitions = new ArrayList<ParameterDefinitionForDescribeCommandsOutput>();
    }
    this.parameterDefinitions.add(parameterDefinitionsItem);
    return this;
  }

   /**
   * Get parameterDefinitions
   * @return parameterDefinitions
  **/
  @Valid
  @Schema(description = "")
  public List<ParameterDefinitionForDescribeCommandsOutput> getParameterDefinitions() {
    return parameterDefinitions;
  }

  public void setParameterDefinitions(List<ParameterDefinitionForDescribeCommandsOutput> parameterDefinitions) {
    this.parameterDefinitions = parameterDefinitions;
  }

  public CommandForDescribeCommandsOutput projectName(String projectName) {
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

  public CommandForDescribeCommandsOutput provider(String provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @Schema(description = "")
  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public CommandForDescribeCommandsOutput tags(List<TagForDescribeCommandsOutput> tags) {
    this.tags = tags;
    return this;
  }

  public CommandForDescribeCommandsOutput addTagsItem(TagForDescribeCommandsOutput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForDescribeCommandsOutput>();
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
  public List<TagForDescribeCommandsOutput> getTags() {
    return tags;
  }

  public void setTags(List<TagForDescribeCommandsOutput> tags) {
    this.tags = tags;
  }

  public CommandForDescribeCommandsOutput timeout(Integer timeout) {
    this.timeout = timeout;
    return this;
  }

   /**
   * Get timeout
   * @return timeout
  **/
  @Schema(description = "")
  public Integer getTimeout() {
    return timeout;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }

  public CommandForDescribeCommandsOutput type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CommandForDescribeCommandsOutput updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @Schema(description = "")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public CommandForDescribeCommandsOutput username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @Schema(description = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public CommandForDescribeCommandsOutput workingDir(String workingDir) {
    this.workingDir = workingDir;
    return this;
  }

   /**
   * Get workingDir
   * @return workingDir
  **/
  @Schema(description = "")
  public String getWorkingDir() {
    return workingDir;
  }

  public void setWorkingDir(String workingDir) {
    this.workingDir = workingDir;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandForDescribeCommandsOutput commandForDescribeCommandsOutput = (CommandForDescribeCommandsOutput) o;
    return Objects.equals(this.commandContent, commandForDescribeCommandsOutput.commandContent) &&
        Objects.equals(this.commandId, commandForDescribeCommandsOutput.commandId) &&
        Objects.equals(this.createdAt, commandForDescribeCommandsOutput.createdAt) &&
        Objects.equals(this.description, commandForDescribeCommandsOutput.description) &&
        Objects.equals(this.enableParameter, commandForDescribeCommandsOutput.enableParameter) &&
        Objects.equals(this.invocationTimes, commandForDescribeCommandsOutput.invocationTimes) &&
        Objects.equals(this.name, commandForDescribeCommandsOutput.name) &&
        Objects.equals(this.parameterDefinitions, commandForDescribeCommandsOutput.parameterDefinitions) &&
        Objects.equals(this.projectName, commandForDescribeCommandsOutput.projectName) &&
        Objects.equals(this.provider, commandForDescribeCommandsOutput.provider) &&
        Objects.equals(this.tags, commandForDescribeCommandsOutput.tags) &&
        Objects.equals(this.timeout, commandForDescribeCommandsOutput.timeout) &&
        Objects.equals(this.type, commandForDescribeCommandsOutput.type) &&
        Objects.equals(this.updatedAt, commandForDescribeCommandsOutput.updatedAt) &&
        Objects.equals(this.username, commandForDescribeCommandsOutput.username) &&
        Objects.equals(this.workingDir, commandForDescribeCommandsOutput.workingDir);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commandContent, commandId, createdAt, description, enableParameter, invocationTimes, name, parameterDefinitions, projectName, provider, tags, timeout, type, updatedAt, username, workingDir);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommandForDescribeCommandsOutput {\n");
    
    sb.append("    commandContent: ").append(toIndentedString(commandContent)).append("\n");
    sb.append("    commandId: ").append(toIndentedString(commandId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    enableParameter: ").append(toIndentedString(enableParameter)).append("\n");
    sb.append("    invocationTimes: ").append(toIndentedString(invocationTimes)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parameterDefinitions: ").append(toIndentedString(parameterDefinitions)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    workingDir: ").append(toIndentedString(workingDir)).append("\n");
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
