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

import net.sf.json.JSONObject;

public class PersonCenterInfoUpdateServlet extends HttpServlet{
	
	private  LoginService ls = new LoginServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	     resp.setCharacterEncoding("utf-8");
	     String mobile = req.getParameter("mobile");
	     String section = req.getParameter("section");
	     String role =  req.getParameter("role");
	     String address = req.getParameter("address");
	     PrintWriter pw = resp.getWriter();
	     if (section == null || section.trim().length() == 0 || role == null || role.trim().length() == 0) {
			pw.print("部门或职位不能为空");
			pw.flush();
			pw.close();
			return;
		 }
	     User oldUser = (User) req.getSession().getAttribute("user");
	     User newUser = new User();
	     newUser = oldUser;
	     newUser.setMobile(mobile);
	     newUser.setSection(section);
	     newUser.setRole(role);
	     newUser.setAddress(address);
	     boolean isSuccess = ls.updateUserInfo(newUser);
	     String result = "未知错误，请联系管理员";
	     if (isSuccess) {
	    	 result = "更新信息成功";
	     }else {
	    	 result = "更新信息失败";
	     }
		 pw.print(result);
		 pw.flush();
		 pw.close();
	}
	
}
