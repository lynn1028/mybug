<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug管理系统</title>
<script src="http://yui.yahooapis.com/3.13.0/build/yui/yui-min.js"></script>
<link rel="stylesheet" href="http://yui.yahooapis.com/3.13.0/build/cssbutton/cssbutton.css">

</head>
<body>
	<table>
		<thead>
			<th>ID</th>
			<th>title</th>
			<th>状态</th>
			<th>优先级</th>
		</thead>
		<tbody>
			<c:forEach items="${bugs }" var="b">
			<tr>
				<td>${b.id }</td>
				<td>${b.title }</td>
				<td>${b.status }</td>
				<td>${b.priority }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

<script>
</script>
</html>