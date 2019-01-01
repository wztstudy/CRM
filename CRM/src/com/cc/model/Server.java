package com.cc.model;
/**
 * 服务表
 * @author 黄恒愉
 * 
 */


public class Server{
	
	private String userName;
	private String custName;
	private String value;
	private  Integer id;
	private  Integer customerID;
	private  Integer userID;
	private  String serverContent;
	private  Integer status;
	private  String process;
	private  String result;
	private String content;
	
	public void setId(Integer id){
	   this.id = id;
	}
	public Integer getId(){
	   return this.id;
	}
	public void setCustomerID(Integer customerID){
	   this.customerID = customerID;
	}
	public Integer getCustomerID(){
	   return this.customerID;
	}
	public void setUserID(Integer userID){
	   this.userID = userID;
	}
	public Integer getUserID(){
	   return this.userID;
	}
	public void setServerContent(String serverContent){
	   this.serverContent = serverContent;
	}
	public String getServerContent(){
	   return this.serverContent;
	}
	public void setStatus(Integer status){
	   this.status = status;
	}
	public Integer getStatus(){
	   return this.status;
	}
	public void setProcess(String process){
	   this.process = process;
	}
	public String getProcess(){
	   return this.process;
	}
	public void setResult(String result){
	   this.result = result;
	}
	public String getResult(){
	   return this.result;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Server [userName=" + userName + ", custName=" + custName + ", value=" + value + ", id=" + id
				+ ", customerID=" + customerID + ", userID=" + userID + ", serverContent=" + serverContent + ", status="
				+ status + ", process=" + process + ", result=" + result + "]";
	}
	
}