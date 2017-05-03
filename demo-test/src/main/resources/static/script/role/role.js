function search(){
	$("#pageNo").val(1);
	pageQuery();
}

function pageQuery(){
	$("#tableDiv").load(ctx+"/roleinfo/list",
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

function toAddPage(){
	$("#contentDiv").load(ctx+"/roleinfo/addPage");
}

function toEditPage(id){
	$("#contentDiv").load(ctx+"/roleinfo/editPage/"+id);
}

function goBack(){
	$("#contentDiv").load(ctx+"/roleinfo/main");
}


/**
 * 验证保存的必填条件
 * return 
 */
function validateSave(){
	if(trim($("#roleName").val())==""){
		showMsg("[角色名称]不能为空");
		$("#roleName").focus();
		return false;
	}

	return true;
}

function addRole(){
	if(!validateSave()){
		return;
	}
	
	//取得树形中所有check状态的id,拼成字符串
	var funcIdTreeStr = getAllCheckOfFunc();
	var data = $("#addForm").serialize();
	data += ("&funcIdTreeStr="+funcIdTreeStr);
	
	$.ajax({
		"url" : ctx+"/roleinfo/roleAdd",
		"type" : "PUT",
		data:data,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				}else{
					alert("保存成功！", 2000);
					$("#contentDiv").load(ctx+"/roleinfo/main");
				}
				
			}else{
				showMsg("保存出错!");
			}
		},
		"error" : function() {
			
		}
	});
}

function updateRole(){
	if(!validateSave()){
		return;
	}
	
	//取得树形中所有check状态的id,拼成字符串
	var funcIdTreeStr = getAllCheckOfFunc();
	var data = $("#editForm").serialize();
	data += ("&funcIdTreeStr="+funcIdTreeStr);
	
	$.ajax({
		"url" : ctx+"/roleinfo/roleEdit",
		"type" : "POST",
		data:data,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				} else {
					alert("修改成功！", 2000);
					$("#contentDiv").load(ctx+"/roleinfo/main");
				}
				
			}else{
				showMsg("修改出错！");
			}
		},
		"error" : function() {
		}
	});
}

function deleteRole(id,name){
	$('#myModal').modal('show');
	$("#del_name").html(name);
	$("#confirm_del").attr("onclick","deleteRoleSubmit("+id+")");
}

function deleteRoleSubmit(id){
	$.ajax({
		"url" : ctx+"/roleinfo/roleDelete/"+id,
		"type" : "DELETE",
		data:null,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					alert(data.message);
					$('#myModal').modal('hide');
				}else{
					$("#"+id).remove();
					$('#myModal').modal('hide');
					pageQuery();
				}
				
			}else{
				alert("保存出错！",2000);
				$('#myModal').modal('hide');
			}
		},
		"error" : function() {
		}
	});

}

