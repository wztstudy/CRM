//package com.cc.util;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PushbackInputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.POIXMLDocument;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
//public class ExcelOrder {
//	private static final String USERNAME = "账号";
//	private static final String SEX = "性别";
//	private static final String PHONE = "电话";
//	private static final String ADDRESS = "地址";
//	private static final String AGE = "年龄";
//	private static final String SALARY = "工资";
//	private static final String PROFESSION = "职业";
//	private static final String SCHOOL = "学校";
//	private static final String EMAIL = "邮箱";
//	
//	public static void main(String[] args) throws IOException {
//		try {
//			FileInputStream fis = new FileInputStream("d:/test1.xls");
//			
//			List<Customer> Customers = readExcel(fis);
//			for(int i=0; i<Customers.size(); i++){
//				Customers.get(i).show();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		List<Customer> Customers = new ArrayList<>();
//		for(int i=0; i<10; i++){
//			Customer Customer = new Customer();
//			Customer.setListener("listener"+i);
//			Customer.setTime(new Date());
//			Customer.setTeacher("teacher"+i);
//			Customers.add(Customer);
//		}
//		FileOutputStream fos = new FileOutputStream(new File("D:/test2.xlsx"));
//		writeExcel(Customers, fos);
//	}
//
//	public static List<Customer> readExcel(InputStream is) {
//		List<Customer> Customers = new ArrayList<>();
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
//			} else throw new Exception("不支持的Excel版本ʽ");
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
//				Customer Customer = new Customer();
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
//						} else {
//							value = cell.getNumericCellValue();
//						}
//					} else if(type == Cell.CELL_TYPE_BOOLEAN){
//						value = cell.getBooleanCellValue();
//					}
//					switch (titleMap.get(n)) {
//					case USERNAME:
//						Customer.setUsername(value.toString());
//						break;
//					case SEX:
//						Customer.setSex(value.toString());
//						break;
//					case PHONE:
//						Customer.setPhone(value.toString());
//						break;
//					case ADDRESS:
//						Customer.setAddress(value.toString());
//						break;
//					case AGE:
//						String age = value.toString();
//						Customer.setAge(Integer.parseInt(age.substring(0,age.indexOf("."))));
//						break;
//					case SALARY:
//						String sal = value.toString();
//						Customer.setSalary(Integer.parseInt(sal.substring(0,sal.indexOf("."))));
//						break;
//					case PROFESSION:
//						Customer.setProfession(value.toString());
//						break;
//					case SCHOOL:
//						Customer.setSchool(value.toString());
//						break;
//					case EMAIL:
//						Customer.setEmail(value.toString());
//						break;
//						
//					}
//				}
//				Customers.add(Customer);
//			}
//		}
//		return Customers;
//	}
//	
//	
//	public static void writeExcel(List<Customer> Customers, OutputStream os){
//		Workbook book = new XSSFWorkbook();
//		Sheet sheet = book.createSheet("用户信息");
//		Row titleRow = sheet.createRow(0);
//
//		Cell cell = titleRow.createCell(0, Cell.CELL_TYPE_STRING);
//		cell.setCellValue(USERNAME);
//		cell = titleRow.createCell(1, Cell.CELL_TYPE_STRING);
//		cell.setCellValue(SEX);
//		cell = titleRow.createCell(2, Cell.CELL_TYPE_NUMERIC);
//		cell.setCellValue(PHONE);
//		cell = titleRow.createCell(3, Cell.CELL_TYPE_STRING);
//		cell.setCellValue(ADDRESS);
//		cell = titleRow.createCell(4, Cell.CELL_TYPE_NUMERIC);
//		cell.setCellValue(AGE);
//		cell = titleRow.createCell(5, Cell.CELL_TYPE_NUMERIC);
//		cell.setCellValue(SALARY);
//		cell = titleRow.createCell(6, Cell.CELL_TYPE_STRING);
//		cell.setCellValue(PROFESSION);
//		cell = titleRow.createCell(7, Cell.CELL_TYPE_STRING);
//		cell.setCellValue(SCHOOL);
//		cell = titleRow.createCell(8, Cell.CELL_TYPE_STRING);
//		cell.setCellValue(EMAIL);
//		for(int i=0; i<Customers.size(); i++){
//			Customer m = Customers.get(i);
//			Row row = sheet.createRow(i+1);
//			Cell c = row.createCell(0, Cell.CELL_TYPE_STRING);
//			c.setCellValue(m.getUsername());
//			c = row.createCell(1, Cell.CELL_TYPE_STRING);
//			c.setCellValue(m.getSex());
//			c = row.createCell(2, Cell.CELL_TYPE_NUMERIC);
//			c.setCellValue(m.getPhone());
//			c = row.createCell(3, Cell.CELL_TYPE_STRING);
//			c.setCellValue(m.getAddress());
//			c = row.createCell(4, Cell.CELL_TYPE_NUMERIC);
//			c.setCellValue(m.getAge());
//			c = row.createCell(5, Cell.CELL_TYPE_NUMERIC);
//			c.setCellValue(m.getSalary());
//			c = row.createCell(6, Cell.CELL_TYPE_STRING);
//			c.setCellValue(m.getProfession());
//			c = row.createCell(7, Cell.CELL_TYPE_STRING);
//			c.setCellValue(m.getSchool());
//			c = row.createCell(8, Cell.CELL_TYPE_STRING);
//			c.setCellValue(m.getEmail());
//		}
//		try {
//			book.write(os);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				os.close();
//				book.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
//	
//}
