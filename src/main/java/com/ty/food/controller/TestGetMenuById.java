package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestGetMenuById {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		Menu menu = menuService.getMenuById(1);
		if(menu!=null) {
//			System.out.println("Name: " + menu.getName());
//			System.out.println("Cost: " + menu.getCost());
//			System.out.println("Description: " + menu.getDescription());
//			System.out.println("Image: " + menu.getImage());
//			System.out.println("Type: " + menu.getType());
			System.out.println(menu);
		}
		else {
			System.out.println("Id not found");
		}
	}
}
