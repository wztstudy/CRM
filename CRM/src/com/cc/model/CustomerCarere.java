
package com.cc.model;
/**
 * 客户关怀
 * @author 黄恒愉
 * 
 */
import java.util.Date;
public class CustomerCarere{
		private  Integer id;
		private  String uname;
		private  String cname;
		private  String title;
		private  String content;
		private  Date cordTime;
		private  Date remindTime;
		private  Integer customerID;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getCordTime() {
	return cordTime.toString().substring(0, 16);
}
public void setCordTime(Date cordTime) {
	this.cordTime = cordTime;
}
public String getRemindTime() {
	return remindTime.toString().substring(0, 16);
}
public void setRemindTime(Date remindTime) {
	this.remindTime = remindTime;
}
public Integer getCustomerID() {
	return customerID;
}
public void setCustomerID(Integer customerID) {
	this.customerID = customerID;
}
@Override
public String toString() {
	return "CustomerCarere [id=" + id + ", uname=" + uname + ", cname=" + cname + ", title=" + title + ", content="
			+ content + ", cordTime=" + cordTime + ", remindTime=" + remindTime + ", customerID=" + customerID + "]";
}

}