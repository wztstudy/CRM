package com.cc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.ServiceDao;
import com.cc.dao.impl.ServiceDaoImpl;
import com.cc.model.Server;
import com.cc.model.User;
import com.cc.service.ServiceService;

public class ServiceServiceImpl implements ServiceService{

	ServiceDao sd = new ServiceDaoImpl();
	
	@Override
	public Map<String, Object> getServiceInfo(String userName, int offset, int showCount) {
		List<Server> list = sd.getServiceInfo(userName, offset, showCount);
		Map<String, Object> map = new HashMap<>();
		int totalCount = sd.getTotal(userName);
		int totalPage = totalCount%showCount==0 ? totalCount/showCount : totalCount/showCount + 1;
		map.put("totalPage", totalPage);
		map.put("serviceInfo", list);
		return map;
	}

	@Override
	public String saveService(Server service) {
		int row = sd.addService(service);
		String tips ="";
		if(row > 1) {
			tips = "添加服务成功";
		}else {
			tips = "添加服务失败，请检查后再试";
		}
		return tips;
	}

	@Override
	public Map<String, String> serviceBack(int id) {
		Map<String, String> map = new HashMap<>();
		List list = sd.serviceBack(id);
		if(list.size() != 0) {
			Server sb = (Server) list.get(0);
			map.put("process", sb.getProcess());
			map.put("result", sb.getResult());
			map.put("back", sb.getContent());
		}
		return map;
	}

	@Override
	public String modifyService(Server service) {
		int row = sd.modifyService(service);
		String tips ="";
		if(row > 0) {
			tips = "修改服务成功";
		}else {
			tips = "修改服务失败，请检查后再试";
		}
		return tips;
	}

	@Override
	public String deleteService(int[] ids) {
		int row = sd.deleteService(ids);
		String tips ="";
		if(row > 0) {
			tips = "删除服务成功";
		}else {
			tips = "删除服务失败，请检查后再试";
		}
		return tips;
	}

	@Override
	public List<User> searchUsers(String name) {
		return sd.searchUsers(name);
	}

	@Override
	public String allotService(String name,int[] ids) {
		int row = sd.allotService(name,ids);
		String tips ="";
		if(row > 0) {
			tips = "分配服务成功";
		}else {
			tips = "分配服务失败，请检查后再试";
		}
		return tips;
	}

	
}
