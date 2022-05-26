package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

import java.util.List;
import java.util.Scanner;
public class TestValidateUserByEmailPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user email and password");
		String email = sc.next();
		String password = sc.next();
		UserService service = new UserService();
		List<User> users = service.validateUser(email, password);
		if(users.size()>0) {
			//User user = u.get(0);
			for(User user : users) {
			System.out.println("ID: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Phone: " + user.getPhone());
			}
		}
		else 
		{
			System.out.println("Invalid email or password");
		}
	}
}
