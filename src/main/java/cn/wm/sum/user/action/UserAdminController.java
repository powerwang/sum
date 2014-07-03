package cn.wm.sum.user.action;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.wm.sum.security.shiro.entity.Role;
import cn.wm.sum.security.shiro.entity.User;
import cn.wm.sum.security.shiro.service.AccountService;

import com.google.common.collect.Maps;

/**
 * 管理员管理用户的Controller.
 * 
 * @author wsm
 */
@Controller
@RequestMapping(value = "/admin/user")
public class UserAdminController {

	private static Map<String, String> allStatus = Maps.newHashMap();
	
	static {
		allStatus.put("enabled", "有效");
		allStatus.put("disabled", "无效");
	}
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<User> users = accountService.getAllUser();
		model.addAttribute("users", users);
		model.addAttribute("action", "userList");
		return "account/user/adminUserController";
	}
    
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("user", accountService.getUser(id));
		model.addAttribute("allRoles",accountService.getRoles());
		model.addAttribute("allStatus", allStatus);
		model.addAttribute("action", "userUpdate");
		return "account/user/adminUserController";
	}

	/**
	 * 演示自行绑定表单中的checkBox roleList到对象中.
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("user") User user,
			@RequestParam(value = "roleList") List<Long> checkedRoleList, RedirectAttributes redirectAttributes) {
        
		// bind roleList
		user.getRoleList().clear();
		for (Long roleId : checkedRoleList) {
			Role role = new Role(roleId);
			user.getRoleList().add(role);
		}
		accountService.updateUser(user);
		redirectAttributes.addFlashAttribute("message", "保存用户成功");
		return "redirect:/admin/user";
	}
	
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(@Valid @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
//		accountService.updateUser(user);
//		redirectAttributes.addFlashAttribute("message", "更新用户" + user.getLoginName() + "成功");
//		return "redirect:/admin/user";
//	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		User user = accountService.getUser(id);
		accountService.deleteUser(id);
		redirectAttributes.addFlashAttribute("message", "删除用户" + user.getLoginName() + "成功");
		return "redirect:/admin/user";
	}

	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("user", accountService.getUser(id));
		}
	}
	
	/**
	 * 不自动绑定对象中的roleList属性，另行处理。
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("roleList");
	}
}
