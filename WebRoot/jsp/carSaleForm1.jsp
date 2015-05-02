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
			<table id="dg" class="easyui-datagrid" title="销售单表体" style="width:960px;height:auto" cellpadding="20px"
						data-options="iconCls: 'icon-edit',
						singleSelect: true,
						toolbar: '#tlbar',
						url: '',
						method: 'get',
						onClickRow: onClickRow">
			<thead>
			<tr>
				<th data-options="field:'itemid',width:80">序号</th>
				<th data-options="field:'productid',width:150px,
						formatter:function(value,row){
							return row.productname;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'productid',
								textField:'productname',
								method:'get',
								url:'products.json',
								required:true
							}
						}">车辆型号</th>
						<th data-options="field:'productid',width:150,
						formatter:function(value,row){
							return row.productname;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'productid',
								textField:'productname',
								method:'get',
								url:'products.json',
								required:true
							}
						}">车辆编号</th>
				<th data-options="field:'listprice',width:150px,align:'right',editor:{type:'numberbox',options:{precision:1}}">销售单价</th>
				<th data-options="field:'unitcost',width:120,align:'right',editor:'numberbox'">销售数量</th>
				<th data-options="field:'unitcost',width:120,align:'right',editor:'numberbox'">税前</th>
				<th data-options="field:'unitcost',width:120,align:'right',editor:'numberbox'">税额</th>
				<th data-options="field:'unitcost',width:120,align:'right',editor:'numberbox'">税后</th>
				<th data-options="field:'unitcost',width:120,align:'right',editor:'numberbox'">小计金额</th>
				<!-- <th data-options="field:'attr1',width:250,editor:'text'">Attribute</th> -->
			</tr>
		</thead>
		
	</table>
		<div id="tlbar" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">添加行</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">删除行</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">提交</a>
	</div>
	
		</div>
		<div data-options="region:'south',border:true" style="margin-bottom: 20px;height:60px;background:#A9FACD;padding:10px;border-color: blue">表尾
		
		</div>
	</div>
</body>
<script type="text/javascript">
		(function($){
			function getCacheContainer(t){
				var view = $(t).closest('div.datagrid-view');
				var c = view.children('div.datagrid-editor-cache');
				if (!c.length){
					c = $('<div class="datagrid-editor-cache" style="position:absolute;display:none"></div>').appendTo(view);
				}
				return c;
			}
			function getCacheEditor(t, field){
				var c = getCacheContainer(t);
				return c.children('div.datagrid-editor-cache-' + field);
			}
			function setCacheEditor(t, field, editor){
				var c = getCacheContainer(t);
				c.children('div.datagrid-editor-cache-' + field).remove();
				var e = $('<div class="datagrid-editor-cache-' + field + '"></div>').appendTo(c);
				e.append(editor);
			}
			
			var editors = $.fn.datagrid.defaults.editors;
			for(var editor in editors){
				var opts = editors[editor];
				(function(){
					var init = opts.init;
					opts.init = function(container, options){
						var field = $(container).closest('td[field]').attr('field');
						var ed = getCacheEditor(container, field);
						if (ed.length){
							ed.appendTo(container);
							return ed.find('.datagrid-editable-input');
						} else {
							return init(container, options);
						}
					}
				})();
				(function(){
					var destroy = opts.destroy;
					opts.destroy = function(target){
						if ($(target).hasClass('datagrid-editable-input')){
							var field = $(target).closest('td[field]').attr('field');
							setCacheEditor(target, field, $(target).parent().children());
						} else if (destroy){
							destroy(target);
						}
					}
				})();
			}
		})(jQuery);
	</script>
	<script type="text/javascript">
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'productid'});
				var productname = $(ed.target).combobox('getText');
				$('#dg').datagrid('getRows')[editIndex]['productname'] = productname;
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickRow(index){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					editIndex = index;
				} else {
					$('#dg').datagrid('selectRow', editIndex);
				}
			}
		}
		function accept(){
			if (endEditing()){
				$('#dg').datagrid('acceptChanges');
			}
		}
		function reject(){
			$('#dg').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges(){
			var rows = $('#dg').datagrid('getChanges');
			alert(rows.length+' rows are changed!');
		}
	</script>
</html>
