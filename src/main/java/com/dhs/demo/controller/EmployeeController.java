package com.dhs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhs.demo.model.Employee;
import com.dhs.demo.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/createNewEmployee")
	public Employee createNewEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/getAllEmployesList")
	public List<Employee> getAllEmployesList(){
		return employeeService.getAllEmployesList();
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee Employee){
		return employeeService.updateEmployee(Employee);
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable String id){
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/test")
	public String test(){
		return "Sucess";
	}
}
