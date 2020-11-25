package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.TodoService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	private final TodoService todoService;
	
	public IndexController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping	// 경로가 /고 HTTP 메서드가 GET인 경우
	public String index() {
		todoService.test();
		return "index";	// view name
	}
	
	@GetMapping("/new-page")
	public String newPage() {
		return "abc";
	}

	@GetMapping("/user-info")
	public ModelAndView userInfo() {
		final ModelAndView mv = new ModelAndView();
		// 뷰 네임 설정
		mv.setViewName("userView");
		// 모델 설정
		mv.addObject("name", "원치호");
		mv.addObject("email", "high.neoul@gmail.com");
		return mv;
	}
}
