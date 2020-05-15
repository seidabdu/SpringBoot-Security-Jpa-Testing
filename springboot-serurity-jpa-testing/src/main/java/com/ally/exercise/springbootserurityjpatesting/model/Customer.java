package com.ally.exercise.springbootserurityjpatesting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Customer {

	@Id
	@GeneratedValue
	private long customerId;

	private String companyName;

	private String contactName;

	private String address;

	private String city;

	private String state;

	private String zip;

}
