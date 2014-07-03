package cn.wm.sum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.wm.sum.base.dao.CrmBaseDao;
import cn.wm.sum.security.shiro.entity.Permission;
/**
 * 
 * @author wang
 *
 */
@Repository
public class PermissionDao extends CrmBaseDao<Permission>{

	
	public List<Permission> getPermissions(){
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Permission u ");
		List<Permission> permissions = this.find(hql.toString());
		if (permissions != null && permissions.size() != 0) {
			return permissions;
		}
		return null;
	}
}
