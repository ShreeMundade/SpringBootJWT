package com.sp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
