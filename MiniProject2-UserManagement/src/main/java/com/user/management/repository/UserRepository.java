package com.user.management.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.management.model.User;

public interface UserRepository extends CrudRepository<User, Serializable>{

	List<User> findByEmail(String email);
	
	List<User> findByEmailAndPassword(String email, String password);
}
