<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
	<link href="${ctx}/static/styles/user/setting.css" type="text/css" rel="stylesheet" />
	<style type="text/css">
	.accordion-heading {background-color: #d4e4ff;}
	</style>
</head>

<body>

  <div class="container-fluid" style="height:602px;">
	   <!--Dashboad-->
	  <div class="container-fluid" style="height:602px;">
		<div class="row-fluid">
			<div class="span2" style="margin-left:10px;">
				<div class="accordion" id="settingion1" style="overflow:auto;height:580px;">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#settingion1" href="#collapseOne">基本设置</a>
						</div>
						
						<div id="collapseOne" class="accordion-body collapse in">
							<div class="accordion-inner">
								 <ul class="nav nav-list">
										<li id="userList-tab">
											<a href="${ctx }/admin/user">用户列表</a>
										</li>
										<li id="roleList-tab">
											<a href="${ctx }/admin/role">角色列表</a>
										</li>
										<li id="permissionList-tab">
											<a href="${ctx }/admin/permission">权限列表</a>
										</li>
								  </ul>
							</div>
						</div>
						
                  </div>				
              </div>
		   </div>
		    <div class="span10" style="margin-left:10px;" >
                  <!--	Setting	-->
                  <c:choose>
                     <c:when test="${action == 'userList' }">
                        <%@include file="setting/userListSet.jsp" %>
                     </c:when>
                     <c:when test="${action =='userUpdate' }">
                         <%@include file="setting/userFormSet.jsp" %>
                     </c:when>
                     <c:when test="${action =='roleList' }">
                         <!-- 角色列表 -->
                         <%@include file="setting/roleListSet.jsp" %>
                     </c:when>
                     <c:when test="${action =='roleUpdate' }">
                         <!-- 角色信息修改 -->
                         <%@include file="setting/roleFormSet.jsp" %>
                     </c:when>
                     <c:when test="${action =='rolePermissione' }">
                         <!-- 角色权限 -->
                         <%@include file="setting/rolepermissionSet.jsp" %>
                     </c:when>
                     <c:when test="${action =='permissioneList' }">
                         <%@include file="setting/permissionListSet.jsp" %>
                     </c:when>
                     <c:when test="${action =='roleUpdate' }">
                         <%@include file="setting/userFormSet.jsp" %>
                     </c:when>
                     
                     <c:otherwise></c:otherwise>
                  </c:choose>
                  
                  <!--	/Setting	-->
			</div>
	  </div>
	</div>
 </div>

</body>
</html>
