package com.cc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cc.dao.UserDao;
import com.cc.model.Notice;
import com.cc.model.Role;
import com.cc.model.Section;
import com.cc.model.User;
import com.cc.util.JDBC;

public class UserDaoImpl implements UserDao {


	@Override
	public User getUser(String username, String password) {
		String sql = "SELECT s.`name` section,r.`name` role,r.id roleID,u.id,u.username,u.password,u.name,u.mobile,u.sex,u.address,u.age,u.status,u.sectionID,u.lockingTime,u.themeColor FROM `user` u,user_role ur,role r,section s WHERE u.username=? AND u.password=(MD5(?)) AND u.sectionID=s.id AND ur.userID=u.id AND ur.roleID=r.id";
		List<Object> result = JDBC.query(sql, User.class, username, password);
		if (result.size() == 0) {
			return null;
		}
		return (User)result.get(0);
	}

	@Override
	public int updateUserInfo(User user) {
		String sql = "UPDATE `user` u,section s,user_role ur,role r SET u.themeColor=?,u.mobile=?,u.address=?,u.sectionID=(SELECT id FROM section WHERE `name`=?),ur.roleID=(SELECT id FROM role WHERE `name`=?) WHERE u.sectionID=s.id AND ur.userID=u.id AND ur.roleID=r.id AND u.username=?";
		Object[] params = {
				user.getThemeColor(),
				user.getMobile(),
				user.getAddress(),
				user.getSection(),
				user.getRole(),
				user.getUsername()
		};
		return JDBC.update(sql, params);
	}
	
	@Override
	public List<Notice> getNotices(String content, int offset, int pageCount) {
		String sql = "SELECT n.id,n.time,n.content,n.userID,u.username,u.`name` FROM notice n,`user` u WHERE n.userID=u.id ";
		List<String> params = new ArrayList<>();
		if (content != null && !"".equals(content)) {
			sql += " AND n.content like ?";
			params.add("%" + content + "%");
		}
		sql += " ORDER BY n.time DESC LIMIT " + offset + "," + pageCount;
		return JDBC.query(sql, Notice.class, params.toArray());
	}

	@Override
	public int getNoticesTotal(String content) {
		String sql = "SELECT COUNT(*) FROM notice WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (content != null && !"".equals(content.trim())) {
			sql += "AND content like ?";
			params.add("%" + content + "%");
		}
		return JDBC.getCount(sql, params.toArray());
	}

	@Override
	public int addNotice(Notice addNotice) {
		String sql = "INSERT INTO notice(id,time,content,userID) VALUES(DEFAULT,NOW(),?,?)";
		Object[] params = {
				addNotice.getContent(),
				addNotice.getUserID()
		};
		return JDBC.update(sql, params);
	}

	@Override
	public int updateNotice(Notice updateNotice) {
		String sql = "UPDATE notice SET content=? WHERE id=" + updateNotice.getId();
		return JDBC.update(sql, updateNotice.getContent());
	}

	@Override
	public int deleteNotice(Object[] ids) {
		String sql = "DELETE FROM notice WHERE id in (";
		for (int i=1,j=ids.length; i<=j; i++) {
			if(i == j) {
				sql += "?";
			}else {
				sql += "?,";
			}
		}
		sql += ")";
		return JDBC.update(sql,ids);
	}

	@Override
	public List<Section> getSections(String name, int offset, int pageCount) {
		String sql = "SELECT s.id,s.`name`,s.time,(SELECT COUNT(id) FROM `user` u WHERE u.sectionID=s.id GROUP BY sectionID) peopleCount,(SELECT u.`name` FROM `user` u,user_role ur,role r WHERE u.sectionID=s.id AND ur.userID=u.id AND ur.roleID=r.id AND r.`name`='销售经理')  manager FROM section s WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql += " AND s.name like ?";
			params.add("%" + name + "%");
		}
		sql += " LIMIT " + offset + "," + pageCount;
		return JDBC.querySection(sql, params.toArray());
	}

	@Override
	public int getSectionsTotal(String name) {
		String sql = "SELECT COUNT(*) FROM section WHERE 1=1";
		List<String> params = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql += " AND name like ?";
			params.add("%" + name + "%");
		}
		return JDBC.getCount(sql, params.toArray());
	}

	@Override
	public int addSection(String name) {
		String sql = "INSERT INTO section(id,name,time) VALUES(DEFAULT,?,NOW())";
		return JDBC.update(sql, name);
	}

	@Override
	public int updateSection(String id, String name) {
		String sql = "UPDATE section SET name=? WHERE id=?";
		return JDBC.update(sql, name, id);
	}

	@Override
	public int deleteSection(Object[] ids) {
		String sql = "DELETE FROM section WHERE id in (";
		for (int i=1,j=ids.length; i<=j; i++) {
			if(i == j) {
				sql += "?";
			}else {
				sql += "?,";
			}
		}
		sql += ")";
		return JDBC.update(sql,ids);
	}

	@Override
	public List<User> getUsers(String name, int offset, int pageCount) {
		String sql = "SELECT s.`name` section,r.`name` role,u.id,u.username,u.`password`,u.`name`,u.mobile,u.sex,u.address,u.age,u.`status`,u.sectionID,u.lockingTime FROM `user` u,user_role ur,role r,section s WHERE u.sectionID=s.id AND ur.userID=u.id AND ur.roleID=r.id";
		List<String> params = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql += " AND u.name like ?";
			params.add("%" + name + "%");
		}
		sql += " LIMIT " + offset + "," + pageCount;
		return JDBC.query(sql, User.class, params.toArray());
	}

	@Override
	public int getUsersTotal(String name) {
		String sql = "SELECT COUNT(*) FROM user WHERE 1=1";
		List<String> params = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql += " AND name like ?";
			params.add("%" + name + "%");
		}
		return JDBC.getCount(sql, params.toArray());
	}

	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO user(id,name,username,password,mobile,sex,address,age,status,sectionID,lockingTime) VALUES(DEFAULT,?,?,MD5('123456'),?,?,?,?,1,?,NULL)";
		Object[] params = {
				user.getName(),
				user.getUsername(),
				user.getMobile(),
				user.getSex(),
				user.getAddress(),
				user.getAge(),
				user.getSectionID()
		};
		int row1 = JDBC.update(sql, params);
		if (row1 == 1) {
			sql = "INSERT INTO user_role(id,userID,roleID) VALUES(DEFAULT,(SELECT MAX(id) FROM user),?)";
			Object[] param = {
					user.getRoleid()
			};
			int row2 = JDBC.update(sql, param);
			if (row2 == 1) return 2;
			else return 0;
		}else {
			return 0;
		}
	}

	@Override
	public List<Role> getRoles(String name, int offset, int pageCount) {
		String sql = "SELECT id,name FROM role WHERE 1=1";
		List<String> params = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql += " AND name like ?";
			params.add("%" + name + "%");
		}
		sql += " LIMIT " + offset + "," + pageCount;
		return JDBC.query(sql, Role.class, params.toArray());
	}

	@Override
	public int getRolesTotal(String name) {
		String sql = "SELECT COUNT(*) FROM role WHERE 1=1";
		List<String> params = new ArrayList<>();
		if (name != null && !"".equals(name)) {
			sql += " AND name like ?";
			params.add("%" + name + "%");
		}
		return JDBC.getCount(sql, params.toArray());
	}

}
