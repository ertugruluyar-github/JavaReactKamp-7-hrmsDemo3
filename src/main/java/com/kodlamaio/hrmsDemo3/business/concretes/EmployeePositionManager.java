package com.kodlamaio.hrmsDemo3.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrmsDemo3.business.abstracts.EmployeePositionService;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.ErrorResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessDataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.SuccessResult;
import com.kodlamaio.hrmsDemo3.dataAccess.abstracts.EmployeePositionDao;
import com.kodlamaio.hrmsDemo3.entities.concretes.EmployeePosition;

@Service
public class EmployeePositionManager implements EmployeePositionService {
	
	private EmployeePositionDao employeePositionDao;
	
	@Autowired
	public EmployeePositionManager(EmployeePositionDao employeePositionDao) {
		this.employeePositionDao = employeePositionDao;
	}

	@Override
	public DataResult<List<EmployeePosition>> getAll() {
		return new SuccessDataResult<List<EmployeePosition>>("Ürünler başarıyla listelendi.",
				this.employeePositionDao.findAll());
	}

	@Override
	public DataResult<EmployeePosition> get(int id) {
		if (this.employeePositionDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<EmployeePosition>(
					"Belirtilen iş pozisyonu başarıyla bulundu.",
					this.employeePositionDao.findById(id).get());
		} else {
			return new ErrorDataResult<EmployeePosition>("Belirtilen iş pozisyonu mevcut değildir.");
		}
	}

	@Override
	public Result add(EmployeePosition employeePosition) {
		if (this.employeePositionDao.existsEmployeePositionByPositionName(employeePosition.getPositionName())) {
			return new ErrorResult("Bu isimde bir iş pozisyonu vardır.");
		} else {
			this.employeePositionDao.save(employeePosition);
			return new SuccessResult("İş pozisyonu başarıyla eklendi.");
		}
		
	}

	@Override
	public Result delete(int id) {
		this.employeePositionDao.deleteById(id);
		return new SuccessResult("İş pozisyonu başarıyla silindi.");
	}

	@Override
	public Result update(EmployeePosition employeePosition) {
		this.employeePositionDao.save(employeePosition);
		return new SuccessResult("İş pozisyonu başarıyla güncellendi.");
	}

	@Override
	public boolean existsEmployeePositionByPositionName(String positionName) {
		return this.employeePositionDao.existsEmployeePositionByPositionName(positionName);
	}

}
