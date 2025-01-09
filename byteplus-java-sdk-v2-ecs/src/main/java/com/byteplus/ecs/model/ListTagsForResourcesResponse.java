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
import com.byteplus.ecs.model.TagResourceForListTagsForResourcesOutput;
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
 * ListTagsForResourcesResponse
 */



public class ListTagsForResourcesResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("NextToken")
  private String nextToken = null;

  @SerializedName("TagResources")
  private List<TagResourceForListTagsForResourcesOutput> tagResources = null;

  public ListTagsForResourcesResponse nextToken(String nextToken) {
    this.nextToken = nextToken;
    return this;
  }

   /**
   * Get nextToken
   * @return nextToken
  **/
  @Schema(description = "")
  public String getNextToken() {
    return nextToken;
  }

  public void setNextToken(String nextToken) {
    this.nextToken = nextToken;
  }

  public ListTagsForResourcesResponse tagResources(List<TagResourceForListTagsForResourcesOutput> tagResources) {
    this.tagResources = tagResources;
    return this;
  }

  public ListTagsForResourcesResponse addTagResourcesItem(TagResourceForListTagsForResourcesOutput tagResourcesItem) {
    if (this.tagResources == null) {
      this.tagResources = new ArrayList<TagResourceForListTagsForResourcesOutput>();
    }
    this.tagResources.add(tagResourcesItem);
    return this;
  }

   /**
   * Get tagResources
   * @return tagResources
  **/
  @Valid
  @Schema(description = "")
  public List<TagResourceForListTagsForResourcesOutput> getTagResources() {
    return tagResources;
  }

  public void setTagResources(List<TagResourceForListTagsForResourcesOutput> tagResources) {
    this.tagResources = tagResources;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTagsForResourcesResponse listTagsForResourcesResponse = (ListTagsForResourcesResponse) o;
    return Objects.equals(this.nextToken, listTagsForResourcesResponse.nextToken) &&
        Objects.equals(this.tagResources, listTagsForResourcesResponse.tagResources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextToken, tagResources);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTagsForResourcesResponse {\n");
    
    sb.append("    nextToken: ").append(toIndentedString(nextToken)).append("\n");
    sb.append("    tagResources: ").append(toIndentedString(tagResources)).append("\n");
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
