package com.caizhen.model;

import java.util.Date;

//新闻表
public class EpNews {

  private long newsId;//新闻id
  private String newsTitle;//新闻标题
  private String newsContent;//新闻内容
  private Date newsDatetime;//发表时间

  public long getNewsId() {
    return newsId;
  }

  public EpNews() {
  }

  @Override
  public String toString() {
    return "EpNews{" +
            "newsId=" + newsId +
            ", newsTitle='" + newsTitle + '\'' +
            ", newsContent='" + newsContent + '\'' +
            ", newsDatetime=" + newsDatetime +
            '}';
  }

  public void setNewsId(long newsId) {
    this.newsId = newsId;
  }

  public String getNewsTitle() {
    return newsTitle;
  }

  public void setNewsTitle(String newsTitle) {
    this.newsTitle = newsTitle;
  }

  public String getNewsContent() {
    return newsContent;
  }

  public void setNewsContent(String newsContent) {
    this.newsContent = newsContent;
  }

  public Date getNewsDatetime() {
    return newsDatetime;
  }

  public void setNewsDatetime(Date newsDatetime) {
    this.newsDatetime = newsDatetime;
  }

  public EpNews( String newsTitle, String newsContent, Date newsDatetime) {
    this.newsTitle = newsTitle;
    this.newsContent = newsContent;
    this.newsDatetime = newsDatetime;
  }
}
