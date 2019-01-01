package com.cc.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cc.model.CustValueDataModel;



public class CustomerValueExcelUtil {
	//客户姓名	客户类型	客户信誉度	客户满意度	价值分析结果
	private static final String TITLE_NAME = "客户姓名";
	private static final String TITLE_TYPE = "客户类型";
	private static final String TITLE_CREDIT = "客户信誉度";
	private static final String TITLE_SATISFY = "客户满意度";
	private static final String TITLE_VALUE = "价值分析结果";

	
	public static void main(String[] args) throws IOException {
//     InputStream is = new FileInputStream(new File("E:\\空气质量监管.xlsx"));
//		List<CustValueDataModel> models = readExcel( is);
//		models.forEach(a->{
//			System.out.println(a);
//		});
//		List<Worker> models = new ArrayList<>();
//		for(int i=0; i<10; i++){
//			Worker model = new Worker();
//		
//		}
//		FileOutputStream fos = new FileOutputStream(new File("D:/test2.xlsx"));
		//writeExcel(models, fos);
	}

//	public static List<CustValueDataModel> readExcel(InputStream is) {
//		List<CustValueDataModel> workers = new ArrayList<>();
//		//工作簿
//		Workbook book = null;
//		try {
//			if(!is.markSupported()){//如果流不支持标记
//				is = new PushbackInputStream(is, 8);
//			}
//			if(POIXMLDocument.hasOOXMLHeader(is)){
//				book = new XSSFWorkbook(is);//office2003以上版本
//			} else if(POIFSFileSystem.hasPOIFSHeader(is)){
//				book = new HSSFWorkbook(is);//office2003以下版本
//			} else throw new Exception("无法解析的Excel格式");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//获取sheet的数量
//		int sheetCount = book.getNumberOfSheets();
//		for(int i=0; i<sheetCount; i++){
//			//获取指定位置的sheet
//			Sheet sheet = book.getSheetAt(i);
//			//获取最后一行行号，也就是总行数
//			int rowNum = sheet.getLastRowNum();
//			//获取第一行作为标题行
//			Row titleRow = sheet.getRow(0);
//			Map<Integer, String> titleMap = new HashMap<>();
//			for(int m=0; m<titleRow.getLastCellNum(); m++){
//				Cell cell = titleRow.getCell(m);
//				titleMap.put(m,cell.getStringCellValue());
//			}
//			//从第一行开始，循环解析每一行数据
//			for(int j=1; j<=rowNum; j++){
//				//获取指定位置的行
//				Row row = sheet.getRow(j);
//				CustValueDataModel dataModel = new CustValueDataModel();
//				//循环解析每一列数据
//				for(int n=0; n < row.getLastCellNum(); n++){
//					//获取指定位置的单元格
//					Cell cell = row.getCell(n);
//					//获取单元格数据类型
//					int type = cell.getCellType();
//					Object value = null;
//					if(type == Cell.CELL_TYPE_STRING){
//						value = cell.getStringCellValue();
//					} else if(type == Cell.CELL_TYPE_NUMERIC){
//						if(DateUtil.isCellDateFormatted(cell)){
//							value = cell.getDateCellValue();
//							SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd");
//							value = slf.format(value);
//						} else {
//							value = cell.getNumericCellValue();
//							NumberFormat format = NumberFormat.getInstance();
//							format.setGroupingUsed(false);//去掉千分位
//							value = format.format(value);
//						}
//					} else if(type == Cell.CELL_TYPE_BOOLEAN){
//						value = cell.getBooleanCellValue();
//					}
//
//					switch (titleMap.get(n)) {
//					case TITLE_NAME: 
//						dataModel.setName((String) value);
//						break;
//					case TITLE_MONITOR_TIME:
//						dataModel.setMonitor_time((String) value);;
//						break;
//					case TITLE_TYPE:
//						int pm10 = Integer.parseInt((String) value);
//						dataModel.setPm10(pm10);;
//						break;
//					case TITLE_CREDIT:
//						int pm25 = Integer.parseInt((String) value);
//						dataModel.setPm25(pm25);
//						break;
//					case TITLE_SATISFY:
//						dataModel.setMonitor_station((String) value);
//						break;
//					case TITLE_VALUE:
//						dataModel.setLast_modify_time((String) value);
//						break;
//					  }
//				}
//				workers.add(dataModel);
//			}
//		}
//		return workers;
//	}
//	
	
	public static void writeExcel(List<CustValueDataModel> models, OutputStream os){
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("数据测试");
		System.out.println("进来啦----------------------------------------------------");
		Row titleRow = sheet.createRow(0);
		Cell cell = titleRow.createCell(0, Cell.CELL_TYPE_STRING);
		cell.setCellValue(TITLE_NAME);
		cell = titleRow.createCell(1, Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(TITLE_TYPE);
		//-----------------------------------
		cell = titleRow.createCell(2, Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(TITLE_CREDIT);
		cell = titleRow.createCell(3, Cell.CELL_TYPE_STRING);
		cell.setCellValue(TITLE_SATISFY);
		cell = titleRow.createCell(4, Cell.CELL_TYPE_STRING);
		cell.setCellValue(TITLE_VALUE);
		
		for(int i=0; i<models.size(); i++){
			CustValueDataModel m = models.get(i);
			Row row = sheet.createRow(i+1);
			Cell c = row.createCell(0, Cell.CELL_TYPE_STRING);
			c.setCellValue(m.getName());
			c = row.createCell(1, Cell.CELL_TYPE_STRING);
			c.setCellValue(m.getType());
			c = row.createCell(2, Cell.CELL_TYPE_STRING);
			c.setCellValue(m.getCredit());
			c = row.createCell(3, Cell.CELL_TYPE_STRING);
			c.setCellValue(m.getSatisfy());
			c = row.createCell(4, Cell.CELL_TYPE_STRING);
			c.setCellValue(m.getValue());
		}
		try {
			book.write(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				book.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
