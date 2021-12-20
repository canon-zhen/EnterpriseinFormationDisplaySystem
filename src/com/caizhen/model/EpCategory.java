package com.caizhen.model;

import java.util.Objects;

//产品分类表
public class EpCategory {

  private long catId;//分类编号
  private String catName;//分类名称

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EpCategory that = (EpCategory) o;
    return catId == that.catId && Objects.equals(catName, that.catName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(catId, catName);
  }

  public long getCatId() {
    return catId;
  }

  public void setCatId(long catId) {
    this.catId = catId;
  }


  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }

  @Override
  public String toString() {
    return "EpCategory{" +
            "catId=" + catId +
            ", catName='" + catName + '\'' +
            '}';
  }

  
}
