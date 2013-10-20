<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug管理系统</title>
<style type="text/css">
	.loginFrom
	{
		position:absolute;
		top:100px;
		left:300px;
		border:1px solid blue;
		border-radius:6px;
		width:250px;
		height:100px;
		padding:10px;
	}
</style>
</head>
<body>
	<form class="loginFrom" action="/mybug/user/login.do" method="post">
		<table>
			<tr>
				<td style="height:30px;" align="right">用户名：</td>
				<td><input style="width:150px;" type="text" name="username"/></td>
			</tr>
			<tr>
				<td style="height:30px;" align="right">密   码：</td>
				<td><input style="width:150px;" type="password" name="password"/></td>
			</tr>
			<tr>
				<td style="height:30px;"></td>
				<td><input type="submit" value="登  陆"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="注 册"/></td>
			</tr>
		</table>
	</form>
</body>
</html>