package com.fastcampus.biz.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.Category;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{
//	Optional<Blog> findByCategory(Category category);
	List<Blog> findByTitleContaining(String Keyword);	
}
