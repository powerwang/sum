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
				<li class="active"><a href="">用户列表</a> <span class="divider">/</span></li>
				<li class="active">
				   <c:choose>
				     <c:when test="${not empty user}"> ${user.name }</c:when>
				     <c:otherwise>
				        <a href="">用户添加</a> <span class="divider">/</span>
				     </c:otherwise>
				   </c:choose>
				</li>
			</ul>
			<!-- user form -->
		  <form:form id="inputForm"  modelAttribute="user" action="${ctx}/admin/user/update" method="post" class="form-horizontal">
			<input type="hidden" name="id" value="${user.id}"/>
			<fieldset>
				<legend><small></small></legend>
				<div id="messageBox" class="alert alert-error input-large controls" style="display:none">输入有误，请先更正。</div>
				<div class="control-group">
					<label for="loginName" class="control-label">登录名:</label>
					<div class="controls">
						<input type="text" id="loginName" name="loginName" value="${user.loginName}" class="input-large required"/>
					</div>
				</div>
				<div class="control-group">
					<label for="name" class="control-label">用户名:</label>
					<div class="controls">
						<input type="text" id="name" name="name"  value="${user.name}" class="input-large required"/>
					</div>
				</div>
				<div class="control-group">
					<label for="groupList" class="control-label">角色:</label>
					<div class="controls">
						<form:bscheckboxes path="roleList" items="${allRoles}" itemLabel="description" itemValue="id" />
					</div>
				</div>	
               <div class="control-group">
				  <label for="status" class="control-label">状态:</label>
				  <div class="controls">
					<form:bsradiobuttons path="status" items="${allStatus}" labelCssClass="inline"/>
				  </div>
			   </div>

				<div class="form-actions">
					<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
					<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
					<p class="help-block">(保存后将发送JMS消息通知改动，而消息接收者将发送提醒邮件)</p>			
				</div>
			</fieldset>
		</form:form>
			<!-- user form -->
	  </div>
</div>
<!--	/Setting	-->
<script>

	$(document).ready(function() {
		$("#userList-tab").addClass("active");
	});
</script>
