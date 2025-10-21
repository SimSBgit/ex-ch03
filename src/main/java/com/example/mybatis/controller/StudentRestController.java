package com.example.mybatis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.domain.Student;
import com.example.mybatis.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

// 	의존성 주입 방법1
//	@Autowired
//	private final StudentService studentservice;
	
//	의존성 주입 방법2
//	private final StudentService studentservice;
//	public StudentRestController(StudentService studentService) {
//		this.studentservice = StudentService;
//	}
	
//	의존성 주입 방법3 : 롬복 사용	
	private final StudentService studentservice;
	
//	전체 조회: http://localhost:8080/api/students
	@GetMapping
	public List<Student> list() {
		return studentservice.getAllStudent();
	}
	
//	단건 조회: http://localhost:8080/api/students/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Student> detail(@PathVariable Long id) {
		Student student = studentservice.getStudent(id);
		if(student == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(student);
	}
	
//	등록 post
	@PostMapping
	public ResponseEntity<Student> create(@RequestBody Student student) {
		studentservice.createStudent(student);
		return ResponseEntity.ok(student);
	}
	
//	수정 put / patch
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		student.setId(id);
		studentservice.updateStudent(student);
		return ResponseEntity.ok(student);
	}
	
//	삭제 delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		studentservice.deleteStudent(id);
		return ResponseEntity.ok().build();
	}
	
}
