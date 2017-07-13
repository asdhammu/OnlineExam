package com.onlineexam;

import java.io.IOException;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;


public class JavaSourceFromString extends SimpleJavaFileObject{

	private String code;
	
	JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),
              Kind.SOURCE);
        this.code = code;
    }
	
	
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		// TODO Auto-generated method stub
		return code;
	}
	
	

	
}
