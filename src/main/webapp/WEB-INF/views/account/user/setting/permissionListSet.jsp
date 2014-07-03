<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var path = '${pageContext.request.contextPath}';
</script>
<link rel="stylesheet" href="${ctx}/static/tree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/static/tree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/bootstrap-modal.js"></script>
<script type="text/javascript" src="${ctx}/static/tree/js/crmTree.js"></script>

<style type="text/css">
div#rMenu {position:absolute; visibility:hidden; top:0;text-align: left;padding: 2px;}
div#rMenu ul li{
	margin: 1px 0;
	padding: 0 5px;
	cursor: pointer;
	list-style: none outside none;
	background-color: #B4D6E7;
}
</style>

<!--	Setting	 用户列表	-->
<div class="row-fluid box" style="height:602px;">
	<div class="tab-header">基本设置</div>
	<div class="padded" style="overflow:auto;height:520px;">
		 <!--	Setting Contact		-->
			<ul class="breadcrumb">
				<li><a href="#">基本设置</a> <span class="divider">/</span></li>
				<li class="active"><a href="">权限列表</a> <span class="divider">/</span></li>
				<li class="active"></li>
			</ul>
			 <!-- permission start -->
			<div class="content_wrap">
				<div class="zTreeDemoBackground left">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
			</div>
			<div id="rMenu" style="width:135px; visibility: hidden;">
				<ul class="nav nav-list">
					<li id="m_add" onclick="addTreeNode();"  ><i class="icon-plus"></i>增加节点</li>
					<li id="m_reset" onclick="updateTree();"><i class="icon-pencil"></i>修改节点</li>
					<li id="m_del" onclick="removeTreeNode();"><i class="icon-trash"></i>删除节点</li>
				</ul>
			</div>
			<div class="modal hide fade"  id="myModal" style="display: none;top: 25%;">
			   <form id="inputForm" action="${ctx}/admin/permission/update" method="post" class="form-horizontal">
				  <div class="modal-header">
				    <a class="close" data-dismiss="modal">×</a>
				    <h3>权限</h3>
				  </div>
				  <div class="modal-body">
							<input type="hidden" id="permissionId" name="id" />
							<input type="hidden" id="parentId" name="parentId" />
							<fieldset>
								<div class="control-group">
									<label class="control-label">权限名:</label>
									<div class="controls">
									    <!-- disabled=""   -->
										<input type="text"  id="name" name="name" class="input-large"  />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">权限代码:</label>
									<div class="controls">
										<input type="text" id="description" name="description"  class="input-large required"/>
									</div>
								</div>
							</fieldset>
						
				  </div>
				  <div class="modal-footer">
				    <a href="#" data-dismiss="modal" class="btn">关闭</a>
				    <input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>
				  </div>
				</form>
			</div>
			<!-- permission end -->
	  </div>
</div>
<!--	/Setting	-->
<script>
	$(document).ready(function() {
		$("#permissionList-tab").addClass("active");
		//为inputForm注册validate函数
		$("#inputForm").validate();
	});
</script>
