package com.learn.spring.models;

public class Post {

	private int Id;
	private String title;
	private String content;
	private String summary;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Post [Id=" + Id + ", title=" + title + ", content=" + content + ", summary=" + summary + "]";
	}
}
