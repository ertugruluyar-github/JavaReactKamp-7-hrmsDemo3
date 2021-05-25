package com.kodlamaio.hrmsDemo3.core.validators.emailVerify.abstracts;

public abstract class EmployerEmailVerifyService implements EmailVerifyService {

	@Override // default verify
	public boolean hasVerifyEmail(String email) {
		return true;
	}

}
