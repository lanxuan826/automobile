<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售业绩统计</title>
    <link href="../css/analysis.css" rel="stylesheet" type="text/css" />
   	<link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css">
  <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
  <script type="text/javascript" src="../js/check.js"></script>
      <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="../js/highcharts/highcharts.js"></script>
  <script type="text/javascript" src="../js/highcharts/exporting.js"></script>
  <script type="text/javascript" src="../js/highcharts/exporting.js"></script>
   <script type="text/javascript">
   $(function () {  
	   
	  //图形显示
	   $('#pic_show').click(function(){
		   $('#saleCountByDate').show();
		   $('#show_table').hide();
	   });
	   //table显示
	   $('#table_show').click(function(){
		   $('#show_table').show();
		   $('#saleCountByDate').hide();
	
	   });
	   
	  
	    $('#saleCountByDate').highcharts({
	        title: {
	            text: 'DF品牌汽车销售量趋势图',
	            x: -20 //center
	        },
	        subtitle: {
	            text: '来源：DF销售管理分析决策系统',
	            x: -20
	        },
	        xAxis: {
	            categories: ['1月', '2月', '3月', '4月', '5月', '6月','7月', '8月', '9月', '10月', '11月', '12月']
	        },
	        yAxis: {
	            title: {
	                text: '销售总量（万台）'
	            },
	            min: 0, 
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        tooltip: {
	            valueSuffix: '万台'
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	        series: [{
	            name: '2014年',
	            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
	        }, {
	            name: '2013年',
	            data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
	        }, {
	            name: '2012年',
	            data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
	        }, {
	            name: '2011年',
	            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
	        }]
	    });
	});
   
   //提交
   function submitForm(){
	   alert( new Date().Format("yyyy-MM-dd").substring(0,7));
	   var timetype = $('input:radio[name="timetype"]:checked').val();
	   var startDate = $('#startDate').val();
	   var endDate = $('#endDate').val();
	   var datePoint = $('#datePoint').val();
	   if(timetype=="0") {
		   if(!isNull(startDate) || !isNull(endDate)){
			   
		   }else {
			   $.messager.alert("提醒", "时间段为空！");
			   return;
		   }
	   }
	   else if(timetype=="1"){
	   		if(!isNull(datePoint)){
	   			
	   		}else {
	   		 $.messager.alert("提醒", "时间点为空！");
	   		 return;
	   		}
	   } else {
		   //无条件 查询的为默认的
		   alert("查询默认");
	   }
   }
   
   //清空
   function clearForm(){
	   alert("清空");
   }
   Date.prototype.Format = function (fmt) { 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
   </script>
</head>
<body>
			<div class="search">
					<ul>
							<li><input  id="timeq" name="timetype" type="radio"  value="0"/>时间段：<input type="month" name="user_date" id="startDate"/>&nbsp;至&nbsp;<input type="month" name="user_date" id="endDate" /></li>
							<li><input  id="timep" name="timetype" type="radio"  value="1"/>时间点(某个月份近五年趋势):<input type="month" name="user_date" id="datePoint"/></li>
					</ul>
			<div class="search_btn">
					<ul>
			 		<li><input name="search" type="button" value="搜索" id="search_form"onClick="javascript:submitForm()"   />
			 		&nbsp;&nbsp;<input name="clean" type="button" id="clear()" value="清空"  onClick="javascript:clearForm()" />  												
			 		</li>
			 		</ul>
			</div>
	</div>
	<div>
	<div class="show_btn">
			<input id="pic_show" name="show" type="radio"  value="图形显示"/>图形显示
			<input id="table_show" name="show" type="radio" value="表格显示" />表格显示
	</div>
	<div id="saleCountByDate" style="min-width:700px;height:360px">
	</div>
	<div class="show_table" id="show_table">
			<table>
					<thead>
						<tr>
							<th></th>
							<th>2011</th>
							<th>2012</th>
							<th>2013</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1yue</td>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>2yue</td>
								<td>2</td>
								<td>2</td>
								<td>2</td>
							</tr>
					</tbody>
			</table>
	</div>
	</div>
	
</body>
</html>