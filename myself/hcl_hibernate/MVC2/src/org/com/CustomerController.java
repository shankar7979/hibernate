package org.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@RequestMapping("/go")
	public String disp(){
		System.out.println("go control called");
		return "hello";
	}	
}
