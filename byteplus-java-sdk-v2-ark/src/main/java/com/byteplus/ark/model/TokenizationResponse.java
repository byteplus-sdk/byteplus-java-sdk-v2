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
import com.byteplus.ark.model.DataForTokenizationOutput;
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
 * TokenizationResponse
 */



public class TokenizationResponse extends com.byteplus.model.AbstractResponse {
  @SerializedName("created")
  private Integer created = null;

  @SerializedName("data")
  private List<DataForTokenizationOutput> data = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("model")
  private String model = null;

  @SerializedName("object")
  private String object = null;

  public TokenizationResponse created(Integer created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @Schema(description = "")
  public Integer getCreated() {
    return created;
  }

  public void setCreated(Integer created) {
    this.created = created;
  }

  public TokenizationResponse data(List<DataForTokenizationOutput> data) {
    this.data = data;
    return this;
  }

  public TokenizationResponse addDataItem(DataForTokenizationOutput dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<DataForTokenizationOutput>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Valid
  @Schema(description = "")
  public List<DataForTokenizationOutput> getData() {
    return data;
  }

  public void setData(List<DataForTokenizationOutput> data) {
    this.data = data;
  }

  public TokenizationResponse id(String id) {
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

  public TokenizationResponse model(String model) {
    this.model = model;
    return this;
  }

   /**
   * Get model
   * @return model
  **/
  @Schema(description = "")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public TokenizationResponse object(String object) {
    this.object = object;
    return this;
  }

   /**
   * Get object
   * @return object
  **/
  @Schema(description = "")
  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenizationResponse tokenizationResponse = (TokenizationResponse) o;
    return Objects.equals(this.created, tokenizationResponse.created) &&
        Objects.equals(this.data, tokenizationResponse.data) &&
        Objects.equals(this.id, tokenizationResponse.id) &&
        Objects.equals(this.model, tokenizationResponse.model) &&
        Objects.equals(this.object, tokenizationResponse.object);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, data, id, model, object);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenizationResponse {\n");
    
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
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
