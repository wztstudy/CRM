package com.cc.dao;

import java.util.List;
import com.cc.model.Server;
import com.cc.model.User;

public interface ServiceDao {

	/**
	 * 根据条件查询到的服务信息
	 * @param userName
	 * @param offset
	 * @param showCount
	 * @return
	 */
	List<Server> getServiceInfo(String userName,int offset,int showCount);
	
	/**
	 * 根据用户名查询数据记录条数
	 * @param userName
	 * @return
	 */
	int getTotal(String userName);
	
	/**
	 * 添加服务
	 * @param service
	 * @return
	 */
	int addService(Server service);
	
	List<Server> serviceBack(int id);
	
	int modifyService(Server service);
	
	int deleteService(int[] ids);
	
	List<User> searchUsers(String name);
	
	int allotService(String name,int[] ids);
}
