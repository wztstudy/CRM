package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;

import net.sf.json.JSONObject;

public class NoticeSearchServlet extends HttpServlet{
	
	private LoginService ls = new LoginServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String content = req.getParameter("content");
		PrintWriter pw = resp.getWriter();
		JSONObject json = new JSONObject();
		int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		int pageCount = Integer.valueOf(req.getParameter("pageCount"));
		int offset = (currentPage - 1) * pageCount;
		Map<String, Object> result = ls.getNotices(content, offset, pageCount);
		json.putAll(result);
		pw.print(json);
		pw.flush();
		pw.close();
	}
	
}
