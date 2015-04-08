<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="../css/default.css" type=text/css rel=stylesheet>
	<link href="../css/xtree.css" type=text/css rel=stylesheet>
	<link href="../css/user_login.css" type=text/css rel=stylesheet>
	<meta http-equiv=content-type content="text/html; charset=gbk">
	<meta content="mshtml 6.00.6000.16674" name=generator>
	<script type="text/javascript">
		function login() {
			document.getElementById('loginform').submit();
		}
	
	</script>
</head>
<body id=userlogin_body>
<div></div>
<div id=user_login>
<dl>
  <dd id=user_top>
  <ul>
    <li class=user_top_l></li>
    <li class=user_top_c></li>
    <li class=user_top_r></li></ul>
  <dd id=user_main>
  
  <form action="loginform" method="post" id="loginform">
  <ul>
    <li class=user_main_l></li>
    <li class=user_main_c>
    <div class=user_main_box>
    <ul>
      <li class=user_main_text>用户名: </li>
      <li class=user_main_input><input class=txtusernamecssclass id=txtusername 
      maxlength=20 name=username> </li></ul>
    <ul>
      <li class=user_main_text>密 码： </li>
      <li class=user_main_input><input class=txtpasswordcssclass id=txtpassword 
      type=password name=password> </li></ul>
    <ul>
      <li class=user_main_text>记住密码：</li>
      <li class=user_main_input><input type=checkbox checked=checked/> </li>
    </ul>
  </div>
	</li>
    <li class=user_main_r><input class=ibtnentercssclass id=ibtnenter 
    style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px" 
    onclick='javascript:login()' 
    type=image src="../images/images_login/user_botton.gif" name=ibtnenter /> 
    </li>
    </ul>
    </form>
    
  <dd id=user_bottom>
  <ul>
    <li class=user_bottom_l></li>
    <li class=user_bottom_c></li>
    <li class=user_bottom_r></li></ul></dd></dl></div>
    <span id=valrusername style="display: none; color: red"></span>
    <span id=valrpassword style="display: none; color: red"></span>
    <span id=valrvalidatecode style="display: none; color: red"></span>
<div id=validationsummary1 style="display: none; color: red"></div>

<div></div>
</body>
