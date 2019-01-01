package com.cc.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.ServiceService;
import com.cc.service.impl.ServiceServiceImpl;

public class AllotServiceServlet extends HttpServlet{

	ServiceService ss= new ServiceServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] array = req.getParameterValues("ids");
		int[] ids = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			ids[i] = Integer.parseInt(array[i]);
		}
		String name = req.getParameter("userName");
		String tips = ss.allotService(name, ids);
		resp.getWriter().print(tips);
	}
}
