package com.cc.model;
/**
 * 合同表
 * @author 黄恒愉
 * 
 */
import java.util.Date;
public class Contract{
private  Integer id;
private  String contractID;
private  Integer orderID;
private  String name;
private  String content;
private  Integer status;
private  Date startTime;
private  Date endTime;
private  String partA;
private  String partB;
public void setId(Integer id){
   this.id = id;
}
public Integer getId(){
   return this.id;
}
public void setContractID(String contractID){
   this.contractID = contractID;
}
public String getContractID(){
   return this.contractID;
}
public void setOrderID(Integer orderID){
   this.orderID = orderID;
}
public Integer getOrderID(){
   return this.orderID;
}
public void setName(String name){
   this.name = name;
}
public String getName(){
   return this.name;
}
public void setContent(String content){
   this.content = content;
}
public String getContent(){
   return this.content;
}
public void setStatus(Integer status){
   this.status = status;
}
public Integer getStatus(){
   return this.status;
}
public void setStartTime(Date startTime){
   this.startTime = startTime;
}
public Date getStartTime(){
   return this.startTime;
}
public void setEndTime(Date endTime){
   this.endTime = endTime;
}
public Date getEndTime(){
   return this.endTime;
}
public void setPartA(String partA){
   this.partA = partA;
}
public String getPartA(){
   return this.partA;
}
public void setPartB(String partB){
   this.partB = partB;
}
public String getPartB(){
   return this.partB;
}
@Override
 public String toString() {
 return "Contract [id=" + id + ", contractID=" + contractID + ", orderID=" + orderID + ", name=" + name + ", content=" + content + ", status=" + status + ", startTime=" + startTime + ", endTime=" + endTime + ", partA=" + partA + ", partB=" + partB + " ]";
} 
}