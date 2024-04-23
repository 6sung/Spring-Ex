<%@page import="com.example.myapp.hr.model.Emp" %>

<%@page import= "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
</head>
<body>
<h1>사원 목록</h1>
${message}
<a href="./insert">신규 사원 정보 입력</a>
<table border="1">
<tr>
	<th>EMPLOYEE_ID</th>
	<th>FIRST_NAME</th>
	<th>LAST_NAME</th>
	<th>EMAIL</th>
	<th>PHONE_NUMBER</th>
	<th>HIRE_DATE</th>
	<th>JOB_ID</th>
	<th>SALARY</th>
	<th>COMMISSION_PCT</th>
	<th>MANAGER_ID</th>
	<th>DEPARTMENT_ID</th>
</tr>
<c:forEach var="emp" items="${empList}">
<tr>
	<c:url var="empDetailsURI" value="/hr/${emp.employeeId}"/>
	<td><a href="${empDetailsURI}">${emp.employeeId}</a></td>
	<td>${emp.firstName}</td>
	<td>${emp.lastName}</td>
	<td>${emp.email}</td>
	<td>${emp.phoneNumber}</td>
	<td>${emp.hireDate}</td>
	<td>${emp.jobId}</td>
	<td>${emp.salary}</td>
	<td><c:if test="${emp.commissionPct != 0.0}">${emp.commissionPct}</c:if></td>
	<td><c:if test="${emp.managerId != 0 }"></c:if> ${emp.managerId}</td>
	<td><c:if test="${emp.departmentId != 0 }">${emp.departmentId}</c:if></td>
</tr>
</c:forEach>
</table>
<!--  
<table border="1">
<c:forEach var="emp" items="${empList}">
<tr>
	<td><a href="./${emp.employeeId} ">${emp.employeeId}</a></td>
	<td>${emp.firstName}</td>
	<td>${emp.lastName}</td>
	<td>${emp.email}</td>
	<td>${emp.phoneNumber}</td>
	<td>${emp.hireDate}</td>
	<td>${emp.jobId}</td>
	<td>${emp.salary}</td>
	<td><c:if test="${emp.commissionPct != 0.0}">${emp.commissionPct}</c:if></td>
	<td><c:if test="${emp.managerId != 0 }"></c:if> ${emp.managerId}</td>
	<td><c:if test="${emp.departmentId != 0 }">${emp.departmentId}</c:if></td>
	
</tr>
</c:forEach>
</table>
<p>
<hr>
<%-- <%
List<Emp> empList = (List<Emp>)request.getAttribute("empList");
//for(int i=0;i<empList.length;i++)
	for(Emp emp : empList){
%>
		<%=emp.getEmployeeId() %> <%=emp.getFirstName() %><p>
		${emp.employeeId} ${emp.firstName} ${emp.lastName}<p> 
<%
	}
%> --%>

${empList[0].employeeId} ${empList[0].firstName} ${empList[0].lastName}<p>
${empList[1].employeeId} ${empList[1].firstName} ${empList[1].lastName}
-->
</body>
</html>