package edu.utdallas.controller;

import java.util.Collection;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import edu.utdallas.dto.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.utdallas.util.OnlineExamUtil;
import edu.utdallas.entity.User;
import edu.utdallas.service.SecurityService;
import edu.utdallas.service.UserService;
import javassist.bytecode.stackmap.TypeData.ClassName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by asdha on 5/25/2017.
 */
@Controller
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("pageTitle", "Login");
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		String errorMessage = null;
		if (session != null) {
			AuthenticationException ex = (AuthenticationException) session
					.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if (ex != null) {
				errorMessage = ex.getMessage();
			}
		}
		model.addAttribute("errorMessage", errorMessage);
		return "login";
	}

	@GetMapping(value = { "/", "/index", "welcome" })
	public String welcome(Model model) {
		
	    if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken){
	    	return "redirect:/login";
	    }

	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String redirectURL;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		model.addAttribute("pageTitle", "Home");
		model.addAttribute("username", username);

		Set<String> authorities = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());

		if(authorities.contains(UserRole.ADMIN.toString())){
			redirectURL = "admin";
		}else if(authorities.contains(UserRole.TEACHER.toString())){
			redirectURL = "teacher";
		}else{
			redirectURL = "student";
		}
		model.addAttribute("welcome", "Welcome to Online Exam portal");
		return redirectURL;
	}

	@PostMapping(value="/compile")
	public String compile(@RequestParam("compileCode") String compileCode, @RequestParam("input") String input, Model model){
		
		LOGGER.info("CODE is: " + compileCode + " Input is :" + input);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		
	    User user = userService.findByUsername(name);
	    
	    model.addAttribute("result",OnlineExamUtil.compileCode(compileCode, user,input));
		
		return "compileResult";
	}

}
