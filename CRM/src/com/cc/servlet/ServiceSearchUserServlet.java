package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.User;
import com.cc.service.ServiceService;
import com.cc.service.impl.ServiceServiceImpl;

import net.sf.json.JSONObject;

public class ServiceSearchUserServlet extends HttpServlet{

	ServiceService ss = new ServiceServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		System.out.println("--------");
		System.out.println(name);
		PrintWriter pw = resp.getWriter();
		JSONObject json = new JSONObject();
		if(name == null || "".equals(name)) {
			pw.println(json.put("users",null));
		}
		List<User> list = ss.searchUsers(name);
		list.forEach(s->System.out.println(s));
		json.put("users", list);
		resp.getWriter().print(json);
	}
}
