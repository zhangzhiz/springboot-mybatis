<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>聚品商城后台管理平台 | 管理</title>
</head>

<body>
		<table class="table table-striped table-bordered table-hover" id="editable" style="font-size:13px;">
			<thead>
				<tr>
					<th style="width:14%">产品名称</th>
					<th style="width:14%">产品颜色</th>
					<th style="width:14%">产品重量</th>
					<th style="width:14%">产品价格</th>
					<th style="width:14%">生产厂家</th>
					<th style="width:14%">生产日期</th>
				<th style="width:14%">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item" varStatus="status">
				
						<tr class="gradeX" id="${item.productId}">
				
						<td><c:out value="${item.productName}" escapeXml="true" /></td>
				
						<td><c:out value="${item.productColor}" escapeXml="true" /></td>
				
						<td><c:out value="${item.productWeight}" escapeXml="true" /></td>
				
						<td><c:out value="${item.productPrice}" escapeXml="true" /></td>
				
						<td><c:out value="${item.createCompany}" escapeXml="true" /></td>
				
						<td><c:out value="${item.createTime}" escapeXml="true" /></td>
				
				     <td class="center">
					 <a href="javascript:void(0);" onclick="toEditPage('${item.productId}')" class="btn btn-warning btn-sm" role="button">
					     		<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改
					     	</a>
					<a href="javascript:void(0);" onclick="deleteOrderInfo('${item.productId}','');" class="btn btn-danger btn-sm" role="button">
					     		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
					     	</a>
					     	
					     	
					     	
					     	
					     	
					     	
					     	
							
					     	
				     </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
            
        <!-- table div -->
        <div class="row">
            <%@ include file="/WEB-INF/jsp/page/common/listPage.jsp" %>
        </div>

    <!-- Page-Level Scripts -->
    <script>
    
    </script>

</body>

</html>
