/**
	字符串操作
	1、是否为空		isNull(str)
	2、是否为整数   isInt(str,bEmpty)
	3、是否是电话   isTelNo(str,bEmpty)
		  是否为手机   isMobile(str, bEmpty)
	4、是否是Email  isEmail(str,bEmpty)
	5、计算字符串长度  strlen(str)
	6、比较字符串是否相等   equals(str1,str2)
	7、比较两个数值的大小，str1大于str2返回-1， 等于返回0， 小于返回1
								compareFloat(str1,str2)
	8、是否含有汉字   checkIsChinese(str) 
	9、是否包含特殊字符(~`!@#$%^&*()-+=|{}[]:";'<>,./?)
	        					hasSpecSymbol(str,bEmpty) 
	10、裁减字符串				trim(str,flag)
	11、判断用户是否只有字母或数字  checkUsername(str)
	12、date的format函数
*/

	function isNull(str){
		if(str==null || trim(str)==""){
			return true;
		}
		return false;
	}
	
	
	function isInt(str , bEmpty) {
		if(str==null||trim(str)=="")
		{
			return bEmpty;
		}	
	
	  if(trim(str) == "0"){
	    return false;
	  }
	  
		var ch = str.substring(0,1);
		
		if (ch == "0" && trim(str) != "0"){
			return false;
		}
		
		for (var i=0; i<str.length ; i++){
			var s = str.substring(i, i+1);
			if (!(s >= "0" && s <="9"))
			{
				return false;
			}
		}
		return true;
	}
	
	function isTelNo(str ,  bEmpty) {
		if(str==null||trim(str)=="")
			return bEmpty;
		var pattern =/^(\d{3,4}-)?(\d{7,8})(-(\d{1,5}))?$/;
	    var tel=tel;
	    if(!pattern.test(str)){
	    	return false;
	    }
	    return true;
	}
	
	function isMobile(str ,  bEmpty)  {
			if(bEmpty == null) {
				bEmpty = true;
			}
			
			if(str==null||trim(str)=="")
				return bEmpty;		
				
	    var str	= trim(str);
			//久的 ^(1)(\d){10}$ 下面新的包含186 188等
	  	//var myphone=/^(13[0-9]|15[0|3|6|7|8|9]|18[6|8|9])\d{8}$/; 
	  	//新修改的，1开头，后面10位
	  	var myphone=/^(1[0-9])\d{9}$/; 
	  	if(myphone.test(str) && str.length > 6 && str.length < 15) return true;
	  	return false;
		}
	
	function  isEmail(str , bEmpty) {
		if(bEmpty == null) {
	  		bEmpty = true;
	  	}
			
			if (str == null || trim(str) == "" || trim(str) == '' || str=='undefine')
			{
				return bEmpty;
			}
			//校验类似于hxu@sitechasia.com的邮件
			pattern1="^[a-zA-Z0-9_.\-]+[@]{1}[a-zA-Z0-9_\-]+[.]{1,5}[a-zA-Z0-9_\-]+";
		  //校验类似于huanxu@yahoo.com.cn的邮件
		  pattern2="^[a-zA-Z0-9_.\-]+[@]{1}[a-zA-Z0-9_\-]+[.]{1,5}[a-zA-Z0-9_\-]+[.]{1,5}[a-zA-Z0-9_\-]";
			
		  if(str.match(pattern1) || str.match(pattern2) ){
				return true;
			}
	      return false;
	}

	function  strlen(str) {
		return str.length;
	}	
	
	function equals(str1 , str2) {
		if (str1 == null && str2 ==null)
		{
			return true;
		}
		
		if (str1 == str2)
		{
			return true;
		}
		
		return false;
	}
	
	
	function compareFloat(str1 , str2) {
		str1 = trim(str1);
		str2 = trim(str2);
		var float1 = parseFloat(str1);
		var float2 = parseFloat(str2);				
		if(float1 < float2) return 1;
		else if(float1 > float2) return -1;
		else if(float1 == float1)
		return 0;		
	}
	
	function hasSpecSymbol(str , bEmpty) {
		if(str==null||trim(str)=="")
			return bEmpty;		
		var str	= trim(str);
		for (var i = 0; i < str.length; i++) { 
			var ch = str.charAt(i); 
			if ((ch == "`" )|| (ch == "~" )||(ch == "!" )||(ch == "@" )||
				(ch == "#" )||(ch == "%" )||(ch == "^" )||(ch == "&" )||
				(ch == "*" )||(ch == "(" )||(ch == ")" )||(ch == "-" )||
				(ch == "+" )||(ch == "=" )||(ch == "|" )||(ch == "{" )||
				(ch == "}" )||(ch == "[" )||(ch == "]" )||(ch == ":" )||
				(ch == ";" )||(ch == "'" )||(ch == '"' )||(ch == "<" )||
				(ch == ">" )||(ch == "," )||(ch == "." )||(ch == "?" )||
				(ch == "/" )||(ch == "？")) { 
				return true; 
			} 
		} 		
	    return false; 
	}
	
	
	function trim(str  , flag){
		str	= ""+str;
		if( flag == "l" || flag == "L" )/*trim left side only*/
		{
			RegularExp	= /^\s+/gi;
			return str.replace( RegularExp,"" );
		}
		else if( flag == "r" || flag == "R" )/*trim right side only*/
		{
			RegularExp	= /\s+$/gi;
			return str.replace( RegularExp,"" );
		}
		else/*defautly, trim both left and right side*/
		{
			RegularExp	= /^\s+|\s+$/gi;
			return str.replace( RegularExp,"" );
		}
	}
	
	function checkIsChinese(str) {
		 //如果值为空，通过校验
		  if (str   ==   "")   
		    return   true;   
		  var pattern   =   /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0])*$/gi;   
		  if (pattern.test(str))   
		      return   true;   
		  else   
		      return   false;   
	}
	
	/**
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
		**/


