package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cc.service.CustomerCareService;
import com.cc.service.CustomerPlanService;
import com.cc.service.impl.CustomerCareServiceImpl;
import com.cc.service.impl.CustomerPlanServiceImpl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


public class CustCareServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname  = request.getParameter("username");
        cname = cname == null ? "" : cname;
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
		Integer displyCount  = Integer.parseInt(request.getParameter("displyCount")) ;
		int offset = (currentPage-1)*displyCount;
		CustomerCareService  ccs = new CustomerCareServiceImpl();
		PrintWriter pw = response.getWriter();
		JSONObject json = new JSONObject();
		Map<String, Object> result = ccs.getCustomerCare(cname, offset, displyCount);
		json.putAll(result);
		pw.print(json);
		pw.flush();
		pw.close();
	}

}