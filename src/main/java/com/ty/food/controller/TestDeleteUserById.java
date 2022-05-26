package com.ty.food.controller;

import com.ty.food.service.UserService;

public class TestDeleteUserById {
	public static void main(String[] args) {
		UserService service = new UserService();

		if(service.deleteUserById(2)) {
			System.out.println("User is deleted");
		}
		else {
			System.out.println("Id not found");
		}
	}
}
