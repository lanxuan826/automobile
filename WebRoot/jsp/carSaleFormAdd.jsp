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
    <link rel="stylesheet" type="text/css" href="../js/themes/demo.css" />
	<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/check.js"></script>
	<style type="text/css">
	table.bodytable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	width: 900px;
	cellpadding:8px;
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
	width: 110px;
}
table.bodytable td input{
	padding:5px 0px;
	width:110px;
	height:11px;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#txtSaleDate").val(new Date().Format("yyyy-MM-dd").substring(0,10));
		//仓库选择框
		$('#comSto').combobox({   
		    url:'getStoInfoByAjax',   
		    valueField:'id',   
		    textField:'text'  
		});  
		
		//初始化客户
		$('#comCustomer').combobox({
			url: 'getDealerInfoByAjax',
			valueField: 'id',
			textField: 'text',
		});
		
		//客户类型二级联动选择框
		$('#comCustomerType').combobox({
			valueField: 'id',
			textField: 'text',
			url: 'customerType.json',
			onSelect: function(rec) {
			if(rec.id=="0"){
				var url = 'getCustomerInfoByAjax';
			}else{
				var url = 'getDealerInfoByAjax';
			}
			$('#comCustomer').combobox('clear');
			$('#comCustomer').combobox('reload',url);
			}
		});
		
		//初始化地区
		$('#comRegion').combobox({
			url: 'getRegioninfoByProvice?proviceID=10',
			valueField: 'id',
			textField: 'text',
		});
		//地区二级联动选择框
		$('#comProvice').combobox({
			valueField: 'id',
			textField: 'text',
			url: 'getProviceInfo',
			onSelect: function(rec) {
			var url = 'getRegioninfoByProvice?proviceID='+rec.id;
			$('#comRegion').combobox('clear');
			$('#comRegion').combobox('reload',url);
			}
		});
		//税率选择框
		$('#comTax').combobox({   
		    url:'getTaxRateInfo',   
		    valueField:'id',   
		    textField:'text'  
		});  
		
	   //车辆选择二级联动
	   $('#comAutoType').combobox({
			valueField: 'id',
			textField: 'text',
			url: 'getAutoTypeInfo',
			onSelect: function(rec) {
			var url = 'getAutoInfoByType?typeID='+rec.id;
			$('#comAutoCode').combobox('clear');
			$('#comAutoCode').combobox('reload',url);
			}
		});
		
		  //车辆2选择二级联动
		   $('#comAutoType2').combobox({
				valueField: 'id',
				textField: 'text',
				url: 'getAutoTypeInfo',
				onSelect: function(rec) {
				var url = 'getAutoInfoByType?typeID='+rec.id;
				$('#comAutoCode2').combobox('clear');
				$('#comAutoCode2').combobox('reload',url);
				}
			});
		  //车辆3选择二级联动
		   $('#comAutoType3').combobox({
				valueField: 'id',
				textField: 'text',
				url: 'getAutoTypeInfo',
				onSelect: function(rec) {
				var url = 'getAutoInfoByType?typeID='+rec.id;
				$('#comAutoCode3').combobox('clear');
				$('#comAutoCode3').combobox('reload',url);
				}
			});
		  //车辆4选择二级联动
		   $('#comAutoType4').combobox({
				valueField: 'id',
				textField: 'text',
				url: 'getAutoTypeInfo',
				onSelect: function(rec) {
				var url = 'getAutoInfoByType?typeID='+rec.id;
				$('#comAutoCode4').combobox('clear');
				$('#comAutoCode4').combobox('reload',url);
				}
			});
		  //车辆5选择二级联动
		   $('#comAutoType5').combobox({
				valueField: 'id',
				textField: 'text',
				url: 'getAutoTypeInfo',
				onSelect: function(rec) {
				var url = 'getAutoInfoByType?typeID='+rec.id;
				$('#comAutoCode5').combobox('clear');
				$('#comAutoCode5').combobox('reload',url);
				}
			});
		  //车辆选择二级联动
		   $('#comAutoType').combobox({
				valueField: 'id',
				textField: 'text',
				url: 'getAutoTypeInfo',
				onSelect: function(rec) {
				var url = 'getAutoInfoByType?typeID='+rec.id;
				$('#comAutoCode').combobox('clear');
				$('#comAutoCode').combobox('reload',url);
				}
			});
	});

	
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
<body >
	
		<div data-options="region:'north',border:true" style="height:200px;border-color:red;padding:10px">
		<div><h1>车辆销售单</h1></div>
		<table cellpadding="10">
			<tr>
				<td><label>销售单号:</label><input id="txtSaleid" name="txtSaleid" type="text" readonly="readonly" /></td>
				<td><label>客商类型:</label>
						  <input id="comCustomerType" class="easyui-combobox" editable="false" name="customerType"  />
				</td>
				<td><label>客户名称:</label>
						 <input id="comCustomer" name="comCustomer" class="easyui-combobox" editable="false" data-options="valueField:'id',textField:'text'"/>
				</td>
			</tr>
		
			<tr>
				<td><label>出库仓库:</label>
							<input id="comSto" class="easyui-combobox" name="sto" editable="false"/>
				</td>
				<td><label>地区:</label>
							  <input  id="comProvice" class="easyui-combobox" editable="false" name="provice"   />
				</td>
				<td><label>城市</label>
							<input id="comRegion" name="region" class="easyui-combobox"  editable="false" data-options="valueField:'id',textField:'text'" />
				</td>
			</tr>
		   <tr>
				<td><label>是否付款:</label>
						 <select id="comIsPay" class="easyui-combobox" name="isPay" style="width:200px;">
						  		<option value="1">已付款</option>
						  		<option value="0">未付款</option>
						   </select>
				</td>
				<td><label >税率账套:</label>
						 <input id="comTax" class="easyui-combobox" name="tax" editable="false"  />
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
		<div data-options="region:'center',border:true" style="height:310px;border-color:green;">

			 <table  class="bodytable"  id="dg" class="easyui-datagrid" title="Cell Editing in DataGrid" style="height:auto" 
			 				data-options="iconCls: 'icon-edit',singleSelect: true,url: 'datagrid_data1.json',method:'get',onClickCell: onClickCell	">
			 	<thead>
			 		<tr>
			 				<th>序号</th>
			 				<th>车辆型号</th>
			 				<th>车辆编号</th>
			 				<th>销售单价(万元)</th>
			 				<th>销售数量</th>
			 				<th>税前(万元)</th>
			 				<th>税额(万元)</th>
			 				<th>税后(万元)</th>
			 				<th>小计金额(万元)</th>
			 		</tr>
			 		</thead>
			 		<tbody>
			 		 <tr id="data" onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			 				<td>1</td>
			 				<td><input id="comAutoType" class="easyui-combobox" name="autoType" readonly="readonly"/>
						  	</td>
						  	<td>
						  		 <input id="comAutoCode" name="autoCode" class="easyui-combobox" data-options="valueField:'id',textField:'text'" readonly="readonly"/>
						  	</td>
						  <td><input type="text" id="salePrice" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleNum" class="easyui-numberbox" ></td>
						  	<td><input type="text" id="salebefore" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleCount"class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleAfter" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleTotal" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
			 			</tr>
			 		
			 	 		 <tr id="data" onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			 				<td>2</td>
			 				<td><input id="comAutoType2" class="easyui-combobox" name="autoType" readonly="readonly"/>
						  	</td>
						  	<td>
						  		 <input id="comAutoCode2" name="autoCode" class="easyui-combobox" data-options="valueField:'id',textField:'text'" readonly="readonly"/>
						  	</td>
						  <td><input type="text" id="salePrice" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleNum" class="easyui-numberbox" ></td>
						  	<td><input type="text" id="salebefore" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleCount"class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleAfter" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleTotal" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
			 			</tr>
			 		 	
			 		 	 <tr id="data" onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			 				<td>3</td>
			 				<td><input id="comAutoType3" class="easyui-combobox" name="autoType" readonly="readonly"/>
						  	</td>
						  	<td>
						  		 <input id="comAutoCode3" name="autoCode" class="easyui-combobox" data-options="valueField:'id',textField:'text'" readonly="readonly"/>
						  	</td>
						  <td><input type="text" id="salePrice" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleNum" class="easyui-numberbox" ></td>
						  	<td><input type="text" id="salebefore" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleCount"class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleAfter" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleTotal" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
			 			</tr>
			 		
			 		
			 		
			 		<tr id="data" onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			 				<td>4</td>
			 				<td><input id="comAutoType4" class="easyui-combobox" name="autoType" readonly="readonly"/>
						  	</td>
						  	<td>
						  		 <input id="comAutoCode4" name="autoCode" class="easyui-combobox" data-options="valueField:'id',textField:'text'" readonly="readonly"/>
						  	</td>
						  <td><input type="text" id="salePrice" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleNum" class="easyui-numberbox" ></td>
						  	<td><input type="text" id="salebefore" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleCount"class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleAfter" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleTotal" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
			 			</tr>
			 		
			 		<tr id="data" onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
			 				<td>5</td>
			 				<td><input id="comAutoType5" class="easyui-combobox" name="autoType" readonly="readonly"/>
						  	</td>
						  	<td>
						  		 <input id="comAutoCode5" name="autoCode" class="easyui-combobox" data-options="valueField:'id',textField:'text'" readonly="readonly"/>
						  	</td>
						  <td><input type="text" id="salePrice" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleNum" class="easyui-numberbox" ></td>
						  	<td><input type="text" id="salebefore" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleCount"class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleAfter" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
						  	<td><input type="text" id="saleTotal" class="easyui-numberbox" precision="2" max="99999.99" size="8" maxlength="8" ></td>
			 			</tr>
			 		
				</tbody>
			 		
			 	
			 </table>
		</div>
		<div data-options="region:'south',border:true" style="height:60px;padding:10px;border-color: blue">
			<table cellpadding="10">
				<tr>
				   		<td><label>开单人:</label><input id="txtUserName" name="txtUserName" type="text" /></td>
					    <td><label>销售日期:</label><input id="txtSaleDate" name="txtSaleDate" type="text" readonly="readonly"  /></td>
				
			</tr>
			</table>
		</div>
		<div style="height:30px;margin-bottom: 10px;margin-top: 20px;">
				 <input type="submit" id="btn_save" value="保存"  class="easyui-linkbutton"style="padding:5px 0px;width:80px;"  />
				 <input type="button" id="btn_back" value="返回"  class="easyui-linkbutton"style="padding:5px 0px;width:80px;" />
		</div>
		
</body>
<script type="text/javascript">
$('#btn_back').click(function(){
	window.location.href="carSaleManage.jsp";
});

$('#btn_save').click(function(){
	alert("save");
	var data = "";
	var data_carType="";
	var data_temp = ""; 
	var customer = $('#comCustomer').combobox('getValue');
	var customerType = $('#comCustomerType').combobox('getValue');
	var storge =  $('#comSto').combobox('getValue');
	var provice = $('#comProvice').combobox('getValue');
	var region = $('#comRegion').combobox('getValue');
	var isPay = $('#comIsPay').val();
	var  saleDate =  $('#txtSaleDate').val(); 
	var comTax = $('#comTax').combobox('getValue');
	alert("customerType:"+customerType);
	alert("customer:"+customer);
	alert("storge:"+storge);
	alert('provice:'+provice);
	alert('region:'+region);
	alert('isPay:'+isPay);
	alert('comTax:'+comTax);
	//获取表格中的额值
	$('#dg').find('tbody').find('tr').each(function(i){
		if($('#dg').find('tbody').find("tr:eq("+i+")").find("td").length != 0) {
			$('#dg').find('tbody').find('tr:eq('+i+')').find('td').each(function(j){
				if ($(this).css("display") != "none") {  
					  if ($(this).find("input[type='text']").length == 0) {  
						  data_temp = ($(this).text() == "" ? " " : $(this).text());  
					  }else {
						  data_temp = ($(this).find("input[type='text']:eq(0)").val() == "" ? " " : $(this).find("input[type='text']:eq(0)").val());
					  }
					  data += data_temp + "|";
				}
			});
		}
		data += "_"
	});
	//获取隐藏的值
	for(var i=0;i<5;i++) {
		data_carType +="|";
		if(!isNull($("input[name='autoType']:eq("+i+")").val())){
			data_carType +=$("input[name='autoType']:eq("+i+")").val();
		}else{
			data_carType +=" ";
		}
	}
	alert(data_carType);
	alert(data);
	var customer = $('#comCustomer').combobox('getValue');
	var customerType = $('#comCustomerType').combobox('getValue');
	var storge =  $('#comSto').combobox('getValue');
	var provice = $('#comProvice').combobox('getValue');
	var region = $('#comRegion').combobox('getValue');
	var isPay = $('#comIsPay').val();
	var  saleDate =  $('#txtSaleDate').val(); 
	var url = "carSaleFormAdd?data_carType="+data_carType+"&data="+data+"&customer="+customer+
					"&customerType="+customerType+"&storg="+storge+"&provice="+provice+"&region="+region+
					"&isPay="+isPay+"&saleDate="+saleDate;
	window.location.href = url;
	
	
});

</script>
</html>