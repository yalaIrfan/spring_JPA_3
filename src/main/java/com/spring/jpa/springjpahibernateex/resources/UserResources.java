package com.spring.jpa.springjpahibernateex.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.springjpahibernateex.model.Users;
import com.spring.jpa.springjpahibernateex.repository.UserRepository;

@RestController
@RequestMapping(value="/api/users")
public class UserResources {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/all")
	public List<Users> getAll(){
		
		return userRepository.findAll();
		
	}
	
	@RequestMapping(value="/{name}")
	public List<Users> getUser(@PathVariable final String name ){
		
		Optional<List<Users>> optionalList=userRepository.findByName(name);
		
		List<Users> users=optionalList
				//.orElseThrow(()-> new RuntimeException("No records"))
				.orElse(new ArrayList<>())
				;
				
		return users;
	}
	
	@RequestMapping(value="/id/{id}")
	public Users getUserById(@PathVariable final Integer id ){
		
		Users user=userRepository.findOne(id);
				
		return user;
	}
	
	@RequestMapping(value="/update/{id}/{name}")
	public Users getUserById(@PathVariable("name") final String name,@PathVariable("id") final Integer id ){
		
		Users user=getUserById(id);
				user.setName(name);	
		return userRepository.save(user);
	}
	
}
