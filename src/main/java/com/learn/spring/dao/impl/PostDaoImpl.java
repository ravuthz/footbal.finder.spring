package com.learn.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learn.spring.dao.PostDao;
import com.learn.spring.models.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Post findId(Object id) {
		String sql = "SELECT * FROM posts WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setSummary(rs.getString("summary"));
				return post;
			}
		}, new Object[]{id});
	}
	
	@Override
	public Post findBy(String key, Object val) {
		String sql = "SELECT * FROM posts ORDER BY " + key + " DESC";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setSummary(rs.getString("summary"));
				return post;
			}
		}, new Object[]{val});
	}
		
	@Override
	public List<Post> findAll() {
		String sql = "SELECT * FROM posts ORDER BY id DESC";
		List<Post> posts = new ArrayList<Post>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for (Map<String, Object> row : rows) {
			Post post = new Post();
			post.setId((int) row.get("id"));
			post.setTitle((String) row.get("title"));
			post.setContent((String) row.get("content"));
			post.setSummary((String) row.get("summary"));
			posts.add(post);
		}
		
		return posts;
	}
	
	@Override
	public List<Post> search(String keyword) {
		String key = "%" + keyword + "%";
		String sql = "SELECT * FROM posts WHERE title LIKE ? OR content LIKE ? OR summary LIKE ?";
		return jdbcTemplate.query(sql, new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setSummary(rs.getString("summary"));
				return post;
			}
		}, new Object[]{key, key, key});
	}
	
	@Override
	public boolean insert(Post post) {
		String sql = "INSERT INTO posts (title, content, summary) VALUES (?, ?, ?)";
		int i = jdbcTemplate.update(sql, new Object[] {post.getTitle(), post.getContent(), post.getSummary()});
		return (i > 0);
	}

	@Override
	public boolean update(Post post) {
		String sql = "UPDATE posts SET title = ?, content = ?, summary = ? WHERE id = ?";
		int i = jdbcTemplate.update(sql, new Object[] {post.getTitle(), post.getContent(), post.getSummary(), post.getId()});
		return (i > 0);
	}

	@Override
	public boolean delete(Post post) {
		String sql = "DELETE FROM posts WHERE id = ?";
		int i = jdbcTemplate.update(sql, new Object[] {post.getId()});
		return (i > 0);
	}

}
