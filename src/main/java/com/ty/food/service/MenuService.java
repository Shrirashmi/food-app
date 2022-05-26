package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.MenuDao;
import com.ty.food.dto.Menu;

public class MenuService {
	MenuDao dao = new MenuDao();
	
	public Menu saveMenu(Menu menu) {
		return dao.saveMenu(menu);
	}
	
	public Menu getMenuById(int id) {
		return dao.getMenuById(id);
	}
	
	public List<Menu> getAllMenu(){
		return dao.getAllMenu();
	}
	
	public boolean deleteMenuById(int id) {
		return dao.deleteMenuById(id);
	}
	
	public Menu updateMenuById(int id, Menu menu) {
		return dao.updateMenuById(id, menu);
	}
}
