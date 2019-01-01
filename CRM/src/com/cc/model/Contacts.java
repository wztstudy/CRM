

package com.cc.model;
/**
 * 联系人表
 * @author 黄恒愉
 * 
 */
public class Contacts{
private  Integer id;
private  Integer chanceID;
private  String name;
private  String mobile;
private  String address;
public void setId(Integer id){
   this.id = id;
}
public Integer getId(){
   return this.id;
}
public void setChanceID(Integer chanceID){
   this.chanceID = chanceID;
}
public Integer getChanceID(){
   return this.chanceID;
}
public void setName(String name){
   this.name = name;
}
public String getName(){
   return this.name;
}
public void setMobile(String mobile){
   this.mobile = mobile;
}
public String getMobile(){
   return this.mobile;
}
public void setAddress(String address){
   this.address = address;
}
public String getAddress(){
   return this.address;
}
@Override
 public String toString() {
 return "Contacts [id=" + id + ", chanceID=" + chanceID + ", name=" + name + ", mobile=" + mobile + ", address=" + address + " ]";
} 
}