package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import static com.ty.food.dto.Tax.*;

public class FoodOrderService {
	public FoodOrder saveOrder(FoodOrder foodOrder) {
		FoodOrderDao dao = new FoodOrderDao();
		return dao.saveOrder(foodOrder);
	}

	public FoodOrder getOrderById(int id) {
		FoodOrderDao dao = new FoodOrderDao();
		return dao.getOrderById(id);
	}

	public boolean deleteOrderById(int id) {
		FoodOrderDao dao = new FoodOrderDao();
		return dao.deleteOrderById(id);
	}

	public List<FoodOrder> getAllOrders() {
		FoodOrderDao dao = new FoodOrderDao();
		return dao.getAllOrders();
	}

	public FoodOrder updateOrderById(int id, Item item) {
		FoodOrderDao dao = new FoodOrderDao();
		return dao.updateOrderById(id, item);
	}

	public double genarateBill(int id) {
		FoodOrderDao dao = new FoodOrderDao();
		FoodOrder foodOrder = dao.getOrderById(id);
		double offer = 0;
		if (foodOrder.getTotal() > 1000) {
			offer = foodOrder.getTotal() / 10;
		}
		double a = (foodOrder.getTotal() / CGST) + (foodOrder.getTotal() / SGST);
		return foodOrder.getTotal() - offer + a;
	}
}
