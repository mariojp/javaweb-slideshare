<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Página Home</title>
<jsp:useBean id="user" class="br.com.mariojp.javaweb.Usuario"
	scope="session" />
</head>
<body>
	<c:if test="${user.login == null}">
		<c:redirect url="login.jsp" />
	</c:if>
	Bem vindo,
	<c:out value="${user.login}" />
</body>
</html>