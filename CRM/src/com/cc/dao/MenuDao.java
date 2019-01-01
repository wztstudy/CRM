package com.cc.dao;

import java.util.List;

import com.cc.model.Menu;

public interface MenuDao {

     List<Menu> getMenus(int id);
     List<Menu> getChildMenus(int parentID,int id);


}
