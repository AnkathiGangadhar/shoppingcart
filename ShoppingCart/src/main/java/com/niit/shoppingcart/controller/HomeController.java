package com.niit.shoppingcart.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.ContactDAO;
import com.niit.shoppingcart.model.Contact;
import com.niit.shoppingcart.model.Register;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {
	@Autowired
	ContactDAO Contactdao;
	@RequestMapping("/")	
	public String homePage()
	{
		return "home";
	}
	@RequestMapping("/multiusers")	
	public String homePage1()
	{
		return "multiusers";
	}
	@RequestMapping("/contact")	
	public String contact()
	{
		return "contact";
	}
	@RequestMapping(value = "con", method = RequestMethod.GET)
	public String addUser(@Valid @ModelAttribute("Contact") Contact contact,BindingResult result) {
		if (result.hasErrors()) {
			return "contact";
		}
		Contactdao.saveorUpdate(contact);
		Contact c = new Contact();
		
		c.setId(contact.getId());
		c.setEmail(contact.getEmail());
		c.setName(contact.getName());
		c.setMessage(contact.getMessage());
		c.setSubject(contact.getSubject());
		Contactdao.saveorUpdate(contact);
		return "contact";
	}
	
	
}
