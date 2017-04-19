package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Register;
import com.niit.shoppingcart.model.User;


@Controller
public class UserController {

	@Autowired
	UserDAO Registerdao;
	
	

	@RequestMapping("ManageUsers")
	public ModelAndView userList(){
		ModelAndView mv9 = new ModelAndView("ManageUsers");
		return mv9;
	}
	@RequestMapping("viewuser")
	public ModelAndView viewuser(){
		ModelAndView mv9 = new ModelAndView("viewuser");
		return mv9;
	}
	@RequestMapping(value = "viewuser", method = RequestMethod.GET)
	public ModelAndView viewPro(@RequestParam int id, @ModelAttribute User loginuser) {
		User user = Registerdao.getSingleUser(id);
		return new ModelAndView("viewuser", "user", user);
	}
	@RequestMapping(value="edituser", method=RequestMethod.GET)
	public ModelAndView edituser(@RequestParam int id){
		Register u1=Registerdao.get(id);
		return new ModelAndView("edituser","User",u1);
	}
	@RequestMapping(value = "listusers", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showList()
	{
		List list = Registerdao.getAllUsers();
		Gson x = new Gson();
		String json = x.toJson(list);
		return json;
	}

	@RequestMapping("Login")
	public ModelAndView display1() {
		ModelAndView mv1 = new ModelAndView("Login");
		return mv1;
	}

	@RequestMapping(value = "fail2Login", method = RequestMethod.GET)
	public ModelAndView loginerror(ModelMap model) {
		return new ModelAndView("Login", "error", true);
	}

	@RequestMapping("Register")
	public ModelAndView display2() {

		ModelAndView mv2 = new ModelAndView("Register");
		return mv2;
	}

	@RequestMapping(value = "storeUser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("UserDetails") Register Registeruser,BindingResult result) {
		if (result.hasErrors()) {
			return "Register";
		}
		Registerdao.saveorUpdate(Registeruser);
		User Loginuser = new User();
		
		Loginuser.setUsername(Registeruser.getUsername());
		Loginuser.setPassword(Registeruser.getPassword());
		Loginuser.setStatus(Registeruser.getStatus());
		Registerdao.saveorUpdate(Loginuser);
		return "Register";
	}

	@RequestMapping("deleteuser")
	public ModelAndView deleteUser(@RequestParam int id,@Valid @ModelAttribute("User")User Loginuser) {
		Registerdao.delete(id);
		ModelAndView m1 = new ModelAndView("ManageUsers");
		return m1;
	}
	@ModelAttribute("UserDetails")
	public Register RegisterUser() {
		return new Register();

	}

	@ModelAttribute("User")
	public User createUser() {
		return new User();

	}

	@RequestMapping("/Admin")
	public ModelAndView display5() {
		ModelAndView m5 = new ModelAndView("admin");
		return m5;
	}
	@RequestMapping(value = "/welcome")
	public ModelAndView checkUserOne(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		if (request.isUserInRole("ROLE_ADMIN")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName(); // get username
			session = request.getSession(true);
			session.setAttribute("LoggedInUser", str);
			// session.invalidate();
			ModelAndView m1 = new ModelAndView("admin");
			return m1;
		}
		else
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName();
			session = request.getSession(true);
			session.setAttribute("LoggedInUser", str);
			ModelAndView m2 = new ModelAndView("viewproducts");
			return m2;
		}
		
	}
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request,@Valid @ModelAttribute("User")User editlogin,BindingResult result)
    {
		Registerdao.update(editlogin);
		return new ModelAndView("ManageUsers");
    }
	@RequestMapping("/logout")
    public ModelAndView updateUser1()
    {

		return new ModelAndView("home");
    }

}

