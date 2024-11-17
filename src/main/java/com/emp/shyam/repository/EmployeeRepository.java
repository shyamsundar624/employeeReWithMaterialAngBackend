package com.emp.shyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.shyam.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
