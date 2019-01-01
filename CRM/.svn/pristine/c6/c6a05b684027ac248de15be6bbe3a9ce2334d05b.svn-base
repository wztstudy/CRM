package com.cc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.FaqService;
import com.cc.service.impl.FaqServiceImpl;

public class DeleteFaqServlet extends HttpServlet{

	FaqService fs = new FaqServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] chooseIds = req.getParameterValues("chooseIds");
		int[] ids = new int[chooseIds.length];
		for (int i = 0; i < chooseIds.length; i++) {
			ids[i] = Integer.parseInt(chooseIds[i]);
		}
		String tips = fs.deleteFaq(ids);
		resp.getWriter().print(tips);
	}
}
