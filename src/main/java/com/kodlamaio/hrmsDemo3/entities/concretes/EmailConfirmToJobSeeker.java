package com.kodlamaio.hrmsDemo3.entities.concretes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kodlamaio.hrmsDemo3.entities.abstracts.EmailConfirm;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name="email_confirms_to_job_seeker")
public class EmailConfirmToJobSeeker extends EmailConfirm {
	
	@OneToOne//Unidirectional
	private JobSeeker jobSeeker;
	
	public EmailConfirmToJobSeeker(boolean isConfirm, Date dateOfConfirm) {
		super(isConfirm, dateOfConfirm);
	}
	
}