package com.cc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.cc.dao.ServiceDao;
import com.cc.model.Server;
import com.cc.model.User;
import com.cc.util.JDBC;

public class ServiceDaoImpl implements ServiceDao{

	@Override
	public List<Server> getServiceInfo(String userName, int offset, int showCount) {
		String sql = "SELECT a.`name` userName,b.id,b.serverContent,b.`status`,c.`name` custName,d.`value` FROM `user` a,`server` b,customer c,dictionary d WHERE a.id=b.userID AND b.customerID=c.id AND b.`status`=d.`key` AND d.tableName='server'AND 1=1 ";
		List<String> list = new ArrayList<>();
		if(userName != null && !"".equals(userName)) {
			sql += " AND a.name like ?";
			list.add("%"+userName+"%");
		}
		sql += "LIMIT "+offset+","+showCount;
		return JDBC.query(sql, Server.class, list.toArray());
	}

	@Override
	public int getTotal(String userName) {
		String sql = "SELECT COUNT(*) FROM `user` a,`server` b,customer c,dictionary d WHERE a.id=b.userID AND b.customerID=c.id AND b.`status`=d.`key` AND d.tableName='server'AND 1=1";
		List<String> list = new ArrayList<>();
		if(userName != null && !"".equals(userName)) {
			sql += " AND a.name like ?";
			list.add("%"+userName+"%");
		}
		return JDBC.getCount(sql, list.toArray());
	}

	@Override
	public int addService(Server service) {
		String custName = service.getCustName();
		int userID = service.getUserID();
		String serviceContent = service.getServerContent();
		String sql1 = "INSERT INTO `server` (customerID,userID,serverContent) VALUES ( (SELECT a.id FROM customer a WHERE a.name =?),?,?)";
		int row1 = JDBC.update(sql1, custName,userID,serviceContent);
		String sql2 = "INSERT INTO serverback(serverID) VALUES((SELECT MAX(id) FROM `server`))";
		int row2 = JDBC.update(sql2);
		return row1+row2;
	}

	@Override
	public List<Server> serviceBack(int id) {
		String sql = "SELECT a.process,a.result,b.content FROM `server` a,serverback b WHERE a.id = b.serverID AND a.id=?";
		return JDBC.query(sql, Server.class, id);
	}

	@Override
	public int modifyService(Server service) {
		String sql = "UPDATE `server` a,serverback b SET a.`status`=(SELECT d.key FROM dictionary d WHERE d.value=? AND d.tableName='server'),a.serverContent=?,a.process=?,a.result=?,b.content=? WHERE a.id=b.serverID AND a.id=?";
		return JDBC.update(sql, service.getValue(),service.getServerContent(),service.getProcess(),service.getResult(),service.getContent(),service.getId());
	}

	@Override
	public int deleteService(int[] ids) {
		String sql = "DELETE a FROM `server` a WHERE a.id in (";
		for(int i=0; i<ids.length; i++) {
			sql += ids[i] +",";
		}
		sql = sql.substring(0,sql.length()-1) + ")";
		System.out.println(sql);
		return JDBC.update(sql);
	}

	@Override
	public List<User> searchUsers(String name) {
		String sql = "SELECT id,`name`,username FROM `user` WHERE `name` LIKE ? LIMIT 0,5";
//		String sql = "SELECT * FROM `user` WHERE `name` LIKE ? LIMIT 0,5";
		return JDBC.query(sql, User.class, "%"+name+"%");
	}

	@Override
	public int allotService(String name,int[] ids) {
		String sql = "UPDATE `server` a SET a.`status`=3 ,a.userID=(SELECT b.id FROM `user` b WHERE b.name=?) WHERE a.id in(";
		for(int i = 0; i<ids.length; i++) {
			sql += ids[i]+",";
		}
		sql = sql.substring(0,sql.length()-1) + ")" ;
		System.out.println(sql);
		return JDBC.update(sql,name);
	}

	
}
