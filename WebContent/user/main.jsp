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
<h1>主面板</h1>
<hr/>
用户：${user.username }, 当前一共有100个未完成的bug
<hr/>
	<br/>
	 <button class="yui3-button" onclick="javascript:location='${ctx}/bug/bug.do';;">我的bug</button>
	 <button class="yui3-button" onclick="javascript:location='${ctx}/bug/pageAdd.do';;">新建bug</button>
</body>

<script>
</script>
</html>