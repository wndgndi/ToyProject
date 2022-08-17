package com.fastcampus.biz.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
//	@Column(nullable = false)
//	private Long blogId;
	
	private String categoryName;
	
	private String description;
	
	private String displayType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BLOG_ID")
	private Blog blog;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Post> postList = new ArrayList<>();
	
	
	public Category() {
		this.categoryName = "미분류";
		this.description = "기본으로 제공되는 카테고리입니다.";
		this.displayType = "제목 + 내용";
	}
	
	public void setBlog(Blog blog) {
		if(this.blog != null) {
			this.blog.getCategoryList().remove(this);
		}
		this.blog = blog;
	}
	
	public void addPost(Post post) {
		post.setCategory(this);
	}
}
