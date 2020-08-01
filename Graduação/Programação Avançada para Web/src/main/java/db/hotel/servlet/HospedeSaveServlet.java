package db.hotel.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;

import db.hotel.entity.Endereco;
import db.hotel.entity.Hospede;
import db.hotel.service.HospedeService;
import db.hotel.util.Util;

public class HospedeSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HospedeSaveServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Dados Hóspede");
		request.getRequestDispatcher("../hospede.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		try {
			String nome =  request.getParameter("nome");
			String cpf = (String) request.getParameter("cpf");
			String logradouro = (String) request.getParameter("logradouro");
			String numero = (String) request.getParameter("numero");
			String complemento = (String) request.getParameter("complemento");
			String bairro = (String) request.getParameter("bairro");
			String cidade = (String) request.getParameter("cidade");
			String cep = (String) request.getParameter("cep");
			String email = (String) request.getParameter("email");
			Long telefone = Long.parseLong(request.getParameter("telefone"));
			Date dataNascimento = Util.toDate(
					(String) request.getParameter("dataNascimento"));
			
			HospedeService hospedeService = new HospedeService();
			Hospede hospede = new Hospede(nome, cpf,
					new Endereco(logradouro, numero, complemento, bairro, cidade, cep),
					0, email, telefone, dataNascimento);
			
			if(uri.indexOf("/new") >= 0) 
				hospedeService.salvar(hospede);
			if(uri.indexOf("/save") >= 0) 
				hospedeService.alterar(hospede);

			response.sendRedirect(request.getContextPath() + "/hospedes");
		} catch (ParseException | SystemException e) {
			e.printStackTrace();
		}
	}

}
