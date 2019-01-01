package com.cc.dao.impl;

import java.util.List;

import com.cc.dao.MenuDao;
import com.cc.model.Menu;
import com.cc.util.JDBC;

public class MenuDaoImpl implements MenuDao {

	@Override
	public List<Menu> getMenus(int id) {
		String sql = "SELECT DISTINCT e.id,e.`name`,e.url,e.parentID,e.fontImag FROM `user` a, user_role b,role c,role_menu d,menu e WHERE a.id=b.userID AND b.roleID=c.id AND c.id=d.roleID AND d.menuID=e.id AND e.parentID is null AND a.id=?";
		return JDBC.query(sql, Menu.class,id);

	}
	@Override

	public List<Menu> getChildMenus(int parentID,int id) {
		String sql = "SELECT DISTINCT e.id,e.`name`,e.url,e.parentID,e.fontImag FROM `user` a, user_role b,role c,role_menu d,menu e WHERE a.id=b.userID AND b.roleID=c.id AND c.id=d.roleID AND d.menuID=e.id AND e.parentID=? AND a.id=?";
		return JDBC.query(sql, Menu.class,parentID,id);

	}

	


}
