package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ExService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
public class ExController {

	private static final Logger log = LoggerFactory.getLogger(ExController.class);
	
	ExService exService;
	
	public ExController(ExService exService) {
		this.exService = exService;
	}
	
//	@GetMapping("/")
//	public String getMethodName() {
//		return new String("루트경로");
//	}
	
	@GetMapping("/")
	public String getMethodName() {
		return exService.sayHello("안녕");
	}

	@GetMapping("/ex70")
	public String ex70() {
		return exService.ex70();
	}
	
	@GetMapping("/ex72")
	public Integer ex72() {
		return exService.ex72();
	}
	
	@GetMapping("/ex73")
	public String[] ex73() {
		return exService.ex73();
	}
	
	@GetMapping("/ex75")
	public String ex75() {
		return exService.ex75();
	}
	
	@GetMapping("/ex76")
	public Object ex76() {
		return exService.ex76();
	}
	
	@GetMapping("/ex77")
	public Map<String, String> ex77() {
		return exService.ex77();
	}
	
	@GetMapping("/ex79")
	public String ex79() {
		return exService.ex79();
	}
	
	@GetMapping("/ex85")
	public List<String> ex85() {
		return exService.ex85();
	}
	
	@GetMapping("/ex88")
	public List<String> ex88() {
		return exService.ex88();
	}
	
	@GetMapping("/ex88_332")
	public List<String> ex88_332() {
		return exService.ex88_332();
	}
	
	@GetMapping("/ex89_333")
	public List<Integer> ex89_333() {
		return ExService.ex89_333();
	}
	
	@GetMapping("/ex90")
	public List<Integer> ex90() {
		return ExService.ex90();
	}
	

	@GetMapping("/ex91")
	public List<Integer> ex91() {
		return exService.ex91();
	}
	
	@GetMapping("/ex92")
	public List<Integer> ex92() {
		return exService.ex92();
	}
	
	@GetMapping("/ex93_337")
	public List<Integer> ex93_337() {
		return exService.ex93_337();
	}
	
	@GetMapping("/ex93_338")
	public List<String> ex93_338() {
		return exService.ex93_338();
	}
	
	@GetMapping("/ex94")
	public String ex94() {
		return exService.ex94();
	}
	
	@GetMapping("/ex95_3310")
	public String ex95_3310() {
		return exService.ex95_3310();
	}
	
	@GetMapping("/ex95_3311")
	public Optional<String> ex95_3311() {
		return exService.ex95_3311();
	}
	
	@GetMapping("/ex96_3312")
	public Optional<String> ex96_3312() {
		return exService.ex96_3312();
	}
	
	@GetMapping("/ex97")
	public Optional<String> ex97() {
		return exService.ex97();
	}
	
	@GetMapping("/ex98")
	public Optional<String> ex98() {
		return exService.ex98();
	}
	
	// 여기부터 5장
	@RequestMapping("/ex159")
	public String ex159() {
		return exService.ex159();
	}
	
	@RequestMapping("/ex161")
	public String ex161_1() {
		return exService.ex161();
	}
	
	// Ambiguous mapping
//	@RequestMapping("/ex161")
//	public String ex161_2() {
//		return "동일 경로 호출";
//	}
	
	@RequestMapping("/ex163")
	public String ex163() {
		return exService.ex163();
	}
	
	@GetMapping("/testImage")
	public String getImage() {
		return "/images/Francesco Ungaro.avif";
	}
	
	// p. 207 - 208
	@RequestMapping("/html/article")
	public String ex207(@RequestParam("title") String title,
						@RequestParam("content") String content) {
		return String.format("title=%s / content=%s", title, content);
	}
}
