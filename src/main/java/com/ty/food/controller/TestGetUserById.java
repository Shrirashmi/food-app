package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestGetUserById {
	public static void main(String[] args) {
		UserService userService = new UserService();
		User user = userService.getUserById(1);
		if(user!=null) {
			System.out.println(user);
		}
		else {
			System.out.println("Id not found");
		}
	}
}
