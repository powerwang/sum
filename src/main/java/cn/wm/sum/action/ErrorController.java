package cn.wm.sum.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author wang
 *  错误页面跳转
 */
@Controller
public class ErrorController {

	
	@RequestMapping(value="/error/{page}",method = RequestMethod.GET)
	public String error(@PathVariable("page") String page) {
		
		return "error/"+page;
	}

}
