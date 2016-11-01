package com.learn.spring.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.learn.spring.dao.IPostDao;
import com.learn.spring.entities.Post;

@Repository
public class PostDaoImpl implements IPostDao {

	@Autowired
	private SessionFactory session;

	@Override
	public Post findId(Object id) {
		return session.getCurrentSession().get(Post.class, (int) id);
	}

	@Override
	public Post findBy(String key, Object val) {
		@SuppressWarnings("deprecation")
		Criteria criteria = session.getCurrentSession().createCriteria(Post.class);
		criteria.add(Restrictions.eq(key, val));
		return (Post) criteria.uniqueResult();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public List<Post> findAll() {
		String hql = "from Post";
		Query query = session.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public boolean insert(Post post) {
		try {
			session.getCurrentSession().persist(post);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Post post) {
		try{
			session.getCurrentSession().update(post);
			return true;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Post post) {
		try{
			session.getCurrentSession().delete(post);
			return true;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@Override
	public List<Post> search(String keyword) {
		String sql = "from Post where title like :key or summary like :key or content like :key";
		Query query = session.getCurrentSession().createQuery(sql);
		query.setParameter("key", "%" + keyword + "%");
		return (List<Post>) query.list();
	}
}
