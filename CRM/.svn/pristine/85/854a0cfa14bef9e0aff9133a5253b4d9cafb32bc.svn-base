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

public class UserAddServlet extends HttpServlet{

	private LoginService ls = new LoginServiceImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		Integer sex = req.getParameter("sex") == "男" ? 1 : 2;
		Integer age = Integer.parseInt(req.getParameter("age"));
		String mobile = req.getParameter("mobile");
		String section = req.getParameter("section");
		String role = req.getParameter("role");
		Integer roleID = Integer.parseInt(req.getParameter("roleID"));
		String address = req.getParameter("address");
		Integer sectionID = Integer.parseInt(req.getParameter("sectionID"));
		PrintWriter pw = resp.getWriter();
		if (name == null || "".equals(name.trim())
			||username == null || "".equals(username.trim())
			||sex == null || sex == 0
			||age == null || age == 0
			||mobile == null || "".equals(mobile.trim())
			||section == null || "".equals(section.trim())
			||role == null || "".equals(role.trim())
			||address == null || "".equals(address.trim())) {
			pw.print("任一项不能为空");
			pw.flush();
			pw.close();
			return;
		}
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setSex(sex);
		user.setAge(age);
		user.setMobile(mobile);
		user.setSection(section);
		user.setRole(role);
		user.setAddress(address);
		user.setSectionID(sectionID);
		user.setRoleid(roleID);
		System.out.println(user.toString());
		boolean isSuccess = ls.addUser(user);
		String result = "未知错误，请联系管理员";
	     if (isSuccess) {
	    	 result = "添加成功";
	     }else {
	    	 result = "添加失败";
	     }
		 pw.print(result);
		 pw.flush();
		 pw.close();
	}
	
}

