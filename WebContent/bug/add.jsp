<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bug管理系统</title>
<script src="http://yui.yahooapis.com/3.13.0/build/yui/yui-min.js"></script>
<link rel="stylesheet" href="http://yui.yahooapis.com/3.13.0/build/cssbutton/cssbutton.css">

</head>
<body>
	<form action="${ctx }/bug/add.do" method="post">
		标题：<a></a><input type="text" name="title"/><br/>
		内容：<textarea name="content"></textarea><br/>
		分配给：
		<select name="userId">
			<c:forEach items="${users }" var="u">
				<option value="${u.id }">${u.username }</option>
			</c:forEach>
		</select>
		<br/>
		优先级: 
		<select name="priority">
			<c:forEach items="${priorities }" var="p">
				<option value="${p.value }">${p }</option>
			</c:forEach>
		</select>
		<br/>
		<input type="submit" class="yui3-button" value="保存">
		<input type="reset" class="yui3-button" value="清空">
	</form>
</body>

<script>
</script>
</html>