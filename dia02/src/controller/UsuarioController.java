package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Usuario;
import persistence.UsuarioDao;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;
	Usuario usuario;
	Usuario logado;
	UsuarioDao dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			dao = new UsuarioDao();
			usuario = new Usuario();
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			logado = dao.findByLogin(usuario);

			if (logado == null) {
				request.setAttribute("msg", "Dados Invalidos");
				request.getRequestDispatcher("sistema.jsp").forward(request, response);
			} else {
				session = request.getSession(true);
				session.setAttribute("usuario", logado);
				if (logado.getPerfil().equalsIgnoreCase("adm")) {
					request.getRequestDispatcher("adm/pages.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("usu/pages.jsp").forward(request, response);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("msg", "Dados Invalidos catch : error");
			request.getRequestDispatcher("sistema.jsp").forward(request, response);

		}

	}

}