package com.sp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}