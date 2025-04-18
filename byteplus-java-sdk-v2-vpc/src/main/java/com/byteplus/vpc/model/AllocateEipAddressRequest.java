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
import com.byteplus.vpc.model.TagForAllocateEipAddressInput;
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
 * AllocateEipAddressRequest
 */



public class AllocateEipAddressRequest {
  @SerializedName("Bandwidth")
  private Integer bandwidth = null;

  @SerializedName("BandwidthPackageId")
  private String bandwidthPackageId = null;

  @SerializedName("BillingType")
  private Integer billingType = null;

  @SerializedName("ClientToken")
  private String clientToken = null;

  @SerializedName("Description")
  private String description = null;

  /**
   * Gets or Sets ISP
   */
  @JsonAdapter(ISPEnum.Adapter.class)
  public enum ISPEnum {
    @SerializedName("BGP")
    BGP("BGP"),
    @SerializedName("SingleLine_BGP")
    SINGLELINE_BGP("SingleLine_BGP"),
    @SerializedName("Static_BGP")
    STATIC_BGP("Static_BGP"),
    @SerializedName("Fusion_BGP")
    FUSION_BGP("Fusion_BGP"),
    @SerializedName("ChinaMobile")
    CHINAMOBILE("ChinaMobile"),
    @SerializedName("ChinaUnicom")
    CHINAUNICOM("ChinaUnicom"),
    @SerializedName("ChinaTelecom")
    CHINATELECOM("ChinaTelecom"),
    @SerializedName("ChinaMobile_Value")
    CHINAMOBILE_VALUE("ChinaMobile_Value"),
    @SerializedName("ChinaUnicom_Value")
    CHINAUNICOM_VALUE("ChinaUnicom_Value"),
    @SerializedName("ChinaTelecom_Value")
    CHINATELECOM_VALUE("ChinaTelecom_Value");

    private String value;

    ISPEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static ISPEnum fromValue(String input) {
      for (ISPEnum b : ISPEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<ISPEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ISPEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public ISPEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return ISPEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("ISP")
  private ISPEnum ISP = null;

  @SerializedName("IpAddress")
  private String ipAddress = null;

  @SerializedName("IpAddressPoolId")
  private String ipAddressPoolId = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Period")
  private Integer period = null;

  @SerializedName("PeriodUnit")
  private Integer periodUnit = null;

  @SerializedName("ProjectName")
  private String projectName = null;

  @SerializedName("RenewPeriodTimes")
  private Integer renewPeriodTimes = null;

  @SerializedName("RenewType")
  private Integer renewType = null;

  @SerializedName("SecurityProtectionInstanceId")
  private Integer securityProtectionInstanceId = null;

  @SerializedName("SecurityProtectionTypes")
  private List<String> securityProtectionTypes = null;

  @SerializedName("Tags")
  private List<TagForAllocateEipAddressInput> tags = null;

  public AllocateEipAddressRequest bandwidth(Integer bandwidth) {
    this.bandwidth = bandwidth;
    return this;
  }

   /**
   * Get bandwidth
   * minimum: 1
   * @return bandwidth
  **/
 @Min(1)  @Schema(description = "")
  public Integer getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(Integer bandwidth) {
    this.bandwidth = bandwidth;
  }

  public AllocateEipAddressRequest bandwidthPackageId(String bandwidthPackageId) {
    this.bandwidthPackageId = bandwidthPackageId;
    return this;
  }

   /**
   * Get bandwidthPackageId
   * @return bandwidthPackageId
  **/
  @Schema(description = "")
  public String getBandwidthPackageId() {
    return bandwidthPackageId;
  }

  public void setBandwidthPackageId(String bandwidthPackageId) {
    this.bandwidthPackageId = bandwidthPackageId;
  }

  public AllocateEipAddressRequest billingType(Integer billingType) {
    this.billingType = billingType;
    return this;
  }

   /**
   * Get billingType
   * minimum: 1
   * maximum: 3
   * @return billingType
  **/
 @Min(1) @Max(3)  @Schema(description = "")
  public Integer getBillingType() {
    return billingType;
  }

  public void setBillingType(Integer billingType) {
    this.billingType = billingType;
  }

  public AllocateEipAddressRequest clientToken(String clientToken) {
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

  public AllocateEipAddressRequest description(String description) {
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

  public AllocateEipAddressRequest ISP(ISPEnum ISP) {
    this.ISP = ISP;
    return this;
  }

   /**
   * Get ISP
   * @return ISP
  **/
  @Schema(description = "")
  public ISPEnum getISP() {
    return ISP;
  }

  public void setISP(ISPEnum ISP) {
    this.ISP = ISP;
  }

  public AllocateEipAddressRequest ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * Get ipAddress
   * @return ipAddress
  **/
  @Schema(description = "")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public AllocateEipAddressRequest ipAddressPoolId(String ipAddressPoolId) {
    this.ipAddressPoolId = ipAddressPoolId;
    return this;
  }

   /**
   * Get ipAddressPoolId
   * @return ipAddressPoolId
  **/
  @Schema(description = "")
  public String getIpAddressPoolId() {
    return ipAddressPoolId;
  }

  public void setIpAddressPoolId(String ipAddressPoolId) {
    this.ipAddressPoolId = ipAddressPoolId;
  }

  public AllocateEipAddressRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
 @Size(min=1,max=128)  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AllocateEipAddressRequest period(Integer period) {
    this.period = period;
    return this;
  }

   /**
   * Get period
   * @return period
  **/
  @Schema(description = "")
  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public AllocateEipAddressRequest periodUnit(Integer periodUnit) {
    this.periodUnit = periodUnit;
    return this;
  }

   /**
   * Get periodUnit
   * minimum: 1
   * maximum: 2
   * @return periodUnit
  **/
 @Min(1) @Max(2)  @Schema(description = "")
  public Integer getPeriodUnit() {
    return periodUnit;
  }

  public void setPeriodUnit(Integer periodUnit) {
    this.periodUnit = periodUnit;
  }

  public AllocateEipAddressRequest projectName(String projectName) {
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

  public AllocateEipAddressRequest renewPeriodTimes(Integer renewPeriodTimes) {
    this.renewPeriodTimes = renewPeriodTimes;
    return this;
  }

   /**
   * Get renewPeriodTimes
   * @return renewPeriodTimes
  **/
  @Schema(description = "")
  public Integer getRenewPeriodTimes() {
    return renewPeriodTimes;
  }

  public void setRenewPeriodTimes(Integer renewPeriodTimes) {
    this.renewPeriodTimes = renewPeriodTimes;
  }

  public AllocateEipAddressRequest renewType(Integer renewType) {
    this.renewType = renewType;
    return this;
  }

   /**
   * Get renewType
   * minimum: 1
   * maximum: 3
   * @return renewType
  **/
 @Min(1) @Max(3)  @Schema(description = "")
  public Integer getRenewType() {
    return renewType;
  }

  public void setRenewType(Integer renewType) {
    this.renewType = renewType;
  }

  public AllocateEipAddressRequest securityProtectionInstanceId(Integer securityProtectionInstanceId) {
    this.securityProtectionInstanceId = securityProtectionInstanceId;
    return this;
  }

   /**
   * Get securityProtectionInstanceId
   * @return securityProtectionInstanceId
  **/
  @Schema(description = "")
  public Integer getSecurityProtectionInstanceId() {
    return securityProtectionInstanceId;
  }

  public void setSecurityProtectionInstanceId(Integer securityProtectionInstanceId) {
    this.securityProtectionInstanceId = securityProtectionInstanceId;
  }

  public AllocateEipAddressRequest securityProtectionTypes(List<String> securityProtectionTypes) {
    this.securityProtectionTypes = securityProtectionTypes;
    return this;
  }

  public AllocateEipAddressRequest addSecurityProtectionTypesItem(String securityProtectionTypesItem) {
    if (this.securityProtectionTypes == null) {
      this.securityProtectionTypes = new ArrayList<String>();
    }
    this.securityProtectionTypes.add(securityProtectionTypesItem);
    return this;
  }

   /**
   * Get securityProtectionTypes
   * @return securityProtectionTypes
  **/
  @Schema(description = "")
  public List<String> getSecurityProtectionTypes() {
    return securityProtectionTypes;
  }

  public void setSecurityProtectionTypes(List<String> securityProtectionTypes) {
    this.securityProtectionTypes = securityProtectionTypes;
  }

  public AllocateEipAddressRequest tags(List<TagForAllocateEipAddressInput> tags) {
    this.tags = tags;
    return this;
  }

  public AllocateEipAddressRequest addTagsItem(TagForAllocateEipAddressInput tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagForAllocateEipAddressInput>();
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
  public List<TagForAllocateEipAddressInput> getTags() {
    return tags;
  }

  public void setTags(List<TagForAllocateEipAddressInput> tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllocateEipAddressRequest allocateEipAddressRequest = (AllocateEipAddressRequest) o;
    return Objects.equals(this.bandwidth, allocateEipAddressRequest.bandwidth) &&
        Objects.equals(this.bandwidthPackageId, allocateEipAddressRequest.bandwidthPackageId) &&
        Objects.equals(this.billingType, allocateEipAddressRequest.billingType) &&
        Objects.equals(this.clientToken, allocateEipAddressRequest.clientToken) &&
        Objects.equals(this.description, allocateEipAddressRequest.description) &&
        Objects.equals(this.ISP, allocateEipAddressRequest.ISP) &&
        Objects.equals(this.ipAddress, allocateEipAddressRequest.ipAddress) &&
        Objects.equals(this.ipAddressPoolId, allocateEipAddressRequest.ipAddressPoolId) &&
        Objects.equals(this.name, allocateEipAddressRequest.name) &&
        Objects.equals(this.period, allocateEipAddressRequest.period) &&
        Objects.equals(this.periodUnit, allocateEipAddressRequest.periodUnit) &&
        Objects.equals(this.projectName, allocateEipAddressRequest.projectName) &&
        Objects.equals(this.renewPeriodTimes, allocateEipAddressRequest.renewPeriodTimes) &&
        Objects.equals(this.renewType, allocateEipAddressRequest.renewType) &&
        Objects.equals(this.securityProtectionInstanceId, allocateEipAddressRequest.securityProtectionInstanceId) &&
        Objects.equals(this.securityProtectionTypes, allocateEipAddressRequest.securityProtectionTypes) &&
        Objects.equals(this.tags, allocateEipAddressRequest.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bandwidth, bandwidthPackageId, billingType, clientToken, description, ISP, ipAddress, ipAddressPoolId, name, period, periodUnit, projectName, renewPeriodTimes, renewType, securityProtectionInstanceId, securityProtectionTypes, tags);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocateEipAddressRequest {\n");
    
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    bandwidthPackageId: ").append(toIndentedString(bandwidthPackageId)).append("\n");
    sb.append("    billingType: ").append(toIndentedString(billingType)).append("\n");
    sb.append("    clientToken: ").append(toIndentedString(clientToken)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    ISP: ").append(toIndentedString(ISP)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    ipAddressPoolId: ").append(toIndentedString(ipAddressPoolId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    periodUnit: ").append(toIndentedString(periodUnit)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    renewPeriodTimes: ").append(toIndentedString(renewPeriodTimes)).append("\n");
    sb.append("    renewType: ").append(toIndentedString(renewType)).append("\n");
    sb.append("    securityProtectionInstanceId: ").append(toIndentedString(securityProtectionInstanceId)).append("\n");
    sb.append("    securityProtectionTypes: ").append(toIndentedString(securityProtectionTypes)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
