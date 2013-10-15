<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String ctx = null;
	if (request.getServerPort() == 80) {
		ctx = "http://" + request.getServerName() + request.getContextPath();
	} else {
		ctx = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
}
	session.setAttribute("ctx", ctx);
%>    
