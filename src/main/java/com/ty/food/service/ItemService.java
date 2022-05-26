package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.ItemDao;
import com.ty.food.dto.Item;

public class ItemService {
	public Item saveItem(List<Item> items) { 
		ItemDao dao = new ItemDao();
		return dao.saveItem(items);
	}
}
