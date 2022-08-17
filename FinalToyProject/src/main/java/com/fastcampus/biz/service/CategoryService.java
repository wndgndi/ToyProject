package com.fastcampus.biz.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Category;
import com.fastcampus.biz.persistence.BlogRepository;
import com.fastcampus.biz.persistence.CategoryRepoistory;

@Service
public class CategoryService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private CategoryRepoistory categoryRepoistory;

	
	@Transactional
	public Page<Category> getCategoryList(Pageable pageable) {
		return categoryRepoistory.findAll(pageable);
	}
	
	
	@Transactional
	public Category getCategory(Long CategoryId) {
		Category findCategory = categoryRepoistory.findById(CategoryId).get();
		return findCategory;
	}
	
	
	@Transactional
	public void insertCategory(Category category, Long blogId) {
		Blog findBlog = blogRepository.findById(blogId).get();
		category.setBlog(findBlog);
		categoryRepoistory.save(category);
	}
	
	@Transactional
	public Category getUpdateCategory(Long categoryId) {
		Category findCategory = categoryRepoistory.findById(categoryId).get();
		return findCategory;
	}
		
	@Transactional
	public Category updateCategory(Long categoryId,String categoryName, String displayType, String description) {
		Category updateCategory = categoryRepoistory.findById(categoryId).get();
		updateCategory.setCategoryName(categoryName);
		updateCategory.setDescription(description);
		updateCategory.setDisplayType(displayType);
		categoryRepoistory.save(updateCategory);
		
		return updateCategory;
	}
	
	@Transactional
	public void deleteCategory(Long categoryId) {
		categoryRepoistory.deleteById(categoryId);
	}
}
