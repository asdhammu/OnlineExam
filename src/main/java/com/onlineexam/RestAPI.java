package com.onlineexam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {

	@RequestMapping(value={"/user", "/"}, method=RequestMethod.GET)
	public ResponseEntity<String> getString(){
		
		return new ResponseEntity<String>("Hello REST",HttpStatus.OK);
		
	}
	
	
}
