package com.kodlamaio.hrmsDemo3.core.validators.systemEmployeeVerify.abstracts;

import com.kodlamaio.hrmsDemo3.entities.concretes.Employer;

public interface SystemEmployeeVerifyService {
	boolean hasVerifyBySystemEmployee(Employer employer);
}
