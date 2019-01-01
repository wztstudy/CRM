package com.cc.service;

import java.util.List;
import java.util.Map;

import com.cc.model.Notice;
import com.cc.model.User;

public interface LoginService {
	
       String login(String username,String password);
       
       User getUser(String username,String password);
       
       boolean updateUserInfo(User user);

	   Map<String, Object> getNotices(String content, int offset, int pageCount);

	   boolean addNotice(Notice addNotice);

	   boolean updateNotice(Notice updateNotice);

	   boolean deleteNotice(Object[] ids);

	   Map<String, Object> getSections(String name, int offset, int pageCount);

	   boolean addSection(String name);

	   boolean updateSection(String id, String name);

	   boolean deleteSection(Object[] ids);

	   Map<String, Object> getUsers(String name, int offset, int pageCount);

	   boolean addUser(User user);

	   Map<String, Object> getRoles(String name, int offset, int pageCount);
       
}
