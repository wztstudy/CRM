package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.User;
import com.cc.service.MenuService;
import com.cc.service.impl.MenuServiceImpl;

import net.sf.json.JSONObject;
public class MenuServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     request.setCharacterEncoding("utf-8");
		     response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
		JSONObject  json = new JSONObject();
		MenuService  ms = new MenuServiceImpl();
		User user = (User) request.getSession().getAttribute("user");
		json.putAll(ms.getMenu(user.getId()));
		pw.print(json);		
	}

}
