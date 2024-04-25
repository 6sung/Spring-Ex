<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE Upload</title>
</head>
<body>
<h1>파일 업로드</h1>
<c:url var="#" value='/file/new'/>
<form action="${actionURL}" method="post" enctype="multipart/form-data">
	카테고리 : <select name="category">
		<option value="/">/
		<option value="image">이미지
		<option value="data">데이터
	</select><p>
	파일 : <input type="file" name="file"><p>
	<input type="submit" value=" 저장 ">
	<input type="reset" value=" 취소 ">
</form>
</body>
</html>