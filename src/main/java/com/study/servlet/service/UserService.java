package com.study.servlet.service;

import com.study.servlet.entity.User;
import com.study.servlet.repository.UserRepository;
import com.study.servlet.repository.UserRepositoryImpl;

public interface UserService {

	public int addUser(User user);
	public User getUser(String username);
	public boolean duplicatedUsername(String uername);
	

}
