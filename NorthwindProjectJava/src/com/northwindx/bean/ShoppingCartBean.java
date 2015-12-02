package com.northwindx.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.northwindx.model.ShoppingCart;
import com.northwindx.model.ShoppingCartItem;

@ManagedBean
@ViewScoped
public class ShoppingCartBean {
	private List<ShoppingCartItem> cart = ShoppingCart.getCart();
	
	public void clearCart() {
		ShoppingCart.clearCart();
		cart = ShoppingCart.getCart(); // Get the new cart
	}

	public List<ShoppingCartItem> getCart() {
		return cart;
	}

	public void setCart(List<ShoppingCartItem> cart) {
		this.cart = cart;
	}
}