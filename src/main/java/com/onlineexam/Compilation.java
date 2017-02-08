package com.onlineexam;

import java.util.List;

public class Compilation {
	boolean compilationResult;
	List<String> errors;

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public boolean isCompilationResult() {
		return compilationResult;
	}

	public void setCompilationResult(boolean compilationResult) {
		this.compilationResult = compilationResult;
	}


	
}
