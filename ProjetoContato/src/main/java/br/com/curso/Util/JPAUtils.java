/**
 * 
 */
package br.com.curso.Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author lab06usuario28
 *
 */
public class JPAUtils {
	
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("Projeto");
		}
		return factory;
				
	}
	
	public static void shutdown() {
		if (factory!= null){
			factory.close();
		}
	}
	
	
}
