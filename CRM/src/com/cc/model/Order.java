package com.cc.model;
/**
 * 订单表
 * @author 黄恒愉
 * 
 */

import java.util.Date;

public class Order{
	private Integer id;
	private String orderID;
	private Date time;
	private Integer customerID;
	private double money;
	private String remark;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getTime() {
		return time.toString().substring(0, time.toString().length()-2);
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderID=" + orderID + ", time=" + time + ", customerID=" + customerID + ", money="
				+ money + ", remark=" + remark + ", name=" + name + "]";
	}
	
	
	
}