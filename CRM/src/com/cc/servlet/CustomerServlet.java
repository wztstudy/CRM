package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.CustomerService;
import com.cc.service.impl.CustomerServiceImpl;

import net.sf.json.JSONObject;


/**
 * 客户Serlet
 * @author 黄恒愉
 *
 */
public class CustomerServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String custName = request.getParameter("custName");
		custName = custName == null ? "" : custName;
		JSONObject json = new JSONObject();
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
		Integer totalpage  = Integer.parseInt(request.getParameter("totalpage")) ;
		Integer displyCount  = Integer.parseInt(request.getParameter("displyCount")) ;
		int offset  = (currentPage - 1) * displyCount; 
		
		System.out.println("输入的搜索关键词"+custName);
		
		PrintWriter pw = response.getWriter(); 
		CustomerService  custService = new CustomerServiceImpl();
		Map<String, Object> result = custService.search(custName,offset,displyCount);
		json.putAll(result);
		pw.println(json);
		pw.flush();
		pw.close();
	}



}
