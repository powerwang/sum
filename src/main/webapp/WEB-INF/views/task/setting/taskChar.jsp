<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/script" src="${ctx }/static/chart/highcharts-all.js"></script>
<script type="text/script" src="${ctx }/static/chart/exporting.js"></script>
<script type="text/javascript">




$(function () {
	
$(document).ready(function() {
	
		var colors = Highcharts.getOptions().colors,
			categories = ['无','男','女'],
			name = '性别',
			type = 'column',
			title = '客户-性别分布统计',
			data = [{name:'无',y:1,color: colors[0]},{name:'男',y:0,color: colors[1]},{name:'女',y:0,color: colors[2]}];	
		var chart = new Highcharts.Chart({
			chart: {
				renderTo: 'containeraaaa',
				inverted: false  //左右显示，默认上下正向。假如设置为true，则横纵坐标调换位置
			},
			title: {
				text: 'Monthly Average Rainfall'
			},
	        subtitle: {
	            text: 'Source: WorldClimate.com'
	        },
	        xAxis: {
	            categories: [
	                'Jan',
	                'Feb',
	                'Mar',
	                'Apr',
	                'May',
	                'Jun',
	                'Jul',
	                'Aug',
	                'Sep',
	                'Oct',
	                'Nov',
	                'Dec'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: 'Rainfall (mm)'
	            }
	        },
	        
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
			
	        series: [{
	            name: 'Tokyo',
	            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
	
	        }, {
	            name: 'New York',
	            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
	
	        }, {
	            name: 'London',
	            data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]
	
	        }, {
	            name: 'Berlin',
	            data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]
	
	        }]
	        
		});
});  
});



</script>

     
<div id="showReportInfo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="width: 1000px; margin-left: -500px; height: 600px; ">
	<div class="modal-header">
		<button class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="myModalLabel">任务-新添分布统计</h3>
	</div>
<div class="modal-body" style="max-height:520px;height:520px">
	<div style="position: relative;height: 20px;margin-bottom: 20px">
		<table border="0" align="left" width="100%">
		   <tbody>
					<tr>
						<td align="center">
						   显示类型: <select name="graphtype">
								<option value="column">柱图</option>
								<option value="line" selected="">折线图</option>
								<option value="pie">饼图</option>
							</select>
						   &nbsp; &nbsp;统计项目: <select name="grouptype">
								 <option value="count" selected="">记录数</option>
							</select>
							<button type="button" style="margin-top: -8px;" class="btn btn-success btn-small" onclick="">
							<i class="icon-ok icon-white"></i> 确定 </button>
						</td>
					</tr>
			</tbody>
		</table>
	</div>
    <ul class="nav nav-tabs">
	  <li class="active"><a href="#reportChar" data-toggle="tab">报表图形</a></li>
	  <li><a href="#preportData" data-toggle="tab">报表数据</a></li>
    </ul>
    
    <div id="myTabContent" class="tab-content">
           <div class="tab-pane fade active in" id="reportChar">

		      <div id="containeraaaa" style="min-width:700px;height:400px"></div>
            </div>
            <div class="tab-pane fade" id="preportData">
                    <div class="reportTitle" style="margin-top:10px">客户-性别分布统计</div>
					<table width="97%" border="1" cellspacing="0" cellpadding="0" class="reportTable" basefont="宋体">
	                    <tbody>
	                       <tr><td class="thead">性别 选项</td><td class="thead">记录数</td></tr>
	                       <tr><td class="thead">无</td><td class="thead">1</td></tr>
	                       <tr><td class="thead">男</td><td class="thead">0</td></tr>
	                       <tr><td class="thead">女</td><td class="thead">0</td></tr>
	                       <tr><td class="thead">合计</td><td class="thead">1</td></tr>
	                     </tbody>
                     </table>
            </div>
     </div>
</div>
<div class="modal-footer"></div>
</div>
     
     
     
     


