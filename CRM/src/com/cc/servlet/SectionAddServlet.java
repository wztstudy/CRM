package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;

public class SectionAddServlet extends HttpServlet{

	private LoginService ls = new LoginServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		PrintWriter pw = resp.getWriter();
		if (name == null || "".equals(name.trim())) {
			pw.print("部门名称不能为空");
			pw.flush();
			pw.close();
			return;
		}
		boolean isSuccess = ls.addSection(name);
		String result = "未知错误，请联系管理员";
	     if (isSuccess) {
	    	 result = "创建成功";
	     }else {
	    	 result = "创建失败";
	     }
		 pw.print(result);
		 pw.flush();
		 pw.close();
	}
	
}
