package com.ty.food.controller;

import com.ty.food.service.FoodOrderService;

public class TestDeleteOrderById_Item {
	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService();
		if(foodOrderService.deleteOrderById(2)) {
			System.out.println("Order cancelled");
		}
		else {
			System.out.println("No order for the given id");
		}
	}
}
