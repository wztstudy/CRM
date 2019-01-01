package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;

public class SectionDeleteServlet extends HttpServlet{
	
	private LoginService ls = new LoginServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object[] ids = req.getParameterValues("ids");
		PrintWriter pw = resp.getWriter();
		boolean isSuccess = ls.deleteSection(ids);
		String result = "未知错误，请联系管理员";
	     if (isSuccess) {
	    	 result = "删除成功";
	     }else {
	    	 result = "删除失败";
	     }
		 pw.print(result);
		 pw.flush();
		 pw.close();
	}

}
