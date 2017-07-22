package edu.UTDallas.Util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.UTDallas.entity.User;
import javassist.bytecode.stackmap.TypeData.ClassName;
import net.openhft.compiler.CompilerUtils;

public class OnlineExamUtil {
	
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
	
	private static final String headerContent ="public class MyClass{\n";
								
	private static final String endContent ="}\n";
	
	public static String compileCode(String codeValue, User user, String input) {
		return compileCode(codeValue,input);
	}
	
	
	private static String compileCode(String code,String input){
		
		String className = "MyClass";
		String javaCode = headerContent + code + endContent;
		
        final StringWriter writer = new StringWriter();
             
        ClassLoader classLoader = new ClassLoader() {
		};
		
        try{
        	/*CompilerUtils.CACHED_COMPILER.loadFromJava(
        			classLoader, "edu.UTDallas.Util.MyInterface", "package edu.UTDallas.Util;"  + 	
		                  "public interface MyInterface {\n" +
	        				"public String getName(String name);"+
		                  "}",
	        new PrintWriter(writer));*/
        	Class<?> class1 = CompilerUtils.CACHED_COMPILER.loadFromJava(
	        		classLoader, className, javaCode,
	        new PrintWriter(writer));
        	
            Method method = class1.getMethods()[0];
	        
	        String s = (String) method.invoke(class1.newInstance(), new Object[] {input});
	        if(writer.toString().equalsIgnoreCase("")){
	        	return s;
	        }
        }catch(ClassNotFoundException e){
        	LOGGER.log(Level.SEVERE, e.getMessage());
        } catch (IllegalAccessException e) {
			writer.flush();
			writer.write(e.getMessage());
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (IllegalArgumentException e) {
			writer.flush();
			writer.write(e.getMessage());
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (InvocationTargetException e) {
			writer.flush();
			writer.write(e.getTargetException().toString());
			LOGGER.log(Level.SEVERE, e.getTargetException().toString());
		} catch (InstantiationException e) {
			writer.flush();
			writer.write(e.getMessage());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
        
        	
        return writer.toString();
        
        	        
	}	
}
