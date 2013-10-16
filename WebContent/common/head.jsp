<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String ctx = null;
	if (request.getServerPort() == 80) {
		ctx = "http://" + request.getServerName() + request.getContextPath();
	} else {
		ctx = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
}
	session.setAttribute("ctx", ctx);
%>    
