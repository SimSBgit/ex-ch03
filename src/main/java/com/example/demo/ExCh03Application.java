package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo", "com.example.calculator2" })
public class ExCh03Application {

	public static void main(String[] args) {
		SpringApplication.run(ExCh03Application.class, args);
	}

}
