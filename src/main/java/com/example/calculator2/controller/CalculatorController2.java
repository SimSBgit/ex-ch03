package com.example.calculator2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator2.dto.CalculationRequest;
import com.example.calculator2.dto.CalculationResponse;
import com.example.calculator2.service.CalculatorService2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("calculator2")
public class CalculatorController2 {
	
//	1. springboot autowired 방식
//	@Autowired
//	CalculatorService calculatorService;
	
//	2. springboot 생성자를 통한 객체주입 방식
	CalculatorService2 calculatorService2;
	
	public CalculatorController2 (CalculatorService2 calculatorService2) {
		this.calculatorService2 = calculatorService2;
	}
	
//	@GetMapping("/add")
//	public String add() {
//		return new String("덧셈");
//	}
	
//	@GetMapping("/add")
//	public Double add() {
//		return (10.0 + 5);
//	}
	
	// 사용자가 입력한 값을 받아서, 서비스 로직으로 연산한 결과를 리턴
	@GetMapping("/add")
	public Double add(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		return calculatorService2.add(doubleNum, intNum);
	}
	
	@GetMapping("/subtract")
	public Double subtract(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		return calculatorService2.subtract(doubleNum, intNum);
	}
	
	@GetMapping("/multiply")
	public Double multiply(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		return calculatorService2.multiply(doubleNum, intNum);
	}

	@GetMapping("/divide")
	public Double divide(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		return calculatorService2.divide(doubleNum, intNum);
	}
	
	// -------------------------------------------
	
	// 1. 서비스 로직으로 연산결과를 얻음. 
	// 2. 결과를 출력할 포맷을 dto(record타입)를 사용.
	// 3. 리턴타입을 dto(record타입)으로 수정. 
	// -> 객체를 리턴해서 json으로 확인.
	// 4. 브라우저 : http://localhost:8090/calculator/divide2?doubleNum=10&intNum=5
	@GetMapping("/add2")
	public CalculationResponse add2(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		double resullt = calculatorService2.add(doubleNum, intNum);
		return new CalculationResponse(doubleNum, intNum, "ADD2", resullt);
	}
	
	@GetMapping("/subtract2")
	public CalculationResponse subtract2(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		double resullt = calculatorService2.subtract(doubleNum, intNum);
		return new CalculationResponse(doubleNum, intNum, "SUBTRACT2", resullt);
	}
	
	@GetMapping("/multiply2")
	public CalculationResponse multiply2(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		double result = calculatorService2.multiply(doubleNum, intNum);
		return new CalculationResponse(doubleNum, intNum, "MULTIPLY2", result);
	}

	@GetMapping("/divide2")
	public CalculationResponse divide2(@RequestParam("doubleNum") double doubleNum, @RequestParam("intNum") int intNum) {
		double result = calculatorService2.divide(doubleNum, intNum);
		return new CalculationResponse(doubleNum, intNum, "DIVIDE2", result);
	}
	
	// --------------------------------------------------
	
	// post - RequestBody
	// ENDpoint테스트: http://localhost:8090/calculator/calculate
	
//	{
//    "num1": 100.0,
//    "num2": 50,
//    "operation": "*"    
//}
	
	// 단계별 예제
	
	// 예제1
	@PostMapping("/calculate")
	public String calculate(@RequestBody String entity) {
		return entity;
	}
	
	// 예제2
	// 테스트: http://localhost:8090/calculator/calculate1
	@PostMapping("/calculate1")
	public CalculationResponse calculate1(@RequestBody CalculationRequest request) {
		Double result = calculatorService2.add(request.getNum1(), request.getNum2());
		return new CalculationResponse(request.getNum1(), request.getNum2(), request.getOperation(), result);
	}
	
	// 예제3
	// 테스트: http://localhost:8090/calculator/calculate2
	@PostMapping("/calculate2")
	public CalculationResponse calculate2(@RequestBody CalculationRequest request) {
		
		Double result = calculatorService2.calculate(request.getNum1(), request.getNum2(), request.getOperation());
		return new CalculationResponse(request.getNum1(), request.getNum2(), request.getOperation(), result);
	}
}

