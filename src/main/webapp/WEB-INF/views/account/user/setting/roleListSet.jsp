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
				<li class="active"><a href="">角色列表</a> <span class="divider">/</span></li>
				<li class="active"></li>
				<li class="pull-right">
				   <a class="btn btn-small btn-primary" href="${ctx}/admin/role/add">
				    <i class="icon-plus icon-white"></i>添加</a>
				</li>
			</ul>
			
			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
			</c:if>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead><tr><th>角色名</th><th>角色代码</th><th>管理</th></tr></thead>
				<tbody>
				<c:forEach items="${roles}" var="role">
					<tr>
						<td><a href="${ctx}/admin/role/update/${role.id}">${role.name}</a></td>
						<td>${role.description}</td>
						<td>
						    <a href="${ctx}/admin/role/delete/${role.id}" class="btn btn-small btn-danger"> <i class="icon-trash icon-white""></i>删除</a>
						    <a href="${ctx}/admin/role/update/${role.id}" class="btn btn-small btn-primary"> <i class="icon-pencil icon-white""></i>修改</a>
						    <a href="${ctx}/admin/role/permission/${role.id}" class="btn btn-small btn-primary"><i class="icon-pencil icon-white""></i>权限更改</a>
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
		$("#roleList-tab").addClass("active");
	});
</script>
