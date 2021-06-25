package com.sp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.dao.EmployeeRepository;
import com.sp.entities.Employee;
@Transactional
@Service

public class EmployeeService implements IEmployeeService {
    @Autowired
	private EmployeeRepository repo;
	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

	@Override
	public Employee deleteEmployee(long id) {
		Employee e1 = repo.findById(id).get();
		repo.deleteById(id);
		// TODO Auto-generated method stub
		return e1;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

	@Override
	public List<Employee> listAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee listEmployeeById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
