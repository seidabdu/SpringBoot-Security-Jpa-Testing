package com.ally.exercise.springbootserurityjpatesting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ally.exercise.springbootserurityjpatesting.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);
}