package com.example.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis.domain.Student;
import com.example.mybatis.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

	private final StudentMapper studentMapper;
	
//	public List<Student> getAllStudent() {
//		List<Student> students = new ArrayList<>();
//		students.add(new Student() {{setId(1L); setName("홍길동");}});
//		students.add(new Student() {{setId(2L); setName("이몽룡");}});
//		students.add(new Student() {{setId(3L); setName("성춘향");}});
//		return students;
//	}

	public List<Student> getAllStudent() {
		return studentMapper.findAll();
	}

	public Student getStudent(Long id) {
		return studentMapper.findById(id);
	}

//	create
	@Transactional
	public void createStudent(Student student) {
		studentMapper.insert(student);
	}

// 	update
	@Transactional
	public void updateStudent(Student student) {
		studentMapper.update(student);
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentMapper.delete(id);
	}
	
}
