package com.example.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.controller.ExController;

@Service
public class ExService {

	private static final Logger log = LoggerFactory.getLogger(ExService.class);
	
	public String sayHello(String hi) {
		String msg = hi + " 루트";
		log.info(msg);
		log.debug(msg);
		return msg;
	}

	public String ex70() {
		
		String result = "";
		int num = 2;
		
		if(num == 1) {
			result = "if 블록입니다.";
			log.info(result);
		} else if (num == 2) {
			result = "else if 블록입니다.";
			log.info(result);
		} else {
			result = "else 블록입니다.";
			log.info(result);
		}
		
		String msg = "ex70 결과는: " + result; 
		return msg;
	}

	public Integer ex72() {
		
		int[] array = {1, 2, 3, 4, 5};
		int result = 0;
		
		for(int i=0; i < array.length; i++) {
			log.info("array[{}] = {}" ,i ,array[i]);
			result += array[i];
		}
		
		log.info("ex72 합계는: { " + result + " }");
		return result;
	}

	public String[] ex73() {
		int[] array = { 1, 2, 3, 4, 5 };
		int i = 0;
		String[] logMessages = new String[array.length];
		
		while(i < array.length) {
			logMessages[i] = String.format("array[%d] = %d", i,  array[i]);
			log.info(logMessages[i]);
			i++;
		}
		
		return logMessages;
	}
	
	public interface Car { public String GetColor(String color); }
	
	public class Sonata implements Car {
		String color;
		
		@Override
		public String GetColor(String color) {
			this.color = color;
			String result = "소나타의 색상은: " + color;
			return result;
		}
	}
	
	public class K5 implements Car {
		String color;

		@Override
		public String GetColor(String color) {
			this.color = color;
			String result = "K5의 색상은: " + color;
			return result;
		}
	}
	
	public String ex75() {
		
		Car car1 = new Sonata();
		String re1 = car1.GetColor("블랙");
		log.info(re1);
		
		Car car2 = new K5();
		String re2 = car2.GetColor("화이트");
		log.info(re2);
		
		String result = re1 + "<br>" + re2 + "<br>" +"차량 두 대 출고완료";
		log.info(result);
		return result;
	}
	
	public List<Integer> ex76() {
		List<Integer> list = new ArrayList<>();
				
		list.add(1);
		list.add(2);
		list.add(3);
		
		log.info("리스트 전체: {}", list);
		
		return list;
	}

	public Map<String, String> ex77() {
		Map<String, String> list = new LinkedHashMap<>();
		list.put("첫 번째 값", "public");
		list.put("두 번째 값","static");
		list.put("세 번째 값", "void");
		
		for(Map.Entry<String, String> entry : list.entrySet() ) {
			log.info(entry.getKey() + " - " + entry.getValue());
		}
		
		List<String> values = new ArrayList<>(list.values());
		
		int idx = values.indexOf("void");
		log.info("void의 인덱스: " + idx);
		
		return list;
	}

	public String ex79() {
		String str1 = new String("is same?");
		String str2 = new String("is same?");
		
		log.info("== 결과: {}", (str1 == str2));
		log.info("equlas 결과: {}", (str1.equals(str2)));
		
		String result = "== 결과: " + (str1 == str2) + "<br>" + "equlas 결과: " + (str1.equals(str2));
		
		return result;
	}

	public List<String> ex85() {
		List<String> list = new ArrayList<>();
		
		list.add("void");
		list.add("static");
		list.add("public");
		
		// 익명 클래스 코드
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});
		log.info("재정렬된 코드: "+list);
		
		list.sort((Comparator<String>) (str1, str2) -> 
		str1.compareTo(str2));
		log.info("람다식으로 재정렬된 코드: "+list);
		
		return list;
	}

	

	
	
	
}
