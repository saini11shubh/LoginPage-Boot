package com.practice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entity.LoginData;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openForm(Model model) {
		model.addAttribute("login",new LoginData());
		return "form";
	}
	
	//handler for process form
	//Valid annotation check h validation if data is valid then store a data in BindingResult interface object
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData")LoginData loginData,BindingResult result) {
		
		if(result.hasErrors()) {      //if result is blank then we get Error		
			System.out.println(result);
			return "form2";
		}
		System.out.print(loginData);
		return "success"; 
	}
}
