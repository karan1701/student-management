package com.example.studentmanagement.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentmanagement.department.Department;
import com.example.studentmanagement.department.DepartmentRepository;
import com.example.studentmanagement.department.DepartmentService;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	DepartmentService depService;

	@Autowired
	DepartmentRepository depRepo;

	public Student getStudentDetails(Long id) {
		return studentRepo.findById(id).get();
	}

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Student addStudent(Student student) {
		Department department = new Department();
		department.setName("CS" + Math.random());
		//department = depRepo.save(department);
		try {
			depService.addDepartment(department);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setDepartment(department);
		return studentRepo.save(student);
	}

}
