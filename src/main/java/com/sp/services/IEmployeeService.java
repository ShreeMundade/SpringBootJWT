package com.sp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.entities.Employee;

@Service
public interface IEmployeeService {
	public Employee addEmployee(Employee e);
	public Employee deleteEmployee(long id);
	public Employee updateEmployee(Employee e);
	public List<Employee> listAllEmployees();
	public Employee listEmployeeById(long id);
	

}
