<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!--	Setting	 用户列表	-->
<div class="row-fluid box" style="height:602px;">
	<div class="tab-header">基本设置</div>
	<div class="padded" style="overflow:auto;height:520px;">
		 <!--	Setting Contact		-->
			<ul class="breadcrumb">
				<li><a href="#">基本设置</a> <span class="divider">/</span></li>
				<li class="active"><a href="">用户列表</a> <span class="divider">/</span></li>
				<li class="active"></li>
				<li class="pull-right">
				   <a class="btn btn-small btn-primary" href="${ctx}/admin/role/add">
				    <i class="icon-plus icon-white"></i>添加</a>
				</li>
			</ul>
			<table class="table table-condensed table-bordered table-hover">
				<thead>
				  <tr>  
					<th>登录名</th>
					<th>用户名</th>
					<th>角色</th>
					<th>注册时间</th>
					<th>管理</th>
				  </tr>
				</thead>
				<tbody style="text-align: center;">
				<c:forEach items="${users}" var="user">
					<tr>
						<td><a href="${ctx}/admin/user/update/${user.id}">${user.loginName}</a></td>
						<td>${user.name}</td>
						<td>
						  <c:choose><c:when test="${not empty user.roleNames}">${user.roleNames}</c:when> <c:otherwise>暂未分配角色</c:otherwise></c:choose>
						</td>
						<td>
							<fmt:formatDate value="${user.registerDate}" pattern="yyyy年MM月dd日  HH时mm分ss秒" />
						</td>
						<td>
						  <a class="btn btn-small btn-primary" href="${ctx}/admin/user/update/${user.id}">
						     <i class="icon-pencil icon-white""></i>修改
						  </a> 
						  |
						  <a class="btn btn-small btn-danger" href="${ctx}/admin/user/delete/${user.id}">
						     <i class="icon-trash icon-white""></i>删除
						  </a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	  </div>
</div>
<!--	/Setting	-->
<script>
	$(document).ready(function() {
		$("#userList-tab").addClass("active");
	});
</script>
