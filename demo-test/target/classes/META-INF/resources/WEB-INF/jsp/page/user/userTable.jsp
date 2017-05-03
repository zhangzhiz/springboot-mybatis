<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理平台 | 用户管理</title>
</head>

<body>
		<table class="table table-striped table-bordered table-hover" id="userTableList" style="font-size:13px;">
			<thead>
				<tr>
				<th style="width:5%; text-align:center;"><input type="checkbox" class="i-checks" id="selectAllBox" name="selectAllBox" onclick="selectAllClick();"/></th>
				<th style="width:20%">用户名</th>
				<th style="width:20%">密码</th>
				<th style="width:15%">是否可用</th>
				<th style="width:20%">操作</th>
				</tr>
			</thead>
			<tbody id="userTableListBody">
			<c:forEach items="${list}" var="item" varStatus="status">
				<tr class="gradeX" id="${item.userId}">
					 <td align="center"><input type="checkbox" class="i-checks" value="${item.userId}"/></td>
				     <td><c:out value="${item.userName}" escapeXml="true" /></td>
				     <td><c:out value="${item.userPassword}" escapeXml="true" /></td>
				     <td>
					<c:choose>
					       <c:when test="${item.isEnable=='1'}">可用</c:when>
					       <c:otherwise>停用</c:otherwise>
					</c:choose>
					</td>
				     <td class="center">
					     	<a href="javascript:void(0);" onclick="toEditPage('${item.userId}')" class="btn btn-warning btn-sm" role="button">
					     		<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改
					     	</a>
                            <a href="javascript:void(0);" onclick="deleteUser('${item.userId}','${item.userName}');" class="btn btn-danger btn-sm" role="button">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
                            </a>
					     	<a href="javascript:void(0);" onclick="resetPwd('${item.userId}','${item.userName }');" class="btn btn-success btn-sm" role="button">
					     		<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span> 密码重置
					     	</a>
				     </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
            
        <!-- table div -->
        <div class="row">
            <%@ include file="/WEB-INF/jsp/page/common/listPage_totalSum.jsp" %>
        </div>

    <script>
		$(document).ready(function(){
	        $('.i-checks').iCheck({
	            checkboxClass: 'icheckbox_square-green',
	            radioClass: 'iradio_square-green',
	        });

	        $("#selectAllBox").on('ifChecked', function(event){ //如果是选中，点击后则为不选中 
	        	$("#userTableListBody input[type=checkbox]").iCheck('check');
        	});
	        
	        $("#selectAllBox").on('ifUnchecked', function(event){ //如果不选中，点击后则为选中
	        	$("#userTableListBody input[type=checkbox]").iCheck('uncheck');
        	});
		});
		
    </script>

</body>

</html>
