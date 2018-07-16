package com.hcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/control1")
	public String disp(){
		System.out.println(" control111.......... called");
		return "hello";
	}
	
}
