

//单击验证码图片更新验证码
$(function() {
	$("#img-code").click(function() {
		updateImgCode();
	});
});

//更新验证码验证码
function updateImgCode() {
	document.getElementById("img-code").src = "/randImgCodeCreater?" + Math.random();
}

//回车键触发登录事件
$("body").keydown(function(event){
	if(event.keyCode == 13) {
		signin();
	}
});

//登录
function signin() {
	var username = $("#username").val();
	var password = $("#password").val();
	var captcha  = $("#captcha").val();
	
	//判断有效性
	if(!validate(username, password, captcha)){
		return;
	}
	
	var data = {
		username : username,
		password : password,
		captcha : captcha
	};
	
	$.ajax({
		url : "/signin/verify",
		type : "post",
		data : data,
		error: function() {
			alert("登录失败...");
			updateImgCode();
		},
		success: function(responseInfo) {
			if(responseInfo.status == true){
				window.location.href = "/";
			} else {
				alert(responseInfo.message);
				updateImgCode();
			}
		}
	});
}

//有效性检验
function validate(username, password, captcha) {
	if(username == "") {
		$("#username").focus();
		return false;
	}
	if(password == "") {
		$("#password").focus();
		return false;
	}
	if(captcha == "") {
		$("#captcha").focus();
		return false;
	}
	return true;
}