<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户信息管理</title>
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
			$('#userdg').datagrid({
				 title:'用户信息',//表格标题
				 nowrap: false,//是否只显示一行，即文本过多是否省略部分。
				 striped: true,
				 width: ($(window).width()*0.99), 
				 height:($(window).height()*0.98) ,
				 url:'userListAction', //action地址
				frozenColumns:[[
				     {field:'ck',checkbox:true}
				]],
				columns:[[
				    {field:'user_id',title:'用户ID',width:120,hidden:true},
					{field:'username',title:'用户名',width:150},
					{field:'password',title:'密码',width:120},
					{field:'nickname',title:'用户名称',width:150},
					{field:'role_id',title:'所属角色',width:120},
					{field:'telephone',title:'联系方式',width:150},
					{field:'email',title:'email',width:120},
					{field:'createtime',title:'创建(修改)时间',width:120},
					{field:'description',title:'职位描述',width:150},
					{field:'remark',title:'备注',width:120}
				]],
				
				pagination:true, //包含分页  
				rownumbers:true,
				singleSelect:true,
				
				toolbar:[{
					text:'添加用户信息',
					iconCls:'icon-add',
					handler:function(){
						 $('#w').window('open' );
					}
				},'-',{
					text:'删除',
					iconCls:'icon-cut',
					handler:function(){
						delUserInfoByAiax();
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						alert('save')
					}
				},'-',{
					text:'修改',
					iconCls:'icon-edit',
					handler:function(){
						editUserInfoByAjax();
				
					}
				}]
			});
		}
	
		$(function(){
			addUserWindow();
			$('#btnCancel').click(function(){
				closeUserWindow();
			});
			$('#btnEp').click(function(){
				addUserInfoByAjax();
			});
		});
		
	<!--add窗口默认不显示-->
    function addUserWindow() {
        $('#w').window({
            title: '用户信息',
            width: 360,
            modal: true,
            shadow: true,
            closed: true,
            height: 340,
            top:80,
        	left:100,
            resizable:false
        });
    }
    
    <!--关闭用户窗口-->
    function closeUserWindow() {
        $('#w').window('close');
    }
    
    <!--添加用户信息-->
    function addUserInfoByAjax() {
    	var user_id = $('#txtUser_id').val();
    	 var username = $('#txtUserName').val();
    	 var password = $('#txtPwd').val();
    	 var role_id = $('#txtUserRole').val();
    	 var nickname = $('#txtNickName').val();
    	 var telephone  = $('#txtPhone').val();
    	 var email  = $('#txtEmail').val();
    	 var des  = $('#txtDesc').val();
    	 var remark  = $('#txtRemark').val();
    	 var type ="add";
    	 if(!isNull(user_id)) {    //如果id有值的话，说明是修改
    		 type="edit"
    	 }
    	 if(isNull(username)) {
    		 $.messager.alert('系统提示', '用户名不能为空!', 'warning');
    		 return false;
    	 }
    	 if(hasSpecSymbol(username,true)) {
    		 $.messager.alert('系统提示', '用户名不能包含特殊字符','warning');
    		 return false;
    	 }
    	 if(checkIsChinese(username)) {
    		 $.messager.alert('系统提示', '用户名非法，用户名只能为数字或者字母','warning');
    		 return false;
    	 }
    	 if(isNull(password)) {
    		 $.messager.alert('系统提示', '密码不能为空', 'warning');
    		 return false;
    	 }
    	 if(isNull(role_id)) {
    		 $.messager.alert('系统提示', '用户角色不能为空', 'warning');
    		 return false;
    	 }
    	 if(!isMobile(telephone,true) ||  !isTelNo(telephone,true))  {
    		 $.messager.alert('系统提示', '请输入正确的联系方式', 'warning');
    		 return false;
    	 }
    	 if(!isEmail(email,true))  {
    		 $.messager.alert('系统提示', '请输入正确的EMail', 'warning');
    		 return false;
    	 }
    	
    	  $.post('addUserInfo?username=' + username+'&password='+password+'&role_id='+role_id+
    			  '&nickname='+nickname+'&telephone='+telephone+'&email='+email+'&des='+des+
    			  '&remark='+remark+'&user_id='+user_id+'&type='+type,function(msg) {
    		  $.messager.alert('系统提示',msg,'success');
            <!--  msgShow('系统提示', msg, 'warnring');-->
            $('#txtUserName').val('');
       	    $('#txtPwd').val('');
            $('#txtUser_id').val('');
         	$('#txtUserName').val('');
         	$('#txtPwd').val('');
         	$('#txtUserRole').val('');
         	$('#txtNickName').val();
         	$('#txtPhone').val('');
         	$('#txtEmail').val('');
         	$('#txtDesc').val('');
         	$('#txtRemark').val('');
            closeUserWindow();
            close();
			showTbale();
          })
    }
    
    function editUserInfoByAjax() {
    	 var rows = $('#userdg').datagrid('getSelections'); 
    	 if(rows.length > 0){
    		 $('#w').window('open' );
    		 $('#txtUser_id').val(rows[0].user_id);
          	$('#txtUserName').val(rows[0].username);
          	$('#txtPwd').val(rows[0].password);
          	$('#txtUserRole').val(rows[0].role_id);
          	$('#txtNickName').val(rows[0].nickname);
          	$('#txtPhone').val(rows[0].telephone);
          	$('#txtEmail').val(rows[0].email);
          	$('#txtDesc').val(rows[0].description);
          	$('#txtRemark').val(rows[0].remark);
    	 }else{
    		 $.messager.alert('提示', '请选择要修改的记录', 'error');     
    	 }
    }
    
    <!--删除选择的列 -->
    function delUserInfoByAiax() {
    	 var rows = $('#userdg').datagrid('getSelections'); 
    	  if(rows.length > 0){
    		  $.messager.confirm('请确认','您确定要删除当前选择的'+rows.length+'项吗？', function(data){
    			  
    			  if(data){
    				  var id = rows[0].user_id;
    				  $.post('delUserInfo?user_id=' + id,function(msg) {
    		    		  alert(msg);
    		          <!--    msgShow('系统提示', msg, 'success'); -->
    		              close();
    		              showTbale();
    		          });
    			  }
    			  
    		  });
    	  }else{  
    		  $.messager.alert('提示', '请选择要删除的记录', 'error');        
    		}
   	 }
	</script>

</head>
<body>
		<table calss="easyui-datagrid"  id="userdg" style="height:auto"></table>
		<!--添加用户信息窗口-->
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
</body>
</html>