package br.com.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.com.curso.model.Contato;
import br.com.curso.utils.JPAUtils;

public class ContatoDAOImpl implements IContatoDAO {

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
			factory.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}
	}

	@Override
	public List<Contato> list() throws Exception {
		this.factory = emf.createEntityManager();
		List<Contato> contatos = null;
		try {
			factory.getTransaction().begin();
			 TypedQuery<Contato> query = factory.createQuery("select c from Contato c", Contato.class);
			 return query.getResultList();
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

		return contatos;
	}
	
	@Override
	public void removeById(Long id) throws Exception {
		this.factory = emf.createEntityManager();
		Contato contato = new Contato();

		try {

			contato = factory.find(Contato.class, id);
			factory.getTransaction().begin();
			factory.remove(contato);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
