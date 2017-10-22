package com.syf.money2020.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoyaltyRequest {

  @SerializedName("accountNumber")
  @Expose
  private Integer accountNumber;
  @SerializedName("sku")
  @Expose
  private String sku;
  @SerializedName("quanitiy")
  @Expose
  private Integer quanitiy;
  @SerializedName("totalPriceRequested")
  @Expose
  private Integer totalPriceRequested;

  public Integer getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public Integer getQuanitiy() {
    return quanitiy;
  }

  public void setQuanitiy(Integer quanitiy) {
    this.quanitiy = quanitiy;
  }

  public Integer getTotalPriceRequested() {
    return totalPriceRequested;
  }

  public void setTotalPriceRequested(Integer totalPriceRequested) {
    this.totalPriceRequested = totalPriceRequested;
  }

  @Override
  public String toString() {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      return gson.toJson(this);
  }

}