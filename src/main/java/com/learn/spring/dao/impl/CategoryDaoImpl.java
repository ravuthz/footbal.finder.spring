package com.learn.spring.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.spring.dao.ICategoryDao;
import com.learn.spring.entities.Category;

@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	private SessionFactory session;

	@Override
	public Category findId(Object id) {
		return session.getCurrentSession().get(Category.class, (int) id);
	}

	@Override
	public Category findBy(String key, Object val) {
		@SuppressWarnings("deprecation")
		Criteria criteria = session.getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq(key, val));
		return (Category) criteria.uniqueResult();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public List<Category> findAll() {
		String hql = "from Category";
		Query query = session.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public boolean insert(Category page) {
		try {
			session.getCurrentSession().persist(page);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Category page) {
		try{
			session.getCurrentSession().update(page);
			return true;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Category page) {
		try{
			session.getCurrentSession().delete(page);
			return true;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@Override
	public List<Category> search(String keyword) {
		String sql = "from Category where title like :key or content like :key";
		Query query = session.getCurrentSession().createQuery(sql);
		query.setParameter("key", "%" + keyword + "%");
		return (List<Category>) query.list();
	}
	
}
