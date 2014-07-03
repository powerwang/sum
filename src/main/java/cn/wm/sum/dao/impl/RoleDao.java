package cn.wm.sum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.wm.sum.base.dao.CrmBaseDao;
import cn.wm.sum.security.shiro.entity.Role;
@Repository
public class RoleDao extends  CrmBaseDao<Role> {

	
	public List<Role> getRoles(){
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Role u ");
		List<Role> roles = this.find(hql.toString());
		if (roles != null && roles.size() != 0) {
			return roles;
		}
		return null;
	}
}
