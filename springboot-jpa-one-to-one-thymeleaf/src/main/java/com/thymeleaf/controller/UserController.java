package com.thymeleaf.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import com.thymeleaf.entity.Users;
import com.thymeleaf.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserValidator validator;

	Users u = new Users();

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", u);
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

		Map<Integer, String> pageForms = new HashMap<Integer, String>();
		pageForms.put(0, "user/user");
		pageForms.put(1, "user/user-address");

		if (userClickedCancel(request)) {
			status.setComplete();
			return "redirect:/";
		} else if (userIsFinished(request)) {
			if (result.hasErrors()) {
				return pageForms.get(currentPage);
			} else {
				u.setName(user.getName());
				u.setEmail(user.getEmail());
				u.setPassword(user.getPassword());
				u.setAddress(user.getAddress());
				return "redirect:/";
			}
		} else {
			int targetPage = getTargetPage(request, "_target", currentPage);
			if (userClickedPrevious(currentPage, targetPage)) {
				return pageForms.get(targetPage);
			} else {
				switch (currentPage) {
				case 0:
					validator.validate(user, result);
					break;
				}
				if (result.hasErrors()) {
					return pageForms.get(currentPage);
				} else {
					return pageForms.get(targetPage);
				}
			}
		}
	}

	public static int getTargetPage(ServletRequest request, String paramPrefix, int currentPage) {
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if (paramName.startsWith(paramPrefix)) {
				for (int i = 0; i < WebUtils.SUBMIT_IMAGE_SUFFIXES.length; i++) {
					String suffix = WebUtils.SUBMIT_IMAGE_SUFFIXES[i];
					if (paramName.endsWith(suffix)) {
						paramName = paramName.substring(0, paramName.length() - suffix.length());
					}
				}
				return Integer.parseInt(paramName.substring(paramPrefix.length()));
			}
		}
		return currentPage;
	}

	private boolean userClickedPrevious(int currentPage, int targetPage) {
		return targetPage < currentPage;
	}

	private boolean userIsFinished(HttpServletRequest request) {
		return request.getParameter("_finish") != null;
	}

	private boolean userClickedCancel(HttpServletRequest request) {
		return request.getParameter("_cancel") != null;
	}

}
