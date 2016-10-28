package com.learn.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.spring.dao.PostHibeDao;
import com.learn.spring.entities.Post;
import com.learn.spring.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	private PostHibeDao postDao;
	
	@Override
	@Transactional
	public Post findId(Object id) {
		return postDao.findId(id);
	}

	@Override
	@Transactional
	public Post findBy(String key, Object val) {
		return postDao.findBy(key, val);
	}

	@Override
	@Transactional
	public List<Post> findAll() {
		return postDao.findAll();
	}

	@Override
	@Transactional
	public boolean insert(Post post) {
		return postDao.insert(post);
	}

	@Override
	@Transactional
	public boolean update(Post post) {
		return postDao.update(post); 
	}

	@Override
	@Transactional
	public boolean delete(Post post) {
		return postDao.delete(post);
	}

	@Override
	@Transactional
	public List<Post> search(String keyword) {
		return postDao.search(keyword);
	}

}
