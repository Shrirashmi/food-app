package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.ItemService;

public class TestSaveItem {
	public static void main(String[] args) {
		Item item1 = new Item();
		item1.setName("Idly");
		item1.setQuantity(2);
		item1.setCost(20);
		
		Item item2 = new Item();
		item2.setName("Idly");
		item2.setQuantity(2);
		item2.setCost(20);
		
		Item item3 = new Item();
		item3.setName("Dosa");
		item3.setQuantity(3);
		item3.setCost(25);
		
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setName("Abc");
		foodOrder.setPhone(45621);
	
		item1.setFoodOrder(foodOrder);
		item2.setFoodOrder(foodOrder);
		item3.setFoodOrder(foodOrder);
		
//		List<Item> items = new ArrayList();
//		items.add(item1);
//		items.add(item2);
//		items.add(item3);
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		ItemService itemService = new ItemService();
		Item item = itemService.saveItem(items);
	}
}
