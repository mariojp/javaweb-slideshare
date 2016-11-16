package br.com.mariojp.javaweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = new Usuario();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		user.setLogin(login);
		user.setSenha(senha);
		if (autenticar(user)) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.jsp");
		} else {
			request.setAttribute("erro", "Usuario ou Senha Invalidos!");
			RequestDispatcher d = request.getRequestDispatcher("index.jsp");
			d.forward(request, response);
		}
	}

	private boolean autenticar(Usuario user) {
		boolean autenticado = false;
		if (user.getLogin() != null && user.getSenha() != null && user.getLogin().equals(user.getSenha())) {
			autenticado = true;
		}
		return autenticado;
	}

}
