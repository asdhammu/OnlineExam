package edu.UTDallas.Util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

import edu.UTDallas.entity.User;
import javassist.bytecode.stackmap.TypeData.ClassName;
import net.openhft.compiler.CompilerUtils;

public class OnlineExamUtil {
	
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
	
	private static final String headerContent =
						"package edu.UTDallas.Util;"  + 	
		                  "public class MyClass{\n";
								
	private static final String endContent = "}\n";
	
	public static String compileCode(String codeValue, User user, String input) {

		LOGGER.info("Code Value" + codeValue);
			
		
		return compileCode(codeValue,input);

	}
	
	
	private static String compileCode(String code,String input){
		String className = "edu.UTDallas.Util.MyClass";
		String javaCode = headerContent + code + endContent;
		                  		
		//CompilerUtils.addClassPath("/onlineexam/src/main/java/edu/UTDallas/Util");
		
        final StringWriter writer = new StringWriter();
        MyClass class1 = null;
        //MyInterface interface1 = null;
        ClassLoader classLoader = new ClassLoader() {
		};
        try{
        	/*CompilerUtils.CACHED_COMPILER.loadFromJava("edu.UTDallas.Util.MyInterface", "package edu.UTDallas.Util;"
        					+ "public interface MyInterface { public String getName(String name); }");*/
	        CompilerUtils.CACHED_COMPILER.loadFromJava(
	        		classLoader, className, javaCode,
	        new PrintWriter(writer)).newInstance();
	        class1 = new MyClass();
        }catch(Exception e){
        	System.out.println(e);
        }
        
        if(writer.toString().equalsIgnoreCase(""))
        	return class1.getName(input);
            //return class1.getName(input);
        else{
        	System.out.println(writer.toString());
        	return writer.toString();
        }
        	        
	}	
}
