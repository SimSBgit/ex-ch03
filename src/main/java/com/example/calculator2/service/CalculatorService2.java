package com.example.calculator2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService2 {

	public Double add(double doubleNum, int intNum) {
		double result = doubleNum + intNum;
		return result;
	}

	public Double subtract(double doubleNum, int intNum) {
		double result = doubleNum - intNum;
		return result;
	}

	public Double multiply(double doubleNum, int intNum) {
		double result = doubleNum * intNum;
		return result;
	}

	public Double divide(double doubleNum, int intNum) {
		if(intNum==0) {
			throw new ArithmeticException("0으로 나눌 수 없음");
		} else {
			double result = doubleNum / intNum;
			return result;
		}
	}

	public Double calculate(double num1, int num2, String operation) {

//		return switch (operation.toLowerCase())	{	
//		case "add" -> add(num1, num2);
//		case "subtract" -> subtract(num1, num2);
//		case "multiply" -> multiply(num1, num2);
//		case "divide" -> divide(num1, num2);
//		default -> throw new IllegalArgumentException("적합한 연산자가 없음: " + operation.toLowerCase());
//		};
		
		return switch (operation.toLowerCase())	{	
		case "+" -> add(num1, num2);
		case "-" -> subtract(num1, num2);
		case "*" -> multiply(num1, num2);
		case "/" -> divide(num1, num2);
		default -> throw new IllegalArgumentException("적합한 연산자가 없음.");
		};
	}
	
}
