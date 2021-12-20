package com.caizhen.model;

import java.util.Date;

//用户表
public class EpUser {

  private long userId;//用户id
  private String userName;//用户账号名称
  private String userPwd;//用户密码
  private String userRname;//用户真实名
  private String userEmail;//邮件
  private String userCompany;//公司
  private String userTel;
  private String userFax;//传真
  private Date userDatetime;//注册时间
  private long userRight;//用户权限

  public EpUser() {
  }

  public EpUser(long userId, String userName, String userPwd, String userRname, String userEmail, String userCompany, String userTel, String userFax, Date userDatetime, long userRight) {
    this.userId = userId;
    this.userName = userName;
    this.userPwd = userPwd;
    this.userRname = userRname;
    this.userEmail = userEmail;
    this.userCompany = userCompany;
    this.userTel = userTel;
    this.userFax = userFax;
    this.userDatetime = userDatetime;
    this.userRight = userRight;
  }

  @Override
  public String toString() {
    return "EpUser{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", userRname='" + userRname + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userCompany='" + userCompany + '\'' +
            ", userTel='" + userTel + '\'' +
            ", userFax='" + userFax + '\'' +
            ", userDatetime=" + userDatetime +
            ", userRight=" + userRight +
            '}';
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public String getUserRname() {
    return userRname;
  }

  public void setUserRname(String userRname) {
    this.userRname = userRname;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserCompany() {
    return userCompany;
  }

  public void setUserCompany(String userCompany) {
    this.userCompany = userCompany;
  }

  public String getUserTel() {
    return userTel;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }

  public String getUserFax() {
    return userFax;
  }

  public void setUserFax(String userFax) {
    this.userFax = userFax;
  }

  public Date getUserDatetime() {
    return userDatetime;
  }

  public void setUserDatetime(Date userDatetime) {
    this.userDatetime = userDatetime;
  }

  public long getUserRight() {
    return userRight;
  }

  public void setUserRight(long userRight) {
    this.userRight = userRight;
  }
}
