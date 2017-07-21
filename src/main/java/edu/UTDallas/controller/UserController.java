package edu.UTDallas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.UTDallas.Util.OnlineExamUtil;
import edu.UTDallas.entity.User;
import edu.UTDallas.service.SecurityService;
import edu.UTDallas.service.UserService;
import edu.UTDallas.validator.UserValidator;

/**
 * Created by asdha on 5/25/2017.
 */
@Controller
public class UserController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/", "/index", "welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("welcome", "Welcome to Online Exam portal");
		return "welcome";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		//securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/index";
	}
	
	@RequestMapping(value="/compile",method=RequestMethod.POST)
	public String compile(@RequestParam("compileCode") String compileCode, @RequestParam("input") String input, Model model){
		System.out.println("data" + compileCode);
		System.out.println("input" + input);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		
	    User user = userService.findByUsername(name);
	    
	    model.addAttribute("result",OnlineExamUtil.compileCode(compileCode, user,input));
		
		return "compileResult";
	}
	
	@RequestMapping(value="sessionExpired",method= RequestMethod.GET)
	public String sessionExpired(Model model){
		model.addAttribute("message", "Your session has expired");
		return "sessionExpired";
	}

	@RequestMapping(value="invalidSession",method= RequestMethod.GET)
	public String invalidSession(Model model){
		model.addAttribute("message", "Invalid Session");
		return "invalidSession";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	public UserValidator getUserValidator() {
		return userValidator;
	}

	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

}
