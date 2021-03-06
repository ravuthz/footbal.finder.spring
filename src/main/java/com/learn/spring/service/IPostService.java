package com.learn.spring.service;

import java.util.List;
import com.learn.spring.entities.Post;

public interface IPostService {
	public Post findId(Object id);
	public Post findBy(String key, Object val);
	public List<Post> findAll();
	public boolean insert(Post post);
	public boolean update(Post post);
	public boolean delete(Post post);
	public List<Post> search(String keyword);
}
