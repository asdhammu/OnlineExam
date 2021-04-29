package edu.utdallas.util;

import edu.utdallas.entity.User;
import net.openhft.compiler.CompilerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class OnlineExamUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OnlineExamUtil.class);
	
	private static final String headerContent ="package mypackage;\n public class MyClass{\n";
								
	private static final String endContent ="}\n";
	
	public static String compileCode(String codeValue, User user, String input) {
		return compileCode(codeValue,input);
	}
	
	
	private static String compileCode(String code,String input){
		
		String className = "mypackage.MyClass";
		String javaCode = headerContent + code + endContent;
		
        final StringWriter writer = new StringWriter();
		
        try{
        	/*CompilerUtils.CACHED_COMPILER.loadFromJava(
        			classLoader, "edu.UTDallas.Util.MyInterface", "package edu.UTDallas.Util;"  + 	
		                  "public interface MyInterface {\n" +
	        				"public String getName(String name);"+
		                  "}",
	        new PrintWriter(writer));*/
        	Class class1 = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);

        	Runnable runner = (Runnable) class1.newInstance();
            Method method = class1.getMethods()[0];
	        
	        String s = (String) method.invoke(class1.newInstance(), new Object[] {input});
	        if(writer.toString().equalsIgnoreCase("")){
	        	return s;
	        }
        }catch(Exception e){
        	LOGGER.error("Error occurred ", e);
        }

		return writer.toString();
        
        	        
	}	
}
