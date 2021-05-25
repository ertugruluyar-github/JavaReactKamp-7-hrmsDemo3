package com.kodlamaio.hrmsDemo3.core.validators.emailRegex.abstracts;

public abstract class EmployerEmailRegexValidatorService implements EmailRegexValidatorService {
	// email, web site ile aynı domain'e sahip mi? Regex doğrulaması
	public boolean isValidEmail(String email, String webSite) {
		return true;
	}
}
