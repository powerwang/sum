package cn.wm.sum.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value=false)
public class SpringTool implements ApplicationContextAware {

	private static ApplicationContext applicationContext;  
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		SpringTool.applicationContext = applicationContext;
	}
	public static <T> T getBean(Class<T> clazz) {  
		checkApplicationContext();  
		return (T) applicationContext.getBeansOfType(clazz);  
	} 
	public static void cleanApplicationContext() {  
		applicationContext = null;  
		} 
	public static ApplicationContext getApplicationContext() {  
		checkApplicationContext();  
		return applicationContext;  
	} 
	private static void checkApplicationContext() {  
		if (applicationContext == null) {  
		throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");  
	  }
	}
}
