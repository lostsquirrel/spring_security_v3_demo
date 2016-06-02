<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="http://cn.bing.com/sa/simg/bing_p_rr_teal_min.ico" type="image/x-icon" />
<title>登陆</title>
</head>
<body>
<form action="<c:url value="/j_spring_security_check" />" method="post">
	<span>用户名：<input type="text" name="j_username" /></span>
	<span>密码：<input type="password" name="j_password" /></span>
	<span>记住密码：<input type="checkbox" name="_spring_security_remember_me" /></span>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" />
</form>
</body>
</html>