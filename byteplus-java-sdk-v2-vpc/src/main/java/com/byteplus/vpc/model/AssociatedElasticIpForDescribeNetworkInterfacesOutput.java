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
 * AssociatedElasticIpForDescribeNetworkInterfacesOutput
 */



public class AssociatedElasticIpForDescribeNetworkInterfacesOutput {
  @SerializedName("AllocationId")
  private String allocationId = null;

  @SerializedName("EipAddress")
  private String eipAddress = null;

  @SerializedName("ReleaseWithInstance")
  private Boolean releaseWithInstance = null;

  public AssociatedElasticIpForDescribeNetworkInterfacesOutput allocationId(String allocationId) {
    this.allocationId = allocationId;
    return this;
  }

   /**
   * Get allocationId
   * @return allocationId
  **/
  @Schema(description = "")
  public String getAllocationId() {
    return allocationId;
  }

  public void setAllocationId(String allocationId) {
    this.allocationId = allocationId;
  }

  public AssociatedElasticIpForDescribeNetworkInterfacesOutput eipAddress(String eipAddress) {
    this.eipAddress = eipAddress;
    return this;
  }

   /**
   * Get eipAddress
   * @return eipAddress
  **/
  @Schema(description = "")
  public String getEipAddress() {
    return eipAddress;
  }

  public void setEipAddress(String eipAddress) {
    this.eipAddress = eipAddress;
  }

  public AssociatedElasticIpForDescribeNetworkInterfacesOutput releaseWithInstance(Boolean releaseWithInstance) {
    this.releaseWithInstance = releaseWithInstance;
    return this;
  }

   /**
   * Get releaseWithInstance
   * @return releaseWithInstance
  **/
  @Schema(description = "")
  public Boolean isReleaseWithInstance() {
    return releaseWithInstance;
  }

  public void setReleaseWithInstance(Boolean releaseWithInstance) {
    this.releaseWithInstance = releaseWithInstance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssociatedElasticIpForDescribeNetworkInterfacesOutput associatedElasticIpForDescribeNetworkInterfacesOutput = (AssociatedElasticIpForDescribeNetworkInterfacesOutput) o;
    return Objects.equals(this.allocationId, associatedElasticIpForDescribeNetworkInterfacesOutput.allocationId) &&
        Objects.equals(this.eipAddress, associatedElasticIpForDescribeNetworkInterfacesOutput.eipAddress) &&
        Objects.equals(this.releaseWithInstance, associatedElasticIpForDescribeNetworkInterfacesOutput.releaseWithInstance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allocationId, eipAddress, releaseWithInstance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssociatedElasticIpForDescribeNetworkInterfacesOutput {\n");
    
    sb.append("    allocationId: ").append(toIndentedString(allocationId)).append("\n");
    sb.append("    eipAddress: ").append(toIndentedString(eipAddress)).append("\n");
    sb.append("    releaseWithInstance: ").append(toIndentedString(releaseWithInstance)).append("\n");
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
