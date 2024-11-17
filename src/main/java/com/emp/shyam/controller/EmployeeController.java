package com.emp.shyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.emp.shyam.entity.Employee;
import com.emp.shyam.service.EmployeeService;

@CrossOrigin(maxAge = 3360)
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/api/v1/employees")
	public ResponseEntity<List<Employee>> fetchAllEmployees() {
		return ResponseEntity.ok(employeeService.fetchAllEmployees());
	}

	@PostMapping("/api/v1/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}
	
	@PutMapping("/api/v1/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}
	
	@DeleteMapping("/api/v1/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}
	
	
}
