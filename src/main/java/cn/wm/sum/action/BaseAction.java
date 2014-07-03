package cn.wm.sum.action;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.wm.sum.annotation.RequestAction;
import cn.wm.sum.utils.Global;

@Controller
public abstract class BaseAction {
	
	/**
	 * 所有model 处理之前要经历的方法
	 * @param model
	 */
	@ModelAttribute
	public void getAction(Model model,HttpServletRequest request) {
		System.out.println(this.getClass().getName());
        System.out.println(request.getQueryString());
        System.out.println(request.getRequestURI());
        System.out.println(request.getServletPath());
        System.out.println("method==>>"+request.getMethod());
        
		if(this.getClass().isAnnotationPresent(RequestAction.class)){
	        //若存在就获取注解
			RequestAction annotation=(RequestAction)this.getClass().getAnnotation(RequestAction.class);
			model.addAttribute(Global.REQUEST_ACTION,  annotation.value());
		}else {
			String path = request.getServletPath();
			Method[] methods = this.getClass().getDeclaredMethods();
			for(Method m :methods){
				if(m.isAnnotationPresent(RequestAction.class)){
					RequestAction annotation=(RequestAction)m.getAnnotation(RequestAction.class);
					System.out.println("value==>>>"+annotation.value());
					System.out.println("value==>>>"+annotation.path());
//					if(){}
				}
			}
		}
		
	}
}
