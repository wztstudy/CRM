package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;

import com.cc.service.CustomerService;
import com.cc.service.impl.CustomerServiceImpl;

import net.sf.json.JSONObject;


public class CustGetUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		CustomerService  cs = new CustomerServiceImpl();
		List<Object> users = cs.getUsers(username);
		System.out.println(users);
		JSONObject json = new JSONObject();
		json.put("users", users);
		PrintWriter pw = response.getWriter();
		pw.print(json);
	}

}
