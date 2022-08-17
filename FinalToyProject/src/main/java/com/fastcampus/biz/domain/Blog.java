package com.fastcampus.biz.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =  false)
	private Long blogId;
	
	
	private String status;
	
	private String tag;
	
	private String title;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
	private List<Category> categoryList = new ArrayList<>();
	
	@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
	private List<Post> postList = new ArrayList<>();
	
	public void addUser(User user) {
		this.user = user;
		user.addBlog(this);
	}
	
	
	public void addCategory(Category category) {
		this.categoryList.add(category);
		if(category.getBlog() != this) {
			category.setBlog(this);
		}
	}
	
	public void addPost(Post post) {
		post.setBlog(this);
	}
}
