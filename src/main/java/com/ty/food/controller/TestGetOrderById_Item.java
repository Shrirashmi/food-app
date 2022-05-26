package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestGetOrderById_Item {
	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder = foodOrderService.getOrderById(1);
		System.out.println("------------------------------------------");
		System.out.println("Name: " + foodOrder.getName());
		System.out.println("Phone: " + foodOrder.getPhone());
		List<Item> items = foodOrder.getItem();
		for(Item item : items) {
			System.out.println("Item id: " + item.getId());
			System.out.println("Item name: " + item.getName());
			System.out.println("Quantity: " + item.getQuantity());
			System.out.println("Cost: " + item.getCost());
			System.out.println("--------------------------------------");
		}
	}
}
