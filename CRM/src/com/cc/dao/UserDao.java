package com.cc.dao;

import java.util.List;

import com.cc.model.Notice;
import com.cc.model.Role;
import com.cc.model.Section;
import com.cc.model.User;

public interface UserDao {
      
      User getUser(String username, String password);

      int updateUserInfo(User user);
      
      List<Notice> getNotices(String content, int offset, int pageCount);
      
      int getNoticesTotal(String content);

	  int addNotice(Notice addNotice);

	  int updateNotice(Notice updateNotice);

	  int deleteNotice(Object[] ids);

	  List<Section> getSections(String name, int offset, int pageCount);

	  int getSectionsTotal(String name);

	  int addSection(String name);

	  int updateSection(String id, String name);

	  int deleteSection(Object[] ids);

	  List<User> getUsers(String name, int offset, int pageCount);

	  int getUsersTotal(String name);

	  int addUser(User user);

	  List<Role> getRoles(String name, int offset, int pageCount);

	  int getRolesTotal(String name);
      
}
