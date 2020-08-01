<%@ page import="java.util.*,
				db.hotel.entity.Hospede,
				db.hotel.util.Util" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="/WEB-INF/resources/header.jsp" />
	
	<table>
		<thead><tr>
			<td style="width: 27%;">Nome</td>
			<td style="width: 21%;">Cpf</td>
			<td style="width: 27%;">Email</td>
			<td style="width: 15%;">Data Nascimento</td>
			<td><a href="<%=request.getContextPath() %>/hospede/new">
				<img src="<%=request.getContextPath() %>/img/add.png" />
			</a></td>
		</tr></thead>
		<%
			List<Hospede> hospedes = (List<Hospede>) request.getAttribute("hospedes");
			int i = 0;
			for (Hospede hospede : hospedes) { %>
		<tr class="<%= (i % 2 == 0) ? "even": "odd" %>">
			<td><%=hospede.getNome()%></td>
			<td><%=hospede.getCpf()%></td>
			<td><%=hospede.getEmail()%></td>
			<td><%=Util.toString(hospede.getDataNascimento())%></td>
			<td>
				<a href='<%=request.getContextPath() %>/hospede/edit?id=<%=hospede.getId()%>'>
					<img src="<%=request.getContextPath() %>/img/edit.png" /></a>
				&nbsp;
				<a href='<%=request.getContextPath() %>/hospede/remove?id=<%=hospede.getId()%>' class="conf">
					<img src="<%=request.getContextPath() %>/img/remove.png" /></a>
			</td>
		</tr>
		<%
			i++;
			} 
		%>
	</table>
	<script>
    $('.conf').on('click', function () {
        return confirm('Você tem certeza?');
    });
	</script>

	
	<jsp:include page="/WEB-INF/resources/footer.jsp" />