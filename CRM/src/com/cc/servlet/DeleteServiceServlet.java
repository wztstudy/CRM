package com.cc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.tribes.util.Arrays;
import com.cc.service.ServiceService;
import com.cc.service.impl.ServiceServiceImpl;


public class DeleteServiceServlet extends HttpServlet{

	ServiceService ss= new ServiceServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("66666666666");
		String[] array = req.getParameterValues("deleteData");
		int[] ids = new int[array.length];
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			ids[i] = Integer.parseInt(array[i]);
		}
		String tips = ss.deleteService(ids);
		resp.getWriter().print(tips);
	}
}
