package cn.wm.sum.user.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wm.sum.security.shiro.entity.Permission;
import cn.wm.sum.security.shiro.entity.Role;
import cn.wm.sum.security.shiro.service.AccountService;
import cn.wm.sum.utils.MediaTypes;
/**
 * 
 * @author wang
 * 角色
 */
@Controller
@RequestMapping(value="/admin/role")
public class RoleController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Role> roles = accountService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("action", "roleList");
		return "account/user/adminUserController";
	}
    
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model) {
		
		model.addAttribute("action", "roleUpdate");
		return "account/user/adminUserController";
	}
	/**
	 * 保存和修改角色
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String addForm(@Valid Role role) {

		accountService.updateRole(role);
		return "redirect:/admin/role";
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("role", accountService.getRole(id));
		model.addAttribute("action", "roleUpdate");
		return "account/user/adminUserController";
	}
	
	/**
	 * 进入角色权限列表
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="permission/{id}",method = RequestMethod.GET)
	public String rolePermission(@PathVariable("id") Long id,Model model) {
		
		model.addAttribute("action", "rolePermissione");
		model.addAttribute("role", accountService.getRole(id));
		return "account/user/adminUserController";
	}
    /**
     * 
     * @param id
     * @param model
     * @return
     */
	@RequestMapping(value="permission",method = RequestMethod.POST, produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public Permission rolePerList(@RequestParam("id") Long id,Model model) {
		
		Role role = accountService.getRole(id);
		// 角色拥护的权限
		List<Permission> pers = role.getPermissions();
		// 全部权限
		List<Permission> allPer = accountService.getPermissions();
		Permission per = new Permission();
		List<Permission> list = new ArrayList<Permission>();
		for(Iterator<Permission> it = allPer.iterator();it.hasNext();){
			Permission permission = it.next();
			for(Iterator<Permission> p=pers.iterator();p.hasNext();){
				if(p.next().getId() == permission.getId()){
					permission.setChecked("true");
				}
			}
			if(permission.getParentId() == null || permission.getParentId() == 0){
			    permission.setIconOpen("/static/tree/css/zTreeStyle/img/diy/1_open.png");
			    permission.setIconClose("/static/tree/css/zTreeStyle/img/diy/1_close.png");
				per = permission;
			}
			list.add(permission);
		}
		accountService.tab(per, list);
		return per;
	}
	
	@RequestMapping(value="permission/update", method = RequestMethod.POST, produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public String updateRolePer(@RequestParam("id") Long id,@RequestParam("perIds") String perIds) {
		
		Role role = accountService.getRole(id);
		role.getPermissions().clear();
		if(StringUtils.isNotBlank(perIds)){
			String ids[] = perIds.split(",");
			for(String perid:ids){
				Permission per = new Permission(Long.parseLong(perid));
				role.getPermissions().add(per);
			}
		}
		accountService.updateRole(role); 
		
		return "1";
	}
	
	
	/**
	 * Ajax
	 */
//	@RequestMapping(value = "perRole", method = RequestMethod.POST, produces = MediaTypes.JSON_UTF_8)
//	@ResponseBody
//	public List<Permission> rolePermissionList(@RequestParam(value="id") Long id) {
//		
//		
//		List<Permission> permissions = new ArrayList<Permission>();
//		List<Permission> list = accountService.getPermissions();
////		for(Iterator<Permission> it=list.iterator();it.hasNext();){
////			Permission permission =it.next();
////			if(permission.getParent() == null ){
////				permission.setIconOpen("/static/tree/css/zTreeStyle/img/diy/1_open.png");
////				permission.setIconClose("/static/tree/css/zTreeStyle/img/diy/1_close.png");
////				permissions.add(permission);
////			}
////		}
//        return permissions;
//	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		accountService.delRole(id);
		
		return "redirect:/admin/role";
	}
	

}
