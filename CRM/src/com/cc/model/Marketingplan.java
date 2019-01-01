package com.cc.model;
/**
 * 销售计划
 * @author 黄恒愉
 * 
 */

import java.util.Date;
public class Marketingplan{
private  Integer id;
private  Date planTime;
private  Integer planStatus;
private  Integer planNum;
private  Integer userID;
public void setId(Integer id){
   this.id = id;
}
public Integer getId(){
   return this.id;
}
public void setPlanTime(Date planTime){
   this.planTime = planTime;
}
public Date getPlanTime(){
   return this.planTime;
}
public void setPlanStatus(Integer planStatus){
   this.planStatus = planStatus;
}
public Integer getPlanStatus(){
   return this.planStatus;
}
public void setPlanNum(Integer planNum){
   this.planNum = planNum;
}
public Integer getPlanNum(){
   return this.planNum;
}
public void setUserID(Integer userID){
   this.userID = userID;
}
public Integer getUserID(){
   return this.userID;
}
@Override
 public String toString() {
 return "Marketingplan [id=" + id + ", planTime=" + planTime + ", planStatus=" + planStatus + ", planNum=" + planNum + ", userID=" + userID + " ]";
} 
}