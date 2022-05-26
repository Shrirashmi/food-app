package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestGetAllUsers {
	public static void main(String[] args) {
		UserService service = new UserService();
		List<User> users = service.getAllUser();
		for(User user : users) {
			System.out.println(user);
		}
	}
}
