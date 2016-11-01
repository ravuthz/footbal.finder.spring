package com.learn.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.learn.spring.entities.Category;
import com.learn.spring.service.ICategoryService;

@Controller
public class CategoryController  {

	@Autowired
	private ICategoryService categoryDao;
	
	@GetMapping({"categories", "categories/index"})
	public String index(Model model) {
		model.addAttribute("pageTitle", "List Category");
		model.addAttribute("categories", categoryDao.findAll());
		return "categories/index";
	}
	
	@GetMapping("categories/new")
	public String getCreate(Model model) {
		model.addAttribute("pageTitle", "Create");
		return "categories/create";
	}
	
	@GetMapping("categories/edit/{id}")
	public String getUpdate(Model model, @PathVariable ("id") int id ) {
		model.addAttribute("pageTitle", "Update");
		model.addAttribute("page", categoryDao.findId(id));
		return "categories/update";
	}
	
	@GetMapping("categories/show/{id}")
	public String getDetail(Model model, @PathVariable("id") int id) {
		model.addAttribute("page", categoryDao.findId(id));
		return "categories/detail";
	}
	
	@PostMapping("/categories/create")
	public String pageCreate(Category page) {
		categoryDao.insert(page);
		return "redirect:/categories";
	}
	
	@PostMapping("/categories/update")
	public String pageUpdate(Category page) {
		categoryDao.update(page);
		return "redirect:/categories";
	}
	
	@PostMapping("/categories/delete/{id}")
	public String pageDelete(@PathVariable("id") int id) {
		Category page = categoryDao.findId(id);
		categoryDao.delete(page);
		return "redirect:/categories";
	}
	
	@GetMapping(value = "categories/search")
	public String doSearch(Model model, @RequestParam(value = "key", required = false) String key) {
		model.addAttribute("pageTitle", "Search Categories");
		model.addAttribute("categories", categoryDao.search(key));
		return "categories/index";
	}

}
