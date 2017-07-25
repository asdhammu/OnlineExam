package edu.UTDallas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/student")
@Controller
public class StudentController {
	
	
	public String takeQuiz(String quizId){
		
		
		return "quiz";
	}
	
		
}
