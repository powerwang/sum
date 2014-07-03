package cn.wm.sum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.wm.sum.base.dao.CrmBaseDao;
import cn.wm.sum.security.shiro.entity.User;

@Repository
public class UserDao extends CrmBaseDao<User> {


	public User getUser(String userName, String pwd) {
		// TODO Auto-generated method stub

		StringBuffer hql = new StringBuffer();
		hql.append(" from User u where u.name=? and u.password =?");
		List<User> users = this.find(hql.toString(), userName, pwd);
		if (users != null && users.size() != 0) {
			return users.get(0);
		}
		return null;
	}

	public User findByLoginName(String userName) {
		// TODO Auto-generated method stub
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from User u where u.loginName=?");
		List<User> users = this.find(hql.toString(), userName);
		if (users != null && users.size() != 0) {
			return users.get(0);
		}
		return null;
	}

	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from User u ");
		List<User> users = this.find(hql.toString());
		if (users != null && users.size() != 0) {
			return users;
		}
		return null;
	}
}
