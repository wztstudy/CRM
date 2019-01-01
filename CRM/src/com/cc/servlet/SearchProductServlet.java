package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.Product;
import com.cc.service.OrderService;
import com.cc.service.impl.OrderServiceImpl;

import net.sf.json.JSONObject;

public class SearchProductServlet extends HttpServlet{

	OrderService os = new OrderServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productName = req.getParameter("productName");
		PrintWriter pw = resp.getWriter();
		JSONObject json = new JSONObject();
		if(productName == null || "".equals(productName) ) {
			pw.print(json.put("productInfo", null) );
		}
		List<Product> list = os.getProductInfo(productName);
		list.forEach(s -> System.out.println(s));
		json.put("productInfo", list);
		pw.print(json);
	}
}
