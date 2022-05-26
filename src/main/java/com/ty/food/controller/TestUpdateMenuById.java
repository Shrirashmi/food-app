package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestUpdateMenuById {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setName("burger");
		menu.setCost(200);
		menu.setOffer(-5);
		menu.setType("NonVeg");
		menu.setImage("www.burger.com");
		menu.setDescription("chicken");
		MenuService menuService = new MenuService();
		Menu menu1 = menuService.updateMenuById(1, menu);
		
		if(menu1!=null) {
			System.out.println("Menu updated");
		}
		else {
			System.out.println("No menu");
		}
	}
}
