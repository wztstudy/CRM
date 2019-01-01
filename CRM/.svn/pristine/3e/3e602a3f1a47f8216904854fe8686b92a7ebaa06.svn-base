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

public class ServiceSearchServlet extends HttpServlet{

	ServiceService ss = new ServiceServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		int currentPage = Integer.parseInt(req.getParameter("currentPage"));
		int showCount = Integer.parseInt(req.getParameter("showCount"));
		int offset = (currentPage -1)* showCount;
		Map<String, Object> map = ss.getServiceInfo(userName, offset, showCount);
		JSONObject json = new JSONObject();
		json.putAll(map);
		resp.getWriter().print(json);
	}
}
