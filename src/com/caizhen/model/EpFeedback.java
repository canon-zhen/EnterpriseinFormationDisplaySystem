package com.caizhen.model;

import java.util.Date;

//反馈信息表
public class EpFeedback {

  private long fbackId;//反馈编号
  private String fbackTitle;//反馈标题
  private String fbackContent;//反馈内容
  private long userId;//用户编号
  private Date fbackDatetime;//反馈时间

  @Override
  public String toString() {
    return "EpFeedback{" +
            "fbackId=" + fbackId +
            ", fbackTitle='" + fbackTitle + '\'' +
            ", fbackContent='" + fbackContent + '\'' +
            ", userId=" + userId +
            ", fbackDatetime=" + fbackDatetime +
            '}';
  }

  public long getFbackId() {
    return fbackId;
  }

  public void setFbackId(long fbackId) {
    this.fbackId = fbackId;
  }


  public String getFbackTitle() {
    return fbackTitle;
  }

  public void setFbackTitle(String fbackTitle) {
    this.fbackTitle = fbackTitle;
  }


  public String getFbackContent() {
    return fbackContent;
  }

  public void setFbackContent(String fbackContent) {
    this.fbackContent = fbackContent;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public Date getFbackDatetime() {
    return fbackDatetime;
  }

  public void setFbackDatetime(Date fbackDatetime) {
    this.fbackDatetime = fbackDatetime;
  }
}
