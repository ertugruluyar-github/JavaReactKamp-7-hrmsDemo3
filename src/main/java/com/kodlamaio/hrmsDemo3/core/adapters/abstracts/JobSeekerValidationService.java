package com.kodlamaio.hrmsDemo3.core.adapters.abstracts;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrmsDemo3.entities.concretes.JobSeeker;

@Service
public interface JobSeekerValidationService {
	boolean isRealPerson(JobSeeker jobSeeker);
}
