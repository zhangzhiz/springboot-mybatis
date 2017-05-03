<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/page/common/page_head.jsp"%>
<!DOCTYPE html>

<html>
<script src="/script/orderInfo/orderInfo.js"></script>

<link rel="stylesheet" href="/js/zTree_v3/css/zTreeStyle/metro.css" type="text/css">
<script type="text/javascript" src="/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="/js/zTree_v3/js/jquery.ztree.exedit-3.5.js"></script>

<head>
	<title>维信金科后台管理平台 | 管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	
</script>

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
                        <strong>管理</strong>
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
                            	
                                
									<input type="hidden" id="productId" name="productId" value="${orderInfo.productId}"/>
                                
									<div class="form-group"><label class="col-sm-2 control-label">产品名称</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="productName" name="productName" value="${orderInfo.productName}" maxlength="200"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                
									<div class="form-group"><label class="col-sm-2 control-label">产品颜色</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="productColor" name="productColor" value="${orderInfo.productColor}" maxlength="200"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                
									<div class="form-group"><label class="col-sm-2 control-label">产品重量</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="productWeight" name="productWeight" value="${orderInfo.productWeight}" maxlength="200"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                
									<div class="form-group"><label class="col-sm-2 control-label">产品价格</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="productPrice" name="productPrice" value="${orderInfo.productPrice}" maxlength="200"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                
									<div class="form-group"><label class="col-sm-2 control-label">生产厂家</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="createCompany" name="createCompany" value="${orderInfo.createCompany}" maxlength="200"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                
									<div class="form-group"><label class="col-sm-2 control-label">生产日期</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="createTime" name="createTime" value="${orderInfo.createTime}" maxlength="200"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                
											
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-2">
                                    	<a href="javascript:void(0);" onclick="updateOrderInfo();" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 保存</button></a>
                                    	<a href="javascript:void(0);" onclick="goBack();" class="btn btn-white" role="button"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 取消</button></a>
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


    <!-- Page-Level Scripts -->
    <script>

    </script>

</body>

</html>
