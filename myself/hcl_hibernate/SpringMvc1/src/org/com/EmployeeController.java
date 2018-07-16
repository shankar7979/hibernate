package org.com;

import org.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/emp_control1", method = RequestMethod.GET)
	public String disp1() {
		return "Emp_Form";
	}

	ModelAndView modelAndView;

	@RequestMapping(value = "/emp_control1", method = RequestMethod.POST)
	public ModelAndView disp2(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("salary") float salary, Model model)

	{
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);

		//model.addAttribute("emp", employee);

		//modelAndView=new ModelAndView("Emp_Suceess");
modelAndView=new ModelAndView("Emp_Suceess","emp",employee);
		return modelAndView;
		
		//return "Emp_Suceess";
	}

}
