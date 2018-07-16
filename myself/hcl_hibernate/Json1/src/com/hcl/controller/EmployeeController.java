package com.hcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "go", method = RequestMethod.POST)
	public @ResponseBody
	Employee getEmployee(@ModelAttribute("emp") Employee emp) {
		System.out.println("control2 called............");
		return emp;
	}

	ModelAndView modelAndView;

	@RequestMapping(value = "go", method = RequestMethod.GET)
	public ModelAndView getEmployee1() {
		System.out.println("control1 called............");
		modelAndView = new ModelAndView("EmpForm", "emp", new Employee());
		return modelAndView;
	}

	
	/*@RequestMapping(value = "go", method = RequestMethod.GET)
	public String getEmployee1() {
		System.out.println("control1 called............");
		//model.addAttribute("emp", new Employee());
		return "EmpForm1";
	}*/

	
}
