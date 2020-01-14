<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="d-flex flex-column h-100">

<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

Main Page <br>

${user }
<sec:authorize access="isAnonymous()">
<a href="/usr/join">회원가입</a>
<a href="/usr/login">로그인</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<a href="/usr/logout">로그아웃</a>
</sec:authorize>
</body>
</html>