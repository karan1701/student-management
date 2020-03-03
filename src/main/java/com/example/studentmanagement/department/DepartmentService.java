package com.example.studentmanagement.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentmanagement.student.Student;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepo;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addDepartment(Department department) throws Exception {
		List<Student> students = new ArrayList<Student>();
		Student st = new Student();
		st.setName("Karan");
		st.setStandard("Second");
		st.setDepartment(department);
		students.add(st);
		department.setStudents(students);
		departmentRepo.save(department);
	}

	public void updateDepartment(Department department) throws Exception {

	}

}
