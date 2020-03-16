package com.online.shopping.shoppingcart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class AddToCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cartid")
	private Long id;
	
	@OneToMany(mappedBy = "addToCart",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<CartItem> cartItem;
	
	@OneToOne
	@JoinColumn(name="userid",nullable=false)
	private User  user;
	
	@Column(name="grandtotal")
	private double grandTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
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

	
	
	
	
}
