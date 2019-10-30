package br.org.catolicasc.loja.dao;

import java.util.List;

public interface IDao<T> {

	public void save(T t);

	public void update(T t);

	public void destroy(T t);

	public T findById(Long id);

	public List<T> collection();

	public List<T> paginatedCollection(int ini, int max);
}
