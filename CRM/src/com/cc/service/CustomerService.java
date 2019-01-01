package com.cc.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cc.model.Customer;

/**
 * 客户服务层接口
 * @author 黄恒愉
 *
 */
public interface CustomerService {
	 /**
	  * 查找客户信息
	  * @param custName 客户名
	  * @return
	  */
       Map<String,Object> search(String custName ,Integer offset, Integer displyCount);
       boolean addCustomerData(String name,int sex,int userID,String birthday,String mobile,String type,String address,int credit,int satisfy);
       boolean updateCustomerData(String name,int sex,String birthday,String mobile,String type,String address,int credit,int satisfy,int custID);
       boolean assignCustomer(String username,String[] custIDs);
       List<Object> getUsers(String uaername);
}
