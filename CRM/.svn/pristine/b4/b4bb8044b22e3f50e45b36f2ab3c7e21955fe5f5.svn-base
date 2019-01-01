package com.cc.dao.impl;

import java.util.List;
import java.util.Map;

import com.cc.dao.CustomerCareDao;
import com.cc.model.CustomerCarere;
import com.cc.util.JDBC;

public class CustomerCareDaoImpl implements CustomerCareDao {
//public static void main(String[] args) {
//	CustomerCareDaoImpl dd = new CustomerCareDaoImpl();
//	dd.getCustomerCare("白", 1, 1).forEach(a->System.out.println(a));
//  }
	@Override
	public List<Map> getCustomerCare(String cname, int offset, int displyCount) {
		String sql = " SELECT DISTINCT u.`name`, c.`name`, cr.title,cr.content,cr.time,cm.time FROM carerecord cr,careremind cm,customer c,`user` u WHERE cr.id=cm.id AND  c.id=cr.customerID AND c.userID=u.id  ";
		if(cname != null && !"".equals(cname)) {
			sql += " and c.name like '%"+cname+"%' ";
		}
		sql += " ORDER BY cm.time DESC LIMIT "+offset+", "+displyCount;
		return JDBC.freeQuery(sql);
	}

	@Override
	public int getCount(String cname) {
		String sql = " SELECT count(*) FROM carerecord cr,careremind cm,customer c,`user` u WHERE cr.id=cm.id AND  c.id=cr.customerID AND c.userID=u.id  ";
		if(cname != null && !"".equals(cname)) {
			sql += " and c.name like '%"+cname+"%' ";
		}
		
		return JDBC.getCount(sql);
	}

}
