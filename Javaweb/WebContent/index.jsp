<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Página de Login</title>
</head>
<body>
	<form method="post" action="Autenticador">
		Login: <input name="login" type="text"> <br> Senha: <input
			name="senha" type="password"><br> <input type="submit">
	</form>
	<c:out value="${erro}" />
</body>
</html>