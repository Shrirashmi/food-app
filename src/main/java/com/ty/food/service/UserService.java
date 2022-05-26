package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;

public class UserService {
	UserDao dao = new UserDao();
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public User getUserById(int id) {
		return dao.getUserById(id);
	}
	
	public List<User> getAllUser(){
		return dao.getAllUser();
	}
	
	public boolean deleteUserById(int id) {
		return dao.deleteUserById(id);
	}
	
	public User updateUserById(int id, User user) {
		return dao.updateUserById(id, user);
	}
	
	public List<User> validateUser(String email, String password){
		return dao.validateUser(email, password);
	}
}
