package edu.UTDallas.controller;

import java.util.logging.Logger;

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
import edu.UTDallas.Util.Roles;
import edu.UTDallas.entity.Role;
import edu.UTDallas.entity.User;
import edu.UTDallas.service.SecurityService;
import edu.UTDallas.service.UserService;
import edu.UTDallas.validator.UserValidator;
import javassist.bytecode.stackmap.TypeData.ClassName;

/**
 * Created by asdha on 5/25/2017.
 */
@Controller
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
	
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		
	    String redirectURL = "welcome";
	    
	    
	    User user = userService.findByUsername(name);
	    if(user!=null){
	    	for(Role r : user.getRoles()){
		    	if(r.getRole().equals(Roles.ROLE_ADMIN.toString())){
		    		redirectURL = "admin";
		    		break;
		    	}else if (r.getRole().equals(Roles.ROLE_TEACHER.toString())){
		    		redirectURL = "teacher";		    		
		    	}else{
		    		redirectURL = "student";
		    	}
		    }
	    }
	    
	    
		model.addAttribute("welcome", "Welcome to Online Exam portal");
		return redirectURL;
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
		
		LOGGER.info("CODE is: " + compileCode + " Input is :" + input);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		
	    User user = userService.findByUsername(name);
	    
	    model.addAttribute("result",OnlineExamUtil.compileCode(compileCode, user,input));
		
		return "compileResult";
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
