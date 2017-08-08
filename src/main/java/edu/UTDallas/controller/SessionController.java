package edu.UTDallas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author asdha
 *
 */

@Controller
public class SessionController {
	
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
	
	@RequestMapping(value="403",method= RequestMethod.GET)
	public String accessDenied(Model model){
		model.addAttribute("message", "Your are not authorised");
		return "403";
	}
	
	@RequestMapping(value="/404",method=RequestMethod.GET)
	public String pageNotFound(Model model){
		model.addAttribute("message", "Page not found");
		return "404";
	}
	
	
	
	
}
