package br.com.mariojp.javaweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		Connection con = BancoUtil.getConnection();
		try {
			String sql = "select * from usuarios where " + "login=? and senha=?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getLogin());
			pstmt.setString(2, user.getSenha());
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				autenticado = true;
			}
			resultSet.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autenticado;
	}

}
