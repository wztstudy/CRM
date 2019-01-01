
package com.cc.model;
/**
 * 机会表实体类
 * @author 黄恒愉
 * 
 */
public class Chance{
private  Integer id;
private  String name;
private  String customerName;
private  String type;
private  String source;
private  Integer status;
private  String remark;
private  String mobile;
private  Integer userID;
public void setId(Integer id){
   this.id = id;
}
public Integer getId(){
   return this.id;
}
public void setName(String name){
   this.name = name;
}
public String getName(){
   return this.name;
}
public void setCustomerName(String customerName){
   this.customerName = customerName;
}
public String getCustomerName(){
   return this.customerName;
}
public void setType(String type){
   this.type = type;
}
public String getType(){
   return this.type;
}
public void setSource(String source){
   this.source = source;
}
public String getSource(){
   return this.source;
}
public void setStatus(Integer status){
   this.status = status;
}
public Integer getStatus(){
   return this.status;
}
public void setRemark(String remark){
   this.remark = remark;
}
public String getRemark(){
   return this.remark;
}
public void setMobile(String mobile){
   this.mobile = mobile;
}
public String getMobile(){
   return this.mobile;
}
public void setUserID(Integer userID){
   this.userID = userID;
}
public Integer getUserID(){
   return this.userID;
}
@Override
 public String toString() {
 return "Chance [id=" + id + ", name=" + name + ", customerName=" + customerName + ", type=" + type + ", source=" + source + ", status=" + status + ", remark=" + remark + ", mobile=" + mobile + ", userID=" + userID + " ]";
} 
}