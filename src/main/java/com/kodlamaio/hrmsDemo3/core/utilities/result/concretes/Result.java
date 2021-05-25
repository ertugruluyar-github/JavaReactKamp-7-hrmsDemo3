/**
 * 
 */
package com.kodlamaio.hrmsDemo3.core.utilities.result.concretes;

import lombok.NoArgsConstructor;

/**
 * @author Ertuğrul Uyar
 * @LinkedIn www.linkedin.com/in/ertugruluyar
 * @GitHub https://github.com/euyar42
 */
@NoArgsConstructor
public class Result {
	private boolean isSuccess;
	private String infoMessage;
	
	
	public Result(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public Result(boolean isSuccess, String infoMessage) {
		this(isSuccess);
		this.infoMessage = infoMessage;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getInfoMessage() {
		return infoMessage;
	}
	
}
