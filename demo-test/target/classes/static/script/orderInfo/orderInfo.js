function search(){
	$("#pageNo").val(1);
	pageQuery();
}

function pageQuery(){
	$("#tableDiv").load(ctx+"/orderinfo/list",
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
	$("#contentDiv").load(ctx+"/orderinfo/addPage");
}

function toEditPage(id){
	$("#contentDiv").load(ctx+"/orderinfo/editPage/"+id);
}

function goBack(){
	$("#contentDiv").load(ctx+"/orderinfo/main");
}


/**
 * 验证保存的必填条件
 * return 
 */
function validateSave(){
	
		
	return true;
}

function addOrderInfo(){
	if(!validateSave()){
		return;
	}
	debugger;
	var data = $("#addForm").serialize();

	// 取得下拉角色
	//data += ("&roleId="+$("#roleSelector").val());
	
	$.ajax({
		//"url" : ctx+"/roleinfo/roleAdd",
		"url" : ctx+"/orderinfo/orderInfoAdd",
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
					$("#contentDiv").load(ctx+"/orderinfo/main");
				}
				
			}else{
				showMsg("保存出错!");
			}
		},
		"error" : function() {
			
		}
	});
}

function updateOrderInfo(){
	if(!validateSave()){
		return;
	}

	var data = $("#editForm").serialize();

	// 取得下拉角色
	//data += ("&roleId="+$("#roleSelector").val());
	
	$.ajax({
		"url" : ctx+"/orderinfo/orderInfoEdit",
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
					$("#contentDiv").load(ctx+"/orderinfo/main");
				}
				
			}else{
				showMsg("修改出错！");
			}
		},
		"error" : function() {
		}
	});
}

function deleteOrderInfo(id,name){
	$('#deleteConfirmModal').modal('show');
	$("#del_user_name").html(name);
	$("#confirm_del").attr("onclick","deleteOrderInfoSubmit("+id+")");
}

function deleteOrderInfoSubmit(id){
	$.ajax({
		"url" : ctx+"/orderinfo/orderInfoDelete/"+id,
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

