package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public User saveUser(User user) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return entityManager.find(User.class, user.getId());
	}

	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}

	public List<User> getAllUser() {
		String sql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	public boolean deleteUserById(int id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public User updateUserById(int id, User user) {
		User user1 = entityManager.find(User.class, id);
		if (user1 != null) {
			user.setId(id);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return entityManager.find(User.class, user.getId());
		} else {
			return null;
		}
	}
	
	public List<User> validateUser(String email, String password) {
		String sql = "SELECT u FROM User u WHERE u.email=?1 AND u.password= :myPassword";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
	   	query.setParameter("myPassword", password);
		List<User> users = query.getResultList();
		return users;
	}
}
