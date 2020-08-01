<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/resources/header.jsp" />

		<div id="login">
		<h1>Login</h1>
		<% if(request.getAttribute("msg") != null){%>
			<h3><%= request.getAttribute("msg")	 %></h3>	
		<% } %>
		<form action="<%= request.getContextPath()%>/login" method="post"
			enctype="application/x-www-form-urlencoded">
			Login: <input type="text" name="login" /><br />
			Senha: <input type="password" name="senha" /><br />
			<input type="submit" value="Logar" />
		</form>
		</div>

<jsp:include page="/WEB-INF/resources/footer.jsp" />