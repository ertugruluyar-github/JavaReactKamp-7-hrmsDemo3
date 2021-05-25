package com.kodlamaio.hrmsDemo3.core.utilities.result.concretes;

public class ErrorResult extends Result {
	
	public ErrorResult() {
		super(false);
	}
	
	public ErrorResult(String infoMessage) {
		super(false, infoMessage);
	}
	
}
