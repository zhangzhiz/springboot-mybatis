<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>

<script>
function errorHandle(XMLHttpRequest){
	var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
	if(sessionstatus == "timeout"){
	   	   parent.location.href = ctx+"/home";
	    }
	var errirstatus = XMLHttpRequest.getResponseHeader("error");
	if(errirstatus == "true"){
		jAlert("系统错误,请联系管理员.","提示信息");
	}
}
$.ajaxSetup({     
    contentType:"application/x-www-form-urlencoded;charset=utf-8",     
    beforeSend: function(XMLHttpRequest){
    	
	},
	error: function(xhr,status,error){
	},
    complete:function(XMLHttpRequest,textStatus){
    	errorHandle(XMLHttpRequest);
    }
});
</script>


<!-- 内部人员操作 -->
    <META HTTP-EQUIV="Refresh" CONTENT="0;URL=home"> 
<!--  外部人员操作 -->
<!--     <META HTTP-EQUIV="Refresh" CONTENT="0;URL=cus.action"> -->
</head>

<body>
</body>
</html>

