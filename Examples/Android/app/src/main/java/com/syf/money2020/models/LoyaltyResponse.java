package com.syf.money2020.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoyaltyResponse {

  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("offer")
  @Expose
  private Offer offer;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }

}