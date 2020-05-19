package com.ally.exercise.springbootserurityjpatesting.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.ally.exercise.springbootserurityjpatesting.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByContactName(String contactName);

	public Customer findByCompanyName(String companyName);

//	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	List<Customer> findAll();
//
//	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	List<Customer> findAll(Sort sort);
//
//	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	Page<Customer> findAll(Pageable pageable);

	// @Override
	// @PreAuthorize("hasRole('ROLE_ADMIN') or principal.companyId == #id")
	// Customer findOne(@Param("id") String id);

}
