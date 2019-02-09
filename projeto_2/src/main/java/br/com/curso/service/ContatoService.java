package br.com.curso.service;

import java.util.List;

import br.com.curso.dao.ContatoDAOImpl;
import br.com.curso.model.Contato;

public class ContatoService {

	private ContatoDAOImpl impl;

	public ContatoService() {
		this.impl = new ContatoDAOImpl();
	}

	public void save(Contato contato) throws Exception {
		this.impl.save(contato);
	}

	public List<Contato> list() throws Exception{
		return this.impl.list();
	}
	
	public void removeById(Long id) throws Exception{
		this.impl.removeById(id);
	}
}
