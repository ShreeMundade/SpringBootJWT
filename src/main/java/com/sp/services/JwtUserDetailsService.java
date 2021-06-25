package com.sp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sp.dao.UserRepository;
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService service;
	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	      com.sp.entities.User user =  repo.findByEmail(username);
	      
	      com.sp.entities.User validuser= service.findUser(user);
	      if(validuser==null)
	    	  throw new UsernameNotFoundException("user not found"+username);
	      
	      return  new org.springframework.security.core.userdetails.User(validuser.getEmail(), validuser.getPassword(), new ArrayList<>());
	      
	
	}

	public com.sp.entities.User save(com.sp.entities.User user) {
		com.sp.entities.User newUser = new com.sp.entities.User();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return service.addUser(newUser);
	}

}