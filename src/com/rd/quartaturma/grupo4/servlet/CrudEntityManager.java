package com.rd.quartaturma.grupo4.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CrudEntityManager {

	 private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("DExamesPersistence");  
	 
	    public static EntityManager getEntityManager() {
	        return emFactory.createEntityManager();
	    }
}
