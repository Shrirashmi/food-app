package com.ty.food.controller;

import com.ty.food.service.MenuService;

public class TestDeleteMenuById {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		if(menuService.deleteMenuById(2)) {
			System.out.println("Menu cancelled");
		}
		else {
			System.out.println("No menu for the given id");
		}
	}
}
