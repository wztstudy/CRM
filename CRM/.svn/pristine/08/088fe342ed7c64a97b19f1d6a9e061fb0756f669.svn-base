package com.cc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.dao.UserDao;
import com.cc.dao.impl.UserDaoImpl;
import com.cc.model.Notice;
import com.cc.model.Role;
import com.cc.model.Section;
import com.cc.model.User;
import com.cc.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private UserDao ud = new UserDaoImpl();
	
	@Override
	public String login(String username, String password) {
		String isSuccess = "";
		User user = ud.getUser(username, password);
		if (user != null) {
//					登录成功
			isSuccess = "登录成功";
		}else {
//					密码错误
			isSuccess = "账号或密码错误";
		}
		return isSuccess;
	}

	@Override
	public User getUser(String username, String password) {
		return ud.getUser(username, password);
	}

	@Override
	public boolean updateUserInfo(User user) {
		int row = ud.updateUserInfo(user);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> getNotices(String content, int offset, int pageCount) {
		List<Notice> noticesList = ud.getNotices(content, offset, pageCount);
		int totalCount = ud.getNoticesTotal(content);
		int totalPage = totalCount % pageCount == 0 ? totalCount / pageCount : totalCount / pageCount + 1;
		Map<String, Object> notices = new HashMap<String, Object>();
		notices.put("notices", noticesList);
		notices.put("totalPage", totalPage);
		return notices;
	}

	@Override
	public boolean addNotice(Notice addNotice) {
		int row = ud.addNotice(addNotice);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateNotice(Notice updateNotice) {
		int row = ud.updateNotice(updateNotice);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteNotice(Object[] ids) {
		int row = ud.deleteNotice(ids);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> getSections(String name, int offset, int pageCount) {
		List<Section> sectionsList = ud.getSections(name, offset, pageCount);
		int totalCount = ud.getSectionsTotal(name);
		int totalPage = totalCount % pageCount == 0 ? totalCount / pageCount : totalCount / pageCount + 1;
		Map<String, Object> sections = new HashMap<String, Object>();
		sections.put("sections", sectionsList);
		sections.put("totalPage", totalPage);
		return sections;
	}

	@Override
	public boolean addSection(String name) {
		int row = ud.addSection(name);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateSection(String id, String name) {
		int row = ud.updateSection(id, name);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteSection(Object[] ids) {
		int row = ud.deleteSection(ids);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> getUsers(String name, int offset, int pageCount) {
		List<User> usersList = ud.getUsers(name, offset, pageCount);
		int totalCount = ud.getUsersTotal(name);
		int totalPage = totalCount % pageCount == 0 ? totalCount / pageCount : totalCount / pageCount + 1;
		Map<String, Object> users = new HashMap<String, Object>();
		users.put("users", usersList);
		users.put("totalPage", totalPage);
		return users;
	}

	@Override
	public boolean addUser(User user) {
		int row = ud.addUser(user);
		if (row == 0) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> getRoles(String name, int offset, int pageCount) {
		List<Role> rolesList = ud.getRoles(name, offset, pageCount);
		int totalCount = ud.getRolesTotal(name);
		int totalPage = totalCount % pageCount == 0 ? totalCount / pageCount : totalCount / pageCount + 1;
		Map<String, Object> roles = new HashMap<String, Object>();
		roles.put("roles", rolesList);
		roles.put("totalPage", totalPage);
		return roles;
	}

}
