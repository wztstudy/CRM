package com.cc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.MenuDao;
import com.cc.dao.impl.MenuDaoImpl;
import com.cc.model.Menu;
import com.cc.service.MenuService;

public class MenuServiceImpl implements MenuService {

//	public static void main(String[] args) {
//		MenuDao  md = new MenuDaoImpl();
//		List<Menu> menus =	md.getMenus();
//		for (Menu m : menus) {
//			//System.out.println(m);
//			List<Menu> childs = md.getChildMenus(m.getId());
//			m.setChildMenu(childs);
//			//System.out.println(m);
//		}
//		
//		for (Menu m : menus) {
//			System.out.println(m);
//		}
//	}
	@Override

	public Map<String, Object> getMenu(int id) {

		Map<String, Object> result = new HashMap<String, Object>();
		List<Menu> menuAll = new ArrayList<>();
		MenuDao  md = new MenuDaoImpl();
		List<Menu> menus =	md.getMenus(id);

		for (Menu m : menus) {
			List<Menu> childs = md.getChildMenus(m.getId(),id);
			m.setChildMenu(childs);
		}
		result.put("menus", menus);
		return result;
	}

	

}
