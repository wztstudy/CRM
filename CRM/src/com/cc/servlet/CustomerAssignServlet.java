package com.cc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.CustomerService;
import com.cc.service.impl.CustomerServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 资源分配
 * @author 黄恒愉
 *
 */
public class CustomerAssignServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		//String arr = request.getParameter();
		String[]  custIDs = request.getParameterValues("custIDs");
		CustomerService  cs = new CustomerServiceImpl();
		System.out.println(username);
		System.out.println(custIDs[0]);
		cs.assignCustomer(username, custIDs);
//		CustomerService cs = new  CustomerServiceImpl();
//		boolean isOk = cs.assignCustomer(username, custID);
	}

}
