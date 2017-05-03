<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    
    <!-- CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Mainly scripts -->
    <script src="/js/common.js"></script>
    <script src="/js/jquery-2.1.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/inspinia.js"></script>
    <script src="/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        
	<!-- check box -->
	<link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
	<script src="/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		var ctx = "<%=request.getContextPath()%>";
		var basePath = "<%=request.getScheme()%>"+"://"+"<%=request.getServerName()%>"+":"+"<%=request.getServerPort()%>"; 
	
		/**
		 * @param msg 提示信息
		 * @param time 显示时间
		 * @param head 提示头信息
		 * @param callback 回调函数
		 */
		function showMsg(msg,time,head,callback){
			$("#messageDiv").show();
			$("#messageDiv").html("<strong>提示信息!</strong>");
			var headText="提示信息：";
			if(head!=null&&head!=""){
				headText=head;
			}
			if(msg!=null&&msg!=""){
				$("#messageDiv").html("<strong>"+headText+"</strong>"+msg);
			}
			var timeOut=5000;
			if(time!=null&&time!=""){
				timeOut=time;
			}
			$("#messageDiv").fadeOut(timeOut,function(){
				if(callback!=null&&callback!=""){
					eval("("+callback+"())");
				}
			});
		}
		
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
		
		
		function createXMLHttpRequest(){
		    if(window.XMLHttpRequest){
		        XMLHttpR = new XMLHttpRequest();
		    }else if(window.ActiveXObject){
		        try{
		            XMLHttpR = new ActiveXObject("Msxml2.XMLHTTP");
		        }catch(e){
		            try{
		                XMLHttpR = new ActiveXObject("Microsoft.XMLHTTP");
		            }catch(e){
		            }
		        }
		    }
		}
		function sendRequest(url){
		    createXMLHttpRequest();
		    XMLHttpR.open("GET",url,true);
		    XMLHttpR.setRequestHeader("Content-Type","text/html;charset=utf-8");
		    XMLHttpR.onreadystatechange = processResponse;
		    XMLHttpR.send(null);
		}
		function processResponse(){
		    if(XMLHttpR.readyState ==4 && XMLHttpR.status == 200){
		        document.write(XMLHttpR.responseText);
		    }
		}

	</script>

</head>