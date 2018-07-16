package com.hcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.model.Employee;


@Controller
public class EmployeeController {

	@RequestMapping(value="go")
	public @ResponseBody Employee getEmployee(){
		Employee employee=new Employee();
		employee.setId(1001);
		employee.setName("ram kumar");
		employee.setSalary(12000);
		return employee;
	}
	
}
