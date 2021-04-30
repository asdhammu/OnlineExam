package edu.utdallas.controller;

import edu.utdallas.dto.User;
import edu.utdallas.service.SecurityService;
import edu.utdallas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("/")
@Controller
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	SecurityService securityService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("userForm") User userForm, Errors errors) {

		if (errors !=null && errors.getErrorCount() > 0) {
			return "registration";
		}

		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), userForm.getPassword());
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new edu.utdallas.dto.User());
		return "registration";
	}
}
