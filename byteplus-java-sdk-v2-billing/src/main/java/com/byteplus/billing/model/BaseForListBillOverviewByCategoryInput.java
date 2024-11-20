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
import com.byteplus.billing.model.TrafficEnvForListBillOverviewByCategoryInput;
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
 * BaseForListBillOverviewByCategoryInput
 */



public class BaseForListBillOverviewByCategoryInput {
  @SerializedName("Addr")
  private String addr = null;

  @SerializedName("Caller")
  private String caller = null;

  @SerializedName("Client")
  private String client = null;

  @SerializedName("Extra")
  private String extra = null;

  @SerializedName("LogID")
  private String logID = null;

  @SerializedName("TrafficEnv")
  private TrafficEnvForListBillOverviewByCategoryInput trafficEnv = null;

  public BaseForListBillOverviewByCategoryInput addr(String addr) {
    this.addr = addr;
    return this;
  }

   /**
   * Get addr
   * @return addr
  **/
  @Schema(description = "")
  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public BaseForListBillOverviewByCategoryInput caller(String caller) {
    this.caller = caller;
    return this;
  }

   /**
   * Get caller
   * @return caller
  **/
  @Schema(description = "")
  public String getCaller() {
    return caller;
  }

  public void setCaller(String caller) {
    this.caller = caller;
  }

  public BaseForListBillOverviewByCategoryInput client(String client) {
    this.client = client;
    return this;
  }

   /**
   * Get client
   * @return client
  **/
  @Schema(description = "")
  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }

  public BaseForListBillOverviewByCategoryInput extra(String extra) {
    this.extra = extra;
    return this;
  }

   /**
   * Get extra
   * @return extra
  **/
  @Schema(description = "")
  public String getExtra() {
    return extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }

  public BaseForListBillOverviewByCategoryInput logID(String logID) {
    this.logID = logID;
    return this;
  }

   /**
   * Get logID
   * @return logID
  **/
  @Schema(description = "")
  public String getLogID() {
    return logID;
  }

  public void setLogID(String logID) {
    this.logID = logID;
  }

  public BaseForListBillOverviewByCategoryInput trafficEnv(TrafficEnvForListBillOverviewByCategoryInput trafficEnv) {
    this.trafficEnv = trafficEnv;
    return this;
  }

   /**
   * Get trafficEnv
   * @return trafficEnv
  **/
  @Valid
  @Schema(description = "")
  public TrafficEnvForListBillOverviewByCategoryInput getTrafficEnv() {
    return trafficEnv;
  }

  public void setTrafficEnv(TrafficEnvForListBillOverviewByCategoryInput trafficEnv) {
    this.trafficEnv = trafficEnv;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseForListBillOverviewByCategoryInput baseForListBillOverviewByCategoryInput = (BaseForListBillOverviewByCategoryInput) o;
    return Objects.equals(this.addr, baseForListBillOverviewByCategoryInput.addr) &&
        Objects.equals(this.caller, baseForListBillOverviewByCategoryInput.caller) &&
        Objects.equals(this.client, baseForListBillOverviewByCategoryInput.client) &&
        Objects.equals(this.extra, baseForListBillOverviewByCategoryInput.extra) &&
        Objects.equals(this.logID, baseForListBillOverviewByCategoryInput.logID) &&
        Objects.equals(this.trafficEnv, baseForListBillOverviewByCategoryInput.trafficEnv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addr, caller, client, extra, logID, trafficEnv);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseForListBillOverviewByCategoryInput {\n");
    
    sb.append("    addr: ").append(toIndentedString(addr)).append("\n");
    sb.append("    caller: ").append(toIndentedString(caller)).append("\n");
    sb.append("    client: ").append(toIndentedString(client)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
    sb.append("    logID: ").append(toIndentedString(logID)).append("\n");
    sb.append("    trafficEnv: ").append(toIndentedString(trafficEnv)).append("\n");
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
