package cn.wm.sum.security.shiro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wm.sum.dao.impl.PermissionDao;
import cn.wm.sum.dao.impl.RoleDao;
import cn.wm.sum.dao.impl.UserDao;
import cn.wm.sum.security.shiro.entity.Permission;
import cn.wm.sum.security.shiro.entity.Role;
import cn.wm.sum.security.shiro.entity.User;
import cn.wm.sum.security.shiro.service.ShiroDbRealm.ShiroUser;
import cn.wm.sum.security.shiro.utils.Digests;
import cn.wm.sum.utils.Encodes;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional
public class AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
   
	@Autowired
	private UserDao userDao;
    
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PermissionDao permissionDao;

	
	public void updatePermission(Permission permission){
	   
		if(permission.getId() != null && permission.getId() != 0){
			permissionDao.update(permission);
	    }else {
	    	permissionDao.save(permission);
	    }
	}
	
	public void delPermission(Long id){
		permissionDao.delete(this.getPermission(id));
	}
	
	public Permission getPermission(Long id) {
		return permissionDao.load(Permission.class, id);
	}
	
	/**
	 * 获取所有权限信息
	 * @return
	 */
	public List<Permission> getPermissions() {
		
		return permissionDao.getPermissions();
	}
	
	
	// 父子集的处理
	public void tab(Permission permission,List<Permission> list){
		//all pid = 1
		for(Iterator<Permission> it=list.iterator();it.hasNext();){
			Permission p = (Permission)it.next();
			if(p.getParentId() !=null && permission.getId() == (p.getParentId())){
				if(permission.getChildren()==null){
					permission.setChildren(new ArrayList<Permission>());
				}
				permission.getChildren().add(p);
				this.tab(p,list);
			}
		}
	}
	
	
	public void updateRole(Role role){
	    if(role.getId() != null && role.getId() != 0){
	    	roleDao.update(role);
	    }else {
		    roleDao.save(role);
	    }
	}
	
	public void delRole(Long id){
	    
		 roleDao.delete(this.getRole(id));
	}
	
	/**
	 * 获取所有权限信息
	 * @return
	 */
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

	public Role getRole(long id) {
		
		return roleDao.load(Role.class, id);
	}
	
	public User getUser(Long id) {
		
		return userDao.load(User.class, id);
	}

	public User findUserByLoginName(String loginName) {
		
		
		return userDao.findByLoginName(loginName);
	}

	public void registerUser(User user) {
		
		entryptPassword(user);
		user.setRegisterDate(new Date());
		userDao.save(user);
	}

	public void updateUser(User user) {
		if (StringUtils.isNotBlank(user.getPlainPassword())) {
			entryptPassword(user);
		}
		userDao.save(user);
	}

	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		userDao.delete(this.getUser(id));
//		taskDao.deleteByUserId(id);
	}

	public List<User> getAllUser(){
		
		return userDao.getAllUser();
	}
	
	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));
        
		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}


}
