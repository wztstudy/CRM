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

import com.cc.service.CustomerPlanService;
import com.cc.service.impl.CustomerPlanServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


/**
 * 客户发展计划servlet
 * @author 黄恒愉
 *
 */
public class CustomerPlanServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username  = request.getParameter("username");
        username = username == null ? "" : username;
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
		//Integer totalpage  = Integer.parseInt(request.getParameter("totalpage")) ;
		Integer displyCount  = Integer.parseInt(request.getParameter("displyCount")) ;
		int offset = (currentPage-1)*displyCount;
		CustomerPlanService cps = new CustomerPlanServiceImpl();
		PrintWriter pw = response.getWriter();
		JSONObject json = new JSONObject();
		Map<String, Object> result = cps.search(username, offset, displyCount);
		json.putAll(result);
		pw.print(json);
		//System.out.println(jsonArr);
		pw.flush();
		pw.close();
		//System.out.println(username);
	}

}