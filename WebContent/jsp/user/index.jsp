<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#button").click(function() {
			$.ajax({
				   type: "POST",
				   url: "/SSH/system/user!ajaxPwd",
				   success: function(data){
				     	$("li :first").append("---->" + data);
				   }
				});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<p>User Index</p>
	<ul>
		<c:forEach var ="user" items="${users }">  
			<li>${user.name}---->${user.age}</li>
		</c:forEach>
	</ul>
	
	<br>
	
	<input type="button" id="button" value="加载密码">
</body>
</html>