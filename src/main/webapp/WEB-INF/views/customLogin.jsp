<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>커스텀 로그인 페이지</h1>

	${exception}
	<form method='post' action="/login">

		<div>
			<input type='text' name='username' />
		</div>
		<br>

		<div>
			<input type='password' name='password' />
		</div>
		<br>

		<div>
			<input type='checkbox' name='remember-me'> 아이디 기억하기
		</div>
		<br>

		<div>
			<input type='submit'>
		</div>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

</body>
</html>
