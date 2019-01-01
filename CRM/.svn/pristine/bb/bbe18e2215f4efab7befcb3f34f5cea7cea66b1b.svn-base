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

public class CustomerPlanDeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] planIDs = request.getParameterValues("objsID");
		PrintWriter  pw = response.getWriter();
		if(planIDs == null){
			pw.print("你没有选择要删除的数据！");
			return;
		}
		System.out.println(planIDs[0]);
		CustomerPlanService cps = new CustomerPlanServiceImpl();
	
		int count = cps.deletePlanCustomer(planIDs);
		if(count > 0) {
			pw.print("删除成功："+count+"条 /删除 失败："+(planIDs.length-count-1));
		}else {
			pw.print("删除失败");
		}
	}

}
