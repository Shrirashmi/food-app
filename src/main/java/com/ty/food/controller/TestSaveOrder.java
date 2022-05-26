package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestSaveOrder {
	public static void main(String[] args) {
		
		FoodOrder foodOrder = new FoodOrder();
		
		foodOrder.setName("Kiran");
		foodOrder.setPhone(889655654);
		
		Item item1 = new Item();
		item1.setName("Biriyani");
		item1.setQuantity(1);
		item1.setCost(200);
		item1.setFoodOrder(foodOrder);
		
		Item item2 = new Item();
		item2.setName("Pizza");
		item2.setQuantity(1);
		item2.setCost(100);
		item2.setFoodOrder(foodOrder);
		
		Item item3 = new Item();
		item3.setName("FrenchFries");
		item3.setQuantity(2);
		item3.setCost(140);
		item3.setFoodOrder(foodOrder);
		
		List<Item> items = new ArrayList();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		foodOrder.setItem(items);
		
		double total = 0;
		for(Item item : items) {
			total += item.getCost();
		}
		foodOrder.setTotal(total);
		
		foodOrder.setStatus("Placed");
		
		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder2 = foodOrderService.saveOrder(foodOrder);
		if(foodOrder2!=null) {
			System.out.println("Order placed");
		}
		else {
			System.out.println("Order not placed");
		}
	}
}
