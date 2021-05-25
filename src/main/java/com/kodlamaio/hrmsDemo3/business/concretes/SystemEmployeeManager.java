package com.kodlamaio.hrmsDemo3.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrmsDemo3.business.abstracts.SystemEmployeeService;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessResult;
import com.kodlamaio.hrmsDemo3.dataAccess.abstracts.SystemEmployeeDao;
import com.kodlamaio.hrmsDemo3.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {
	
	private SystemEmployeeDao systemEmployeeDao;
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
		this.systemEmployeeDao = systemEmployeeDao;
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>("Sistem çalışanı başarıyla listelendi.",
				this.systemEmployeeDao.findAll());
	}

	@Override
	public DataResult<SystemEmployee> get(int id) {
		if (this.systemEmployeeDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<SystemEmployee>(
					"Belirtilen sistem çalışanı başarıyla bulundu.",
					this.systemEmployeeDao.findById(id).get());
		} else {
			return new ErrorDataResult<SystemEmployee>("Belirtilen sistem çalışanı mevcut değildir.");
		}
	}

	@Override
	public Result add(SystemEmployee employeePosition) {
		this.systemEmployeeDao.save(employeePosition);
		return new SuccessResult("Sistem çalışanı başarıyla eklendi.");
	}

	@Override
	public Result delete(int id) {
		this.systemEmployeeDao.deleteById(id);
		return new SuccessResult("Sistem çalışanı başarıyla silindi.");
	}

	@Override
	public Result update(SystemEmployee employeePosition) {
		this.systemEmployeeDao.save(employeePosition);
		return new SuccessResult("Sistem çalışanı başarıyla güncellendi.");
	}

	@Override
	public Result existsSystemEmployeeByNationalityId(String nationalityId) {
		if (this.systemEmployeeDao.existsSystemEmployeeByNationalityId(nationalityId)) {
			return new SuccessResult("Bu kimlik numarasına sahip bir sistem çalışanı vardır: " + nationalityId);
		} else {
			return new ErrorResult("Bu kimlik numarasına sahip bir sistem çalışanı vardır."+ nationalityId);
		}
	}

	@Override
	public Result existsSystemEmployeeByEmail(String email) {
		if (this.systemEmployeeDao.existsSystemEmployeeByEmail(email)) {
			return new SuccessResult("Bu email'e sahip bir sistem çalışanı vardır: " + email);
		} else {
			return new ErrorResult("Bu email'e sahip bir sistem çalışanı vardır."+ email);
		}
	}

}
