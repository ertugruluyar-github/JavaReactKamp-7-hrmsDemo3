package com.kodlamaio.hrmsDemo3.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="phone_numbers")
public class PhoneNumber {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="country_code", nullable = false)
	private String countryCode;
	
	@Column(name="phone_number", nullable = false)
	private String phoneNumber;
	
	@ManyToOne// özellik adı(employer) ile  Employer nesnesinin id özelliğini alt çizgi ile birleştirip
			 // employer_id adında bir column ekleyecek phone_numbers tablosuna.
	// @JoinColumn(name = "e_id") tablpya eklenecek column un adını değiştirir.
	@JsonIgnore//Json verisinde göstermemesi için.
	private Employer employer;
	
	
	public PhoneNumber(Integer id, String countryCode, String phoneNumber) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumber(String countryCode, String phoneNumber) {
		super();
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
	}
	
}
