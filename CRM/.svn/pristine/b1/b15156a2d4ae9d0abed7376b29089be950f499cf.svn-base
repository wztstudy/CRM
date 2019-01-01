package com.cc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.CustomerDao;
import com.cc.dao.impl.CustomerDaoImpl;
import com.cc.model.Customer;
import com.cc.service.CustomerService;

/**
 * 客户服务层实现类
 * @author 黄恒愉
 *
 */
public class CustomerServiceImpl implements CustomerService {
	CustomerDao cust = new CustomerDaoImpl();
	@Override
	public Map<String, Object> search(String custName,Integer offset, Integer displyCount) {
		Map<String, Object> result = new HashMap<>();
		
		List<Customer> custData = cust.search(custName, offset, displyCount);
		for(Customer c : custData) {
			Integer age = cust.getAge(c.getBirthday());
			age = age < 1 ? 1 : age;  //如果得到的年龄小于1，则默认1岁。
			c.setAge(age);
		}
		int count = cust.getCount(custName, offset, displyCount);
		int total = count % displyCount == 0 ?  count / displyCount : count / displyCount +1;
		result.put("custData", custData);
		result.put("count", count);
		result.put("total", total);
		return result;
	}
	  /**
	    * 增加客户信息
	    */
	@Override
	public boolean addCustomerData(String name, int sex,int userID, String birthday,String mobile, String type, String address, int credit,
			int satisfy) {
		return cust.addCustomerData(name, userID, sex, birthday, type, mobile, address, credit, satisfy) > 0;
	}
   /**
    * 修改客户信息
    */
	@Override
	public boolean updateCustomerData(String name, int sex,  String birthday, String mobile, String type,
			String address, int credit, int satisfy,int custID) {
	
		return cust.updateCustomerData(name, sex, birthday, mobile, type, address, credit, satisfy, custID) > 0;
	}
	/**
	 * 分配客户资源
	 */
	@Override
	public boolean assignCustomer(String username,String[] custIDs) {
		
		return  cust.assignCustomer( username, custIDs)  > 0;
	}
	/**
	 * 获取销售代表的名字和ID
	 */
	@Override
	public List<Object> getUsers(String uaername) {
		return cust.getUsers(uaername);
	}


    






}
