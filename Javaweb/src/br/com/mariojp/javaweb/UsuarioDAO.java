package br.com.mariojp.javaweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	
	public boolean autenticar(Usuario user) {
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
