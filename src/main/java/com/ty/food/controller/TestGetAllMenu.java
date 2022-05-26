package com.ty.food.controller;

import java.util.List;
import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestGetAllMenu {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		List<Menu> menus = menuService.getAllMenu();
//		for (Menu menu : menus) {
//			System.out.println(menus);
//		}

		if (menus != null) {
			for (Menu menu : menus) {
				if (menu != null) {
					System.out.println("Name: " + menu.getName());
					System.out.println("Cost: " + menu.getCost());
					System.out.println("Description: " + menu.getDescription());
					System.out.println("Image: " + menu.getImage());
					System.out.println("Type: " + menu.getType());
					System.out.println("---------------------------------------------");
				} else {
					System.out.println("Blank menu");
				}
			}
		} else {
			System.out.println("No menu available");
		}
	}
}
