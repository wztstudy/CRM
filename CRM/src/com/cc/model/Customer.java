package com.cc.model;
/**
 * 客户表
 * @author 黄恒愉
 * 
 */
import java.util.Date;
public class Customer{
private  Integer id;
private  Integer sex;
private  Integer age;
private  Integer userID;
private  String name;
private  Date birthday;
private  String mobile;
private  String type;
private  Integer credit;
private  Integer satisfy;
private  String address;
private  Integer chanceID;
public void setId(Integer id){
   this.id = id;
}
public Integer getId(){
   return this.id;
}
public void setSex(Integer sex){
   this.sex = sex;
}
public Integer getSex(){
   return this.sex;
}
public void setUserID(Integer userID){
   this.userID = userID;
}
public Integer getUserID(){
   return this.userID;
}
public void setName(String name){
   this.name = name;
}
public String getName(){
   return this.name;
}
public void setBirthday(Date birthday){
   this.birthday = birthday;
}
public String getBirthday(){
   return this.birthday.toString();
}
public void setMobile(String mobile){
   this.mobile = mobile;
}
public String getMobile(){
   return this.mobile;
}
public void setType(String type){
   this.type = type;
}
public String getType(){
   return this.type;
}
public void setCredit(Integer credit){
   this.credit = credit;
}
public Integer getCredit(){
   return this.credit;
}
public void setSatisfy(Integer satisfy){
   this.satisfy = satisfy;
}
public Integer getSatisfy(){
   return this.satisfy;
}
public void setAddress(String address){
   this.address = address;
}
public String getAddress(){
   return this.address;
}
public void setChanceID(Integer chanceID){
   this.chanceID = chanceID;
}
public Integer getChanceID(){
   return this.chanceID;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", sex=" + sex + ", age=" + age + ", userID=" + userID + ", name=" + name
			+ ", birthday=" + birthday + ", mobile=" + mobile + ", type=" + type + ", credit=" + credit + ", satisfy="
			+ satisfy + ", address=" + address + ", chanceID=" + chanceID + "]";
}
public Integer getAge() {
	return this.age;
}
public void setAge(Integer age) {
	this.age = age;
} 
}