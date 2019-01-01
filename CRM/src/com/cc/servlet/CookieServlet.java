package com.cc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.model.TempUser;

import net.sf.json.JSONObject;

public class CookieServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	    resp.setCharacterEncoding("utf-8");
	    PrintWriter pw = resp.getWriter();
	    TempUser tempUser = new TempUser();
		Cookie[] cks = req.getCookies();
		if (cks != null){
			for (Cookie ck : cks){
				if ("username".equals(ck.getName())){
					tempUser.setUsername(ck.getValue());
					tempUser.setRemember(true);
				}
				if ("password".equals(ck.getName())){
					tempUser.setPassword(ck.getValue());
					tempUser.setRemember(true);
				}
			}
		}
		JSONObject json = new JSONObject();
		Map<String, TempUser> result = new HashMap<>();
		result.put("tempUser", tempUser);
		json.putAll(result);
		pw.print(json);
		pw.flush();
		pw.close();
	}
	
}
