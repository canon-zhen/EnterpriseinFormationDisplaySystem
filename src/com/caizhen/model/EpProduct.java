package com.caizhen.model;

import java.util.Date;
import java.util.Objects;

//产品表
public class EpProduct {

  private long prodId;//产品编号
  private long catId;//分类编号
  private String prodName;//产品名称
  private String prodType;//产品型号
  private double prodPrice;//产品价格
  private String prodImage;//产品图像
  private String prodDesc;//产品简介
  private Date prodDatetime;//发表时间
  private int prodFirstShow;//是否显示在首页、、prod_firstShow


  public EpProduct() {
  }

  @Override
  public String toString() {
    return "EpProduct{" +
            "prodId=" + prodId +
            ", catId=" + catId +
            ", prodName='" + prodName + '\'' +
            ", prodType='" + prodType + '\'' +
            ", prodPrice=" + prodPrice +
            ", prodImage='" + prodImage + '\'' +
            ", prodDesc='" + prodDesc + '\'' +
            ", prodDatetime=" + prodDatetime +
            ", prodFirstShow=" + prodFirstShow +
            '}';
  }

  public long getProdId() {
    return prodId;
  }

  public void setProdId(long prodId) {
    this.prodId = prodId;
  }

  public long getCatId() {
    return catId;
  }

  public void setCatId(long catId) {
    this.catId = catId;
  }

  public String getProdName() {
    return prodName;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName;
  }

  public String getProdType() {
    return prodType;
  }

  public void setProdType(String prodType) {
    this.prodType = prodType;
  }

  public double getProdPrice() {
    return prodPrice;
  }

  public void setProdPrice(double prodPrice) {
    this.prodPrice = prodPrice;
  }

  public String getProdImage() {
    return prodImage;
  }

  public void setProdImage(String prodImage) {
    this.prodImage = prodImage;
  }

  public String getProdDesc() {
    return prodDesc;
  }

  public void setProdDesc(String prodDesc) {
    this.prodDesc = prodDesc;
  }

  public Date getProdDatetime() {
    return prodDatetime;
  }

  public void setProdDatetime(Date prodDatetime) {
    this.prodDatetime = prodDatetime;
  }

  public int getProdFirstShow() {
    return prodFirstShow;
  }

  public void setProdFirstShow(int prodFirstShow) {
    this.prodFirstShow = prodFirstShow;
  }
}
