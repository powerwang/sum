package cn.wm.sum.security.shiro.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.wm.sum.entity.IdEntity;

import com.google.common.collect.Lists;

/**
 * 用户角色.
 * 
 * @author wsm
 */
@Entity
@Table(name = "t_role",schema="crm")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends IdEntity implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4012038361339090492L;
	
	private String name;
	
	private String description;
    private List<User> users =  Lists.newArrayList();
    private List<Permission> permissions = Lists.newArrayList();

	public Role() {
	
	}

	public Role(Long id) {
		this.id = id;
	}
	@Column(length=50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length=50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	//user 为关系的维护者
    @ManyToMany(mappedBy="roleList")
    @Basic(fetch=FetchType.LAZY)
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
    @ManyToMany
    @Basic(fetch=FetchType.LAZY)
    @JoinTable(name ="t_role_permission",joinColumns={@JoinColumn(name="role_id",updatable=false)},
      inverseJoinColumns={@JoinColumn(name="permission_id",updatable=false)} )   
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
