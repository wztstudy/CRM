package com.cc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.ServiceService;
import com.cc.service.impl.ServiceServiceImpl;

import net.sf.json.JSONObject;

public class ServiceBackServlet extends HttpServlet{

	ServiceService ss = new ServiceServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Map<String, String> map = ss.serviceBack(id);
		JSONObject json = new JSONObject();
		json.putAll(map);
		resp.getWriter().print(json);
		
	}
}
