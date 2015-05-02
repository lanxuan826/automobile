<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆销售信息</title>
	<link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../js/themes/demo.css">
	<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/check.js"></script>
	
<script type="text/javascript">
	$(function(){	
		showTbale();
		});
		function showTbale() {
			$('#saledg').datagrid({
				 title:'车辆销售信息',//表格标题
				 nowrap: false,//是否只显示一行，即文本过多是否省略部分。
				 striped: true,
				 width: ($(window).width()*0.99), 
				 height:($(window).height()*0.98) ,
				 url:'carSaleManageData',  //action地址
				frozenColumns:[[
				     {field:'ck',checkbox:true}
				]],
				columns:[[
				    {field:'saleId',title:'销售单号',width:120},
					{field:'customerName',title:'客商名称',width:120},
					{field:'customerType',title:'客商类型',width:80},
					{field:'saleDate',title:'销售日期',width:120},
					{field:'storgeName',title:'出库仓库名称',width:120},
					{field:'regionName',title:'车辆销售地区',width:120},
					{field:'userName',title:'开单人',width:120},
					{field:'isPay',title:'是否付款',width:80},
					{field:'taxName',title:'税率名称',width:80},
					{field:'taxAfter',title:'税后(万元)',width:80},
					{field:'total_money',title:'总金额(万元)',width:120},
					{field:'sale_remark',title:'备注',width:120}
				]],
				
				pagination:true, //包含分页  
				rownumbers:true,
				singleSelect:true,
				
				toolbar:[{
					text:'新增车辆销售单',
					iconCls:'icon-add',
					handler:function(){
						window.location.href="carSaleFormAdd.jsp";
					}
				},'-',{
					text:'删除',
					iconCls:'icon-cut',
					handler:function(){
						alert("delete");
					}
				},'-',{
					text:'修改车辆销售单',
					iconCls:'icon-edit',
					handler:function(){
						alert('修改')
					}
				},'-',{
					text:'查看车辆销售详单',
					iconCls:'icon-search',
					handler:function(){
						alert("查看详情");
					}
				},'-',{
					text:'设置条件查询',
					iconCls:'icon-search',
					handler:function(){
						alert("按时间");
					}
				}]
			});
		}
	</script>

</head>
<body>
		<table calss="easyui-datagrid"  id="saledg" style="height:auto">
		</table>
		<!--添加用户信息窗口
    <div id="w" class="easyui-window" title="用户信息" collapsible="false" minimizable="false"
        maximizable="false" style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                	<tr>
                	<td><span style="color:red">*为必填项</span></td>
                	 <td><input id="txtUser_id" type="hidden" /></td>
                	</tr>
                    <tr>
                        <td><span style="color:red">*</span>用户名：</td>
                        <td><input id="txtUserName" type="text" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td><span style="color:red">*</span>密&nbsp;&nbsp;码：</td>
                        <td><input id="txtPwd" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>用户名称：</td>
                        <td><input id="txtNickName" type="text" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td><span style="color:red">*</span>用户角色：</td>
                        <td><input id="txtUserRole" type="text" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>职位描述：</td>
                        <td><input id="txtDesc" type="text" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td><span style="color:red">*</span>联系方式：</td>
                        <td><input id="txtPhone" type="text" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td><span style="color:red">*</span>电子邮箱：</td>
                        <td><input id="txtEmail" type="text" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>备注：</td>
                        <td><input id="txtRemark" type="text" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a> 
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>
    -->
</body>
</html>