package br.com.curso.Dao;

import br.com.curso.model.Contato;

public interface IDao extends DaoGeneric <Contato,Long> {
	
	public void save (Contato contato) throws Exception;
}
