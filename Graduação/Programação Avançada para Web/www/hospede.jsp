<%@ page import="db.hotel.entity.Hospede,
				 db.hotel.util.Util" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<jsp:include page="/WEB-INF/resources/header.jsp" />
	
	<%
		Hospede h = (Hospede) request.getAttribute("guest");
	%>
	<h1><%= h == null ? "Novo" : "Editar" %> Hóspede</h1>
	<form action="<%=request.getContextPath() %>/hospede/<%= h == null ? "new" : "save" %>" method="post"
			enctype="application/x-www-form-urlencoded">
		<table>
			<tr><td>Nome</td>
				<td><input type="text" name="nome" value="<%= h == null? "" : h.getNome() %>" /></td></tr>
			<tr><td>CPF</td>
				<td><input type="text" name="cpf" value="<%= h == null? "" : h.getCpf()  %>" /></td></tr>
			<tr><td>Logradouro</td>
				<td><input type="text" name="logradouro" value="<%= h == null? "" :  h.getEndereco().getLogradouro()  %>" /></td></tr>
			<tr><td>Numero</td>
				<td><input type="text" name="numero" value="<%= h == null? "" : h.getEndereco().getNumero()  %>" /></td></tr>
			<tr><td>Complemento</td>
				<td><input type="text" name="complemento" value="<%= h == null? "" : h.getEndereco().getComplemento()  %>" /></td></tr>
			<tr><td>Bairro</td>
				<td><input type="text" name="bairro" value="<%= h == null? "" : h.getEndereco().getBairro()  %>" /></td></tr>
			<tr><td>Cidade</td>
				<td><input type="text" name="cidade" value="<%= h == null? "" : h.getEndereco().getCidade()  %>" /></td></tr>
			<tr><td>CEP</td>
				<td><input type="text" name="cep" value="<%= h == null? "" :  h.getEndereco().getCep()  %>" /></td></tr>
			<tr><td>E-mail</td>
				<td><input type="text" name="email" value="<%= h == null? "" : h.getEmail()  %>" /></td></tr>
			<tr><td>Telefone</td>
				<td><input type="text" name="telefone" value="<%= h == null? "" : h.getTelefone()  %>" /></td></tr>
			<tr><td>Data Nascimento</td>
				<td><input type="text" name="dataNascimento" id="datepicker" value="<%= h == null? "" : Util.toString(h.getDataNascimento())  %>" /></td></tr>
		</table>
		<input type="submit" value="Inserir" />
		<script>
		$( function() {
		  $( "#datepicker" ).datepicker({
			  changeMonth: true,
			  changeYear: true,
			  showOtherMonths: true,
		      selectOtherMonths: true,
			  dateFormat: 'dd/mm/yy',
		      dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
		      dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		      dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		      monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		      monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
		    });
		} );
		</script>	
	</form>
	
	<jsp:include page="/WEB-INF/resources/footer.jsp" />