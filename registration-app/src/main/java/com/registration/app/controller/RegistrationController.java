package com.registration.app.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.registration.app.model.Member;
import com.registration.app.service.RegistrationService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	/** PRG (Post Redirect Get) Pattern **/
	@GetMapping("/form")
	public ModelMap formPageRegistrationView() {
		ModelMap nm = new ModelMap();
		nm.addAttribute("name", "Nana");
		nm.addAttribute("time", LocalDateTime.now());
		return nm;
	}

	@PostMapping("/form")
	public String formRegistrationProcess(@ModelAttribute @Valid Member m, BindingResult errors,
			SessionStatus status) {
		/**
		 * don't return html because not double submit ModelAndView mv = new
		 * ModelAndView("confirmation");
		 **/

		if (errors.hasErrors()) {
			return "form";
		}

		registrationService.registrationNewMember(m);
		status.setComplete();

		return "redirect:confirmation";
	}

	@GetMapping("/confirmation")
	public void formPageConfirmationView() {

	}

}
