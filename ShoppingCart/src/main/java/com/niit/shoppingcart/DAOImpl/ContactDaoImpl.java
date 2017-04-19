package com.niit.shoppingcart.DAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ContactDAO;
import com.niit.shoppingcart.model.Contact;



@Repository
public class ContactDaoImpl implements ContactDAO {
		@Autowired
	private SessionFactory sessionFactory;

	public ContactDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveorUpdate(Contact cont) {
		sessionFactory.getCurrentSession().saveOrUpdate(cont);
		
	}

	

	
	
}


	

