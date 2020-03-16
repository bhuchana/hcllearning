package com.online.shopping.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_order")
public class UserOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userorderid")
	private long id;

	@OneToOne
	@JoinColumn(name="cartid",nullable = false)
	private AddToCart cart;
	
	@OneToOne
	@JoinColumn(name="userid")
	private User user;
	
	@OneToOne
	@JoinColumn(name="addressid",nullable = false)
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AddToCart getCart() {
		return cart;
	}

	public void setCart(AddToCart cart) {
		this.cart = cart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



}
