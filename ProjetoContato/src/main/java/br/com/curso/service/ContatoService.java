package br.com.curso.service;

import br.com.curso.Dao.ContatoDaoImpl;
import br.com.curso.model.Contato;

public class ContatoService {

	private ContatoDaoImpl contatoDAO;

	public ContatoService() {
		this.contatoDAO = new ContatoDaoImpl();
	}

	public void save(Contato contato) throws Exception {
		this.contatoDAO.save(contato);
	}
}
