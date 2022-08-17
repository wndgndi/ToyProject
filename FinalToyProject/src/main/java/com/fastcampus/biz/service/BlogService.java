package com.fastcampus.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.domain.User;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.biz.persistence.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertBlog(Blog blog, User user) {
		
		User myuser = userRepository.findByUsername(user.getUsername()).get();
		
		blog.addUser(myuser);
		blog.addCategory(new Category());
		
		blog.setStatus("운영");
		blog.setTag("No tags");
		
		blogRepository.save(blog);
	}
	
	@Transactional
	public Page<Blog> getBlogList(Pageable pagealbe) {
		return blogRepository.findAll(pagealbe);
	}
	
	@Transactional
	public Blog getBlog(Long blogId) {
		return blogRepository.findById(blogId).get();
	}
	
	@Transactional
	public void updateBlog(Long blogId, Blog blog) {
		Blog findBlog = blogRepository.findById(blogId).get();
		
		findBlog.setTitle(blog.getTitle());
		findBlog.setTag(blog.getTag());
		blogRepository.save(findBlog);
	}
	
	
	@Transactional
	public void changeBlogStatus(Long blogId) {
		Blog findBlog = blogRepository.findById(blogId).get();
		findBlog.setStatus("삭제요청");
		blogRepository.save(findBlog);
	}
	
	@Transactional
	public void deleteBlog(Long blogId) {
		blogRepository.deleteById(blogId);
	}
	
	@Transactional
	public List<Blog> search(String keyword) {
		List<Blog> blogList = blogRepository.findByTitleContaining(keyword);
		return blogList;
	}
	
	 
}
