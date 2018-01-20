package com.spring.jpa.springjpahibernateex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.springjpahibernateex.model.Users;

public interface UserRepository  extends JpaRepository<Users, Integer>{

	Optional<List<Users>> findByName(String name);
	
	

}
