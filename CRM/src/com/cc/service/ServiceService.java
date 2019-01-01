package com.cc.service;

import java.util.List;
import java.util.Map;

import com.cc.model.Server;
import com.cc.model.User;

/**
 * 服务管理的服务层
 * @author	王志涛
 * @date	2018-12-12
 * @version	1.0
 */
public interface ServiceService {

	/**
	 * 查看所有服务信息
	 * @param userName查询条件用户姓名
	 * @param offset分页偏移量
	 * @param showCount分页每页展示数目
	 * @return
	 */
	Map<String, Object> getServiceInfo(String userName,int offset,int showCount);
	
	/**
	 * 保存服务
	 */
	String saveService(Server service);
	
	Map<String, String> serviceBack(int id);
	
	String modifyService(Server service);
	
	String deleteService(int[] ids);
	
	List<User> searchUsers(String name);
	
	String allotService(String name,int[] ids);
}
