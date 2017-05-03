<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

 	
    
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/animate.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="${ctx}/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">
    <link href="${ctx}/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/select2/select2.min.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/chosen/chosen.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/cropper/cropper.min.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/switchery/switchery.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/nouslider/jquery.nouislider.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/ionRangeSlider/ion.rangeSlider.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/clockpicker/clockpicker.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
    
   <!-- 图片上传 -->
    <link href="${ctx}/css/plugins/fileUpload/fileinput.min.css" rel="stylesheet">
	
    <!-- CSS Data Tables -->
    <link href="${ctx}/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/dataTables/dataTables.responsive.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/dataTables/dataTables.tableTools.min.css" rel="stylesheet">
    
     
    
    
    <!-- Mainly scripts -->
    <script src="${ctx}/js/common.js"></script>
    <script src="${ctx}/js/jquery-2.1.1.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${ctx}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${ctx}/js/plugins/jeditable/jquery.jeditable.js"></script>
           
    <!-- Data Tables -->
    <script src="${ctx}/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${ctx}/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script src="${ctx}/js/plugins/dataTables/dataTables.responsive.js"></script>
    <script src="${ctx}/js/plugins/dataTables/dataTables.tableTools.min.js"></script>
    
    <script src="${ctx}/js/jquery-2.1.1.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    
    <!-- Flot -->
    <script src="${ctx}/js/plugins/flot/jquery.flot.js"></script>
    <script src="${ctx}/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="${ctx}/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="${ctx}/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="${ctx}/js/plugins/flot/jquery.flot.pie.js"></script>

    <!-- Peity -->
    <script src="${ctx}/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="${ctx}/js/demo/peity-demo.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="${ctx}/js/inspinia.js"></script>
    <script src="${ctx}/js/plugins/pace/pace.min.js"></script>
    <script src="${ctx}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
      
    <!-- jQuery UI -->
    <script src="${ctx}/js/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- GITTER -->
    <script src="${ctx}/js/plugins/gritter/jquery.gritter.min.js"></script>

    <!-- Sparkline -->
    <script src="${ctx}/js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <!-- Sparkline demo data  -->
    <script src="${ctx}/js/demo/sparkline-demo.js"></script>

    <!-- ChartJS-->
    <script src="${ctx}/js/plugins/chartJs/Chart.min.js"></script>

    <!-- Toastr -->
    <!-- <script src="${ctx}/js/plugins/toastr/toastr.min.js"></script> -->
    
    <!-- MENU -->
    <script src="${ctx}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    
    <!-- Chosen -->
    <script src="${ctx}/js/plugins/chosen/chosen.jquery.js"></script>

	<!-- JSKnob -->
	<script src="${ctx}/js/plugins/jsKnob/jquery.knob.js"></script>

	<!-- Input Mask-->
    <script src="${ctx}/js/plugins/jasny/jasny-bootstrap.min.js"></script>

	<!-- Data picker -->
	<script src="${ctx}/js/plugins/datapicker/bootstrap-datepicker.js"></script>

	<!-- NouSlider -->
	<script src="${ctx}/js/plugins/nouslider/jquery.nouislider.min.js"></script>

	<!-- Switchery -->
	<script src="${ctx}/js/plugins/switchery/switchery.js"></script>

    <!-- IonRangeSlider -->
    <script src="${ctx}/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

    <!-- iCheck -->
    <script src="${ctx}/js/plugins/iCheck/icheck.min.js"></script>

    <!-- Color picker -->
    <script src="${ctx}/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

    <!-- Clock picker -->
    <script src="${ctx}/js/plugins/clockpicker/clockpicker.js"></script>

    <!-- Image cropper -->
    <script src="${ctx}/js/plugins/cropper/cropper.min.js"></script>

    <!-- Date range use moment.js same as full calendar plugin -->
    <script src="${ctx}/js/plugins/fullcalendar/moment.min.js"></script>

    <!-- Date range picker -->
    <script src="${ctx}/js/plugins/daterangepicker/daterangepicker.js"></script>

    <!-- Select2 -->
    <script src="${ctx}/js/plugins/select2/select2.full.min.js"></script>
    
    <!-- 图片上传 -->    
    <script src="${ctx}/js/plugins/fileUpload/fileinput.min.js"></script>
    <script src="${ctx}/js/plugins/fileUpload/fileinput_locale_zh.js"></script>
    <script src="${ctx}/js/uploadify/jquery.uploadify.js"></script>
    <script src="${ctx}/js/uploadify/swfobject.js"></script>
    <script src="${ctx}/js/uploadify/ajaxfileupload.js"></script>
    
    

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

	<style type="text/css">
		.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
	</style>
</head>