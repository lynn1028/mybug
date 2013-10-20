<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bug管理系统</title>

<style type="text/css">
    .table {
    	border:1px solid #ccc;
    }
    .bugFrom
	{
		position:absolute;
		left:700px;
		border:1px solid blue;
		border-radius:6px;
		width:260px;
		height:170px;
		padding:10px;
		padding-left:22px;
	}
</style>
</head>
<body>
	<form class="bugFrom" action="/mybug/bug/add.do" method="post">
		<table>
		    	<tr>
		    		<td align="center" colspan="2" style="color:red;">bug录入</td>
		    	</tr>
			<tr>
				<td style="height:30px;" align="right">标 题：</td>
				<td><input style="width:150px;" type="text" name="titile"/></td>
			</tr>
			<tr>
				<td style="height:30px;" align="right">内 容：</td>
				<td><input style="width:150px;" type="text" name="content"/></td>
			</tr>
			<tr>
				<td style="height:30px;" align="right">状 态：</td>
				<td><input style="width:150px;" type="text" name="status"/><input type="hidden" name="user_id" value="${user.id}"/></td>
			</tr>
			<tr>
				<td style="height:30px;"></td>
				<td><input type="submit" value="提 交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置"/></td>
			</tr>
		</table>
	</form>
	
	<table style="border:1px solid green;">
         <thead>
            <tr>
                <td>标题</td>
                <td>bug内容</td>
                <td>状态</td>
                <td>日期</td>
            </tr>
         </thead>
         <c:forEach items="${buglist}" var="bug">
            	<tr>
	                <td>${bug.title}</td>
	                <td>${bug.content}</td>
	                <td>${bug.status}</td>
	                <td>${bug.createDate}</td>
	            </tr>
          </c:forEach>
    </table>
</body>
</html>