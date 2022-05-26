package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class ItemDao {
	public Item saveItem(List<Item> items) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		for (Item item : items) {
			if(item!=null) {
			entityManager.persist(item);
			entityTransaction.commit();
			return entityManager.find(Item.class, item.getId());
			}
		}
		return null;
	}
}
