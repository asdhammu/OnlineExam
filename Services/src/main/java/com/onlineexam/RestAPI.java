package com.onlineexam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={"http://localhost:3000","http://lowcost.bmjxmh3jyq.us-west-2.elasticbeanstalk.com"}, maxAge=3600)
@Controller
@RestController
public class RestAPI {

	@RequestMapping(value="/", method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<String> getString(){
				
		return new ResponseEntity<String>("Hello",HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/hero",method=RequestMethod.GET)
	public ResponseEntity<List<Hero>> getHeros(Model model){
		 	
			List<Hero> list = new ArrayList<Hero>();
			System.out.println("hello called");
			Hero hero = new Hero(1, "restCall");
			list.add(hero);
		    HttpHeaders headers = new HttpHeaders();
		   // headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
		    headers.add("Content-Type", "application/json; charset=UTF-8");
		    headers.add("X-Fsl-Location", "/");
		    headers.add("X-Fsl-Response-Code", "302");
		    return (new ResponseEntity<List<Hero>>(list, headers, HttpStatus.OK));
	}
	
	
	@RequestMapping(value="/compile", method=RequestMethod.POST)
	public ResponseEntity<Compilation> compileCode(@RequestBody Payload payload){
		
		System.out.println(System.getProperty("java.home"));
		Compilation compilation = new Compilation();
		HttpHeaders headers = new HttpHeaders();
		//System.setProperty("java.home", arg0);
		try {
						
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	        StandardJavaFileManager fileManager =   compiler.getStandardFileManager(null, null, null);
	        
	        DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
	        
	        List<JavaFileObject> compilations = Collections.<JavaFileObject>singletonList(new JavaSourceFromString("Solution", payload.getData()));
	        //List<File> sourceFileList = new ArrayList <File> ();
	       // sourceFileList.add(new File(fileName));
	        //Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles (sourceFileList);
	        CompilationTask task = compiler.getTask (null,fileManager, diagnosticsCollector , null, null, compilations);
	       
	        
	        List<Compilation> listOfCompilation = new ArrayList<Compilation>();
	        
	              
	        
	        if (task.call()) {	
	        	compilation.setCompilationResult(true);
	        	
	        } else {
	        	List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
	            List<String> list = new ArrayList<String>();
	        	for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics) {
	        		
	        		list.add(diagnostic.getMessage(null));
	                System.out.println(diagnostic.getMessage(null));
	            }
	        	compilation.setErrors(list);
	        	compilation.setCompilationResult(false);
	        }
	        listOfCompilation.add(compilation);
	        
	        fileManager.close ();
	        	        
		   // headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
		    headers.add("Content-Type", "application/json; charset=UTF-8");
		    headers.add("X-Fsl-Location", "/");
		    headers.add("X-Fsl-Response-Code", "302");	
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        return new ResponseEntity<Compilation>(compilation, headers, HttpStatus.OK);
		
		
		
	}
	
	
}

