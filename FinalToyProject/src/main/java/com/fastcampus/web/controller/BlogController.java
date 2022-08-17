package com.fastcampus.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Post;
import com.fastcampus.biz.domain.User;
import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.CategoryService;
import com.fastcampus.biz.service.PostService;
import com.fastcampus.biz.service.UserService;
import com.fastcampus.security.jpa.UserDetailsImpl;

@Controller
public class BlogController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/insertBlog") 
	public String insertBlog() {
		return "blog/insertBlog";
	}
	
	@PostMapping("/insertBlog")
	public String insertBlog(Blog blog, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		User principal = userDetailsImpl.getUser();
		blog.setUser(principal);
		blogService.insertBlog(blog, principal);
		userDetailsImpl.setUser(userService.updateUser(principal));
		
		return "redirect:/";
	}
	
	
	@GetMapping("/getBlog/{blogId}")
	public String getBlog(@PathVariable Long blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));	
		return "blog/blogMain";
	}
	
	
	
	@GetMapping("/manageBlog/{blogId}")
	public String manageBlog(@PathVariable Long blogId, Model model) {
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "blog/getBlog";
	}
	
	
	
	@PostMapping("/updateBlog/{blogId}")
	public String updateblog(@PathVariable Long blogId, Model model, Blog blog) {
		
		blogService.updateBlog(blogId, blog);
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "blog/blogMain";
	
	}
	
	@GetMapping("/deleteBlog")
	public String deleteBlog() {
		return "blog/deleteRequest";
	}
	
	@GetMapping("/changeBlogStatus/{blogId}")
	public String changeBlogStatus(@PathVariable Long blogId) {
		blogService.changeBlogStatus(blogId);
		return "redirect:/auth/logout";
	}
	
	@GetMapping("/deleteBlog/{blogId}")
	public String deleteBlog(@PathVariable Long blogId, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		blogService.deleteBlog(blogId);
		User principal = userDetailsImpl.getUser();
		userDetailsImpl.setUser(userService.updateUser(principal));	
		return "redirect:/";
	}
	
	@PostMapping("/blog/search") 
	public String search(String keyword, Model model, @PageableDefault(page=0, size=5, sort="blogId", direction=Direction.DESC) Pageable pageable) {
		List<Blog> searchList = blogService.search(keyword);
		
		model.addAttribute("searchList", searchList);
		return "welcome";
	}
}
