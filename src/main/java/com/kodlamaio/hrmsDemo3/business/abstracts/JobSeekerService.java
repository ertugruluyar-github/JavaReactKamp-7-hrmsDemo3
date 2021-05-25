package com.kodlamaio.hrmsDemo3.business.abstracts;

import java.util.List;

import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> get(int id);
	Result add(JobSeeker jobSeeker);
	Result delete(int id);
	Result update(JobSeeker jobSeeker);
	boolean existsJobSeekerByNationalityId(String nationalityId);
	boolean existsJobSeekerByEmail(String email);
	boolean hasEmptyField(JobSeeker jobSeeker);
}
