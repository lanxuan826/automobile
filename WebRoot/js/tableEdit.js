$(document).ready(function(){
	//########## css 设计鼠标滑动td上变色########
	tdCssStyle();
	//########## css 设计鼠标滑动td上变色########
	
	var tdNodes = $("td");
	tdNodes.click(tdClick);
});

//加载td样式
function tdCssStyle(){
	//########## css 设计鼠标滑动td上变色########
//	var tdNodes = $("td");
//	$.each(tdNodes, function(i, td){
//		$(this).bind("mouseover", function(){
//			$(this).css("background","#ff66ff"); 
//		});
//		$(this).bind("mouseout", function(){
//			$(this).css("background","#ffffff");
//		});
//	});
	// 不好使呢
	var trNodes = $("tr[id='data']");
	$.each(trNodes, function(i,tr){
		$(this).bind("mouseover", function(){
			$(this).css("background","#FC0"); 
		});
		$(this).bind("mouseout", function(){
			$(this).css("background","#ffffff");
		});
	});
	//########## css 设计鼠标滑动td上变色########
	
	
	
}

//td点击触发函数
function tdClick(){
	//1.去除当前td里面的文本
	var td = $(this);
	var tdText = td.text();
	//2.清空td里面的文本内容
	td.html("");//也可以使用td.empty();
	//3.建立一个输入框
	var input = $("<input >");
	//4.将输入框的内容设为刚才保存的td里面的文本内容
	input.attr("value", tdText);
	//4.1让文本框能相应键盘按下的keyup事件，主要是用处理回车确认
	input.keyup(function (event){
		//1.获取当前用户按钮的键值 --并解决不用浏览器获得事件对象的差异，
		//IE用自动提取window.event ，而其他浏览器必须显示的提供，即在方法参数中加上event
		var myEvent = event || window.event;
		var keyCode = myEvent.keyCode;
		//2.判断是否是回车键
		if(keyCode == 13){
			//1.保存当前输入框的内容
			var input = $(this);
			var inputText = input.val();
			//2.清空td的内容，即去掉文本框
			var td = input.parent("td");
			td.empty();
			//3.将保存的内容填写到td中
			td.html(inputText);
			//4.让td重新拥有点击事件
			td.click(tdClick);
		}
		//2.判断是否是ESC键按下
       	if(keyCode == 27){
           	//将input输入框的值还原成修改之前的值
       		var input = $(this);
       		var td = input.parent("td");
       		td.empty();
       		td.html(tdText);
       		td.click(tdClick);
       	}
	});
	//4.2给文本框注册事件，当失去焦点时将文本保存起来
	input.blur(function (){
		//将输入框的文本保存起来
		var input = $(this);
		var inputText = input.val();
		//将td的内容，即输入框去掉，然后给td赋新值
		var td = input.parent("td");
		td.html(inputText);
		td.click(tdClick);
	});
	
    //设置文本框的样式
    input.css("border-width","0");              
    input.css("font-size","16px");
    input.css("text-align","center");
    input.width(td.width());
	
	//5.将输入框加到td中
	td.append(input);//也可以用input.appentTo(td);
	//6.让文本框中的文字被高亮选中
	//需要将jquery对象转化为DOM对象
	var inputDom = input.get(0);
	inputDom.select();
	//7.需要一处td上的点击事件
	td.unbind("click");
};