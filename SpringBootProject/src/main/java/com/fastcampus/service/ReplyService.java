package com.fastcampus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.domain.User;
import com.fastcampus.persistence.PostRepository;
import com.fastcampus.persistence.ReplyRepository;
import com.fastcampus.persistence.UserRepository;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void writeReply(Reply reply, Integer UserId) {
		Post post = postRepository.findById(reply.getId()).get();
		User user = userRepository.findById(UserId).get();
		
		Reply myreply = new Reply();
			
		myreply.setContent(reply.getContent());
		
		post.addReply(myreply);
		user.addReply(myreply);
		
		replyRepository.save(myreply);
	
	}
	
	
	@Transactional 
	public void deleteReply(int id) {
		replyRepository.deleteById(id);
	}
}
