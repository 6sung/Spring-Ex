<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}
<h1>사원의 수 : ${count}</h1>
<a href="./count">사원의 수</a><p>
<a href="list"=${emp.employeeId}">전체 사원 조회</a>
</body>
</html>