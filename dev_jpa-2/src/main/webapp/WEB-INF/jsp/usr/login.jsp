<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<form:form modelAttribute="usrEntity" method="post" action="/usr/login">
	아이디:<form:input path="usrId"/><br>
	비밀번호:<form:password path="usrPw"/><br>
	<button>로그인</button>
</form:form>
</body>
</html>