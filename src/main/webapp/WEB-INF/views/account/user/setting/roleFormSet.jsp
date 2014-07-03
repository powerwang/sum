<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.sum.cn/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!--	Setting	 用户列表	-->
<div class="row-fluid box" style="height:602px;">
	<div class="tab-header">基本设置</div>
	<div class="padded" style="overflow:auto;height:520px;">
		 <!--	Setting Contact		-->
			<ul class="breadcrumb">
				<li><a href="#">基本设置</a> <span class="divider">/</span></li>
				<li class="active"><a href="">角色列表</a> <span class="divider">/</span></li>
				<li class="active">
				   <c:choose>
				     <c:when test="${not empty role}"> ${role.name }</c:when>
				     <c:otherwise>
				        <a href="">角色添加</a> <span class="divider">/</span>
				     </c:otherwise>
				   </c:choose>
				</li>
			</ul>
			<!-- user form -->
		 <form id="inputForm" action="${ctx}/admin/role/update" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${role.id}"/>
		<fieldset>
			<legend><small>角色管理</small></legend>
			<div class="control-group">
				<label class="control-label">角色名:</label>
				<div class="controls">
				    <!-- disabled=""   -->
					<input type="text" value="${role.name}" id="name" name="name" class="input-large"  />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">角色代码:</label>
				<div class="controls">
					<input type="text" id="description" name="description" value="${role.description}" class="input-large required"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
	

			<!-- user form -->
	  </div>
</div>
<!--	/Setting	-->
<script>

	$(document).ready(function() {
		
		$("#roleList-tab").addClass("active");
		//聚焦第一个输入框
		$("#name").focus();
		//为inputForm注册validate函数
		$("#inputForm").validate();
	});
</script>
