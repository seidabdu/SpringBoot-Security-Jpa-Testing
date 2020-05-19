package com.ally.exercise.springbootserurityjpatesting.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ally.exercise.springbootserurityjpatesting.model.DAOUser;

@Component
public class UserEventHandler {
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	public void beforeSave(DAOUser user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		user.setRoles(Arrays.asList("ROLE_USER"));
//	}

}