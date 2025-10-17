package com.example.extemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//controller는 return ""에 html파일명을 넣는다.
@Controller
public class MyThymeleaf {
	
	@GetMapping("/hellooo")
	public String hello() {
		return "hellooo";
	} // html 파일명 리턴
	
	@GetMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("message", "스프링부트 타임리프 화면");
		return "hello_thymeleaf";
	} // html 파일명 리턴
	
	@GetMapping("/mustache")
	public String mustache(Model model) {
		model.addAttribute("message", "머스테치 화면");
		return "hello_mu";
	} 
}
