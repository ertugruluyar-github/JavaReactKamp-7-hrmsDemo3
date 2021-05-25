package com.kodlamaio.hrmsDemo3.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kodlamaio.hrmsDemo3.entities.abstracts.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name="system_employees")
public class SystemEmployee extends User {
	
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(name="nationality_id", nullable = false, unique = true)
	private String nationalityId;
	
	@Column(name="date_of_birth", nullable = false)
	private Date dateOfBirth;
	
	@Column(name="gender", nullable = false)
	private String gender;
	

	public SystemEmployee(Integer id, String email, String password, String firstName, String lastName,
			String nationalityId, Date dateOfBirth, String gender) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public SystemEmployee(String email, String password, String firstName, String lastName, String nationalityId,
			Date dateOfBirth, String gender) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
}
