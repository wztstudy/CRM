package com.cc.dao;

import java.util.List;

import com.cc.model.Order;
import com.cc.model.Product;

public interface OrderDao {

	List<Product> getProductInfo(String productName);
	
	List<Order> getOrderInfo(String custName,int offset,int showCount);
	
	int getTotal(String custName);
	
	int addOrder(String custName, String productName, String money, String remark);
}
