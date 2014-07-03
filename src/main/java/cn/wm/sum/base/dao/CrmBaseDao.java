package cn.wm.sum.base.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public abstract class CrmBaseDao<T> implements BaseDao<T> {


   @PersistenceContext(unitName="crm")
   private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		Query q = em.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i+1, params[i]);
			}
		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findWithPaging(String hql, int currentPage, int pageSize,
			Object... params) {
		// TODO Auto-generated method stub
		Query q = em.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i+1, params[i]);
			}
		}
		
		return q.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).getResultList();
	}

	public Long count(String hql, Object... param) {
		// TODO Auto-generated method stub
		

		Query q = em.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i+1, param[i]);
			}
		}
		return (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<?> findBySql(String sql) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery(sql);
		return (List<Object[]>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<?> findBySql(String sql, Object... params) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i+1, params[i]);
			}
		}
		return (List<Object[]>) q.getResultList();
	}

	public void save(T o) {
		// TODO Auto-generated method stub
		em.persist(o);
	}

	public void update(T o) {
		// TODO Auto-generated method stub
		em.merge(o);
	}

	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		
	}

	public void delete(T o) {
		// TODO Auto-generated method stub
		em.remove(o);
	}

	public T load(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T) em.find(clazz, id);
	}

	public int execute(String hql, Object... params) {
		// TODO Auto-generated method stub
		Query q = em.createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i+1, params[i]);
			}
		}
		return q.executeUpdate();
	}
	
	
	
}
