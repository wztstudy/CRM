package com.cc.dao;

import java.util.List;

import com.cc.model.Customer;

/**
 * 客户DAO层
 * @author 黄恒愉
 *
 */
public interface CustomerDao {
    List<Customer> search(String custName,Integer offset, Integer displyCount);
    int getAge(String birthday);
    int getCount(String custName,Integer offset,Integer displyCount);
    int addCustomerData(String name,int userID, int sex,  String birthday, String type,String mobile, String address, int credit,int satisfy); 
    int updateCustomerData(String name,int sex,String birthday,String mobile,String type,String address,int credit,int satisfy,int custID);
    int assignCustomer(String username,String[] custIDs);
    List<Object> getUsers(String uaername);
}
