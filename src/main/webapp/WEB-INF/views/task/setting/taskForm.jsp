<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>任务管理</title>
</head>

<body>
     
 <div id="showReportInfo" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="width: 1000px; margin-left: -400px; height: 600px; display: block;"><!--<LINK REL="stylesheet" TYPE="text/css" HREF="include/phpreports/sales.css">-->
<!--<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>-->
<link href="themes/images/report.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="themes/images/tabpane.js"></script>
<link href="themes/images/tab.css" rel="stylesheet" type="text/css">
<script src="include/js/highcharts.js"></script>
<script src="include/js/exporting.js"></script>
<script>
	
		function changeTypeOfReport(url){
		
			$.ajax({
				type:"GET",
				url:url,
				success:function(msg){
					$("#showReportInfo").html(msg);
				}
			});
		}
	
</script>

<div class="modal-header">
	<button class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h3 id="myModalLabel">客户-性别分布统计</h3>
</div>
<div class="modal-body" style="max-height:520px;height:520px">
	<div style="position: relative;height: 20px;margin-bottom: 20px">
		<table border="0" align="left" width="100%">
			<form method="post" action="index.php"></form>
				<tbody>
					<tr>
						<td align="center">
						   显示类型: <select name="graphtype">
								<option value="column">柱图</option><option value="line" selected="">折线图</option><option value="pie">饼图</option>
							</select>
						   &nbsp; &nbsp;统计项目: <select name="grouptype">
								<option value="count" selected="">记录数</option>
							</select>
							<button type="button" class="btn btn-success btn-small" onclick="changeTypeOfReport('index.php?module=ListViewReport&amp;action=Popup_ListView&amp;pickfieldname='+document.getElementsByName('pickfieldname')[0].value+'&amp;pickfieldtable='+document.getElementsByName('pickfieldtable')[0].value+'&amp;pickfieldcolname='+document.getElementsByName('pickfieldcolname')[0].value+'&amp;relatedmodule='+document.getElementsByName('relatedmodule')[0].value+'&amp;PHPSESSID='+document.getElementsByName('PHPSESSID')[0].value+'&amp;graphtype='+document.getElementsByName('graphtype')[0].value+'&amp;grouptype='+document.getElementsByName('grouptype')[0].value)">
							<i class="icon-ok icon-white"></i> 确定 </button>
						</td>
					</tr>
				</tbody>
			
		</table>
	</div>

	<div class="dynamic-tab-pane-control tab-pane" id="tabPane1"><div class="tab-row"><h2 class="tab"><a href="#">报表图形</a></h2><h2 class="tab selected"><a href="#">报表数据</a></h2></div>
		<div align="left" class="tab-page" id="tabPage1" style="display: none;">
		<br>
		<div id="container"><div class="highcharts-container" id="highcharts-0" style="position: relative; overflow: hidden; width: 948px; height: 400px; text-align: left; line-height: normal; z-index: 0; font-family: 'Lucida Grande', 'Lucida Sans Unicode', Verdana, Arial, Helvetica, sans-serif; font-size: 12px;"><svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="948" height="400"><defs><clipPath id="highcharts-1"><rect rx="0" ry="0" fill="none" x="0" y="0" width="9999" height="400" stroke-width="0.000001"></rect></clipPath><clipPath id="highcharts-2"><rect fill="none" x="0" y="0" width="866" height="292"></rect></clipPath><linearGradient x1="0" y1="0" x2="0" y2="20" gradientUnits="userSpaceOnUse" id="highcharts-5"><stop offset="0.4" stop-color="#F7F7F7" stop-opacity="1"></stop><stop offset="0.6" stop-color="#E3E3E3" stop-opacity="1"></stop></linearGradient><linearGradient x1="0" y1="0" x2="0" y2="20" gradientUnits="userSpaceOnUse" id="highcharts-6"><stop offset="0.4" stop-color="#F7F7F7" stop-opacity="1"></stop><stop offset="0.6" stop-color="#E3E3E3" stop-opacity="1"></stop></linearGradient></defs><rect rx="5" ry="5" fill="#FFFFFF" x="0" y="0" width="948" height="400" stroke-width="0.000001"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"><path fill="none" d="M 72 274.5 L 938 274.5" stroke="#C0C0C0" stroke-width="1" zIndex="1"></path><path fill="none" d="M 72 215.5 L 938 215.5" stroke="#C0C0C0" stroke-width="1" zIndex="1"></path><path fill="none" d="M 72 157.5 L 938 157.5" stroke="#C0C0C0" stroke-width="1" zIndex="1"></path><path fill="none" d="M 72 98.5 L 938 98.5" stroke="#C0C0C0" stroke-width="1" zIndex="1"></path><path fill="none" d="M 72 40.5 L 938 40.5" stroke="#C0C0C0" stroke-width="1" zIndex="1"></path><path fill="none" d="M 72 332.5 L 938 332.5" stroke="#C0C0C0" stroke-width="1" zIndex="1"></path></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 648.5 332 L 648.5 337" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 937.5 332 L 937.5 337" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 360.5 332 L 360.5 337" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 72 332.5 L 938 332.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"><text x="26" y="186" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#6D869F;font-weight:bold;fill:#6D869F;" zIndex="7" transform="rotate(270 26 186)" text-anchor="middle" visibility="visible"><tspan x="26">数值(个)</tspan></text></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series" visibility="visible" zIndex="0.1" transform="translate(72,40)" clip-path="url(#highcharts-2)"><path fill="none" d="M 144.33333333333334 58.4 L 433 292 L 721.6666666666667 292" stroke="black" stroke-width="5" zIndex="1" isShadow="true" stroke-opacity="0.049999999999999996" transform="translate(1, 1)"></path><path fill="none" d="M 144.33333333333334 58.4 L 433 292 L 721.6666666666667 292" stroke="black" stroke-width="3" zIndex="1" isShadow="true" stroke-opacity="0.09999999999999999" transform="translate(1, 1)"></path><path fill="none" d="M 144.33333333333334 58.4 L 433 292 L 721.6666666666667 292" stroke="black" stroke-width="1" zIndex="1" isShadow="true" stroke-opacity="0.15" transform="translate(1, 1)"></path><path fill="none" d="M 144.33333333333334 58.4 L 433 292 L 721.6666666666667 292" stroke="#4572A7" stroke-width="2" zIndex="1"></path></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(72,40)" clip-path="none"><path fill="#4572A7" d="M 721.6666666666667 288 C 726.9946666666667 288 726.9946666666667 296 721.6666666666667 296 C 716.3386666666668 296 716.3386666666668 288 721.6666666666667 288 Z" stroke="#FFFFFF" stroke-width="0.000001" visibility="inherit"></path><path fill="#4572A7" d="M 433 288 C 438.328 288 438.328 296 433 296 C 427.672 296 427.672 288 433 288 Z" stroke="#FFFFFF" stroke-width="0.000001" visibility="inherit"></path><path fill="#4572A7" d="M 144.33333333333334 54.4 C 149.66133333333335 54.4 149.66133333333335 62.4 144.33333333333334 62.4 C 139.00533333333334 62.4 139.00533333333334 54.4 144.33333333333334 54.4 Z" stroke="#FFFFFF" stroke-width="0.000001" visibility="inherit"></path></g></g><text x="474" y="25" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:16px;color:#3E576F;fill:#3E576F;" text-anchor="middle" class="highcharts-title" zIndex="4"><tspan x="474">客户-性别分布统计</tspan></text><g class="highcharts-legend" zIndex="7" transform="translate(444,358)"><rect rx="5" ry="5" fill="none" x="0.5" y="0.5" width="60" height="26" stroke-width="1" stroke="#909090" visibility="visible"></rect><g zIndex="1" clip-path="url(#highcharts-1)"><g><g class="highcharts-legend-item" zIndex="1" transform="translate(8,3)"><path fill="none" d="M 0 11 L 16 11" stroke-width="2" stroke="#4572A7"></path><path fill="#4572A7" d="M 8 7 C 13.328 7 13.328 15 8 15 C 2.6719999999999997 15 2.6719999999999997 7 8 7 Z" stroke="#4572A7"></path><text x="21" y="15" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;cursor:pointer;color:#3E576F;fill:#3E576F;" text-anchor="start" zIndex="2"><tspan x="21">性别</tspan></text></g></g></g></g><g class="highcharts-axis-labels" zIndex="7"><text x="216.33333333333334" y="346" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:269px;color:#666;line-height:14px;fill:#666;" text-anchor="middle" visibility="visible"><tspan x="216.33333333333334">无</tspan></text><text x="505" y="346" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:269px;color:#666;line-height:14px;fill:#666;" text-anchor="middle" visibility="visible"><tspan x="505">男</tspan></text><text x="793.6666666666667" y="346" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:269px;color:#666;line-height:14px;fill:#666;" text-anchor="middle" visibility="visible"><tspan x="793.6666666666667">女</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"><text x="64" y="336.5921875" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:413px;color:#666;line-height:14px;fill:#666;" text-anchor="end" visibility="visible"><tspan x="64">0</tspan></text><text x="64" y="103" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:413px;color:#666;line-height:14px;fill:#666;" text-anchor="end" visibility="visible"><tspan x="64">1</tspan></text><text x="64" y="278.19218750000005" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:413px;color:#666;line-height:14px;fill:#666;" text-anchor="end" visibility="visible"><tspan x="64">0.25</tspan></text><text x="64" y="219.79218749999998" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:413px;color:#666;line-height:14px;fill:#666;" text-anchor="end" visibility="visible"><tspan x="64">0.5</tspan></text><text x="64" y="161.3921875" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:413px;color:#666;line-height:14px;fill:#666;" text-anchor="end" visibility="visible"><tspan x="64">0.75</tspan></text><text x="64" y="44.5921875" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;width:413px;color:#666;line-height:14px;fill:#666;" text-anchor="end" visibility="visible"><tspan x="64">1.25</tspan></text></g><g class="highcharts-tooltip" zIndex="8" style="padding:0;white-space:nowrap;" visibility="hidden" transform="translate(166,87)"><rect rx="5" ry="5" fill="none" x="0" y="0" width="38" height="26" stroke-width="5" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" transform="translate(1, 1)"></rect><rect rx="5" ry="5" fill="none" x="0" y="0" width="38" height="26" stroke-width="3" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" transform="translate(1, 1)"></rect><rect rx="5" ry="5" fill="none" x="0" y="0" width="38" height="26" stroke-width="1" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.15" transform="translate(1, 1)"></rect><rect rx="5" ry="5" fill="rgb(255,255,255)" x="0" y="0" width="38" height="26" stroke-width="2" fill-opacity="0.85" stroke="#4572A7" anchorX="50" anchorY="11"></rect><text x="5" y="18" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;" zIndex="1"><tspan x="5">无: 1</tspan></text></g><text x="938" y="395" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:10px;cursor:pointer;color:#909090;fill:#909090;" text-anchor="end" zIndex="8"></text><g class="highcharts-tracker" zIndex="9"><g visibility="visible" zIndex="1" transform="translate(72,40)"><path fill="none" d="M 134.33333333333334 58.4 L 144.33333333333334 58.4 L 433 292 L 721.6666666666667 292 L 731.6666666666667 292" isTracker="true" stroke-linejoin="bevel" visibility="visible" stroke-opacity="0.000001" stroke="rgb(192,192,192)" stroke-width="22" style=""></path></g></g><rect rx="3" ry="3" fill="url(#highcharts-5)" x="0.5" y="0.5" width="23" height="19" stroke-width="1" transform="translate(914,10)" zIndex="19" stroke="#B0B0B0"></rect><rect rx="3" ry="3" fill="url(#highcharts-6)" x="0.5" y="0.5" width="23" height="19" stroke-width="1" transform="translate(888,10)" zIndex="19" stroke="#B0B0B0"></rect><path fill="#A8BF77" d="M 5.5 16.5 L 17.5 16.5 17.5 14.5 5.5 14.5 Z M 11.5 14.5 L 15.5 9.5 10.5 9.5 10.5 4.5 12.5 4.5 12.5 9.5 7.5 9.5 Z" transform="translate(914,10)" stroke="#A0A0A0" stroke-width="1" zIndex="20"></path><path fill="#B5C9DF" d="M 5.5 12.5 L 17.5 12.5 17.5 9.5 5.5 9.5 Z M 7.5 9.5 L 7.5 4.5 15.5 4.5 15.5 9.5 Z M 7.5 12.5 L 5.5 16.5 17.5 16.5 15.5 12.5 Z" transform="translate(888,10)" stroke="#A0A0A0" stroke-width="1" zIndex="20"></path><rect rx="0" ry="0" fill="rgb(255,255,255)" x="914" y="10" width="24" height="20" stroke-width="0.000001" id="exportButton" fill-opacity="0.001" title="Export to raster or vector image" zIndex="21" style="cursor:pointer;"><title>Export to raster or vector image</title></rect><rect rx="0" ry="0" fill="rgb(255,255,255)" x="888" y="10" width="24" height="20" stroke-width="0.000001" id="printButton" fill-opacity="0.001" title="Print the chart" zIndex="21" style="cursor:pointer;"><title>Print the chart</title></rect></svg></div></div>
		<script type="text/javascript">
		
		$(function () {
		var chart;
		$(document).ready(function() {
			var colors = Highcharts.getOptions().colors,
				categories = ['无','男','女'],
				name = '性别',
				type = 'line',
				title = '客户-性别分布统计',
				data = [{name:'无',y:1,color: colors[0]},{name:'男',y:0,color: colors[1]},{name:'女',y:0,color: colors[2]}];	
			chart = new Highcharts.Chart({
				chart: {
					renderTo: 'container',
					inverted: false  //左右显示，默认上下正向。假如设置为true，则横纵坐标调换位置
				},
				title: {
					text: title
				},
				xAxis: {
					categories: categories,
					labels: {
							rotation: 0      //坐标值显示的倾斜度    
						}
				},
				yAxis: {
					min: 0,
					title: {
						text: '数值(个)'
					}
				},
				plotOptions: {
					pie: {
						allowPointSelect: true,
						cursor: 'pointer',
						dataLabels: {
							enabled: true,
							color: '#000000',
							connectorColor: '#000000',
							formatter: function() {
								return '<b>'+ this.point.name +'</b>: '+ this.y ;
							}
						}
					}
				},
				tooltip: {
					formatter: function() {
						var s;
						if (type == 'pie') {// the pie chart
							s = ''+
								this.point.name + ': '+ this.percentage +' %';
						} else {
							s = ''+
								this.x  +': '+ this.y;
						}
						return s;
					}
				},
			   series: [{
					name: name,
					type: type,
					data: data
			   }]
			});
	   });  
	});

	</script>
		</div>
		<div class="tab-page" id="tabPage2" style="display: block;">
			
				<div id="report">
					<div class="reportTitle" style="margin-top:10px">客户-性别分布统计</div>
					<table width="97%" border="1" cellspacing="0" cellpadding="0" class="reportTable" basefont="宋体">
            <tbody><tr><td class="thead">性别 选项</td><td class="thead">记录数</td></tr><tr><td class="thead">无</td><td class="thead">1</td></tr><tr><td class="thead">男</td><td class="thead">0</td></tr><tr><td class="thead">女</td><td class="thead">0</td></tr><tr><td class="thead">合计</td><td class="thead">1</td></tr></tbody></table>
				</div>
		</div>
	</div>

</div>
<div class="modal-footer">
</div></div>
     
     
     
     
	<form id="inputForm" action="${ctx}/task/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${task.id}"/>
		<fieldset>
			<legend><small>管理任务</small></legend>
			<div class="control-group">
				<label for="task_title" class="control-label">任务名称:</label>
				<div class="controls">
					<input type="text" id="task_title" name="title"  value="${task.title}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="description" class="control-label">任务描述:</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large">${task.description}</textarea>
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#task_title").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</body>
</html>
