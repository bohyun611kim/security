<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지</title>
</head>
<body>

	<h1>/sample/admin page</h1>
	
	<!--  CustomerUserDetailService 반환된 객체 : CustomerMember getMember 호출   -->	
	<p>
		principal : 
		<sec:authentication property="principal" />
	</p>
	<p>
		MemberVO :
		<sec:authentication property="principal.member" />
	</p>
	<p>
		사용자 이름 :
		<sec:authentication property="principal.member.userName" />
	</p>
	<p>
		사용자 권한리스트 :
		<sec:authentication property="principal.member.authList" />
	</p>

	<a href="/customLogout">로그아웃</a>

</body>
</html>
