package com.example.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mybatis.domain.Student;
import com.example.mybatis.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

//	전체 학생 목록 가져오기	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "list";
	}

//	새로운 학생 정보 등록	
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}

//	새로운 학생정보 저장
	@PostMapping
	public String create(@ModelAttribute Student student) {
		studentService.createStudent(student);
		return "redirect:/students";
	}

//	수정 form
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "form";
	}

//	수정 처리
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}

//	삭제 처리
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

}
//http://localhost:8090/students/3/edit
//http://localhost:8090/students/3/delete
//http://localhost:8090/students/new