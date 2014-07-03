<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>


<!DOCTYPE html>
<html>
<head>
	<title>没有权限</title>
</head>
<body>
	<h2> 用户：<shiro:principal property="name"/>，没有权限操作该页面.</h2>
	<p><a href="<c:url value="/"/>">返回首页</a></p>
</body>
</html>