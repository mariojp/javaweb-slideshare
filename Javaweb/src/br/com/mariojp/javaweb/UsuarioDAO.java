package br.com.mariojp.javaweb;

import javax.persistence.EntityManager;

public class UsuarioDAO {

	public boolean autenticar(Usuario user) {
		EntityManager manager = BancoUtil.getInstancia().getEntityManagerFactory().createEntityManager();
		String query = "select u from Usuario as u where " + "u.login=:login and u.senha=:senha";
		Usuario usuario = null;
		try{
		 usuario = (Usuario) manager.createQuery(query).setParameter("login", user.getLogin())
				.setParameter("senha", user.getSenha()).getSingleResult();
		}catch (javax.persistence.NoResultException e) {
			System.out.println("Usuario não existe"+ e.getMessage());
		}
		manager.close();
		return (usuario!=null);

	}
}
