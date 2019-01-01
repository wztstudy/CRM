package com.cc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.FaqService;
import com.cc.service.impl.FaqServiceImpl;

import net.sf.json.JSONObject;

public class FaqSearchServlet extends HttpServlet{

	FaqService fs = new FaqServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		int currentPage = Integer.parseInt(req.getParameter("currentPage"));
		int showCount = Integer.parseInt(req.getParameter("showCount"));
		int offset = (currentPage -1)* showCount;
		Map<String, Object> map = fs.getFaqInfo(title, offset, showCount);
		JSONObject json = new JSONObject();
		json.putAll(map);
		resp.getWriter().print(json);
	}
}
