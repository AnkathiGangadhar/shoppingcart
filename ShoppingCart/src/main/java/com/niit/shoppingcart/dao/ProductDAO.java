package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Product;

@Component
public interface ProductDAO {

	
	public List<Product> list();
	
	public Product get(int Id);
	
	public void saveOrUpdate(Product product);
	
	public void delete(int Id);
	
	public List getAllProducts();
	
	public Product getSingleProduct(int id);
	
	public void updateProduct(Product product);

}
