package com.cc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cc.dao.FaqDao;
import com.cc.model.Faq;
import com.cc.model.Server;
import com.cc.util.JDBC;

public class FaqDaoImpl implements FaqDao{

	@Override
	public List<Faq> getFaqInfo(String title, int offset, int showCount) {
		String sql = "SELECT a.id,a.recordTime,a.title,a.content,b.`name` FROM faq a,`user` b WHERE a.userID=b.id AND 1=1 ";
		List<String> list = new ArrayList<>();
		if(title != null && !"".equals(title)) {
			sql += " AND a.title like ?";
			list.add("%"+title+"%");
		}
		sql += " ORDER BY a.recordTime DESC LIMIT "+offset+","+showCount;
		return JDBC.query(sql, Faq.class, list.toArray());
	}

	@Override
	public int getTotal(String title) {
		String sql = "SELECT COUNT(*) FROM faq a,`user` b WHERE a.userID=b.id AND 1=1";
		List<String> list = new ArrayList<>();
		if(title != null && !"".equals(title)) {
			sql += " AND a.title like ?";
			list.add("%"+title+"%");
		}
		return JDBC.getCount(sql, list.toArray());
	}

	@Override
	public int addFaq(Faq faq) {
		String title = faq.getTitle();
		String content = faq.getContent();
		int userID = faq.getUserID();
		String sql = "INSERT INTO faq(recordTime,title,content,userID) VALUES(NOW(),?,?,?)";
		return JDBC.update(sql,title,content,userID);
	}

	@Override
	public int modify(String title, String content,int id) {
		String sql = "UPDATE faq SET title=?,content=? WHERE id=?";
		return JDBC.update(sql, title,content,id);
	}

	@Override
	public int delete(int[] ids) {
		String sql = "DELETE a FROM faq a WHERE a.id in (";
		for(int i=0; i<ids.length; i++) {
			sql += ids[i] +",";
		}
		sql = sql.substring(0,sql.length()-1) + ")";
		System.out.println(sql);
		return JDBC.update(sql);
	}

	
}
