package com.online.shopping.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cartitem")
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cartitemid")
	private long cartItemId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="cartid",nullable = false)
	private AddToCart addToCart;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="productid",nullable = false)
	private Product product;
	
	@Column(name="quantity")
    private int quantity;
	
	@Column(name="totalprice")
	private double totalPrice;
	
	
	public long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public AddToCart getAddToCart() {
		return addToCart;
	}

	public void setAddToCart(AddToCart addToCart) {
		this.addToCart = addToCart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
}
