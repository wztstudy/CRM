package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.User;
import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private  LoginService ls = new LoginServiceImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	     String username = req.getParameter("username");
	     String password = req.getParameter("password");
	     String remember = req.getParameter("remember");
	     PrintWriter pw = resp.getWriter();
	     boolean isRemember = remember != null;
	     if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
			pw.print("账号或密码不能为空");
			pw.flush();
			pw.close();
			return;
		 }
	     String result = ls.login(username, password);
		 if ("登录成功".equals(result)) {
			User user = ls.getUser(username, password);
			req.getSession().setAttribute("user", user);
			req.getSession().setMaxInactiveInterval(1800);
			Cookie usernameCk = new Cookie("username",username);
			Cookie passwordCk = new Cookie("password",password);
			if (remember != null){
				usernameCk.setMaxAge(1800);
				passwordCk.setMaxAge(1800);
			}else{
				usernameCk.setMaxAge(0);
				passwordCk.setMaxAge(0);
			}
			resp.addCookie(usernameCk);
			resp.addCookie(passwordCk);
		 }
		 pw.print(result);
		 pw.flush();
		 pw.close();
	}

}
