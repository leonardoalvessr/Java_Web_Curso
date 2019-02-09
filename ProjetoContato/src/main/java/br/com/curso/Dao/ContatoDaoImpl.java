package br.com.curso.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.curso.Util.JPAUtils;
import br.com.curso.model.Contato;

public class ContatoDaoImpl implements IDao {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = null;

	public void save(Contato contato) throws Exception {

		this.factory = emf.createEntityManager();

		try {
			factory.getTransaction().begin();
			if (contato.getId() == null) {
				factory.persist(contato);
			} else {
				factory.merge(contato);
			}
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
