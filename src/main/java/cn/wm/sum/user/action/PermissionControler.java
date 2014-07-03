package cn.wm.sum.user.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wm.sum.security.shiro.entity.Permission;
import cn.wm.sum.security.shiro.service.AccountService;
import cn.wm.sum.utils.MediaTypes;

/**
 * 
 * @author wang
 * 权限管理
 */
@Controller
@RequestMapping(value="/admin/permission")
public class PermissionControler {
    
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("action", "permissioneList");
		return "account/user/adminUserController";
	}

	/**
	 * Ajax
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public Permission permissionList() {
		
//		List<Permission> permissions = new ArrayList<Permission>();
		List<Permission> list = accountService.getPermissions();
		Permission per = new Permission();
		for(Iterator<Permission> it = list.iterator();it.hasNext();){
			Permission permission = it.next();
			if(permission.getParentId() == null || permission.getParentId() == 0){
				accountService.tab(permission, list);
			    permission.setIconOpen("/static/tree/css/zTreeStyle/img/diy/1_open.png");
			    permission.setIconClose("/static/tree/css/zTreeStyle/img/diy/1_close.png");
				per = permission;
			}
		}
        return per;
	}
	

	
//	@RequestMapping(value = "add", method = RequestMethod.GET)
//	public String addForm() {
//		
//		return "account/permission/permissionForm";
//	}
	/**
	 * 保存和修改角色
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateForm(@Valid Permission permission,@RequestParam(value = "parentId", defaultValue = "1L") Long id) {

//		Permission parent = new Permission(id);
		permission.setParentId(id);; 
		accountService.updatePermission(permission);
		return "redirect:/admin/permission";
	}
	
	/**
	 * 获取permission
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "per",method = RequestMethod.POST,produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public Map updateForm(@RequestParam(value = "id") Long id) {
		
		System.out.println(id);
		Permission permission = accountService.getPermission(id);
		Map map = new HashMap();
		map.put("permission", permission);
		map.put("perentId", permission.getParentId());
		return  map;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		accountService.delPermission(id);
		
		return "redirect:/admin/permission";
	}
}
