package com.sp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sp.entities.User;

@Service

public interface UserService {
	public User addUser(User c);
	public Optional<User> deleteUser(long id);
	public User deleteUser(User c);
	public User updateUser(User c);
	public List<User> listAllUsers();
	public Optional<User> listUserById(long id);
	
	 public User findUser(User user) ;
	
	
}
