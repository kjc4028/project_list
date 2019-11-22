<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>회원가입</title>
</head>
<body>
	<form:form modelAttribute="usrEntity" method="post">
		아이디:<form:input path="usrId"/><br>
		비밀번호:<form:password path="usrPw"/><br>
		성명:<form:input path="usrNm"/><br>
		주민번호 앞자리<form:input path="rrn"/><br>
		성별:<form:radiobutton path="gender" label="남" value="M"/>
		<form:radiobutton path="gender" label="여" value="F"/><br>
		전화번호:<form:input path="telNum1"/> - 
		<form:input path="telNum2"/> - 
		<form:input path="telNum3"/>
		<button>회원가입</button>
	</form:form>
</body>
</html>