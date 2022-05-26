package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public FoodOrder saveOrder(FoodOrder foodOrder) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		for(Item item : foodOrder.getItem()){
			entityManager.persist(item);
		}
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return entityManager.find(FoodOrder.class, foodOrder.getId());
	}
	
	public FoodOrder getOrderById(int id) {
		return entityManager.find(FoodOrder.class, id);
	}
	
	public boolean deleteOrderById(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		if(foodOrder!=null) {
		entityTransaction.begin();
		for(Item item : foodOrder.getItem()) {
			entityManager.remove(item);
		}
		entityManager.remove(foodOrder);
		entityTransaction.commit();
		return true;
		}
		else {
			return false;
		}
	}
	
	public FoodOrder updateOrderById(int id, Item item) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		foodOrder.getItem().add(item);
		entityTransaction.begin();
		
		double total =0;
		for(Item i : foodOrder.getItem()) {
			total += (i.getCost() * i.getQuantity());
			i.setFoodOrder(foodOrder);
		}
		foodOrder.setTotal(total);
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}
	
	public List<FoodOrder> getAllOrders(){
		String sql = "SELECT f FROM FoodOrder f";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}
	
	public List<FoodOrder> getFoodOrderByPhone(long phone){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String sql = "SELECT f FROM FoodOrder f WHERE f.Phone =?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, phone);
		return query.getResultList();	
	}
	
	public List<FoodOrder> getFoodOrderByName(String name){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String sql = "SELECT f FROM FoodOrder f WHERE f.Name =?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, name);
		return query.getResultList();	
	}
}
