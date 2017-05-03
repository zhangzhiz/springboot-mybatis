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
	<title>维信金科后台管理平台 | 菜单管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                            <form id="addForm" class="form-horizontal">
                                <div class="form-group"><label class="col-sm-2 control-label">菜单类型(<span style="color:red">*</span>)</label>
                                        <label class="checkbox-inline">
                                            <input type="radio" name="menuType" id="menuType0" value="0" onchange="setMenuInfo(0);">目录
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" name="menuType" id="menuType1" value="1" onchange="setMenuInfo(1);" checked>菜单
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" name="menuType" id="menuType2" value="2" onchange="setMenuInfo(2);">按钮
                                        </label>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">菜单名称(<span style="color:red">*</span>)</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="menuName" name="menuName" maxlength="50"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">菜单路径(<span style="color:red">*</span>)</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="menuUrl" name="menuUrl" maxlength="50" style="display:block;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <input type="hidden" id="parentId" name="parentId"/>

                                <div class="form-group" id="parentMenuDiv1"><label class="col-sm-2 control-label">父目录(<span style="color:red">*</span>)</label>
									<div class="input-group" >

						                 &nbsp;&nbsp;&nbsp;&nbsp;
                                        <select id="menuSelector1" name="menuSelector1" data-placeholder="选择目录..." class="chosen-select" style="width:350px;display:block;" tabindex="4">
                                            <option value=""></option>
                                            <c:forEach items="${allMenuList}" var="menu" varStatus="status">
							                	<c:if test="${menu.menuType=='0'}">
                                                    <option value="${menu.menuId}"><c:out value="${menu.menuName}" escapeXml="true" /></option>
                                                </c:if>
							                </c:forEach>
						                </select>
	           						</div>
                                </div>
                                <div class="form-group" style="display:block;" id="parentMenuDiv2"><label class="col-sm-2 control-label">父菜单(<span style="color:red">*</span>)</label>
                                    <div class="input-group" >
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <select id="menuSelector2" name="menuSelector2" data-placeholder="选择菜单..." class="chosen-select" style="width:350px;" tabindex="4">
                                            <option value=""></option>
                                            <c:forEach items="${allMenuList}" var="menu" varStatus="status">
                                                <c:if test="${menu.menuType=='1'}">
                                                    <option value="${menu.menuId}"><c:out value="${menu.menuName}" escapeXml="true" /></option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">菜单顺序</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="orderNum" name="orderNum" maxlength="5"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">授权标识</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="menuPers" name="menuPers" maxlength="100" placeholder="多个用逗号分隔，如：user:list,user:create"></div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group"><label class="col-sm-2 control-label">是否可用</label>
                                    <div class="col-sm-10">
										<input type="checkbox" class="i-checks" id="isEnable" name="isEnable" checked>
									</div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-2">
                                    	<a href="javascript:void(0);" onclick="addMenu();" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 保存</a>
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
                document.getElementById("parentMenuDiv2").style.display="none";
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
			});
			
        </script>

</body>

</html>
