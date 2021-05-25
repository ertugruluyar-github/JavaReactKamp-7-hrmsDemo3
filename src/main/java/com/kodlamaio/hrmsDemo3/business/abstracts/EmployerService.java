package com.kodlamaio.hrmsDemo3.business.abstracts;

import java.util.List;

import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<Employer> get(int id);
	Result add(Employer employer);
	Result delete(int id);
	Result update(Employer employer);
	boolean existsEmployerByEmail(String email);
	boolean hasEmptyField(Employer employer);
}
