package com.cc.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cc.dao.OrderDao;
import com.cc.model.Order;
import com.cc.model.Product;
import com.cc.util.JDBC;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Product> getProductInfo(String productName) {
		String sql = "SELECT id,`name`,price FROM product WHERE 1=1 ";
		List<String> list = new ArrayList<>();
		if(productName != null && !"".equals(productName)) {
			sql += " AND name LIKE ?";
			list.add("%"+productName+"%");
		}
		return JDBC.query(sql, Product.class, list.toArray());
	}

	@Override
	public List<Order> getOrderInfo(String custName, int offset, int showCount) {
		String sql = "SELECT a.id,a.orderID,a.time,a.money,a.remark,b.name FROM `order` a,customer b WHERE a.customerID=b.id AND 1=1 ";
		List<String> list = new ArrayList<>();
		if(custName != null && !"".equals(custName)) {
			sql += "AND b.name LIKE ?";
			list.add("%"+custName+"%");
		}
		sql += " LIMIT "+offset+","+showCount;
		return JDBC.query(sql, Order.class, list.toArray());
	}

	@Override
	public int getTotal(String custName) {
		String sql = "SELECT COUNT(*)  FROM `order` a,customer b WHERE a.customerID=b.id AND 1=1 ";
		List<String> list = new ArrayList<>();
		if(custName != null && !"".equals(custName)) {
			sql += " AND b.name LIKE ?";
			list.add("%"+custName+"%");
		}
		
		return JDBC.getCount(sql, list.toArray());
	}

	@Override
	public int addOrder(String custName, String productName, String money, String remark) {
		Date date = new Date();
		//已当前时间作为订单号
		String orderID = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		String orderTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		System.out.println(custName+","+productName+","+money+","+remark);
		String sql1 = "INSERT INTO `order`(orderID,time,customerID,money,remark) VALUES('"+orderID+"','"+orderTime+"',(SELECT id FROM customer WHERE name=? ),?,?)";
		int row1 = JDBC.update(sql1, custName,money,remark);
		String sql2 = "INSERT INTO order_product (productID,orderID,num)VALUES((SELECT id FROM product WHERE name=?),(SELECT MAX(id) FROM `order`),1)";
		int row2 = JDBC.update(sql2, productName);
		
		return row1 + row2;
	}

	
}
