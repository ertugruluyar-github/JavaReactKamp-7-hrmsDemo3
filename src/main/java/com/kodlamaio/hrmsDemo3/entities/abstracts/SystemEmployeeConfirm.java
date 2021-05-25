package com.kodlamaio.hrmsDemo3.entities.abstracts;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="system_employee_confirms")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SystemEmployeeConfirm extends Confirm {
	
	@Column(name="is_confirm", nullable = false)
	private boolean isConfirm;
	
	@Column(name="date_of_confirm")
	private Date dateOfConfirm;
	
}