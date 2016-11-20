package br.com.mariojp.javaweb;

import java.sql.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class BancoUtil {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CRM" );;
		

	private static BancoUtil instancia; 
	
	private BancoUtil(){}

	public static BancoUtil  getInstancia(){
		if(instancia==null){
			instancia = new BancoUtil();
		}
		return instancia;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
}

