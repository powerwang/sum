package cn.wm.in;

import java.util.List;

public class Permission {

	private Long id;
	private String name;
	private Long parentId;
	
	private List<Permission> list;
	
	
	public List<Permission> getList() {
		return list;
	}
	public void setList(List<Permission> list) {
		this.list = list;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
}
