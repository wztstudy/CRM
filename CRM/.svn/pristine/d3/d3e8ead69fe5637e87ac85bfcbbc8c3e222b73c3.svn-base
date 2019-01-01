package com.cc.dao.impl;

import java.util.List;

import com.cc.dao.CustomerValueDao;
import com.cc.model.CustValueDataModel;
import com.cc.util.JDBC;

public class CustomerValueDaoImpl implements CustomerValueDao {
public static void main(String[] args) {
	CustomerValueDaoImpl ss = new CustomerValueDaoImpl();
	ss.getCustValue("", 10, 5).forEach(a->System.out.println(a));
}
	@Override
	public List<CustValueDataModel> getCustValue(String custName, Integer offset, Integer displyCount) {
		String sql = "select name,type,credit,satisfy from Customer where 1=1 ";
		if(custName != null && !"".equals(custName)) {
			sql += " and  name LIKE '%"+custName+"%' ";
		}
		if(offset != null && displyCount != 0) {
			sql += " ORDER BY chanceID DESC LIMIT "+offset+", "+displyCount;
		}else {
			sql += " ORDER BY chanceID DESC  ";
		}
		
		return JDBC.query(sql, CustValueDataModel.class);
	}

}
