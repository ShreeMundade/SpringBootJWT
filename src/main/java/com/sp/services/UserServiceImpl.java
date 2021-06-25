package com.sp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.dao.UserRepository;
import com.sp.entities.User;

@Transactional
@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public Optional<User> deleteUser(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return repo.findById(id);
	}

	@Override
	public User deleteUser(User c) {
		// TODO Auto-generated method stub
		repo.delete(c);
		return c;
	}

	@Override
	public User updateUser(User c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<User> listUserById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public User findUser(User user) {

		User dbUser = repo.findByEmail(user.getEmail());
		System.out.println("db user " + dbUser);
		if (dbUser == null)
			throw new RuntimeException("user does nt exist");
		if (!dbUser.getPassword().contentEquals(user.getPassword())) {
			throw new RuntimeException("password mismatch");
		}
		System.out.println("returning dbuser");
		return dbUser;
	}

	public User addUser(User user) {
		User newuser = new User();
		User byEmail = repo.findByEmail(user.getEmail());
		if (byEmail != null) {
			throw new RuntimeException("User already registered. Please use different email.");
		}
		newuser.setEmail(user.getEmail());
		newuser.setPassword(user.getPassword());
		repo.save(newuser);
		return newuser;
	}

}
