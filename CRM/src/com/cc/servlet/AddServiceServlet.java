package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.Server;
import com.cc.model.User;
import com.cc.service.ServiceService;
import com.cc.service.impl.ServiceServiceImpl;

public class AddServiceServlet extends HttpServlet{

	ServiceService ss = new ServiceServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custName = req.getParameter("custName");
		PrintWriter pw = resp.getWriter();
		if(custName == null) {
			pw.print("没有该客户信息，请先添加客户");
			return;
		}
		String serviceContent = req.getParameter("serviceContent");
		User user = (User) req.getSession().getAttribute("user");
		int userID = user.getId();//正在使用该系统的用户id
		System.out.println(userID);
		Server service = new Server();
		service.setCustName(custName);
		service.setUserID(userID);
		service.setServerContent(serviceContent);
		String tips = ss.saveService(service);
		resp.getWriter().print(tips);
	}
}
