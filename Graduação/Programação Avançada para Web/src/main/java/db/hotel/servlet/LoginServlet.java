package db.hotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.hotel.entity.Usuario;
import db.hotel.service.UsuarioService;
import db.hotel.util.Util;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() { super(); }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		if (login.equals("") || senha.equals("")) {
			req.setAttribute("msg", "preencha os campos");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		} else {
			UsuarioService usuarioService = new UsuarioService();
			Usuario usuario = usuarioService.efetuarLogin(login, Util.HashPassword(senha));
			if (usuario == null) {
				req.setAttribute("msg", "login ou senha inválidos");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("usuario", usuario);

				resp.sendRedirect(req.getContextPath() + "/hospedes");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect(req.getContextPath() + "/login");
		req.setAttribute("title", "Login");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

}