package cn.wm.sum.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wm.sum.dao.impl.TaskDao;
import cn.wm.sum.entity.Task;
import cn.wm.sum.model.Page;
import cn.wm.sum.service.TaskService;
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	
	public Page<Task> getUserTask(long userId,
			Map<String, Object> searchParams,Page<Task> page,
			String sortType) {
		// TODO Auto-generated method stub
		
		StringBuffer hql = new StringBuffer();
		String words = (String) searchParams.get("title");
		hql.append(" from Task t where ");
		if(StringUtils.isNotBlank(words)){
			hql.append("  t.title like '").append(words).append("%'");
		}
		hql.append(" t.user.id = ?");
		int pageRecords= this.getCountNum(userId, searchParams);
		page.setResultsNum(pageRecords);
		List<Task> tasks = taskDao.findWithPaging(hql.toString(), page.getPageNo(), page.getPageSize(), userId);
		page.setList(tasks);
		
		return page;
	}
	
	public int getCountNum(long userId,
			Map<String, Object> searchParams){
		
		StringBuffer hql = new StringBuffer();
		String words = (String) searchParams.get("title");
		hql.append("select count(t.id) from Task t  where");
		if(StringUtils.isNotBlank(words)){
			hql.append("  t.title like '").append(words).append("%'");
		}
		hql.append(" t.user.id = ?");
		Long pageRecords = taskDao.count(hql.toString(), userId);
		return pageRecords.intValue();
	}
    

	
	 
	public void saveTask(Task task) {
		// TODO Auto-generated method stub
		taskDao.save(task);
	}
	
	
}
