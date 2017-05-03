<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/page/common/page_head.jsp"%>
<!DOCTYPE html>

<html>
<script src="/script/menu/menu.js?var=${randomVal}"></script>

<!--<link rel="stylesheet" href="js/zTree_v3/css/zTreeStyle/metro.css" type="text/css">
<script type="text/javascript" src="js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="js/zTree_v3/js/jquery.ztree.exedit-3.5.js"></script> -->

<head>
	<title>聚品商城后台管理平台 | 菜单管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    
	<!-- chosen select -->
	<link href="/css/plugins/chosen/chosen.css" rel="stylesheet">
	<script src="/js/plugins/chosen/chosen.jquery.js"></script>

</head>

<body>

        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
            		<h>&nbsp;</h>
                <ol class="breadcrumb">
                    <li>
                        <a href="index.html">主页</a>
                    </li>
                    <li>
                        <a>系统管理</a>
                    </li>
                    <li class="active">
                        <strong>菜单管理</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>


        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>基本信息</h5>
                        </div>
                        <div class="ibox-content">
                            <form id="editForm" class="form-horizontal">
                            	<input type="hidden" id="menuId" name="menuId" value="${menu.menuId }"/>
                                <div class="form-group"><label class="col-sm-2 control-label">菜单名称(<span style="color:red">*</span>)</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="menuName" name="menuName"  value="${menu.menuName}"></div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">菜单路径(<span style="color:red">*</span>)</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="menuUrl" name="menuUrl" value="${menu.menuUrl}" maxlength="50"></div>
                                </div>

                                <div class="hr-line-dashed"></div>

                                <div class="form-group"><label class="col-sm-2 control-label">父菜单(<span style="color:red">*</span>)</label>
									<div class="input-group">
						                 &nbsp;&nbsp;&nbsp;&nbsp;<select id="menuSelector" name="menuSelector" data-placeholder="选择父菜单..." class="chosen-select" style="width:350px;" tabindex="4">
                                            <option value=""></option>
                                            <c:forEach items="${allMenuList}" var="item" varStatus="status">
							                	<option value="${item.menuId}" <c:if test="${item.menuId == menu.parentId}">selected</c:if> ><c:out value="${item.menuName}" escapeXml="true" /></option>
							                </c:forEach>
						                </select>
	           						</div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">是否可用</label>
                                    <div class="col-sm-10">
										<input type="checkbox" class="i-checks" id="isEnable" name="isEnable" <c:if test='${menu.isEnable=="1"}'> checked</c:if>>
									</div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-2">
                                    	<a href="javascript:void(0);" onclick="updateMenu();" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 保存</a>
                                    	<a href="javascript:void(0);" onclick="goBack();" class="btn btn-white" role="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 取消</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
	            <div class="col-sm-12 col-md-12">
	                <div id="messageDiv" class="alert alert-danger" role="alert" style="display:none;">
	                    <strong>提示信息!</strong> 
	                </div>
	            </div>
            </div>
        </div>


		<script>
			var config = {
			    '.chosen-select'           : {},
			    '.chosen-select-deselect'  : {allow_single_deselect:true},
			    '.chosen-select-no-single' : {disable_search_threshold:10},
			    '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
			    '.chosen-select-width'     : {width:"95%"}
			    }
			for (var selector in config) {
			    $(selector).chosen(config[selector]);
			}

			$(document).ready(function(){
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
                
				// 选中角色
				<c:forEach items="${roleList}" var="role" varStatus="status">
					$("#roleSelector option").each(function(){
						if($(this).val() == '${role.id}'){
							$(this).attr("selected", "selected");
						}
					});
					$("#roleSelector").trigger("chosen:updated");
				</c:forEach>
			});
			
			
			
		</script>


</body>

</html>
