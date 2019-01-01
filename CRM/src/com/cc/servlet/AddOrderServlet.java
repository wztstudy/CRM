package com.cc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.OrderService;
import com.cc.service.impl.OrderServiceImpl;

public class AddOrderServlet extends HttpServlet{

	OrderService os = new OrderServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custName = req.getParameter("custName");
		String productName = req.getParameter("productName");
		String money = req.getParameter("price");
		String remark = req.getParameter("remark");
		String tips = os.addOrder(custName, productName, money, remark);
		resp.getWriter().print(tips);
		
	}
}
