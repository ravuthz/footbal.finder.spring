package com.learn.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.spring.entities.Post;
import com.learn.spring.service.ICategoryService;
import com.learn.spring.service.IPostService;

@Controller
public class PostController {
	
	@Autowired
	private IPostService postDao;
	
	@Autowired
	private ICategoryService categoryDao;
	
	@GetMapping({"posts", "posts/index"})
	public String index(Model model) {
		model.addAttribute("pageTitle", "List Post");
		model.addAttribute("posts", postDao.findAll());
		return "posts/index";
	}
	 
	@GetMapping("posts/new")
	public String getCreate(Model model) {
		model.addAttribute("pageTitle", "Create");
		model.addAttribute("categories", categoryDao.findAll());
		return "posts/create";
	}
	
	@GetMapping("posts/edit/{id}")
	public String getUpdate(Model model, @PathVariable ("id") int id ) {
		model.addAttribute("pageTitle", "Update");
		model.addAttribute("post", postDao.findId(id));
		model.addAttribute("categories", categoryDao.findAll());
		return "posts/update";
	}
	
	@GetMapping("posts/show/{id}")
	public String getDetail(Model model, @PathVariable("id") int id) {
		model.addAttribute("post", postDao.findId(id));
		return "posts/detail";
	}
	
	@PostMapping("/posts/create")
	public String postCreate(Post post) {
		postDao.insert(post);
		return "redirect:/posts";
	}
	
	@PostMapping("/posts/update")
	public String postUpdate(Post post) {
		postDao.update(post);
		return "redirect:/posts";
	}
	
	@PostMapping("/posts/delete/{id}")
	public String postDelete(@PathVariable("id") int id) {
		Post post = postDao.findId(id);
		postDao.delete(post);
		return "redirect:/posts";
	}
	
	@GetMapping(value = "posts/search")
	public String doSearch(Model model, @RequestParam(value = "key", required = false) String key) {
		model.addAttribute("pageTitle", "Search Posts");
		model.addAttribute("posts", postDao.search(key));
		return "posts/index";
	}
}
