package cn.wm.sum.base.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    List<T> find(String hql, Object... params);
	
	List<T> findWithPaging(String hql, int currentPage, int pageRecords, Object... params);

	Long count(String hql, Object... param);

	List<?> findBySql(String sql);

	List<?> findBySql(String sql, Object... params);

	void save(T o);

	void update(T o);

	void saveOrUpdate(T o);

	void delete(T o);

	T load(Class<T> clazz, Serializable id);
	
	int execute(String hql, Object... params);
}
