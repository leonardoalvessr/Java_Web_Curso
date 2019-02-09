package br.com.curso.dao;

import java.util.List;

import br.com.curso.model.Contato;

public interface IContatoDAO extends GenericDAO<Contato, Long> {

	public void save(Contato contato) throws Exception;
	
	public List<Contato> list() throws Exception;
	
	public void removeById(Long id) throws Exception;
}
