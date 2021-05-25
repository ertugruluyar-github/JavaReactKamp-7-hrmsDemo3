package com.kodlamaio.hrmsDemo3.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kodlamaio.hrmsDemo3.entities.abstracts.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Entity
@Table(name="employers")
public class Employer extends User {
	
	@Column(name="company_name", nullable = false)
	private String companyName;
	
	@Column(name="web_site", nullable = false)
	private String webSite;
	
	
	public Employer(Integer id, String email, String password, String companyName, String webSite) {
		super(id, email, password);
		this.companyName = companyName;
		this.webSite = webSite;
	}

	public Employer(String email, String password, String companyName, String webSite) {
		super(email, password);
		this.companyName = companyName;
		this.webSite = webSite;
	}
	
}
