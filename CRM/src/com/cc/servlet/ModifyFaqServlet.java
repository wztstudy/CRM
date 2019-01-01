package com.cc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.FaqService;
import com.cc.service.impl.FaqServiceImpl;

public class ModifyFaqServlet extends HttpServlet{

	FaqService fs = new FaqServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int id = Integer.parseInt(req.getParameter("id"));
		String tips = fs.modifyFaq(title, content, id);
		resp.getWriter().print(tips);
		
	}
}
