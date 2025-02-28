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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * TruncationStrategyForContextCreateInput
 */



public class TruncationStrategyForContextCreateInput {
  @SerializedName("last_history_tokens")
  private Integer lastHistoryTokens = null;

  @SerializedName("rolling_tokens")
  private Boolean rollingTokens = null;

  @SerializedName("type")
  private String type = null;

  public TruncationStrategyForContextCreateInput lastHistoryTokens(Integer lastHistoryTokens) {
    this.lastHistoryTokens = lastHistoryTokens;
    return this;
  }

   /**
   * Get lastHistoryTokens
   * @return lastHistoryTokens
  **/
  @Schema(description = "")
  public Integer getLastHistoryTokens() {
    return lastHistoryTokens;
  }

  public void setLastHistoryTokens(Integer lastHistoryTokens) {
    this.lastHistoryTokens = lastHistoryTokens;
  }

  public TruncationStrategyForContextCreateInput rollingTokens(Boolean rollingTokens) {
    this.rollingTokens = rollingTokens;
    return this;
  }

   /**
   * Get rollingTokens
   * @return rollingTokens
  **/
  @Schema(description = "")
  public Boolean isRollingTokens() {
    return rollingTokens;
  }

  public void setRollingTokens(Boolean rollingTokens) {
    this.rollingTokens = rollingTokens;
  }

  public TruncationStrategyForContextCreateInput type(String type) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TruncationStrategyForContextCreateInput truncationStrategyForContextCreateInput = (TruncationStrategyForContextCreateInput) o;
    return Objects.equals(this.lastHistoryTokens, truncationStrategyForContextCreateInput.lastHistoryTokens) &&
        Objects.equals(this.rollingTokens, truncationStrategyForContextCreateInput.rollingTokens) &&
        Objects.equals(this.type, truncationStrategyForContextCreateInput.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastHistoryTokens, rollingTokens, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TruncationStrategyForContextCreateInput {\n");
    
    sb.append("    lastHistoryTokens: ").append(toIndentedString(lastHistoryTokens)).append("\n");
    sb.append("    rollingTokens: ").append(toIndentedString(rollingTokens)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
