package com.cc.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.OrderService;
import com.cc.service.impl.OrderServiceImpl;


public class ExportOrderStatistics extends HttpServlet{

	OrderService os = new OrderServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		String fileName = "订单分析"+time+".xls";
		resp.setHeader("Content-Disposition","attachment;fileName=\""+ URLEncoder.encode(fileName, "UTF-8")+"\"");
//		ps.queryAll().forEach(s->System.out.println());
//		ExcelOrder.writeExcel(os.queryAll(),resp.getOutputStream());
	}
}
