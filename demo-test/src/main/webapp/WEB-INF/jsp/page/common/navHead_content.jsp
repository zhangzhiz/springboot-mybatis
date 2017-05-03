<%@ page language="java" import="java.util.*,com.jupin.common.Constant,com.jupin.user.entity.User" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ include file="/page/common/taglibs.jsp"%>
<head>
<title>聚品商城主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function menuClick(href) {
		//$("#containerDIV").load(href);
	}

	function logout(){
		parent.window.location='${ctx}/home/logout';
	}
</script>

<%
	String name = "";
	User user = (User)request.getSession().getAttribute(Constant.SESSION_KEY);
	if(user != null){
		name = user.getName();
	}
%>

</head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>聚品商城后台管理平台 | 主页</title>


</head>

<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
	            <ul class="nav metismenu" id="side-menu">
	                <li class="nav-header">
	                    <div class="dropdown profile-element"> <span>
	                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
	                             </span>
	                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
	                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">张三</strong>
	                             </span> <span class="text-muted text-xs block">市场总监 <b class="caret"></b></span> </span> </a>
	                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
	                            <li><a href="#">名片</a></li>
	                            <li><a href="#">邮箱</a></li>
	                            <li class="divider"></li>
	                            <li><a href="login.html">退出</a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="active">
	                    <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">系统管理</span> <span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        <li class="active"><a href="user_list.html">用户管理</a></li>
	                        <li><a href="#">角色管理</a></li>
	                        <li><a href="#">菜单管理</a></li>
	                        <li><a href="#">城市管理</a></li>
	                        <li><a href="#">系统消息</a></li>
	                        <li><a href="#">运费设置</a></li>
	                    </ul>
	                </li>
	                <li>
	                    <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">会员管理</span> <span class="fa arrow"></span></a>
	                </li>
	                <li>
	                    <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">主页管理</span> <span class="fa arrow"></span></a>
	                </li>
	                <li>
	                    <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">商品管理</span> <span class="fa arrow"></span></a>
	                </li>
	                <li>
	                    <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">订单管理</span> <span class="fa arrow"></span></a>
	                </li>
	                <li>
	                    <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">区域账户管理</span> <span class="fa arrow"></span></a>
	                </li>
	                <li>
	                    <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">报表</span> <span class="fa arrow"></span></a>
	                </li>
	            </ul>

            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <a href="${ctx}/home/logout">
                        <i class="fa fa-sign-out"></i> 退出
                    </a>
                </li>
            </ul>

        </nav>
        </div>
            <div id="contentDiv" class="row  border-bottom white-bg dashboard-header" style="height:800px">
				<font size="3">欢迎回到聚品商城后台管理平台！</font>
            </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content">
                </div>
                <div class="footer">
                    <div>
                        <strong>Copyright</strong> 聚品商城 &copy; 2016
                    </div>
                </div>
            </div>
        </div>

        </div>
    </div>


</body>
</html>
