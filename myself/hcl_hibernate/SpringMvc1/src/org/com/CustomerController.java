package org.com;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	ModelAndView modelAndView;

	CustomerValidation customerValidation;
	
	@Autowired
	public CustomerController(CustomerValidation customerValidation) {
	this.customerValidation=customerValidation;
	}
	
	@RequestMapping(value = "cst_control_1", method = RequestMethod.GET)
	public ModelAndView cust_control1() {

		Customer customer = new Customer();
		customer.setId(1000);
		customer.setName("sumanth sarma");
		customer.setAge(22);
		customer.setCity("karnool");

		modelAndView = new ModelAndView("CustomerForm", "cst", customer);

		return modelAndView;
	}

	@RequestMapping(value = "cst_control_1", method = RequestMethod.POST)
	public ModelAndView cust_control2
	(@ModelAttribute("cst") Customer cst, Errors errors) {
		
		customerValidation.validate(cst, errors);
		
		if(errors.hasErrors()){
		modelAndView = new ModelAndView("CustomerForm");
		}
		else
		modelAndView = new ModelAndView("CustomerSuccess");
		
		return modelAndView;
	}

	@ModelAttribute(value = "state_name")
	public List<String> stateData() {

		List<String> state_list = new ArrayList<String>();
		state_list.add("None");
		state_list.add("Andhara Pardesh");
		state_list.add("Karnataka");
		state_list.add("Kerala");
		state_list.add("TamilNadu");

		state_list.add("Maharashtra");
		return state_list;
	}
	
	@ModelAttribute(value = "hobby_name")
	public List<String> hobbyData() {

		List<String> hobby_list = new ArrayList<String>();
		hobby_list.add("Novel Reading");
		hobby_list.add("Listening Music");
		hobby_list.add("Horror Movie");
		hobby_list.add("Swimming");
		hobby_list.add("Touring");
		
		return hobby_list;
	}
	
	
	@ModelAttribute(value = "gender_name")
	public List<String> genderData() {

		List<String> gender_list = new ArrayList<String>();
   
		gender_list.add("male");
		gender_list.add("female");
		
		return gender_list;
	}
	

}
