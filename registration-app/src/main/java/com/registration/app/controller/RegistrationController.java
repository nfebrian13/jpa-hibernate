package com.registration.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class RegistrationController {

	/** PRG (Post Redirect Get) Pattern **/
	
	@GetMapping("/registration")
	public ModelMap formPageRegistrationView() {
		ModelMap nm = new ModelMap();
		nm.addAttribute("name", "Nana");
		nm.addAttribute("time", LocalDateTime.now());
		return nm;
	}

	@PostMapping("/registration")
	public String formRegistrationProcess() {
		/** don't return html because not double submit 
		ModelAndView mv = new ModelAndView("confirmation"); **/
		
		return "redirect:confirmation";
	}

	@GetMapping("/confirmation")
	public void formPageConfirmationView() {

	}

}
