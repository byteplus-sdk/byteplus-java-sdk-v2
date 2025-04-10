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
 * SubscriptionForDescribeSubscriptionsOutput
 */



public class SubscriptionForDescribeSubscriptionsOutput {
  @SerializedName("CreatedAt")
  private String createdAt = null;

  @SerializedName("EventTypes")
  private List<String> eventTypes = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("Type")
  private String type = null;

  @SerializedName("UpdatedAt")
  private String updatedAt = null;

  public SubscriptionForDescribeSubscriptionsOutput createdAt(String createdAt) {
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

  public SubscriptionForDescribeSubscriptionsOutput eventTypes(List<String> eventTypes) {
    this.eventTypes = eventTypes;
    return this;
  }

  public SubscriptionForDescribeSubscriptionsOutput addEventTypesItem(String eventTypesItem) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList<String>();
    }
    this.eventTypes.add(eventTypesItem);
    return this;
  }

   /**
   * Get eventTypes
   * @return eventTypes
  **/
  @Schema(description = "")
  public List<String> getEventTypes() {
    return eventTypes;
  }

  public void setEventTypes(List<String> eventTypes) {
    this.eventTypes = eventTypes;
  }

  public SubscriptionForDescribeSubscriptionsOutput id(String id) {
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

  public SubscriptionForDescribeSubscriptionsOutput type(String type) {
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

  public SubscriptionForDescribeSubscriptionsOutput updatedAt(String updatedAt) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionForDescribeSubscriptionsOutput subscriptionForDescribeSubscriptionsOutput = (SubscriptionForDescribeSubscriptionsOutput) o;
    return Objects.equals(this.createdAt, subscriptionForDescribeSubscriptionsOutput.createdAt) &&
        Objects.equals(this.eventTypes, subscriptionForDescribeSubscriptionsOutput.eventTypes) &&
        Objects.equals(this.id, subscriptionForDescribeSubscriptionsOutput.id) &&
        Objects.equals(this.type, subscriptionForDescribeSubscriptionsOutput.type) &&
        Objects.equals(this.updatedAt, subscriptionForDescribeSubscriptionsOutput.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, eventTypes, id, type, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionForDescribeSubscriptionsOutput {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    eventTypes: ").append(toIndentedString(eventTypes)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
