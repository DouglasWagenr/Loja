package br.org.catolicasc.loja.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.org.catolicasc.loja.entities.EntityBase;

public abstract class JpaDaoBase<T extends EntityBase> implements IDao<T> {

	private final Class<T> classe;
	protected static EntityManager em = new JPAUtil().getEntityManager();

	@SuppressWarnings("unchecked")
	public JpaDaoBase() {
		this.classe = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void save(T t) {
		em.getTransaction().begin();
		if (t.getId() == null)
			em.persist(t);
		else
			em.merge(t);
		em.getTransaction().commit();
	}

	public void destroy(T t) {
		em.getTransaction().begin();
		em.remove(this.findById(t.getId()));
		em.getTransaction().commit();
	}

	public void update(T t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	public T findById(Long id) {
		return (T) em.find(classe, id);
	}

	public List<T> collection() {
		Query query = em.createQuery("select t from " + classe.getName()+ " t ");
		List<T> lista = query.getResultList();
		return lista;
	}

	
	public List<T> paginatedCollection(int ini, int max) {
		Query query = em.createQuery("select t from " + classe.getName()+ " t ");
		query.setFirstResult(ini);
		query.setMaxResults(max);
		List<T> lista = query.getResultList();
		return lista;
	}	
}