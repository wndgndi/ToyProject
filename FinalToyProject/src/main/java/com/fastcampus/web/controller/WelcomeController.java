package com.fastcampus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fastcampus.biz.service.BlogService;

@Controller
public class WelcomeController {
	
	@Autowired
	private BlogService blogService;
	

	@GetMapping({"","/"})
	public String getBlogList(Model model, @PageableDefault(size = 5, sort= "blogId", direction=Direction.DESC)Pageable pageable) {
		model.addAttribute("blogList", blogService.getBlogList(pageable));
		return "welcome";
	}

}
