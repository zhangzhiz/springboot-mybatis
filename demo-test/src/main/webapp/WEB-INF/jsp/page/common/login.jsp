<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/page/common/page_head.jsp"%>
<!DOCTYPE html>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="维信金科">
	<meta name="author" content="维信金科">

    <title>维信后台管理平台 | 登录</title>

</head>

<script>
	if("${errorMsg}" != ''){
		alert("${errorMsg}");
	}
	
	// 获取Cookie存储的账号, userName=xxxxxxxx
	function GetCookie(name) {
	    var arg = name + "=";
	    var alen = arg.length;
	    var clen = document.cookie.length;
	    var i = 0;
	    while (i < clen) {
	        var j = i + alen;
	        if (document.cookie.substring(i, j) == arg) return getCookieVal(j);
	        i = document.cookie.indexOf(" ", i) + 1;
	        if (i == 0) break;
	    }
	    return null;
	}
	function getCookieVal(offset) {
	    var endstr = document.cookie.indexOf(";", offset);
	    if (endstr == -1) endstr = document.cookie.length;
	    return unescape(document.cookie.substring(offset, endstr));
	}
	var userName = GetCookie("userName");
	/* if(userName != null && userName != ''){
		$("#user_name").val(userName);
	} */
	$(function(){
		if(userName != null && userName != ''){
			$("#userName").val(userName);
		}
	});
</script>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">维</h1>

            </div>
            <form id="loginForm" class="m-t" role="form" action="${ctx}/home/login" method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" required="" id="userName" name="userName" value="${user_name}">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="" id="userPassword" name="userPassword">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登录</button>
                ${message}

<!--                 <a href="#"><small>忘记密码?</small></a>
                <a class="btn btn-sm btn-white btn-block" href="register.html">注册新账号</a> -->
            </form>
            <p class="m-t"> <small>Copyright &copy; 2017 维信金科</small> </p>
        </div>
    </div>

</body>

</html>

