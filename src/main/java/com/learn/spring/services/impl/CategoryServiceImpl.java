package com.learn.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.spring.dao.ICategoryDao;
import com.learn.spring.entities.Category;
import com.learn.spring.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional
	public Category findId(Object id) {
		return categoryDao.findId(id);
	}

	@Override
	@Transactional
	public Category findBy(String key, Object val) {
		return categoryDao.findBy(key, val);
	}

	@Override
	@Transactional
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	@Transactional
	public boolean insert(Category page) {
		return categoryDao.insert(page);
	}

	@Override
	@Transactional
	public boolean update(Category page) {
		return categoryDao.update(page); 
	}

	@Override
	@Transactional
	public boolean delete(Category page) {
		return categoryDao.delete(page);
	}

	@Override
	@Transactional
	public List<Category> search(String keyword) {
		return categoryDao.search(keyword);
	}

}
