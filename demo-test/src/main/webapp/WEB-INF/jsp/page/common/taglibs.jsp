<!-- 清除缓存 -->
<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<META HTTP-EQUIV="expires" CONTENT="0">

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1  
	response.addHeader("Cache-Control", "no-store"); //Firefox  
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0  
	response.setDateHeader("Expires", -1);  
	response.setDateHeader("max-age", 0);  
%>
<base href="<%=basePath%>">

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="imgPath" value="http://image.jupin.com"/>
<c:set var="randomVal" scope="page" value="<%=Math.random()%>"/>
</head>