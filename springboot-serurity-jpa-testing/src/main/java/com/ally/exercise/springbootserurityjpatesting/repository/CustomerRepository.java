package com.ally.exercise.springbootserurityjpatesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ally.exercise.springbootserurityjpatesting.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByContactName(String contactName);

	public Customer findByCompanyName(String companyName);

}
