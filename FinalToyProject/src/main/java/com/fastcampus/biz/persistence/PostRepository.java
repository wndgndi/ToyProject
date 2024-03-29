package com.fastcampus.biz.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.biz.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
