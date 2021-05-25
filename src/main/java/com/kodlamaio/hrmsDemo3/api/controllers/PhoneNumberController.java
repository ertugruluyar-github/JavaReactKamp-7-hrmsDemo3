package com.kodlamaio.hrmsDemo3.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrmsDemo3.business.abstracts.PhoneNumberService;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.entities.concretes.PhoneNumber;

@RestController
@RequestMapping("/api/phonenumbers")
public class PhoneNumberController {
private PhoneNumberService phoneNumberService;
	
	@Autowired
	public PhoneNumberController(PhoneNumberService employerService) {
		this.phoneNumberService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<PhoneNumber>> getAll() {
		return this.phoneNumberService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody PhoneNumber phoneNumber) {
		return this.phoneNumberService.add(phoneNumber);
	}
	
}
