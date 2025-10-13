package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ExService;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
	
}
