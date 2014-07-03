package cn.wm.sum.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.wm.sum.dao.impl.RoleDao;
import cn.wm.sum.dao.impl.TaskDao;
import cn.wm.sum.dao.impl.UserDao;
import cn.wm.sum.security.shiro.entity.Role;
import cn.wm.sum.security.shiro.entity.User;
import cn.wm.sum.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private RoleDao roleDao;
	
	
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,rollbackFor={ RuntimeException.class, Exception.class })
	public boolean login(String userName, String pwd) {
		// TODO Auto-generated method stub
		boolean flg = false;
		User user = userDao.getUser(userName, pwd);
		System.out.println(user.getName());
		if (user != null) {
			System.out.println("=========");
			user.setLoginDate(new Date());
			userDao.update(user);
			
			User user1 = new User();
			user1.setName("admin");
			user1.setLoginName("adminaa");
			user1.setPassword("123456");
			user1.setRegisterDate(new Date());
			userDao.save(user1);
			System.out.println(user1.getId());
//			user1.setLoginDate(new Date());
			userDao.delete(user1);
			
//			 Task task = new Task();
//			 task.setTitle("hello world bbbbb");
//			 task.setDescription("new spring+hibernate frameWork ");
//			 task.setUser(user);
//			 taskDao.save(task);
//			 System.out.println(task.getId());
//			 System.out.println("=======================");
//			 if(w/f == 0){
//				 task = new Task();
//				 task.setTitle("hello world aaa");
//				 task.setDescription("new spring+hibernate frameWork ");
//				 task.setUser(user);
//				 taskDao.save(task);
//			 }

		}

		return flg;
	}
	@Transactional
	public boolean register(User user) {
		// TODO Auto-generated method stub
		
		Role role = new Role();
		role.setName("超级管理员");
		role.setDescription("?????");
		roleDao.save(role);
		List<Role> list = new ArrayList<Role>();
		list.add(role);
		user.setRoleList(list);
		userDao.save(user);
//		System.out.println(user.getId());
		return false;
	}
	
	public User getUser(Long id ) {
		// TODO Auto-generated method stub
		return userDao.load(User.class, id);
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}
	
	

}
