package com.cc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.Faq;
import com.cc.model.User;
import com.cc.service.FaqService;
import com.cc.service.impl.FaqServiceImpl;

public class AddFaqServlet extends HttpServlet{

	FaqService fs = new FaqServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		User user = (User) req.getSession().getAttribute("user");
		Faq faq = new Faq();
		faq.setTitle(title);
		faq.setContent(content);
		faq.setUserID(user.getId());
		String tips = fs.addFaq(faq);
		resp.getWriter().print(tips);
	}
}
