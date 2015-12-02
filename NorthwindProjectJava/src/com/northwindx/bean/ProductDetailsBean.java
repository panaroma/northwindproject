package com.northwindx.bean;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.northwindx.model.ShoppingCart;
import com.northwindx.model.ShoppingCartItem;
import com.northwindx.model.jpa.Products;
import com.northwindx.util.PersistenceUtil;

@ManagedBean
@RequestScoped
public class ProductDetailsBean {
		
	private Products product;
	
	public ProductDetailsBean() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		loadProduct(Integer.valueOf(request.getParameter("id")));
	}
	
	public String addProductToCart() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		ShoppingCartItem cartItem = new ShoppingCartItem(product);
		cartItem.setQuantity(Integer.valueOf(params.get("quantity")));
		ShoppingCart.addItem(cartItem);
		
		return "showCart?faces-redirect=true";
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	protected void loadProduct(int productID) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		product = em.createQuery("from Products Where ProductId = " + productID, Products.class).getResultList().get(0);
		em.getTransaction().commit();
	}

}
