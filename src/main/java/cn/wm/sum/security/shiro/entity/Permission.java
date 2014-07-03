package cn.wm.sum.security.shiro.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

import cn.wm.sum.entity.IdEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
/**
 * 
 * @author wang
 *  角色权限
 *  自关联很问题
 */

@Entity
@Table(name = "t_permission",schema="crm")
public class Permission extends IdEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -60045945396321247L;
	private String name;
	private String description;
//	private Permission parent;
	private List<Permission> children = Lists.newArrayList();
	private Long parentId;
	private List<Role> roles = Lists.newArrayList();
    // jsp tree 使用属性 不用持久化到数据库
	private String open ="true";
	private String iconOpen;
	private String iconClose;
	private String checked;
	
	
	


	public Permission() {
		super();
	}
	
	public Permission(Long id) {
		super();
		this.id = id;
	}
	@Transient
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	@Transient
	public String getIconOpen() {
		return iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}
	@Transient
	public String getIconClose() {
		return iconClose;
	}

	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}
	@Transient
	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
	
	@Transient
	public List<Permission> getChildren() {
		return children;
	}


	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	
    @Column(name="parent_id",length=20)
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		
		this.parentId = parentId;
	}
	

	@Column(length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//	/**
//	 * json 不希望出现
//	 * @return
//	 */
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "parent_id")
//	public Permission getParent() {
//		return parent;
//	}
//
//	public void setParent(Permission parent) {
//		this.parent = parent;
//	}
//	
//	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
//	public List<Permission> getChildren() {
//		return children;
//	}
//
//	public void setChildren(List<Permission> children) {
//		this.children = children;
//	}
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "permissions")
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	
}