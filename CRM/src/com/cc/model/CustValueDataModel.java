package com.cc.model;

public class CustValueDataModel {
     private  String  name;
     private  String  type;
     private  Integer  credit;
     private  Integer  satisfy;
     private  Integer  value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getSatisfy() {
		return satisfy;
	}
	public void setSatisfy(Integer satisfy) {
		this.satisfy = satisfy;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue() {
		this.value = this.credit+this.satisfy;
	}
	@Override
	public String toString() {
		return "CustValueDataModel [name=" + name + ", type=" + type + ", credit=" + credit + ", satisfy=" + satisfy
				+ ", value=" + value + "]";
	}
     
}
