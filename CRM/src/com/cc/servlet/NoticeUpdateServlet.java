package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.Notice;
import com.cc.service.LoginService;
import com.cc.service.impl.LoginServiceImpl;

public class NoticeUpdateServlet extends HttpServlet{
	
	private LoginService ls = new LoginServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String content = req.getParameter("content");
		Integer id = Integer.parseInt(req.getParameter("id"));
		PrintWriter pw = resp.getWriter();
		if (content == null || "".equals(content.trim())) {
			pw.print("公告内容不能为空");
			pw.flush();
			pw.close();
			return;
		}
		Notice updateNotice = new Notice();
		updateNotice.setId(id);
		updateNotice.setContent(content);
		boolean isSuccess = ls.updateNotice(updateNotice);
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
