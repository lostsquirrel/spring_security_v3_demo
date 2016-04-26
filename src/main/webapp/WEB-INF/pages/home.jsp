<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<%-- 
<h1>Welcome <c:out value="${pageContext.request}"/></h1>
 --%>
	<h1>
		Welcome
		<c:out value="${pageContext.request.remoteUser}" />
	</h1>
	<c:if test="${not empty msg }">
		<c:out value="${msg}"></c:out>
	</c:if>
	<c:url var="logoutUrl" value="/j_spring_security_logout" />
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>