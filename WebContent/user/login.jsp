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
	<form action="${ctx }/user/login.do" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="admin"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" value="admin"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="yui3-button" type="submit" value="登陆"/>
					<span style="color:red;">${msg }</span>
				</td>
			</tr>
		</table>
	</form>
</body>

<script>
</script>
</html>