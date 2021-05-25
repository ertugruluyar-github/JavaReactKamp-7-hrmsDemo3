package com.kodlamaio.hrmsDemo3.core.utilities.result.concretes;

public class SuccessResult extends Result {
	
	public SuccessResult() {
		super(true);
	}
	
	public SuccessResult(String infoMessage) {
		super(true, infoMessage);
	}
	
}
