package br.com.curso.Dao;

import java.io.Serializable;

public interface DaoGeneric <T,ID extends Serializable> {
	public void save (T instance) throws Exception;
}
