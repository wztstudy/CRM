package com.cc.model;
/**
 * 订单产品表
 * @author 黄恒愉
 * 
 */

public class Order_product{
	private  Integer id;
	private  Integer productID;
	private  Integer orderID;
	private  Integer num;
	public void setId(Integer id){
	   this.id = id;
	}
	public Integer getId(){
	   return this.id;
	}
	public void setProductID(Integer productID){
	   this.productID = productID;
	}
	public Integer getProductID(){
	   return this.productID;
	}
	public void setOrderID(Integer orderID){
	   this.orderID = orderID;
	}
	public Integer getOrderID(){
	   return this.orderID;
	}
	public void setNum(Integer num){
	   this.num = num;
	}
	public Integer getNum(){
	   return this.num;
	}
	@Override
	 public String toString() {
	 return "Order_product [id=" + id + ", productID=" + productID + ", orderID=" + orderID + ", num=" + num + " ]";
	} 
}