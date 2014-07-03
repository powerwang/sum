<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>任务管理</title>
</head>
<body>
<div class="container-fluid ">
 <div style="margin-top:2px;padding-top:5px;margin-bottom:5px;border-top:2px solid #0088CC;"> 
  <div class="">
     <a href="${ctx}/task/create " class="btn btn-small btn-primary pull-left"  style="margin-top:2px;"><i class="icon-plus icon-white"></i>新增</a>
     <button class="btn btn-small btn-danger pull-left" style="margin-top:2px; margin-left: 2px;margin-right: 5px;"><i class="icon-trash icon-white"></i>删除</button>
     <form class="form-search " style="margin-bottom:5px"  action="" method="POST">
         <input type="text" class="input-large search-query" value="" name="search_text">
         <button type="button" class="btn btn-small" onclick=""><i class="icon-search"></i>&nbsp;搜索</button>
      </form>   
                             
  </div>
 </div>
 
 <div id="ListViewContents" class="small" style="width:100%;position:relative;"><div id="quickedit_form_div" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
  <div style="margin-top:0px;margin-bottom:0px;">
   <table class="table table-bordered table-hover table-condensed table-striped">
    <thead>
      <tr>  
          <th align="left" width="35">
            <input type="checkbox" name="selectedAll" id="selectedAll">
            </th>
                 <th align="left"><a href="javascript:;" onclick="" >任务名&nbsp;</a></th>
                 <th align="left"><a href="javascript:;" onclick="" >任务内容&nbsp;</a></th>
                 <th align="left"><a href="javascript:;" onclick="" >添加时间&nbsp;</a></th>
                 <th align="left"><a href="javascript:;" onclick="" >状态&nbsp;</a></th>
                 <th align="left">编辑 | 删除</th>
           </tr>
     </thead>
     <tbody>
     
      <c:forEach items="${tasks.list}" var="task">
			<tr>
			    <td>
		            <input type="checkbox" name="selected_id" id="selected_id_" value="">
		        </td>
				<td><a href="${ctx}/task/update/${task.id}">${task.title}</a></td>
				<td><a href="" >${task.description} </a></td>
				<td><a href="" ><fmt:formatDate value="${task.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </a></td>
				<td>${task.taskType }</td>
				<td><a href="" title="编辑"> &nbsp;<i class="icon-edit "></i> </a>  | <a href=''> &nbsp;<i class="icon-trash"></i> </a></td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
  </div>
	<!-- 分页 -->
	<tags:pagination page="${tasks}" paginationSize="5"/>   
      
    <div style="background-color:#D4E4FF " >
        <img src="${ctx }/static/images/count.gif" style="width: 25px;"  width="25px;" height="25px;" border="0"><span style="font-size:12px;">&nbsp;<strong>本次查询汇总结果</strong></span>
    </div>
    <div align="center">
         <span>【总任务数】&nbsp;&nbsp;</span><span>【已经完成】:&nbsp;&nbsp;</span>
    </div>

    <div style="background-color:#D4E4FF " >
        <img src="${ctx }/static/images/chart.gif" style="width: 25px;" width="25" height="25" border="0"><strong><span style="font-size:12px;">&nbsp;本次查询统计报表</span></strong>
    </div>
    <div align="">
          ●<a style="color: rgb(153, 102, 51);" href="javascript:showReport();">任务添加统计</a>　
		  ●<a style="color: rgb(153, 102, 51);" href="">任务完成统计</a>　
    </div>
    <%-- @include file="setting/taskChar.jsp" --%>
</div>
</div>


<script type="text/javascript" src="${ctx}/static/bootstrap/bootstrap-modal.js"></script>
    <script>
		$(document).ready(function() {
			$("#actionTask").addClass("active");
// 			taskChart();
		});
		function showReport(){
			$('#showReportInfo').modal({
			    backdrop:true,
			    keyboard: false,
			    show:true
			});
			
			
		}
	</script>
</body>
</html>
