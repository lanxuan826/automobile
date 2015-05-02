<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>DF汽车销售分析决策系统</title>
    <link href="../css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../js/themes/icon.css" />
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='../js/XiuCai.index.js'> </script>

    <script type="text/javascript">

	var _menus = {
	"menus": [{
		"menuid": "1",
		"icon": "icon-xtgl",
		"menuname": "系统管理",
		"menus": [{
			"menuid": "12",
			"menuname": "系统设置",
			"icon": "icon-xtsz",
			"url": "#",
			"child": [{
				"menuid": "140",
				"menuname": "初始化",
				"icon": "icon-xtcsh",
				"url": "../jsp/login.jsp"
			},
			{
				"menuid": "150",
				"menuname": "导入数据",
				"icon": "icon-drsj",
				"url": "demo.html"
			}]
		},
		{
			"menuid": "13",
			"menuname": "权限管理",
			"icon": "icon-qxgl",
			"url": "demo2.html",
			"child": [{
				"menuid": "141",
				"menuname": "角色设置",
				"icon": "icon-jssz",
				"url": "demo2.html"
			},
			{
				"menuid": "151",
				"menuname": "权限分配",
				"icon": "icon-qxfp",
				"url": "demo.html"
			}]
		},
		{
			"menuid": "14",
			"menuname": "数据备份",
			"icon": "icon-sjbf",
			"url": "demo2.html",
			"child": [{
				"menuid": "142",
				"menuname": "自动备份",
				"icon": "icon-zdbf",
				"url": "demo2.html"
			},
			{
				"menuid": "152",
				"menuname": "手动备份",
				"icon": "icon-sdbf",
				"url": "demo.html"
			}]
		},
		{
			"menuid": "15",
			"menuname": "日志管理",
			"icon": "icon-rzgl",
			"url": "demo.html",
			"child": [{
				"menuid": "143",
				"menuname": "删除日志",
				"icon": "icon-scrz",
				"url": "demo2.html"
			},
			{
				"menuid": "153",
				"menuname": "查询日志",
				"icon": "icon-cxrz",
				"url": "demo.html"
			}]
		}]
	},
	{
		"menuid": "8",
		"icon": "icon-jcdagl",
		"menuname": "基础档案管理",
		"menus": [{
			"menuid": "21",
			"menuname": "车辆档案",
			"icon": "icon-clda",
			"url": "demo.html"
		},
		{
			"menuid": "22",
			"menuname": "管理员档案",
			"icon": "icon-gzyda",
			"url": "demo1.html",
			"child": [{
				"menuid": "221",
				"menuname": "分配角色",
				"icon": "icon-fbjs",
				"url": "demo.html"
			},{
				"menuid": "222",
				"menuname": "管理员信息管理",
				"icon": "icon-gzyxxgl",
				"url": "userManage"
			}]
		},
		{
			"menuid": "21",
			"menuname": "客户档案",
			"icon": "icon-khda",
			"url": "demo.html"
		},
		{
			"menuid": "21",
			"menuname": "经销商档案",
			"icon": "icon-jxsda",
			"url": "demo.html"
		},
		{
			"menuid": "21",
			"menuname": "直营店档案",
			"icon": "icon-zydda",
			"url": "demo.html"
		},
		{
			"menuid": "21",
			"menuname": "仓库档案",
			"icon": "icon-ckda",
			"url": "demo.html"
		},
		{
			"menuid": "21",
			"menuname": "地区档案",
			"icon": "icon-dqda",
			"url": "demo.html"
		},
		{
			"menuid": "21",
			"menuname": "税率类型档案",
			"icon": "icon-slda",
			"url": "demo.html"
		},
		{
			"menuid": "21",
			"menuname": "车辆类型档案",
			"icon": "icon-clxhda",
			"url": "demo.html"
		}]
	},
	{
		"menuid": "56",
		"icon": "icon-sys",
		"menuname": "销售管理",
		"menus": [{
			"menuid": "31",
			"menuname": "车辆销售",
			"icon": "icon-nav",
			"url": "",
			"child":[{
				"menuid": "310",
				"menuname": "车辆销售",
				"icon": "icon-nav",
				"url": "carSaleManage]"
			},{
				"menuid": "311",
				"menuname": "销售计划",
				"icon": "icon-nav",
				"url": "demo1.html"
			}]
		},
		{
			"menuid": "321",
			"menuname": "库存管理",
			"icon": "icon-nav",
			"url": "demo2.html",
			"child": [{
				"menuid": "311",
				"menuname": "库存预警",
				"icon": "icon-nav",
				"url": "demo1.html"
			},
			{
				"menuid": "312",
				"menuname": "产品入库",
				"icon": "icon-nav",
				"url": "demo2.html"
			}]
		},
		{
			"menuid": "321",
			"menuname": "订单管理",
			"icon": "icon-nav",
			"url": "demo2.html",
			"child": [{
				"menuid": "311",
				"menuname": "订单信息",
				"icon": "icon-nav",
				"url": "demo1.html"
			},
			{
				"menuid": "312",
				"menuname": "订单完成",
				"icon": "icon-nav",
				"url": "demo2.html"
			}]
			
		},
		{
			"menuid": "321",
			"menuname": "财务管理",
			"icon": "icon-nav",
			"url": "demo2.html",
			"child": [{
				"menuid": "3211",
				"menuname": "销售财务管理",
				"icon": "icon-nav",
				"url": "demo1.html"
			},{
				"menuid": "3212",
				"menuname": "营销费用管理",
				"icon": "icon-nav",
				"url": "demo1.html"
			},
			{
				"menuid": "3212",
				"menuname": "其他费用管理",
				"icon": "icon-nav",
				"url": "demo2.html"
			}]
		}]
	},
	{
		"menuid": "56",
		"icon": "icon-sys",
		"menuname": "销售分析决策",
		"menus": [
		          {
			"menuid": "31",
			"menuname": "销售业绩报表分析",
			"icon": "icon-nav",
			"url": "",
			"child":[{
				"menuid": "311",
				"menuname": "按时间维度分析",
				"icon": "icon-nav",
				"url": "saleCountAnalysisByDate.jsp"
			},{
				"menuid": "311",
				"menuname": "按车型维度分析",
				"icon": "icon-nav",
				"url": "demo1.html"
			},{
				"menuid": "311",
				"menuname": "按地区维度分析",
				"icon": "icon-nav",
				"url": "demo1.html"
			}]
		},
		{
			"menuid": "321",
			"menuname": "销售报表分析",
			"icon": "icon-nav",
			"url": "demo2.html",
			"child": [{
				"menuid": "311",
				"menuname": "销售业绩分析",
				"icon": "icon-nav",
				"url": "saleCountAnalysis"
			},
			{
				"menuid": "312",
				"menuname": "车型综合分析",
				"icon": "icon-nav",
				"url": "demo2.html"
			},	{
				"menuid": "312",
				"menuname": "客户综合分析",
				"icon": "icon-nav",
				"url": "demo2.html"
			},{
				"menuid": "312",
				"menuname": "经销商综合分析",
				"icon": "icon-nav",
				"url": "demo2.html"
			},
			{
				"menuid": "312",
				"menuname": "销售财务分析",
				"icon": "icon-nav",
				"url": "demo2.html"
			},
			{
				"menuid": "312",
				"menuname": "仓库综合分析",
				"icon": "icon-nav",
				"url": "demo2.html"
			},
			{
				"menuid": "312",
				"menuname": "综合统计分析",
				"icon": "icon-nav",
				"url": "demo2.html"
			}]
		}]
	}
	]
};

        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = '/ajax/loginout';
                    }
                });
            })
        });
		
    </script>

</head>

<body class="easyui-layout" style="overflow-y: hidden"  fit="true"   scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="../images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>

<div id="loading-mask" style="position:absolute;top:0px; left:0px; width:100%; height:100%; background:#D2E0F2; z-index:20000">
<div id="pageloading" style="position:absolute; top:50%; left:50%; margin:-120px 0px 0px -120px; text-align:center;  border:2px solid #8DB2E3; width:200px; height:40px;  font-size:14px;padding:10px; font-weight:bold; background:#fff; color:#15428B;"> 
    <img src="../images/loading.gif" align="absmiddle" /> 正在加载中,请稍候...</div>
</div>

    <div region="north" split="true" border="false" style="overflow: hidden; height: 50px;
        background: url(../images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎 周总<a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; "><img src="../images/blocks.gif" width="20" height="40" align="absmiddle" /> DF汽车销售分析决策系统</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">DF公司拥有所有权Copyright2014</div>
    </div>
    <div region="west" split="true"  title="导航菜单" style="width:180px;" id="west">
			<div id="nav">
		<!--  导航内容 -->
				
			</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
				<h1 style="font-size:24px;">* ***DF******</h1>
<h1 style="font-size:24px;">* *: <a style="font-size:24px;color:green;" href="http://hxling.cnblogs.com">汽车销售分析系统</a></h1>
<h1 style="font-size:24px;">* ********</h1>
				<h1 style="font-size:24px;">* ********************************~~~~</h1>
			</div>
		</div>
    </div>
    
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="close">关闭</div>
		<div id="closeall">全部关闭</div>
		<div id="closeother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="closeright">当前页右侧全部关闭</div>
		<div id="closeleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="exit">退出</div>
	</div>

</body>
</html>