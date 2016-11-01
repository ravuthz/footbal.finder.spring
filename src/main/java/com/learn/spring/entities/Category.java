package com.learn.spring.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.learn.spring.entities.Post;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_id")
	@SequenceGenerator(name = "category_seq_id", sequenceName = "category_seq_id")
	private int id;
	private String title;
	private String content;
	
	@OneToMany(mappedBy = "category")
	private List<Post> posts = new ArrayList<Post>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
