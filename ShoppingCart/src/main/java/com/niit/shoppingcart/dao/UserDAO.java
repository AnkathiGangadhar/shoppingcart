package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Register;
import com.niit.shoppingcart.model.User;


public interface UserDAO {

	public List<Register> list();
	
	
	public Register get(int id);
	
	
	
	
	
	
	
	public void delete(int id);


	public User getSingleUser(int id);


	public List getAllUsers();


	public void saveorUpdate(Register registeruser);
	public void saveorUpdate(User loginuser);


	public void update(User editlogin);


	
	
	
}
