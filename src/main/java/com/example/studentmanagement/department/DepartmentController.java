package com.example.studentmanagement.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.POST)
	public void addDepartment(@RequestBody Department department) throws Exception {
		departmentService.addDepartment(department);
		;
	}

}
