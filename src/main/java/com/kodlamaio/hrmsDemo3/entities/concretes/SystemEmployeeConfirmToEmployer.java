package com.kodlamaio.hrmsDemo3.entities.concretes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kodlamaio.hrmsDemo3.entities.abstracts.SystemEmployeeConfirm;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name="system_employee_confirms_to_employer")
public class SystemEmployeeConfirmToEmployer extends SystemEmployeeConfirm {
	
	@OneToOne//Unidirectional
	private Employer employer;
	
	public SystemEmployeeConfirmToEmployer(boolean isConfirm, Date dateOfConfirm) {
		super(isConfirm, dateOfConfirm);
	}
	
}