package com.kodlamaio.hrmsDemo3.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrmsDemo3.business.abstracts.SystemEmployeeService;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo3.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo3.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/systememployes")
public class SystemEmployeeController {
	
	private SystemEmployeeService systemEmployeeService;
	
	@Autowired
	public SystemEmployeeController(SystemEmployeeService systemEmployeeService) {
		this.systemEmployeeService = systemEmployeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemEmployee>> getAll() {
		return this.systemEmployeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployee systemEmployee) {
		return this.systemEmployeeService.add(systemEmployee);
	}
	
}
