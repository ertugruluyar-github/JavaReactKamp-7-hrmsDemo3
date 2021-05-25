package com.kodlamaio.hrmsDemo3.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrmsDemo3.business.abstracts.JobSeekerService;
import com.kodlamaio.hrmsDemo3.core.adapters.abstracts.JobSeekerValidationService;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessResult;
import com.kodlamaio.hrmsDemo3.core.validators.emailRegex.abstracts.JobSeekerEmailRegexValidatorService;
import com.kodlamaio.hrmsDemo3.core.validators.emailVerify.abstracts.JobSeekerEmailVerifyService;
import com.kodlamaio.hrmsDemo3.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrmsDemo3.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private JobSeekerEmailRegexValidatorService jobSeekerEmailRegexValidatorService;
	private JobSeekerValidationService jobSeekerValidationService;
	private JobSeekerEmailVerifyService jobSeekerEmailVerifyService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,
			JobSeekerEmailRegexValidatorService jobSeekerEmailRegexValidatorService,
			JobSeekerValidationService jobSeekerValidationService, 
			JobSeekerEmailVerifyService jobSeekerEmailVerifyService) {
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerEmailRegexValidatorService = jobSeekerEmailRegexValidatorService;
		this.jobSeekerValidationService = jobSeekerValidationService;
		this.jobSeekerEmailVerifyService = jobSeekerEmailVerifyService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>("Ürünler başarıyla listelendi.",
				this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> get(int id) {
		if (this.jobSeekerDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<JobSeeker>(
					"Belirtilen iş arayan başarıyla bulundu.",
					this.jobSeekerDao.findById(id).get());
		} else {
			return new ErrorDataResult<JobSeeker>("Belirtilen iş arayan mevcut değildir.");
		}
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (this.hasEmptyField(jobSeeker)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		} else if (!this.jobSeekerValidationService.isRealPerson(jobSeeker)) {
			return new ErrorResult("Sahte iş arayan!");
		} else if (this.existsJobSeekerByNationalityId(jobSeeker.getNationalityId())) {
			return new ErrorResult("Bu kimlik numaralı bir iş arayan mevcuttur.");
		} else if (!this.jobSeekerEmailRegexValidatorService.isValidEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Email geçerli değil!");
		} else if (this.existsJobSeekerByEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Bu email'e sahip bir iş arayan mevcuttur.");
		} else if (!this.jobSeekerEmailVerifyService.hasVerifyEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Email doğrulanmadı!");
		} else {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("iş arayan başarıyla kaydedildi.");
		}
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("iş arayan başarıyla silindi.");
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("iş arayan başarıyla güncellendi.");
	}

	@Override
	public boolean existsJobSeekerByNationalityId(String nationalityId) {
		return this.jobSeekerDao.existsJobSeekerByNationalityId(nationalityId);
	}

	@Override
	public boolean existsJobSeekerByEmail(String email) {
		return this.jobSeekerDao.existsJobSeekerByEmail(email);
	}

	@Override
	public boolean hasEmptyField(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() 
				|| jobSeeker.getDateOfBirth().toString().isEmpty() || jobSeeker.getEmail().isEmpty() 
				|| jobSeeker.getNationalityId().isEmpty() || jobSeeker.getPassword().isEmpty() 
				|| jobSeeker.getGender().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
