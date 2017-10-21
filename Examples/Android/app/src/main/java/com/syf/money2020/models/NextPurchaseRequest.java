package com.syf.money2020.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NextPurchaseRequest {

  @SerializedName("accountNumber")
  @Expose
  private Integer accountNumber;

  public Integer getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
  }

}