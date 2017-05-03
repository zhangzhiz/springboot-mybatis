function search(){
	$("#pageNo").val(1);
	pageQuery();
}

function pageQuery(){
	$("#tableDiv").load(ctx+"/manageuser/list",
			$("#searchForm").serialize()
			,function(){
	});
}

function enterPress(e){
	var e = e || window.event; 
	if(e.keyCode == 13){ 
		search(); 
	}
}

// 启用
function enableUser(){
	var userId = '';
	
	$("#userTableListBody input[type=checkbox]").each(function(){
		if($(this).prop("checked")){
			userId+=$(this).val()+",";
		}
	});
	
	if(userId==''){
		alert("请选择要启用的用户");
		return false;
	}
	
	$.ajax({
		"url" : ctx+"/manageuser/enableUser/"+userId,
		"type" : "GET",
		data:null,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				}else{
					alert("启用成功！");
					pageQuery();
				}
				
			}else{
				alert("启用出错！");
			}
		},
		"error" : function() {
			
		}
	});
}

//禁用
function disableUser(){
	var userId = '';
	
	$("#userTableListBody input[type=checkbox]").each(function(){
		if($(this).prop("checked")){
			userId+=$(this).val()+",";
		}
	});
	
	if(userId==''){
		alert("请选择要禁用的用户");
		return false;
	}
	
	$.ajax({
		"url" : ctx+"/manageuser/disableUser/"+userId,
		"type" : "GET",
		data:null,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				}else{
					alert("禁用成功！");
					pageQuery();
				}
				
			}else{
				alert("禁用出错！");
			}
		},
		"error" : function() {
			
		}
	});
}

function toAddPage(){
	$("#contentDiv").load(ctx+"/manageuser/addPage");
}

function toEditPage(id){
	$("#contentDiv").load(ctx+"/manageuser/editPage/"+id);
}

function goBack(){
	$("#contentDiv").load(ctx+"/manageuser/main");
}


/**
 * 验证保存的必填条件
 * return 
 */
function validateSave(){
	if(trim($("#userName").val())==""){
		showMsg("[用户名]不能为空");
		$("#userName").focus();
		return false;
	}
	
	if(isChinese(trim($("#userName").val()))){
		showMsg("[用户名]不能输入中文或其他全角字符");
		$("#userName").focus();
		return false;
	}
	
	if(trim($("#userPassword").val())==""){
		showMsg("[密码]不能为空");
		$("#userPassword").focus();
		return false;
	}
	
	if(trim($("#checkPassword").val())==""){
		showMsg("[确认密码]不能为空");
		$("#checkPassword").focus();
		return false;
	}

	if($("#checkPassword").val() != $("#userPassword").val()){
		showMsg("[确认密码]不正确");
		$("#checkPassword").focus();
		return false;
	}

	
	var roles = $("#roleSelector").val();
	if(roles==null || roles==""){
		showMsg("[角色]不能为空");
		return false;
	}
	
	return true;
}

function addUser(){
	if(!validateSave()){
		return;
	}
	
	var data = $("#addForm").serialize();

	// 取得下拉角色
	data += ("&roleId="+$("#roleSelector").val());
	
	$.ajax({
		"url" : ctx+"/manageuser/userAdd",
		"type" : "PUT",
		data:data,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				}else{
					//showMsg("保存成功！", 2000);
					alert(data.message);
					$("#contentDiv").load(ctx+"/manageuser/main");
				}
				
			}else{
				showMsg("保存出错!");
			}
		},
		"error" : function() {
			
		}
	});
}

function updateUser(){
	if(!validateSave()){
		return;
	}

	var data = $("#editForm").serialize();

	// 取得下拉角色
	data += ("&roleId="+$("#roleSelector").val());
	
	$.ajax({
		"url" : ctx+"/manageuser/userEdit",
		"type" : "POST",
		data:data,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				} else {
					//showMsg("修改成功！", 2000);
					alert(data.message);
					$("#contentDiv").load(ctx+"/manageuser/main");
				}
				
			}else{
				showMsg("修改出错！");
			}
		},
		"error" : function() {
		}
	});
}

function deleteUser(userId,userName){
	$('#deleteConfirmModal').modal('show');
	$("#del_user_name").html(userName);
	$("#confirm_del").attr("onclick","deleteUserSubmit("+userId+")");
}

function deleteUserSubmit(id){
	$.ajax({
		"url" : ctx+"/manageuser/userDelete/"+id,
		"type" : "DELETE",
		data:null,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message,2000);
					$('#deleteConfirmModal').modal('hide');
				}else{
					alert(data.message);
					$("#"+id).remove();
					$('#deleteConfirmModal').modal('hide');
					pageQuery();
				}
				
			}else{
				showMsg("保存出错！",2000);
				$('#deleteConfirmModal').modal('hide');
			}
		},
		"error" : function() {
		}
	});

}

function resetPwd(userId,userName){
	$('#resetPwdConfirmModal').modal('show');
	$("#resetPwd_user_name").html(userName);
	$("#confirm_resetPwd").attr("onclick","resetPwdSubmit("+userId+")");
}

function resetPwdSubmit(id){
	$.ajax({
		"url" : ctx+"/manageuser/resetPwd/"+id,
		"type" : "GET",
		data:null,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					alert(data.message);
					$('#resetPwdConfirmModal').modal('hide');
				}else{
					//showMsg("重置成功！",2000);
					alert(data.message);
					$('#resetPwdConfirmModal').modal('hide');
				}
				
			}else{
				//showMsg("重置出错！",2000);
				alert("重置出错！");
				$('#resetPwdConfirmModal').modal('hide');
			}
		},
		"error" : function() {
		}
	});

}


function importExcel(){
	$("#progressBarDIV").hide();
	$("#resultDIV").hide();
	$("#successMsgDIV").hide();
	$("#successDetailDIV").hide();
	$("#errorMsgDIV").hide();
	
	$('#importExcelModal').modal('show');
	$("#confirm_importExcel").attr("onclick","importExcelSubmit()");
}

var i=0;
var ajaxOver = true;
function importExcelSubmit(){
	
	$("#progressBarDIV").hide();
	$("#resultDIV").hide();
	$("#successMsgDIV").hide();
	$("#successDetailDIV").hide();
	$("#errorMsgDIV").hide();
	
	$("#successMsg").html('');
	$("#errorMsg").html('');
	
	var str = $("#uploadFile").val();
	if (str == '') {
		return false;
	}

	str = str.substr(str.lastIndexOf(".") + 1);
	if (!(str.toLowerCase() == "xls" || str.toLowerCase() == "xlsx")) {
		alert("文件非Excel类型的文件，无法导入！", "提示信息");
		return false;
	}
	
	var url = ctx + '/user/importExcel';

	$("#progressBar").css("width","0%");
	$("#progressBarDIV").show();
	
	ajaxOver = false;
	progressBarChange();

	$.ajaxFileUpload({
		url : url,
		fileElementId : 'uploadFile',// id
		type : 'POST',
        dataType : 'json',  
        data:null,  
		async : true,
		success : function(result, status) {
			if(result != null){
				if(result.successMsg != null && result.successMsg!=''){
					$("#progressBar").css("width",+"100%");
					
					$("#resultDIV").show();
					$("#successMsgDIV").show();
					$("#successDetailDIV").show();
					$("#successMsg").html(result.successMsg);
				}
				if(result.errorMsg != null && result.errorMsg!=''){
					$("#resultDIV").show();
					$("#errorMsgDIV").show();
					$("#errorMsg").html(result.errorMsg);
				}
			}
			
			// 重新查询
			search();
		},
		error : function(data, status, e) {
			alert("Excel导入失败，请重试！", "提示信息");
		},
		complete: function(result){
			ajaxOver = true;
			i = 0;
			$("#progressBarDIV").hide();
			$("#progressBar").css("width","0%");
        }
	});

}

function progressBarChange(){
	if(ajaxOver == false){
		if(i<95){
			i=i+4;
			$("#progressBar").css("width",i+"%");
			setTimeout("progressBarChange()", 20);
		}
	}
}

function getAllCheckOfDivision(){
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes(true);
	var idStr = "";
	for(var i=0;i<nodes.length;i++){
		idStr += nodes[i].id+',';
	}
	return idStr.substring(0,idStr.length-1);
}
