package com.ty.food.controller;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestUpdateOrderById {
	public static void main(String[] args) {
		Item item = new Item();
		item.setName("Frenchfries");
		item.setQuantity(2);
		item.setCost(180);
		
		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder = foodOrderService.updateOrderById(1, item);
		
		if(foodOrder!=null) {
			System.out.println("Order updated");
		}
		else {
			System.out.println("Order it doesnt exist");
		}
	}
}
