package com.cc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.Server;
import com.cc.service.ServiceService;
import com.cc.service.impl.ServiceServiceImpl;

public class ModifyServiceServlet extends HttpServlet{

	ServiceService ss = new ServiceServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Server service = new Server();
		service.setId(Integer.parseInt(req.getParameter("id")));
		System.out.println(Integer.parseInt(req.getParameter("id")));
		service.setValue(req.getParameter("status"));
		service.setServerContent(req.getParameter("serviceContent"));
		service.setProcess(req.getParameter("process"));
		service.setResult(req.getParameter("result"));
		service.setContent(req.getParameter("back"));
		String tips = ss.modifyService(service);
		resp.getWriter().print(tips);
	}
}
