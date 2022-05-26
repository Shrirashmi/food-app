package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestSaveUser {
	public static void main(String[] args) {
		UserService service = new UserService();
		User user = new User();
		user.setName("sonia");
		user.setEmail("sonia@gmail.com");
		user.setPassword("sani");
		user.setPhone(88896645l);
		
		User user1 = service.saveUser(user);
		if(user1!=null) {
			System.out.println("Inserted");
			System.out.println(user1);
		}
		else {
			System.out.println("Not inserted");
		}
	}
}
