package com.fastcampus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/getCategoryList/{blogId}")
	public String getCategory(@PathVariable Long blogId, Model model, @PageableDefault(size=5, sort="categoryId", direction = Direction.DESC)Pageable pageable) {
		model.addAttribute("categoryList", categoryService.getCategoryList(pageable));
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "category/getCategoryList";
	}
	
	
	@PostMapping("/insertCategory/{blogId}")
	public String insertCategory(Category category, @PathVariable Long blogId) {
		categoryService.insertCategory(category, blogId);
		
		System.out.println(blogId);
		return "redirect:/getCategoryList/{blogId}";
		
	}

	
	@GetMapping("/updateCategory/{blogId}/{categoryId}")
	public String getUpdateCategory(Model model, @PathVariable Long blogId, @PathVariable Long categoryId) {
		categoryService.getUpdateCategory(categoryId);
		model.addAttribute("category", categoryService.getUpdateCategory(categoryId));
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "category/updateCategoryList";
	}
	
	@PostMapping("/updateCategory/{blogId}")
	public String updateCategory(@PathVariable Long blogId, Long categoryId, Model model, String categoryName, String displayType, String description) {
		categoryService.updateCategory(categoryId, categoryName, displayType, description);
		model.addAttribute("category", categoryService.updateCategory(categoryId, categoryName, displayType, description));

		return "redirect:/getCategoryList/{blogId}";
	}
	
	
	@GetMapping("/deleteCategory/{blogId}/{categoryId}")
	public String deleteCategory(@PathVariable Long categoryId, @PathVariable Long blogId) {
		categoryService.deleteCategory(categoryId);

		return "redirect:/getCategoryList/{blogId}";
	}
	
	
}
