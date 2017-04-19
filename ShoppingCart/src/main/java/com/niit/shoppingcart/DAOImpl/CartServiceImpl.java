package com.niit.shoppingcart.DAOImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niit.shoppingcart.model.CartItem;

import javax.persistence.*;

import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.List;


@Entity
public class CartServiceImpl implements Serializable{

    private static final long serialVersionUID = 3940548625296145582L;

    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "Id")
    @JsonIgnore
    private User user;

    private double grandTotal;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
} // The End of Class;
