package com.example.studentmanagement.student;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") Long id) {
		return studentService.getStudentDetails(id);
	}

	@GetMapping
	public List<Student> getAllStudent() {
		List<Student> students = studentService.getAllStudents();
		if (students != null && students.size() > 0) {
			return studentService.getAllStudents();
		}
		return Collections.emptyList();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		try {
			return studentService.addStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;

	}

}
