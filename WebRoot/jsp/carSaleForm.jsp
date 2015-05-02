<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆销售单</title>
  <link href="../css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../js/themes/icon.css" />
	<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/tableEdit.js"></script>
	<style type="text/css">
	table.bodytable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	width: 960px;
}
table.bodytable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.bodytable tr {
	background-color:#d4e3e5;
}
table.bodytable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>

</head>
<body >
	<div >
		<div data-options="region:'north',border:true" style="height:150px;border-color:red;background:#B3DFDA;padding:10px">
		<table cellpadding="6">
			<tr>
				<td><label>销售单号:</label><input id="txtSaleid" name="txtSaleid" type="text" readonly="readonly" /></td>
				<td><label>客商类型:</label>
						  <input id="comCustomerType" class="easyui-combobox" name="customerType"  data-options="
						  			valueField: 'id',
						  			textField: 'text',
						  			url: '',
						  			onSelect: function(rec) {
						  			var url = ''+rec.id;
						  			$('#customer').combobox('reload',url);
						  			}"/>
				</td>
				<td><label>客户名称:</label>
						 <input id="comCustomer" name="customer" class="easyui-combobox" data-options="valueField:'id',textField:'text'"/>
				</td>
			</tr>
		
			<tr>
				<td><label>出库仓库:</label>
							<input id="comSto" class="easyui-combobox" name="sto" data-options="valueField:'id',textField:'text',url:'get_data.php'"/>
				</td>
				<td><label>地区:</label>
							<input id="region" name="region" type="text"/>
				</td>
			</tr>
		   <tr>
				<td><label>是否付款:</label>
						 <select id="comIsPay" class="easyui-combobox" name="isPay" style="width:200px;"/>
						  		<option value="1">已付款</option>
						  		<option value="0">未付款</option>
						   </select>
				</td>
				<td><label >税率账套:</label>
						 <input id="comTax" class="easyui-combobox" name="tax" data-options="valueField:'id',textField:'text',url:'get_data.php'"/>
				</td>
				<td><label>税前:</label>
						  <input id="txtBeforeTax" type="text" name="beforeTax" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td><label>税额:</label>
						  <input id="txtTax" type="text" name="taxMoney"readonly="readonly"/>
				</td>
				<td><label>总计金额:</label>
						  <input id="txtTotal" type="text" name="taxTotal"readonly="readonly"/>
				</td>
				<td><label>备注:</label>
						 <input id="txtRemark" type="text" name="renark"/>
				</td>
			</tr>
		
		</table>
		
		</div>
		<div data-options="region:'center',border:true" style="height:300px;border-color:green;">
			<div>
			<input type="button" id="btn_add" value="添加行"/>
			<input type="button" id="btn_del" value="删除行"/>
			<input type="button" id="submit" value="提  交"/>
			</div>
			 <table  class="bodytable" cellpadding="20"   id="myTable">
			 		<tr>
			 				<th>序号</th>
			 				<th>车辆型号</th>
			 				<th>车辆编号</th>
			 				<th>销售单价</th>
			 				<th>销售数量</th>
			 				<th>税前</th>
			 				<th>税额</th>
			 				<th>税后</th>
			 				<th>小计金额</th>
			 		</tr>
			 		<!--  
			 		 <tr id="data" onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			 				<td><input id="comCustomerType" class="easyui-combobox" name="customerType"  data-options="
						  			valueField: 'id',
						  			textField: 'text',
						  			url: '',
						  			onSelect: function(rec) {
						  			var url = ''+rec.id;
						  			$('#customer').combobox('reload',url);
						  			}"/>
						  	</td>
						  	<td>
						  		 <input id="comCustomer" name="customer" class="easyui-combobox" data-options="valueField:'id',textField:'text'"/>
						  	</td>
						  	<td>1</td>
						  	<td>1</td>
						  	<td>1</td>
						  	<td>1</td>
						  	<td>1</td>
						  	<td>1</td>
			 		</tr>
			 		-->
			 		<tr id="data">
			 			<td>1</td>
			 			<td>
			 			 <input id="comTax" class="easyui-combobox" name="tax" data-options="valueField:'id',textField:'text',url:'get_data.php'"/>
			 			</td>
						<td>1</td>
			 		    <td>1</td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td>1</td> 		
			 		</tr>
			 </table>
		</div>
		<div data-options="region:'south',border:true" style="margin-bottom: 20px;height:60px;background:#A9FACD;padding:10px;border-color: blue">表尾
		
		</div>
	</div>
</body>

</html>
<script type="text/javascript">
$(document).ready(function(){
		var k = 1;
		$('#btn_add').click(function(){
			var trs = $("tr");
			if(trs.length != 0) {
				var table = document.getElementById('myTable');
				var row = table.insertRow(1);
				k++;
				$(row).attr('id','data');
				row.insertCell(0).innerHTML=k;
				//第一列
				var td1 = row.insertCell(1);
				td1.innerHTML='	';
				$(td1).click(tdClick);
				//第二列
				var td2 = row.insertCell(2);
				td2.innerHTML='';
				$(td2).click(tdClick);
				//第三列
				var td3 = row.insertCell(3);
				td3.innerHTML='';
				$(td3).click(tdClick);
				//第四列
				var td4 = row.insertCell(4);
				td4.innerHTML='';
				$(td4).click(tdClick);
				//第五列
				var td5 = row.insertCell(5);
				td5.innerHTML='';
				$(td5).click(tdClick);
				//第六列
				var td6 = row.insertCell(6);
				td6.innerHTML='';
				$(td6).click(tdClick);
				//第七列
				var td7 = row.insertCell(7);
				td7.innerHTML='';
				$(td7).click(tdClick);
				//第八列
				var td8 = row.insertCell(8);
				td8.innerHTML='';
				$(td8).click(tdClick);
			}
			//重新加载样式
			tdCssStyle();
		});
		
		// 删除行
		$('#btn_del').click(function(){
			var trs = $("tr");
			if(trs.length > 1) {
				document.getElementById('myTable').deleteRow(1);
			}
		});
		
		//获取表格中所以数据
		$('#submit').click(function(){
			var tr = $("tr[id='data']");
			var result = "["; //json格式数据
			$.each(tr,function(trIndex, td){
				var tdNodes = tr.getElementsByTagName("td");
				result += "{";//json格式结果集一个
				$.each(tdNodes, function(tdIndex, td){
					if(tdIndex == 0)
						result += "id:\""+$(td).text()+"\",";
					if(tdIndex == 1)
						result += "name:\""+$(td).text()+"\",";
					if(tdIndex == 2)
						result += "age:\""+$(td).text()+"\",";
					if(tdIndex == 3)
						result += "scope:\""+$(td).text()+"\"";				
					alert("第"+trIndex+"行第"+tdIndex+"列:"+$(td).text());
				});
				result += "},";
			});
			result = result.substring(0,result.length-1);
			result += "]";
			alert(result);
			$.post("TestServlet?data="+result);
		});
	});
</script>