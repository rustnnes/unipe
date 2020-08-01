package db.hotel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;

import db.hotel.entity.Hospede;
import db.hotel.service.HospedeService;

public class HospedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HospedeServlet() { super(); }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HospedeService hospedeService = new HospedeService();
		String uri = req.getRequestURI();

		if (req.getParameter("id") != null) {
			long id = Long.parseLong(req.getParameter("id"));
			Hospede h = hospedeService.buscarPorId(id);
			if (h != null)
				try {
					if (uri.indexOf("edit") >= 0) {
						req.setAttribute("guest", h);
						req.getRequestDispatcher("../hospede.jsp").forward(req, resp);
						return;
					}
					if (uri.indexOf("remove") >= 0)
						hospedeService.remover(h);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			else req.setAttribute("guest", null);
		}
		
		req.setAttribute("title", "Hospedes");
		List<Hospede> hospedes = hospedeService.listar();
		req.setAttribute("hospedes", hospedes);
		req.getRequestDispatcher( (uri.indexOf("remove") >= 0)? "../": "" + "hospedes.jsp").forward(req, resp);
	}
}