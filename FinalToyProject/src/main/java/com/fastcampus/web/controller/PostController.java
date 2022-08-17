package com.fastcampus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fastcampus.biz.domain.Post;
import com.fastcampus.biz.persistence.PostRepository;
import com.fastcampus.biz.service.BlogService;
import com.fastcampus.biz.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("insertPost/{id}")
	public String insertPost(@PathVariable Long id , Model model) {
		model.addAttribute("blog", blogService.getBlog(id));
		return "post/insertPost";
	}
	
	@GetMapping("/getPost/{postId}")
	public String getPost(@PathVariable Long postId,Model model) {
		model.addAttribute("post",postService.getPost(postId));
		return "post/getPost";
	}
	
	
	@PostMapping("/insertPost")
	public String insertPost(Post post, Long blogId, String categoryName, Model model) {
		postService.insertPost(post, blogId, categoryName);
		model.addAttribute("blog", blogService.getBlog(blogId));

		return "/blog/blogMain";
	}
	
	@PostMapping("/updatePost")
	public String updatePost(Post post, Model model, Long blogId) {
		
		postService.updatePost(post);
		model.addAttribute("blog", blogService.getBlog(blogId));
		return "/blog/blogMain";
		
	}
	
	@GetMapping("/deletePost/{postId}")
	public String deletePost(@PathVariable Long postId, Model model) {
		model.addAttribute("blog", postService.deletePost(postId));
		return "/blog/blogMain";
	}
	
}
