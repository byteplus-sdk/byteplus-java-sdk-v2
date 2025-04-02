/*
 * vpc
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.vpc.model;

import java.util.Objects;
import java.util.Arrays;
import com.byteplus.vpc.model.TagForCreateTrafficMirrorTargetInput;
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
 * CreateTrafficMirrorTargetRequest
 */



public class CreateTrafficMirrorTargetRequest {
  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("InstanceId")
  private String instanceId = null;

  /**
   * Gets or Sets instanceType
   */
  @JsonAdapter(InstanceTypeEnum.Adapter.class)
  public enum InstanceTypeEnum {
    @SerializedName("NetworkInterface")
    NETWORKINTERFACE("NetworkInterface"),
    @SerializedName("ClbInstance")
    CLBINSTANCE("ClbInstance");

    private String value;

    InstanceTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static InstanceTypeEnum fromValue(String input) {
      for (InstanceTypeEnum b : InstanceTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<InstanceTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final InstanceTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public InstanceTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return InstanceTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("InstanceType")
  private InstanceTypeEnum instanceType = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("Tags")
  private List<TagForCreateTrafficMirrorTargetInput> tags = null;

  @SerializedName("TrafficMirrorTargetName")
  private String trafficMirrorTargetName = null;

  public CreateTrafficMirrorTargetRequest clientToken(String clientToken) {
    this.clientToken = clientToken;
    return this;
  }

   /**
   * Get clientToken
   * @return clientToken
  **/
  @Schema(description = "")
  public String getClientToken() {
    return clientToken;
  }

  public void setClientToken(String clientToken) {
    this.clientToken = clientToken;
  }

  public CreateTrafficMirrorTargetRequest description(String description) {
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

  public CreateTrafficMirrorTargetRequest instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * Get instanceId
   * @return instanceId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public CreateTrafficMirrorTargetRequest instanceType(InstanceTypeEnum instanceType) {
    this.instanceType = instanceType;
    return this;
  }

   /**
   * Get instanceType
   * @return instanceType
  **/
  @NotNull
  @Schema(required = true, description = "")
  public InstanceTypeEnum getInstanceType() {
    return instanceType;
  }

  public void setInstanceType(InstanceTypeEnum instanceType) {
    this.instanceType = instanceType;
  }

  public CreateTrafficMirrorTargetRequest projectName(String projectName) {
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

  public CreateTrafficMirrorTargetRequest tags(List<TagForCreateTrafficMirrorTargetInput> tags) {
    this.tags = tags;
    return this;
  }

  public CreateTrafficMirrorTargetRequest addTagsItem(TagForCreateTrafficMirrorTargetInput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForCreateTrafficMirrorTargetInput>();
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
  public List<TagForCreateTrafficMirrorTargetInput> getTags() {
    return tags;
  }

  public void setTags(List<TagForCreateTrafficMirrorTargetInput> tags) {
    this.tags = tags;
  }

  public CreateTrafficMirrorTargetRequest trafficMirrorTargetName(String trafficMirrorTargetName) {
    this.trafficMirrorTargetName = trafficMirrorTargetName;
    return this;
  }

   /**
   * Get trafficMirrorTargetName
   * @return trafficMirrorTargetName
  **/
  @Schema(description = "")
  public String getTrafficMirrorTargetName() {
    return trafficMirrorTargetName;
  }

  public void setTrafficMirrorTargetName(String trafficMirrorTargetName) {
    this.trafficMirrorTargetName = trafficMirrorTargetName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTrafficMirrorTargetRequest createTrafficMirrorTargetRequest = (CreateTrafficMirrorTargetRequest) o;
    return Objects.equals(this.clientToken, createTrafficMirrorTargetRequest.clientToken) &&
        Objects.equals(this.description, createTrafficMirrorTargetRequest.description) &&
        Objects.equals(this.instanceId, createTrafficMirrorTargetRequest.instanceId) &&
        Objects.equals(this.instanceType, createTrafficMirrorTargetRequest.instanceType) &&
        Objects.equals(this.projectName, createTrafficMirrorTargetRequest.projectName) &&
        Objects.equals(this.tags, createTrafficMirrorTargetRequest.tags) &&
        Objects.equals(this.trafficMirrorTargetName, createTrafficMirrorTargetRequest.trafficMirrorTargetName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientToken, description, instanceId, instanceType, projectName, tags, trafficMirrorTargetName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTrafficMirrorTargetRequest {\n");
    
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
    sb.append("    instanceType: ").append(toIndentedString(instanceType)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    trafficMirrorTargetName: ").append(toIndentedString(trafficMirrorTargetName)).append("\n");
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
