package com.example.getpost.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.getpost.dto.ArticleRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
public class MyForm {

	// http://localhost:8080/html/article-get?title=제목&content=내용
	@GetMapping("/html/article-get")
	public String articleGet(@RequestParam String title, 
							@RequestParam String content) {
		String result = "제목: " + title + "\n" + "<br>내용: " + content;
		return result;
	}
	
	@PostMapping("/html/article-post")
	public String articlePost(@ModelAttribute ArticleRequest request) { 
		// 파라미터가 객체 타입이면 @ModelAttribute 생략 후 자동 적용.
		String result = "제목: " + request.title() + "\n" + "<br>내용: " + request.content();
		return result;
	}
	
	@PostMapping("/html/article-postman")
	public String articlePostman(@RequestBody ArticleRequest request) {
		String result = "제목: " + request.title() + "\n" + "<br>내용: " + request.content();
		return result;
	}
	
	@PostMapping("/html/article-auto")
	public String articleAuto(ArticleRequest request) {
		// @ModelAttribute ArticleRequest request와 같음. 
		// 파라미터가 객체 타입이면 @ModelAttribute 생략 후 자동 적용됨.
		String result = "제목: " + request.title() + "\n" + "<br>내용: " + request.content();
		return result;
	}
	
	@RequestMapping("/html/no-parameter")
	public String noPparameter() {
		return "파라미터가 없는 GET 요청";
	}
	
}