package com.cc.model;
/**
 * 常见问题
 * @author 黄恒愉
 * 
 */

import java.util.Date;
public class Faq{
	private Integer id;
	private Date recordTime;
	private String title;
	private String content;
	private Integer userID;
	private String name;
	public void setId(Integer id){
	   this.id = id;
	}
	public Integer getId(){
	   return this.id;
	}
	public void setRecordTime(Date recordTime){
	   this.recordTime = recordTime;
	}
	public String getRecordTime(){
	   return this.recordTime.toString().substring(0, this.recordTime.toString().length()-2);
	}
	public void setTitle(String title){
	   this.title = title;
	}
	public String getTitle(){
	   return this.title;
	}
	public void setContent(String content){
	   this.content = content;
	}
	public String getContent(){
	   return this.content;
	}
	public void setUserID(Integer userID){
	   this.userID = userID;
	}
	public Integer getUserID(){
	   return this.userID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Faq [id=" + id + ", recordTime=" + recordTime + ", title=" + title + ", content=" + content
				+ ", userID=" + userID + ", name=" + name + "]";
	}
	
}