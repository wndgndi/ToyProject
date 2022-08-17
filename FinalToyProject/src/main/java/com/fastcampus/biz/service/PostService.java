package com.fastcampus.biz.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.domain.Post;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.biz.persistence.CategoryRepoistory;
import com.fastcampus.biz.persistence.PostRepository;

@Service	
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private CategoryRepoistory categoryRepoistory;
	
	@Transactional
	public void insertPost(Post post, Long blogId, String categoryName) {
		Blog myblog = blogRepository.findById(blogId).get();
		Category mycategory = categoryRepoistory.findByCategoryNameAndBlog(categoryName,myblog).get();
		
		Post mypost = new Post();
		mypost.setTitle(post.getTitle());
		mypost.setContent(post.getContent());
		myblog.addPost(mypost);
		mycategory.addPost(mypost);
		
		postRepository.save(mypost);
	}
	
	@Transactional
	public Post getPost(Long postId) {
		return postRepository.findById(postId).get();
	}
	
	@Transactional
	public void updatePost(Post post) {
		Post findPost = postRepository.findById(post.getPostId()).get();
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
		postRepository.save(findPost);
	}
	
	@Transactional
	public Blog deletePost(Long postId) {
		Post findpost = postRepository.findById(postId).get();
		postRepository.deleteById(postId);
		
		return findpost.getBlog();
	}
}
