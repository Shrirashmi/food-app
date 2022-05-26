package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestSaveMenu {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		Menu menu = new Menu();
		menu.setName("Burger");
		menu.setCost(250);
		menu.setDescription("hbj");
		menu.setImage("www.chickenburger.com");
		//menu.setOffer();
		menu.setType("NonVeg");
		menuService.saveMenu(menu);
	}
}
