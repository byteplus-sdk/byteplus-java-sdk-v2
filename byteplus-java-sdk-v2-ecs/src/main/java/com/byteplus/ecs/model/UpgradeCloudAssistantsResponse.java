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
import com.byteplus.ecs.model.FailedInstanceForUpgradeCloudAssistantsOutput;
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
 * UpgradeCloudAssistantsResponse
 */



public class UpgradeCloudAssistantsResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("FailedInstances")
  private List<FailedInstanceForUpgradeCloudAssistantsOutput> failedInstances = null;

  @SerializedName("UpgradingInstanceIds")
  private List<String> upgradingInstanceIds = null;

  public UpgradeCloudAssistantsResponse failedInstances(List<FailedInstanceForUpgradeCloudAssistantsOutput> failedInstances) {
    this.failedInstances = failedInstances;
    return this;
  }

  public UpgradeCloudAssistantsResponse addFailedInstancesItem(FailedInstanceForUpgradeCloudAssistantsOutput failedInstancesItem) {
    if (this.failedInstances == null) {
      this.failedInstances = new ArrayList<FailedInstanceForUpgradeCloudAssistantsOutput>();
    }
    this.failedInstances.add(failedInstancesItem);
    return this;
  }

   /**
   * Get failedInstances
   * @return failedInstances
  **/
  @Valid
  @Schema(description = "")
  public List<FailedInstanceForUpgradeCloudAssistantsOutput> getFailedInstances() {
    return failedInstances;
  }

  public void setFailedInstances(List<FailedInstanceForUpgradeCloudAssistantsOutput> failedInstances) {
    this.failedInstances = failedInstances;
  }

  public UpgradeCloudAssistantsResponse upgradingInstanceIds(List<String> upgradingInstanceIds) {
    this.upgradingInstanceIds = upgradingInstanceIds;
    return this;
  }

  public UpgradeCloudAssistantsResponse addUpgradingInstanceIdsItem(String upgradingInstanceIdsItem) {
    if (this.upgradingInstanceIds == null) {
      this.upgradingInstanceIds = new ArrayList<String>();
    }
    this.upgradingInstanceIds.add(upgradingInstanceIdsItem);
    return this;
  }

   /**
   * Get upgradingInstanceIds
   * @return upgradingInstanceIds
  **/
  @Schema(description = "")
  public List<String> getUpgradingInstanceIds() {
    return upgradingInstanceIds;
  }

  public void setUpgradingInstanceIds(List<String> upgradingInstanceIds) {
    this.upgradingInstanceIds = upgradingInstanceIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpgradeCloudAssistantsResponse upgradeCloudAssistantsResponse = (UpgradeCloudAssistantsResponse) o;
    return Objects.equals(this.failedInstances, upgradeCloudAssistantsResponse.failedInstances) &&
        Objects.equals(this.upgradingInstanceIds, upgradeCloudAssistantsResponse.upgradingInstanceIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(failedInstances, upgradingInstanceIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpgradeCloudAssistantsResponse {\n");
    
    sb.append("    failedInstances: ").append(toIndentedString(failedInstances)).append("\n");
    sb.append("    upgradingInstanceIds: ").append(toIndentedString(upgradingInstanceIds)).append("\n");
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
