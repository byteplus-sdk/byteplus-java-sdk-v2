/*
 * billing
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: common-version
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.byteplus.billing.model;

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
 * ConfigListForQueryPriceForSubscriptionInput
 */



public class ConfigListForQueryPriceForSubscriptionInput {
  @SerializedName("ChargeItemCode")
  private String chargeItemCode = null;

  @SerializedName("ConfigurationCode")
  private String configurationCode = null;

  @SerializedName("Count")
  private String count = null;

  @SerializedName("Quantity")
  private Integer quantity = null;

  @SerializedName("UseDuration")
  private Integer useDuration = null;

  public ConfigListForQueryPriceForSubscriptionInput chargeItemCode(String chargeItemCode) {
    this.chargeItemCode = chargeItemCode;
    return this;
  }

   /**
   * Get chargeItemCode
   * @return chargeItemCode
  **/
  @Schema(description = "")
  public String getChargeItemCode() {
    return chargeItemCode;
  }

  public void setChargeItemCode(String chargeItemCode) {
    this.chargeItemCode = chargeItemCode;
  }

  public ConfigListForQueryPriceForSubscriptionInput configurationCode(String configurationCode) {
    this.configurationCode = configurationCode;
    return this;
  }

   /**
   * Get configurationCode
   * @return configurationCode
  **/
  @Schema(description = "")
  public String getConfigurationCode() {
    return configurationCode;
  }

  public void setConfigurationCode(String configurationCode) {
    this.configurationCode = configurationCode;
  }

  public ConfigListForQueryPriceForSubscriptionInput count(String count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @Schema(description = "")
  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public ConfigListForQueryPriceForSubscriptionInput quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Get quantity
   * @return quantity
  **/
  @Schema(description = "")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ConfigListForQueryPriceForSubscriptionInput useDuration(Integer useDuration) {
    this.useDuration = useDuration;
    return this;
  }

   /**
   * Get useDuration
   * @return useDuration
  **/
  @Schema(description = "")
  public Integer getUseDuration() {
    return useDuration;
  }

  public void setUseDuration(Integer useDuration) {
    this.useDuration = useDuration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigListForQueryPriceForSubscriptionInput configListForQueryPriceForSubscriptionInput = (ConfigListForQueryPriceForSubscriptionInput) o;
    return Objects.equals(this.chargeItemCode, configListForQueryPriceForSubscriptionInput.chargeItemCode) &&
        Objects.equals(this.configurationCode, configListForQueryPriceForSubscriptionInput.configurationCode) &&
        Objects.equals(this.count, configListForQueryPriceForSubscriptionInput.count) &&
        Objects.equals(this.quantity, configListForQueryPriceForSubscriptionInput.quantity) &&
        Objects.equals(this.useDuration, configListForQueryPriceForSubscriptionInput.useDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chargeItemCode, configurationCode, count, quantity, useDuration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigListForQueryPriceForSubscriptionInput {\n");
    
    sb.append("    chargeItemCode: ").append(toIndentedString(chargeItemCode)).append("\n");
    sb.append("    configurationCode: ").append(toIndentedString(configurationCode)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    useDuration: ").append(toIndentedString(useDuration)).append("\n");
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
