<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div class="container-fluid wraper ">
      <div class="row-fluid ">
              <div class="span2" style="padding-top:2px;padding-left:10px;">
				<a href="${ctx }" target="_blank">
                   <img src="${ctx }/static/images/logonew.png">
				</a>
              </div>
              <div class="span5">
                &nbsp;
              </div>
              <shiro:user>
              <div class="span5" style="padding-top:10px;">
                  <div class="pull-right navbar topbar" style="margin-bottom:5px;">
                    <ul class="nav" style="height:15px;">
                       <shiro:user>
                         <shiro:hasRole name="admin">
					       <li><a href="${ctx}/admin/user"><i class="icon-cog"></i>&nbsp;权限设置</a></li>
					     </shiro:hasRole>
					   </shiro:user>
					   <li><a href="" style="color: #08c" ><i class="icon-user"></i> <shiro:principal property="name"/></a></li>
					   <li><a href="${ctx}/logout"><i class="icon-off"></i>&nbsp;退出</a></li>
                    </ul>
                  </div>
               </div>
              </shiro:user>
      </div>
 </div>
<shiro:user>
<div class="navbar navbar-inverse" style="padding-top: 10px;" >
          <div class="navbar-inner">
            <div class="container">
                 <a class="btn btn-navbar " data-toggle="collapse" data-target=".navbar-inverse-collapse">
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
                 </a>
                 <a class="brand" href="#">&nbsp;&nbsp;&nbsp;</a>
                <div class="nav-collapse collapse navbar-inverse-collapse ">
                   <ul class="nav ">
							<li class="dropdown" id="actionIndex">
          						<a href="${ctx }" class="dropdown-toggle">首页</a>
							</li>
							<li class="dropdown" id="actionTask">
          						<a href="${ctx }/task" class="dropdown-toggle">任务</a>
							</li>
							<li class="dropdown ">
          						<a href="" class="dropdown-toggle" data-toggle="dropdown" >权限管理
          						  <b class="caret"></b>
          						</a>
          					    <ul class="dropdown-menu">
							      <li><a href="#">动作</a></li>
							      <li><a href="#">另一个动作</a></li>
							      <li><a href="#">其他</a></li>
							      <li class="divider"></li>
							      <li><a href="#">被间隔的链接</a></li>
							    </ul>
							</li>
          			 </ul>
                
                <form class="navbar-search pull-right"  name="UnifiedSearch" method="post">
                    <input type="text" class="search-query " placeholder="检索" id="query_string" name="query_string">
				</form>
                  
              </div><!-- /.nav-collapse -->
            </div>
          </div><!-- /navbar-inner -->
</div>

</shiro:user>



<!-- 
<div id="header">
	<div id="title">
	      <h1><a href="${ctx}">CRM</a>
	       <shiro:user>
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i> <shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<shiro:hasRole name="admin">
						<li><a href="${ctx}/admin/user">用户管理</a></li>
						<li><a href="${ctx}/admin/role">角色管理</a></li>
						<li><a href="${ctx}/admin/permission">权限管理</a></li>
						<li class="divider"></li>
					</shiro:hasRole>
					<li><a href="${ctx}/profile">修改密码</a></li>
					<li><a href="${ctx}/logout">退出</a></li>
				</ul>
			</div>
		</shiro:user>
		</h1>
	</div>
</div>
 -->