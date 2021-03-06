package com.learn.spring.service;

import java.util.List;
import com.learn.spring.entities.Category;

public interface ICategoryService {
	public Category findId(Object id);
	public Category findBy(String key, Object val);
	public List<Category> findAll();
	public boolean insert(Category page);
	public boolean update(Category page);
	public boolean delete(Category page);
	public List<Category> search(String keyword);
}
