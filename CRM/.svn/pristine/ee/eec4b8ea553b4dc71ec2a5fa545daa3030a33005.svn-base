package com.cc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.OrderService;
import com.cc.service.impl.OrderServiceImpl;

import net.sf.json.JSONObject;

public class SearchOrderServlet extends HttpServlet{

	OrderService os = new OrderServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custName = req.getParameter("custName");
		int currentPage = Integer.parseInt(req.getParameter("currentPage"));
		int showCount = Integer.parseInt(req.getParameter("showCount"));
		int offset = (currentPage -1 )* showCount;
		Map<String, Object> map = os.getOrderInfo(custName, offset, showCount);
		JSONObject json = new JSONObject();
		json.putAll(map);
		resp.getWriter().print(json);
	}
}
