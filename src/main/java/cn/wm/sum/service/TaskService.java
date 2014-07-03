package cn.wm.sum.service;

import java.util.Map;

import cn.wm.sum.entity.Task;
import cn.wm.sum.model.Page;

public interface TaskService {

	
	public Page<Task>  getUserTask(long userId, Map<String, Object> searchParams,Page<Task> page,String sortType);
	
	public void saveTask(Task task);
}
