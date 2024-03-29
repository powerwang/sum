package cn.wm.sum.task.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.wm.sum.entity.Task;
import cn.wm.sum.model.Page;
import cn.wm.sum.model.TaskType;
import cn.wm.sum.security.shiro.entity.User;
import cn.wm.sum.security.shiro.service.ShiroDbRealm.ShiroUser;
import cn.wm.sum.service.TaskService;
import cn.wm.sum.utils.Servlets;

import com.google.common.collect.Maps;

/**
 * Task管理的Controller, 使用Restful风格的Urls:
 * 
 * List page : GET /task/
 * Create page : GET /task/create
 * Create action : POST /task/create
 * Update page : GET /task/update/{id}
 * Update action : POST /task/update
 * Delete action : GET /task/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {


	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("title", "标题");
	}
	@Autowired
	private TaskService taskService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			 Model model,ServletRequest request) {
		
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "");
		Long userId = getCurrentUserId();
		Page<Task> tasks = new Page<Task>();
		tasks.setPageNo(pageNumber);
		tasks = taskService.getUserTask(userId, searchParams,tasks, "");
		model.addAttribute("tasks", tasks);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, ""));
		return "task/taskList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("action", "create");
		return "task/taskForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid Task task, BindingResult result,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()){
			return "task/taskForm";
		}else {
			User user = new User(getCurrentUserId());
			task.setUser(user);
			task.setCreateTime(new Date());
			task.setTaskType(TaskType.完成);
			taskService.saveTask(task);
			redirectAttributes.addFlashAttribute("message", "创建任务成功");
			return "redirect:/task/";
		}
		
	}

//	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
//	public String updateForm(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("task", taskService.getTask(id));
//		model.addAttribute("action", "update");
//		return "task/taskForm";
//	}

//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(@Valid @ModelAttribute("task") Task task, RedirectAttributes redirectAttributes) {
//		taskService.save(task);
//		redirectAttributes.addFlashAttribute("message", "更新任务成功");
//		return "redirect:/task/";
//	}

//	@RequestMapping(value = "delete/{id}")
//	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
//		taskService.deleteTask(id);
//		redirectAttributes.addFlashAttribute("message", "删除任务成功");
//		return "redirect:/task/";
//	}

	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getTask(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
//			model.addAttribute("task", taskService.getTask(id));
		}
	}


	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}
