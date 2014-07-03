package cn.wm.sum.service;

import java.util.List;

import cn.wm.sum.security.shiro.entity.User;


/**
 * 用户接口
 * @author wang
 *
 */
public interface UserService {

	public boolean login(String userName,String pwd);
	
	public boolean register(User user);
	
	public User getUser(Long id);
	
	public List<User> getUsers();
}
