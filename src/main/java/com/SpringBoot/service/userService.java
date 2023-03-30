package com.SpringBoot.service;

import java.util.List;

import com.SpringBoot.model.User;


public interface userService {
	
	boolean saveUser(User user);

	boolean userCheck(String email, String password);

	User userGet(String email);
	
	List<User> getAllEmployee();
	
	void deleteById(int id);
	 
}
