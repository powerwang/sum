<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var path = '${pageContext.request.contextPath}';
</script>
<link rel="stylesheet" href="${ctx}/static/tree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/static/tree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${ctx}/static/tree/js/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript" src="${ctx}/static/tree/js/crmRoleTree.js"></script>



<!--	Setting	角色权限列表	-->
<div class="row-fluid box" style="height:602px;">
	<div class="tab-header">基本设置</div>
	<div class="padded" style="overflow:auto;height:520px;">
		 <!--	Setting Contact		-->
			<ul class="breadcrumb">
				<li><a href="#">基本设置</a> <span class="divider">/</span></li>
				<li class="active"><a href="${ctx }/admin/role">权限列表</a> <span class="divider">/</span></li>
				<li class=""><a href="">${role.name }</a></li>
				
			</ul>
			 <!-- permission start -->
			<div class="content_wrap">
				<div class="zTreeDemoBackground left">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
			</div>
			
			<div class="form-actions">
			    <input type="hidden" id="roleId" value="${role.id }">
			    <a href="#" onclick="sumbitPer();"  class="btn btn-primary ">提交</a>
			    <a href="${ctx }/admin/role/permission/${role.id}"  class="btn  ">取消</a>
	        </div>
	        
			<!-- permission end -->
	  </div>
</div>

<script>
	$(document).ready(function() {
		$("#roleList-tab").addClass("active");
		//为inputForm注册validate函数
		$("#inputForm").validate();
	});
</script>
