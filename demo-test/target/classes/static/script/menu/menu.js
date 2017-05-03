function search(){
	$("#pageNo").val(1);
	pageQuery();
}

function pageQuery(){
	$("#tableDiv").load(ctx+"/menuinfo/list",
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
function enableMenu(){
	var menuId = '';
	
	$("#userTableListBody input[type=checkbox]").each(function(){
		if($(this).prop("checked")){
			menuId+=$(this).val()+",";
		}
	});
	
	if(menuId==''){
		alert("请选择要启用的用户");
		return false;
	}
	
	$.ajax({
		"url" : ctx+"/menuinfo/enableMenu/"+menuId,
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
function disableMenu(){
	var menuId = '';
	
	$("#userTableListBody input[type=checkbox]").each(function(){
		if($(this).prop("checked")){
			menuId+=$(this).val()+",";
		}
	});
	
	if(menuId==''){
		alert("请选择要禁用的用户");
		return false;
	}
	
	$.ajax({
		"url" : ctx+"/menuinfo/disableMenu/"+menuId,
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
	$("#contentDiv").load(ctx+"/menuinfo/addPage");
}

function toEditPage(id){
	$("#contentDiv").load(ctx+"/menuinfo/editPage/"+id);
}

function goBack(){
	$("#contentDiv").load(ctx+"/menuinfo/main");
}


/**
 * 验证保存的必填条件
 * return 
 */
function validateSave(){
	debugger;
	if(trim($("#menuName").val())==""){
		showMsg("[用户名]不能为空");
		$("#menuName").focus();
		return false;
	}
	
	// if(isChinese(trim($("#userName").val()))){
	// 	showMsg("[用户名]不能输入中文或其他全角字符");
	// 	$("#userName").focus();
	// 	return false;
	// }
	
	if(trim($("#menuUrl").val())==""){
		showMsg("[菜单路径]不能为空");
		$("#menuUrl").focus();
		return false;
	}

	if(isChinese(trim($("#menuUrl").val()))){
		showMsg("[菜单路径]不能输入中文或其他全角字符");
		$("#menuUrl").focus();
		return false;
	}

	return true;
}

function addMenu(){
	debugger;
	if(!validateSave()){
		return;
	}

	var mt=$('input:radio[name="menuType"]:checked').val();
	if(mt=='2'){
		$("#parentId").val($("#menuSelector2").val());
	}
	if(mt=='1'){
		$("#parentId").val($("#menuSelector1").val());
	}

	var data = $("#addForm").serialize();

	$.ajax({
		"url" : ctx+"/menuinfo/menuAdd",
		//"url" : ctx+"/manageuser/userAdd",
		"type" : "PUT",
		data:data,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					alert(data.message);
				}else{
					//showMsg("保存成功！", 2000);
					alert("保存成功！");
					$("#contentDiv").load(ctx+"/menuinfo/main");
				}
				
			}else{
				showMsg("保存出错!");
			}
		},
		"error" : function() {
			
		}
	});
}

function updateMenu(){
	debugger;
	if(!validateSave()){
		return;
	}

	var data = $("#editForm").serialize();

	// 取得下拉角色
	data += ("&parentId="+$("#menuSelector").val());
	
	$.ajax({
		"url" : ctx+"/menuinfo/menuEdit",
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
					alert("修改成功！");
					$("#contentDiv").load(ctx+"/menuinfo/main");
				}
				
			}else{
				showMsg("修改出错！");
			}
		},
		"error" : function() {
		}
	});
}

function deleteMenu(menuId,menuName){
	$('#deleteConfirmModal').modal('show');
	$("#del_user_name").html(menuName);
	$("#confirm_del").attr("onclick","deleteMenuSubmit("+menuId+")");
}

function deleteMenuSubmit(id){
	$.ajax({
		"url" : ctx+"/menuinfo/menuDelete/"+id,
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

function setMenuInfo(type){
	debugger;
	if(type==0){
		//菜单设置为#,并且不能修改
		$("#menuUrl").val("#");
		$("#menuUrl").attr("disabled",true);
		$("#parentMenuDiv1").hide();
		$("#parentMenuDiv2").hide();


	}else if(type==1){
		$("#menuUrl").val("");
		$("#menuUrl").attr("disabled",false);
		$("#parentMenuDiv1").show();
		$("#parentMenuDiv2").hide();


	}else{
		$("#menuUrl").val("*");
		$("#menuUrl").attr("disabled",true);
		$("#parentMenuDiv1").hide();
		$("#parentMenuDiv2").show();

	}
}