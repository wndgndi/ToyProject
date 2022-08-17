package com.fastcampus.biz.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Category;

@Repository
public interface CategoryRepoistory extends JpaRepository<Category, Long>{
	Optional<Category> findByCategoryNameAndBlog(String categoryName,Blog blog);
}
