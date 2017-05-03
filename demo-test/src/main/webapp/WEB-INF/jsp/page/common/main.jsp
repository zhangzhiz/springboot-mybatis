<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/page/common/page_head.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>维信后台管理平台 | 主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

</head>

<script>
	function changePwd(){
		$('#changePwdModal').modal('show');
		$("#confirm_changePwd").attr("onclick","changePwdSubmit()");
	}
	
	function changePwdSubmit(){
		var old_pwd = $('#old_pwd').val();
		var new_pwd = $('#new_pwd').val();
		var new_pwd2 = $('#new_pwd2').val();
		
		if(old_pwd == ''){
			alert("[旧密码]不能为空");
			$("#old_pwd").focus();
			return false;
		}
		if(new_pwd == ''){
			alert("[新密码]不能为空");
			$("#new_pwd").focus();
			return false;
		}
		if(new_pwd2 == ''){
			alert("[确认新密码]不能为空");
			$("#new_pwd2").focus();
			return false;
		}
		if(new_pwd.length < 6){
			alert("[新密码]长度不能少于6位");
			$("#new_pwd").focus();
			return false;
		}
		if(new_pwd2.length < 6){
			alert("[新密码]长度不能少于6位");
			$("#new_pwd2").focus();
			return false;
		}
		if(new_pwd != new_pwd2){
			alert("两次新密码不一致");
			$("#new_pwd2").focus();
			return false;
		}
		
		$.ajax({
			"url" : ctx+"/user/changePwd",
			"type" : "POST",
			data:$("#changePwdForm").serialize(),
			"success" : function(data) {
				if(data!=""&&data!=null){
					var index=data.indexOf("MSG|");
					if(index==0){
						alert(data.substring(4));
					}else{
						alert("修改成功！");
						$('#changePwdModal').modal('hide');
						window.location.href = ctx + "/home/logout";
					}
				}else{
					alert("修改出错！");
					$('#changePwdModal').modal('hide');
				}
			},
			"error" : function() {
			}
		});
		return false;
	}
</script>

<body>
    <div id="wrapper">
    
    	<jsp:include page="/WEB-INF/jsp/page/common/navHead.jsp" />

        <div id="page-wrapper" class="gray-bg">
	        <div class="row border-bottom">
		        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
		            <ul class="nav navbar-top-links navbar-right">
		                <li>
		                    <a href="javascript:void(0);" onclick="changePwd();" >
		                        <i class="fa fa-key"></i> 修改密码
		                    </a>
		                </li>
		                <li>
		                    <a href="${ctx}/home/logout">
		                        <i class="fa fa-sign-out"></i> 退出
		                    </a>
		                </li>
		            </ul>
		        </nav>
	        </div>

			<div id="contentDiv">
				<h1></h1>
            	<span style="font-weight:bold; font-size:18px;">欢迎回到维信金科后台管理平台！</span>
            	
            	<br/><br/><br/><br/>

			</div>
			<div class="footer">
			    <div>
			        <strong>Copyright</strong> 维信金科 &copy; 2017
			    </div>
			</div>
        </div>
    </div>

    <div id="changePwdModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">修改密码确认对话框</h4>
                </div>
                <form id="changePwdForm">
                <div class="modal-body" style="height:150px;">
                	<div class="form-group"><label class="col-sm-3 control-label">旧密码(<span style="color:red">*</span>)</label>
                        <div class="col-sm-9"><input type="password" class="form-control" id="old_pwd" name="old_pwd" maxlength="100" style="width:200px; float:left; "></div>
                    </div>
                	<div class="form-group"><label class="col-sm-3 control-label">新密码(<span style="color:red">*</span>)</label>
                        <div class="col-sm-9"><input type="password" class="form-control" id="new_pwd" name="new_pwd" maxlength="100" style="width:200px; float:left; "></div>
                    </div>
                    <div class="form-group"><label class="col-sm-3 control-label">确认新密码(<span style="color:red">*</span>)</label>
                        <div class="col-sm-9"><input type="password" class="form-control" id="new_pwd2" name="new_pwd2" maxlength="100" style="width:200px; float:left; "></div>
                    </div>
                </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button id="confirm_changePwd" onclick="bbb" type="button" class="btn btn-primary">确定</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>

</body>
</html>

<script type="text/javascript">
	function goSysMessageMenu(){
		$("#sysMgtNav").trigger("click");
		$("#sysMsgLi").addClass("active");
		$("#sysMsgNav").trigger("click");

		return false;
	}
</script>
