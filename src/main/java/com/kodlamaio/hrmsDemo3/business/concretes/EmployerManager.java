package com.kodlamaio.hrmsDemo3.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrmsDemo3.business.abstracts.EmployerService;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessResult;
import com.kodlamaio.hrmsDemo3.core.validators.emailRegex.abstracts.EmployerEmailRegexValidatorService;
import com.kodlamaio.hrmsDemo3.core.validators.emailVerify.abstracts.EmployerEmailVerifyService;
import com.kodlamaio.hrmsDemo3.core.validators.systemEmployeeVerify.abstracts.EmployerSystemEmployeeVerifyService;
import com.kodlamaio.hrmsDemo3.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrmsDemo3.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerEmailRegexValidatorService employerEmailRegexValidatorService;
	private EmployerEmailVerifyService employerEmailVerifyService;
	private EmployerSystemEmployeeVerifyService employerSystemEmployeeVerifyService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,
			EmployerEmailRegexValidatorService employerEmailRegexValidatorService, 
			EmployerEmailVerifyService employerEmailVerifyService, 
			EmployerSystemEmployeeVerifyService employerSystemEmployeeVerifyService) {
		this.employerDao = employerDao;
		this.employerEmailRegexValidatorService = employerEmailRegexValidatorService;
		this.employerEmailVerifyService = employerEmailVerifyService;
		this.employerSystemEmployeeVerifyService = employerSystemEmployeeVerifyService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>("İşverenler başarıyla listelendi.", this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> get(int id) {
		if (this.employerDao.findById(id).orElse(null) != null) {
			return new SuccessDataResult<Employer>("Belirtilen iş pozisyonu başarıyla bulundu.",
					this.employerDao.findById(id).get());
		} else {
			return new ErrorDataResult<Employer>("Belirtilen iş pozisyonu mevcut değildir.");
		}
	}

	@Override
	public Result add(Employer employer) {
		if (this.hasEmptyField(employer)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		} else if (!this.employerEmailRegexValidatorService.isValidEmail(employer.getEmail(),
				employer.getWebSite())) {
			return new ErrorResult("Email, web site ile aynı domain'e sahip olmalıdır.");
		} else if (this.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("Bu email'e sahip bir işveren kaydı mevcuttur.");
		} else if (!this.employerEmailVerifyService.hasVerifyEmail(employer.getEmail())) {
			return new ErrorResult("Email doğrulanmadı!");
		} else if (!this.employerSystemEmployeeVerifyService.hasVerifyBySystemEmployee(employer)) {
			return new ErrorResult("Sistem tarafından doğrulanmadı!");
		} else {
			this.employerDao.save(employer);
			return new SuccessResult("İşveren başarıyla kaydedildi.");
		}
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("İşveren başarıyla silindi.");
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İşveren başarıyla güncellendi.");
	}

	@Override
	public boolean existsEmployerByEmail(String email) {
		return this.employerDao.existsEmployerByEmail(email);
	}

	@Override
	public boolean hasEmptyField(Employer employer) {
		if (employer.getCompanyName().isEmpty() || employer.getWebSite().isEmpty()
				|| employer.getEmail().isEmpty() || employer.getPassword().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
