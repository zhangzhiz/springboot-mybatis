<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<head>
<title>维信金科后台管理首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function menuClick(href) {
		$("#contentDiv").load(href);
	}

	function logout(){
		parent.window.location='${ctx}/home/logout';
	}
</script>

</head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>维信金科后台管理 | 主页</title>


</head>

<body>
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
	            <ul class="nav metismenu" id="side-menu">
	                <li class="nav-header">
	                    <div class="dropdown profile-element"> <span>
	                            <img alt="image" class="img-circle" src="/img/user_default.jpg" />
	                             </span>
	                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
	                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${userName}</strong>
	                             </span> </span> </a>
	                    </div>
	                </li>

	                <li>
	                    <a href="#" id="sysMgtNav"><i class="fa fa-th-large"></i> <span class="nav-label">系统管理</span> <span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">

	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/manageuser/main')">用户管理</a></li>

	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/roleinfo/main')">角色管理</a></li>

	                        	<li id="sysMsgLi"><a id="sysMsgNav" href="javascript:void(0);" onclick="menuClick('${ctx}/orderinfo/main')">产品管理</a></li>

	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/menuinfo/main')">菜单管理</a></li>

	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/adviseInfo/main')">意见反馈</a></li>

	                    </ul>
	                </li>

	<c:forEach items="${list}" var="item" varStatus="status">
		<c:if test="${item.menuUrl=='#'}"><li>
			<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">
				${item.menuName}
			</span> <span class="fa arrow"></span></a>
			<ul class="nav nav-second-level">
			<c:forEach items="${list}" var="other" varStatus="sta">
				<c:if test="${other.parentId==item.menuId}">
					<li><a href="javascript:void(0);" onclick="menuClick('${ctx}${other.menuUrl}')">${other.menuName}</a></li>
				</c:if>
			</c:forEach>
			</ul>
		</li>
		</c:if>
	</c:forEach>

	                <!--<li>

						<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">零售商管理</span> <span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/member/main')">零售商管理</a></li>
	                    </ul>
	                </li>
	                <li>
	                    <a href="javascript:void(0);"><i class="fa fa-th-large"></i> <span class="nav-label">主页管理</span> <span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/keyword/main')">关键词管理</a></li>
	                    </ul>
	                </li>
	                <li>
	                    <a href="javascript:void(0);"><i class="fa fa-th-large"></i> <span class="nav-label">商品管理</span> <span class="fa arrow"></span></a>
	                	<ul class="nav nav-second-level">
	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/product/main')">商品管理</a></li>
	                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/productClass/main')">商品分类管理</a></li>
	                    </ul>
	                </li>
		                <li>
		                    <a href="javascript:void(0);"><i class="fa fa-th-large"></i> <span class="nav-label">订单管理</span> <span class="fa arrow"></span></a>
		                    <ul class="nav nav-second-level">
		                        	<li><a href="javascript:void(0);" onclick="menuClick('${ctx}/order/main')">订单查询</a></li>
		                    </ul>
		                </li>-->
	            </ul>

            </div>
        </nav>



</body>
</html>
