package com.northwindx.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShoppingCart {
	
	static List<ShoppingCartItem> cart;
	
	static {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		
		if (session.getAttribute("cart") == null) {
			cart = new ArrayList<>();
		} else {
			cart = (ArrayList<ShoppingCartItem>)session.getAttribute("cart");
		}
	}
	
	/**
	 * Returns a List of ShoppingCartItems.
	 * <p>
	 * The cart being returned is dependent on the user's session.
	 * @return	A List of ShoppingCartItems.
	 */
	public static List<ShoppingCartItem> getCart() {
		
		return cart;
	}
	
	/**
	 * Adds an item to the user's (session's) cart.
	 * 
	 * @param item	The ShoppingCartItem to be added
	 */
	public static void addItem(ShoppingCartItem item) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		List<ShoppingCartItem> cart = getCart();
		
		cart.add(item);
		session.setAttribute("cart", cart);
	}
	
	/**
	 * Removes an item from the user's (session's) cart.
	 * 
	 * @param item	The ShoppingCartItem to be removed
	 */
	public static void removeItem(ShoppingCartItem item) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		List<ShoppingCartItem> cart = getCart();
		
		cart.remove(item);
		session.setAttribute("cart", cart);
	}
	
	/**
	 * Deletes all items in the cart by creating a new ArrayList
	 */
	public static void clearCart() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		
		cart = new ArrayList<>();
		session.setAttribute("cart", cart);
	}
}
