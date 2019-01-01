package com.cc.service;

import java.util.List;
import java.util.Map;

import com.cc.model.Product;

public interface OrderService {

	List<Product> getProductInfo(String productName);
	
	Map<String, Object> getOrderInfo(String custName,int offset,int showCount);
	
	String addOrder(String custName,String productName,String money,String remark);
}
