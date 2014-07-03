package cn.wm.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.wm.spring.SpringContextTestCase;
import cn.wm.sum.security.shiro.entity.User;
import cn.wm.sum.service.UserService;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class HibernateTest extends SpringContextTestCase {

	@Autowired
	private UserService  userService;

	@Test
	public void wang() {

//		assertEquals(value2, result);
		User user = new User();
		user.setName("admin");
		user.setLoginName("adminaa");
		user.setPassword("123456");
		user.setRegisterDate(new Date());
		userService.register(user);
		
//		userService.login("admin", "123456");
//      System.out.println("=============");
//		assertNull(result);
	}
	@Test
	public void lazyF(){
		
		User user= userService.getUser(2L);
		System.out.println("=============");
//		System.out.println(user.getRoleList());
		List<User> user2= userService.getUsers();
		System.out.println(user2.get(0).getName());
	}

	
}
