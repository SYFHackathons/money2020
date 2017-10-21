package com.syf.money2020.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinancialAdvisorResponse {

  @SerializedName("highestCategoryAbsolute")
  @Expose
  private String highestCategoryAbsolute;
  @SerializedName("highestCategoryAbsolutePercentile")
  @Expose
  private Integer highestCategoryAbsolutePercentile;
  @SerializedName("lowestCategoryAbsolute")
  @Expose
  private String lowestCategoryAbsolute;
  @SerializedName("lowestCategoryAbsolutePercentile")
  @Expose
  private Integer lowestCategoryAbsolutePercentile;
  @SerializedName("highestCategoryRelative")
  @Expose
  private String highestCategoryRelative;
  @SerializedName("highestCategoryRelativePercentile")
  @Expose
  private Integer highestCategoryRelativePercentile;
  @SerializedName("lowestCategoryRelative")
  @Expose
  private String lowestCategoryRelative;
  @SerializedName("lowestCategoryRelativePercentile")
  @Expose
  private Integer lowestCategoryRelativePercentile;

  public String getHighestCategoryAbsolute() {
    return highestCategoryAbsolute;
  }

  public void setHighestCategoryAbsolute(String highestCategoryAbsolute) {
    this.highestCategoryAbsolute = highestCategoryAbsolute;
  }

  public Integer getHighestCategoryAbsolutePercentile() {
    return highestCategoryAbsolutePercentile;
  }

  public void setHighestCategoryAbsolutePercentile(Integer highestCategoryAbsolutePercentile) {
    this.highestCategoryAbsolutePercentile = highestCategoryAbsolutePercentile;
  }

  public String getLowestCategoryAbsolute() {
    return lowestCategoryAbsolute;
  }

  public void setLowestCategoryAbsolute(String lowestCategoryAbsolute) {
    this.lowestCategoryAbsolute = lowestCategoryAbsolute;
  }

  public Integer getLowestCategoryAbsolutePercentile() {
    return lowestCategoryAbsolutePercentile;
  }

  public void setLowestCategoryAbsolutePercentile(Integer lowestCategoryAbsolutePercentile) {
    this.lowestCategoryAbsolutePercentile = lowestCategoryAbsolutePercentile;
  }

  public String getHighestCategoryRelative() {
    return highestCategoryRelative;
  }

  public void setHighestCategoryRelative(String highestCategoryRelative) {
    this.highestCategoryRelative = highestCategoryRelative;
  }

  public Integer getHighestCategoryRelativePercentile() {
    return highestCategoryRelativePercentile;
  }

  public void setHighestCategoryRelativePercentile(Integer highestCategoryRelativePercentile) {
    this.highestCategoryRelativePercentile = highestCategoryRelativePercentile;
  }

  public String getLowestCategoryRelative() {
    return lowestCategoryRelative;
  }

  public void setLowestCategoryRelative(String lowestCategoryRelative) {
    this.lowestCategoryRelative = lowestCategoryRelative;
  }

  public Integer getLowestCategoryRelativePercentile() {
    return lowestCategoryRelativePercentile;
  }

  public void setLowestCategoryRelativePercentile(Integer lowestCategoryRelativePercentile) {
    this.lowestCategoryRelativePercentile = lowestCategoryRelativePercentile;
  }

}