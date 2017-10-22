package com.syf.money2020.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

  @SerializedName("barcode")
  @Expose
  private String barcode;
  @SerializedName("description")
  @Expose
  private String description;

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      return gson.toJson(this);
  }

}