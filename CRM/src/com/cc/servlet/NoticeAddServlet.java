package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.Notice;
import com.cc.model.User;
import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;

public class NoticeAddServlet extends HttpServlet{

	private LoginService ls = new LoginServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String content = req.getParameter("content");
		PrintWriter pw = resp.getWriter();
		if (content == null || "".equals(content.trim())) {
			pw.print("公告内容不能为空");
			pw.flush();
			pw.close();
			return;
		}
		User user = (User) req.getSession().getAttribute("user");
		Notice addNotice = new Notice();
		addNotice.setContent(content);
		addNotice.setUserID(user.getId());
		boolean isSuccess = ls.addNotice(addNotice);
		String result = "未知错误，请联系管理员";
	     if (isSuccess) {
	    	 result = "发布成功";
	     }else {
	    	 result = "发布失败";
	     }
		 pw.print(result);
		 pw.flush();
		 pw.close();
	}
	
}
