package com.fastcampus.biz.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="BLOG_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long userId;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String role;

	@Column(nullable = false)
	private String name;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Blog blog;
	
	public void addBlog(Blog blog) {
		this.blog = blog;
	}
	
}
