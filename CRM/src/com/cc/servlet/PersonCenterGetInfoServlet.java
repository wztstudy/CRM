package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.User;
import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;

import net.sf.json.JSONObject;

public class PersonCenterGetInfoServlet extends HttpServlet{
	
	private LoginService ls = new LoginServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String content = req.getParameter("content");
	    PrintWriter pw = resp.getWriter();
	    User user = (User) req.getSession().getAttribute("user");
	    JSONObject json = new JSONObject();
	    Map<String, Object> result = ls.getNotices(content, 0, 10);
	    result.put("user", user);
	    json.putAll(result);
	    pw.print(json);
	    pw.flush();
	    pw.close();
	}
	
}
