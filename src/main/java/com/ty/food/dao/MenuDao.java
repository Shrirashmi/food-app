package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.Menu;

public class MenuDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public Menu saveMenu(Menu menu) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return entityManager.find(Menu.class, menu.getId());
	}
	
	public Menu getMenuById(int id) {
		return entityManager.find(Menu.class, id);
	}
	
	public List<Menu> getMenuByType(String type) {
		Query query = entityManager.createQuery("SELECT m FROM Menu m WHERE type = ?1");
		query.setParameter(1, type);
		return query.getResultList();
	}
	
	public List<Menu> getAllMenu(){
		String sql = "SELECT m FROM Menu m";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}
	
	public boolean deleteMenuById(int id) {
		Menu menu = entityManager.find(Menu.class, id);
		if(menu!=null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
	
	public Menu updateMenuById(int id, Menu menu) {
		Menu menu1 = entityManager.find(Menu.class, id);
		if(menu1!=null) {
			menu.setId(id);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(menu);
			entityTransaction.commit();
			return entityManager.find(Menu.class, menu.getId());
		}
		else {
			return null;
		}
	}
}
