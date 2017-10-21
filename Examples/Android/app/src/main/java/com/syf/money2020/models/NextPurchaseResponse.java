package com.syf.money2020.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NextPurchaseResponse {

  @SerializedName("accountNumber")
  @Expose
  private Integer accountNumber;
  @SerializedName("categories")
  @Expose
  private List<Category> categories = null;

  public Integer getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Integer accountNumber) {
    this.accountNumber = accountNumber;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

}