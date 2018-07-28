<%@ page import="db.hotel.entity.Usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<?xml version="1.0" encoding="UTF-8" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>hotelDB :: <%
	out.print(request.getAttribute("title") == null ? "Home" : request.getAttribute("title"));
	%></title>
</head>
<body><div id="header">
		<div id="logo">
			<h1><a href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/img/logo.png" /></a></h1>
		</div>
		<div id="user"><%
			if ((request.getSession(false) == null) ||
					(request.getSession(false).getAttribute("usuario") == null)) { %>
		<a href="/hotel/login">Login</a>
		<% } else { %>
		<a href="<%=request.getContextPath() %>/profile">
		<%
			Usuario u = (Usuario) request.getSession(false).getAttribute("usuario");
			if(u.getPessoa() != null){
				out.print(u.getPessoa().getNome());
			} else {
				out.print(u.getLogin());
			}
		 %></a> | <a href="<%=request.getContextPath() %>/logout">logout</a>
		<% } %>
		</div>	
	</div>
	<div id="content">