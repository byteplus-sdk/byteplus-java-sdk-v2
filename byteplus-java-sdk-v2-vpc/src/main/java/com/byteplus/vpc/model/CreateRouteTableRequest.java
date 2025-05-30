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
import com.byteplus.vpc.model.TagForCreateRouteTableInput;
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
 * CreateRouteTableRequest
 */



public class CreateRouteTableRequest {
  /**
   * Gets or Sets associateType
   */
  @JsonAdapter(AssociateTypeEnum.Adapter.class)
  public enum AssociateTypeEnum {
    @SerializedName("Subnet")
    SUBNET("Subnet"),
    @SerializedName("Gateway")
    GATEWAY("Gateway");

    private String value;

    AssociateTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static AssociateTypeEnum fromValue(String input) {
      for (AssociateTypeEnum b : AssociateTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<AssociateTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AssociateTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public AssociateTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return AssociateTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("AssociateType")
  private AssociateTypeEnum associateType = null;

  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("RouteTableName")
  private String routeTableName = null;

  @SerializedName("Tags")
  private List<TagForCreateRouteTableInput> tags = null;

  @SerializedName("VpcId")
  private String vpcId = null;

  public CreateRouteTableRequest associateType(AssociateTypeEnum associateType) {
    this.associateType = associateType;
    return this;
  }

   /**
   * Get associateType
   * @return associateType
  **/
  @Schema(description = "")
  public AssociateTypeEnum getAssociateType() {
    return associateType;
  }

  public void setAssociateType(AssociateTypeEnum associateType) {
    this.associateType = associateType;
  }

  public CreateRouteTableRequest clientToken(String clientToken) {
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

  public CreateRouteTableRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
 @Size(min=1,max=255)  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateRouteTableRequest projectName(String projectName) {
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

  public CreateRouteTableRequest routeTableName(String routeTableName) {
    this.routeTableName = routeTableName;
    return this;
  }

   /**
   * Get routeTableName
   * @return routeTableName
  **/
 @Size(min=1,max=128)  @Schema(description = "")
  public String getRouteTableName() {
    return routeTableName;
  }

  public void setRouteTableName(String routeTableName) {
    this.routeTableName = routeTableName;
  }

  public CreateRouteTableRequest tags(List<TagForCreateRouteTableInput> tags) {
    this.tags = tags;
    return this;
  }

  public CreateRouteTableRequest addTagsItem(TagForCreateRouteTableInput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForCreateRouteTableInput>();
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
  public List<TagForCreateRouteTableInput> getTags() {
    return tags;
  }

  public void setTags(List<TagForCreateRouteTableInput> tags) {
    this.tags = tags;
  }

  public CreateRouteTableRequest vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * Get vpcId
   * @return vpcId
  **/
  @NotNull
  @Schema(required = true, description = "")
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateRouteTableRequest createRouteTableRequest = (CreateRouteTableRequest) o;
    return Objects.equals(this.associateType, createRouteTableRequest.associateType) &&
        Objects.equals(this.clientToken, createRouteTableRequest.clientToken) &&
        Objects.equals(this.description, createRouteTableRequest.description) &&
        Objects.equals(this.projectName, createRouteTableRequest.projectName) &&
        Objects.equals(this.routeTableName, createRouteTableRequest.routeTableName) &&
        Objects.equals(this.tags, createRouteTableRequest.tags) &&
        Objects.equals(this.vpcId, createRouteTableRequest.vpcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(associateType, clientToken, description, projectName, routeTableName, tags, vpcId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateRouteTableRequest {\n");
    
    sb.append("    associateType: ").append(toIndentedString(associateType)).append("\n");
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    routeTableName: ").append(toIndentedString(routeTableName)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
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
