package cn.wm.sum.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import cn.wm.sum.model.TaskType;
import cn.wm.sum.security.shiro.entity.User;

//JPA标识
@Entity
@Table(name = "t_task",schema="crm")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Task extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4653601749533068525L;
	private String title;
	@URL(message="必须url 格式")
	private String description;
	private Date createTime;
    private TaskType taskType;	
	private User user;

	
	public Task() {
		super();
	}

	public Task(String title, String description, User user) {
		super();
		this.title = title;
		this.description = description;
		this.user = user;
	}
	@Column(name="task_type",length=20)
	@Enumerated(EnumType.STRING)
	public TaskType getTaskType() {
		
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	// JSR303 BeanValidator的校验规则
	@NotBlank(message="")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// JPA 基于USER_ID列的多对一关系定义
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
