package com.kodlamaio.hrmsDemo3.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlamaio.hrmsDemo3.entities.concretes.SystemEmployee;

@Repository
public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {
	boolean existsSystemEmployeeByNationalityId(String nationalityId);
	boolean existsSystemEmployeeByEmail(String email);
}
