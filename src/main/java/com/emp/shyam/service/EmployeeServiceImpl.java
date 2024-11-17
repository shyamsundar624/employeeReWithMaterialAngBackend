package com.emp.shyam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.shyam.entity.Employee;
import com.emp.shyam.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee empObj = employeeRepository.findById(employee.getId()).get();
		if (empObj != null) {
			empObj.setEmail(employee.getEmail());
			empObj.setName(employee.getName());
			empObj.setSalary(employee.getSalary());
		}

		return employeeRepository.save(empObj);
	}

	@Override
	public String deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee emp = employeeRepository.findById(id).get();
		String msg=null;
		if(emp!=null) {
			employeeRepository.delete(emp);
			msg="Employee Deleted Successfully for Id "+id;
		}
		return msg;
	}

}
