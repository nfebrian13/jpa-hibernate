package com.thymeleaf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.thymeleaf.entity.Users;

@Controller
public class UserController {
	
	Users u = new Users();

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user",u);
		return "user/index";
	}

	@RequestMapping(value = "user")
	public String user(Model model) {
		model.addAttribute("user", new Users());
		return "user/user";
	}

	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") Users user, BindingResult result, SessionStatus status,
			@RequestParam("_page") int currentPage, Model model) {
		
		System.out.println("user " + user);

		u.setName(user.getName());
		u.setEmail(user.getEmail());

		return "redirect:/";
	}
}
