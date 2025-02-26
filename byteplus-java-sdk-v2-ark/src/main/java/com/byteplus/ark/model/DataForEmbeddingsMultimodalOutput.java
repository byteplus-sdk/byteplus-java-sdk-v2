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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * DataForEmbeddingsMultimodalOutput
 */



public class DataForEmbeddingsMultimodalOutput {
  @SerializedName("embedding")
  private List<String> embedding = null;

  @SerializedName("object")
  private String object = null;

  public DataForEmbeddingsMultimodalOutput embedding(List<String> embedding) {
    this.embedding = embedding;
    return this;
  }

  public DataForEmbeddingsMultimodalOutput addEmbeddingItem(String embeddingItem) {
    if (this.embedding == null) {
      this.embedding = new ArrayList<String>();
    }
    this.embedding.add(embeddingItem);
    return this;
  }

   /**
   * Get embedding
   * @return embedding
  **/
  @Schema(description = "")
  public List<String> getEmbedding() {
    return embedding;
  }

  public void setEmbedding(List<String> embedding) {
    this.embedding = embedding;
  }

  public DataForEmbeddingsMultimodalOutput object(String object) {
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
    DataForEmbeddingsMultimodalOutput dataForEmbeddingsMultimodalOutput = (DataForEmbeddingsMultimodalOutput) o;
    return Objects.equals(this.embedding, dataForEmbeddingsMultimodalOutput.embedding) &&
        Objects.equals(this.object, dataForEmbeddingsMultimodalOutput.object);
  }

  @Override
  public int hashCode() {
    return Objects.hash(embedding, object);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataForEmbeddingsMultimodalOutput {\n");
    
    sb.append("    embedding: ").append(toIndentedString(embedding)).append("\n");
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
