package com.kodlamaio.hrmsDemo3.business.abstracts;

import java.util.List;

import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.entities.concretes.SystemEmployee;

public interface SystemEmployeeService {
	DataResult<List<SystemEmployee>> getAll();
	DataResult<SystemEmployee> get(int id);
	Result add(SystemEmployee systemEmployee);
	Result delete(int id);
	Result update(SystemEmployee systemEmployee);
	Result existsSystemEmployeeByNationalityId(String nationalityId);
	Result existsSystemEmployeeByEmail(String email);
}
