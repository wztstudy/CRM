package com.cc.model;
/**
 * 客户发展计划
 * @author 黄恒愉
 * 
 */
import java.util.Date;
public class Customerplan{
	private  Integer id;
	private  Date planTime;
	private  Integer planNum;
	private  Integer userID;
	private  String name;
	
	public void setId(Integer id){
	   this.id = id;
	}
	public Integer getId(){
	   return this.id;
	}
	public void setPlanTime(Date planTime){
	   this.planTime = planTime;
	}
	public String getPlanTime(){
	   return this.planTime.toString().substring(0,10);
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
		return "Customerplan [id=" + id + ", planTime=" + planTime + ", planNum=" + planNum + ", userID=" + userID
				+ ", username=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
}