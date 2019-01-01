package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.User;
import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;

public class SaveThemeServlet extends HttpServlet{
	
	private LoginService ls = new LoginServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String color = req.getParameter("color");
		PrintWriter pw = resp.getWriter();
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			pw.println("登录超时,请重新登录");
			pw.flush();
			pw.close();
			return;
		}
		user.setThemeColor(color);
		boolean isSuccess = ls.updateUserInfo(user);
		String result = "未知错误请联系管理员";
		if (isSuccess) {
			result = "设置成功";
		}else {
			result = "设置失败";
		}
		pw.print(result);
		pw.flush();
		pw.close();
	}
	
}
