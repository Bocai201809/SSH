<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
		<form action="/SSH/system/upload!up" enctype="multipart/form-data" method="post">
				<input type="file" name="file" >  <br>
				<input type="submit" value=" 导 入 ">
		</form>
</body>
</html>