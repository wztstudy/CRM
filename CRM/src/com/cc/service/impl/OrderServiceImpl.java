package com.cc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.OrderDao;
import com.cc.dao.impl.OrderDaoImpl;
import com.cc.model.Order;
import com.cc.model.Product;
import com.cc.service.OrderService;

public class OrderServiceImpl implements OrderService{

	OrderDao od = new OrderDaoImpl();
	
	@Override
	public List<Product> getProductInfo(String productName) {
		return od.getProductInfo(productName);
	}

	@Override
	public Map<String, Object> getOrderInfo(String custName, int offset, int showCount) {
		List<Order> list = od.getOrderInfo(custName, offset, showCount);
		int totalCount = od.getTotal(custName);
		int totalPage = totalCount%showCount == 0 ? totalCount/showCount : totalCount/showCount+1;
		Map<String, Object> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("orderInfo", list);
		return map;
	}

	@Override
	public String addOrder(String custName, String productName, String money, String remark) {
		int row = od.addOrder(custName, productName, money, remark);
		String tips = "";
		if(row >1) {
			tips = "添加订单成功";
		}else {
			tips = "添加订单失败";
		}
		return tips;
	}

	
}
