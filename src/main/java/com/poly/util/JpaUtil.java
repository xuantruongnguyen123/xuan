package com.poly.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory fac;
	
	public static EntityManager getEntityManager() {
		if (fac == null || fac.isOpen()) {
			fac = Persistence.createEntityManagerFactory("asmjava4");
		}
		return fac.createEntityManager();
	}
	
	public static void shutDown() {
		if (fac != null && fac.isOpen()) {
			fac.close();
		}
		fac = null;
	}
}
