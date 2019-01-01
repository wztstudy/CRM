package com.cc.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.service.CustomerValueService;
import com.cc.service.impl.CustomerValueServiceImpl;
import com.cc.util.CustomerValueExcelUtil;



public class CustomerDataTransferServlet extends HttpServlet {

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("执行导出功能");
//		String filename = "客户价值分析.xlsx";
//		response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\"");
//		OutputStream os = response.getOutputStream();
//		CustomerValueService  cvs = new CustomerValueServiceImpl();
//		CustomerValueExcelUtil.writeExcel(cvs.getCustValue("", 0, 10), os);
//		System.out.println("导出完成");
//		os.flush();
//		os.close();
//		return;
//	}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("get执行导出功能");
    	Date date = new Date(System.currentTimeMillis());
    	SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String filename = "客户价值分析"+sdf.format(date)+".xlsx";
		
		resp.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\"");
		OutputStream os = resp.getOutputStream();
		CustomerValueService  cvs = new CustomerValueServiceImpl();
		CustomerValueExcelUtil.writeExcel(cvs.getCustValue("", 0, 0), os);
		System.out.println("导出完成");
		os.flush();
		os.close();
		return;
    }

}
