package com.cc.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.JdbcInterceptor;

import com.cc.dao.CustomerPlanDao;
import com.cc.model.Customerplan;
import com.cc.util.JDBC;

public class CustomerPlanDaoImpl implements CustomerPlanDao {
//public static void main(String[] args) {
//	CustomerPlanDaoImpl cd = new CustomerPlanDaoImpl();
//	cd.search("吕", 0, 5).forEach(a->System.out.println(a));
//}
	@Override
	public List<Customerplan> search(String username, Integer offset, Integer displyCount) {
		String sql = "SELECT DISTINCT c.id,  u.`name` , c.planNum,c.planTime FROM `user` u,customerplan c WHERE u.id=c.userID AND u.`name` LIKE '%"+username+"%' ";
		sql+=" order by c.planTime limit "+offset+","+displyCount+" ";  //有时候可以反过来思考一下SQL语句的写法
		return JDBC.query(sql, Customerplan.class);
	}

	@Override
	public int getCount(String username, Integer offset, Integer displyCount) {
		String sql = "SELECT DISTINCT count(*) FROM `user` u,customerplan c WHERE u.id=c.userID AND u.`name` LIKE '%"+username+"%' ";
		return JDBC.getCount(sql);
	}

	@Override
	public int addPlan(String id, String planNum, String planTime) {
		String sql = "insert into customerplan values(null,?,?,?)";
		return JDBC.update(sql,planTime, planNum,id);
	}

	@Override
	public int deletePlanCustomer(String[] planIDs) {
		String sql = "DELETE FROM Customerplan WHERE id in (";
		for(int i=1,len=planIDs.length; i <= len;i++) {
			if(i==len) {
				sql+=" ? ";
			}else {
				sql+=" ?, ";
			}
		}
		sql += " )";
		return JDBC.update(sql, planIDs);
	}

}
