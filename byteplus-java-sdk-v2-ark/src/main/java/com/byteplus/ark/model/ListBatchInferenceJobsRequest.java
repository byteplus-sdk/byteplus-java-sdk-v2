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
import com.byteplus.ark.model.FilterForListBatchInferenceJobsInput;
import com.byteplus.ark.model.TagFilterForListBatchInferenceJobsInput;
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
 * ListBatchInferenceJobsRequest
 */



public class ListBatchInferenceJobsRequest {
  @SerializedName("Filter")
  private FilterForListBatchInferenceJobsInput filter = null;

  @SerializedName("PageNumber")
  private Integer pageNumber = null;

  @SerializedName("PageSize")
  private Integer pageSize = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("SortBy")
  private String sortBy = null;

  @SerializedName("SortOrder")
  private String sortOrder = null;

  @SerializedName("TagFilters")
  private List<TagFilterForListBatchInferenceJobsInput> tagFilters = null;

  public ListBatchInferenceJobsRequest filter(FilterForListBatchInferenceJobsInput filter) {
    this.filter = filter;
    return this;
  }

   /**
   * Get filter
   * @return filter
  **/
  @Valid
  @Schema(description = "")
  public FilterForListBatchInferenceJobsInput getFilter() {
    return filter;
  }

  public void setFilter(FilterForListBatchInferenceJobsInput filter) {
    this.filter = filter;
  }

  public ListBatchInferenceJobsRequest pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

   /**
   * Get pageNumber
   * @return pageNumber
  **/
  @Schema(description = "")
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public ListBatchInferenceJobsRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * Get pageSize
   * @return pageSize
  **/
  @Schema(description = "")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public ListBatchInferenceJobsRequest projectName(String projectName) {
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

  public ListBatchInferenceJobsRequest sortBy(String sortBy) {
    this.sortBy = sortBy;
    return this;
  }

   /**
   * Get sortBy
   * @return sortBy
  **/
  @Schema(description = "")
  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
  }

  public ListBatchInferenceJobsRequest sortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

   /**
   * Get sortOrder
   * @return sortOrder
  **/
  @Schema(description = "")
  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }

  public ListBatchInferenceJobsRequest tagFilters(List<TagFilterForListBatchInferenceJobsInput> tagFilters) {
    this.tagFilters = tagFilters;
    return this;
  }

  public ListBatchInferenceJobsRequest addTagFiltersItem(TagFilterForListBatchInferenceJobsInput tagFiltersItem) {
    if (this.tagFilters == null) {
      this.tagFilters = new ArrayList<TagFilterForListBatchInferenceJobsInput>();
    }
    this.tagFilters.add(tagFiltersItem);
    return this;
  }

   /**
   * Get tagFilters
   * @return tagFilters
  **/
  @Valid
  @Schema(description = "")
  public List<TagFilterForListBatchInferenceJobsInput> getTagFilters() {
    return tagFilters;
  }

  public void setTagFilters(List<TagFilterForListBatchInferenceJobsInput> tagFilters) {
    this.tagFilters = tagFilters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListBatchInferenceJobsRequest listBatchInferenceJobsRequest = (ListBatchInferenceJobsRequest) o;
    return Objects.equals(this.filter, listBatchInferenceJobsRequest.filter) &&
        Objects.equals(this.pageNumber, listBatchInferenceJobsRequest.pageNumber) &&
        Objects.equals(this.pageSize, listBatchInferenceJobsRequest.pageSize) &&
        Objects.equals(this.projectName, listBatchInferenceJobsRequest.projectName) &&
        Objects.equals(this.sortBy, listBatchInferenceJobsRequest.sortBy) &&
        Objects.equals(this.sortOrder, listBatchInferenceJobsRequest.sortOrder) &&
        Objects.equals(this.tagFilters, listBatchInferenceJobsRequest.tagFilters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filter, pageNumber, pageSize, projectName, sortBy, sortOrder, tagFilters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListBatchInferenceJobsRequest {\n");
    
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
    sb.append("    tagFilters: ").append(toIndentedString(tagFilters)).append("\n");
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
