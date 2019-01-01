package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.CustomerPlanService;
import com.cc.service.impl.CustomerPlanServiceImpl;

public class CustomerPlanAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            String planNum = request.getParameter("planNum");
            String planTime = request.getParameter("planTime").substring(0, 10);
            String userID = request.getParameter("id");
            PrintWriter  pw = response.getWriter();
            if( userID == null) {
            	pw.print("这个代表不是我们公司的！！");
            	return;
            }
           // System.out.println(userID+"\t"+name+"\t"+planNum+"\t"+planTime);
            CustomerPlanService cps = new CustomerPlanServiceImpl();
            boolean isOk = cps.addPlan(userID, planNum, planTime);
           
            if(isOk) {
            	pw.print("添加成功");
            }else {
            	pw.print("添加失败");
            }
	}

}
