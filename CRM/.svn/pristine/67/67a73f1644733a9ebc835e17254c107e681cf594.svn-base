package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.User;
import com.cc.service.CustomerService;
import com.cc.service.impl.CustomerServiceImpl;


/**
 * 客户信息添加
 * @author 黄恒愉
 *
 */
public class CustomerUpdateServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		 String birthday = request.getParameter("birthday");
		 String type = request.getParameter("type");
		 String address = request.getParameter("address");
		 String mobile = request.getParameter("mobile");
		
		 Integer satisfy = 60;
		 Integer credit  = 60;
		 Integer sex  = 1;
		 Integer custID = 0;
		 String meg = "操作未能成功";
		 try {
			  custID = Integer.parseInt(request.getParameter("id"));
		 }catch (Exception e) {
			  custID = 0;
		 }
		 try {
			 sex = Integer.parseInt(request.getParameter("sex"));
		 }catch (Exception e) {
			 sex = 1;
		 }
		try {
			  satisfy = Integer.parseInt(request.getParameter("satisfy"));
			  satisfy = satisfy > 100 ? 100 : satisfy;
		}catch (Exception e) {
			 satisfy = 60;
		}
		try {
			credit = Integer.parseInt(request.getParameter("credit"));
			credit = credit > 100 ? 100 : credit;
		}catch (Exception e) {
			credit = 60;
		}
		CustomerService cs = new CustomerServiceImpl();
	  //判断是添加还是修改
		if(custID > 0) { //修改客户
			boolean  isOk = cs.updateCustomerData(name, sex, birthday, mobile, type, address, credit, satisfy,custID);
				meg = isOk ? "修改成功" : "修改失败";
				
		}else { //添加客户
			User user =  (User) request.getSession().getAttribute("user");
			System.out.println(user);
			int userID = user.getId();
			boolean  isOk = cs.addCustomerData(name, sex, userID, birthday, mobile, type, address, credit, satisfy);
			meg = isOk ? "添加成功" : "添加失败";
		} 

		PrintWriter pw = response.getWriter();
		pw.print(meg);
	}

}
