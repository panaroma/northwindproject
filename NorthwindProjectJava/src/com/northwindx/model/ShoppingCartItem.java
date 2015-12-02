package com.northwindx.model;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.northwindx.model.jpa.Products;
import com.northwindx.util.PersistenceUtil;

public class ShoppingCartItem {
	
	private int productId;
	private int quantity;
	private BigDecimal unitPrice;
	private String productName;
	private String quantityPerUnit;
	
	public ShoppingCartItem() {}
	
	/**
	 * This constructor creates an item based on a ProductID by looking it up it in the database
	 * then passing it to loadProduct() to set the properties
	 * 
	 * @param productID	The ProductID of the product
	 */
	public ShoppingCartItem(int productID) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		Products product = em.createQuery("from Products WHERE ProductId = " + productID, Products.class).getSingleResult();
		loadProduct(product);
		em.getTransaction().commit();
	}
	
	/**
	 * This constructor creates an item based on a Products object.
	 * 
	 * @param product The Products object
	 */
	public ShoppingCartItem(Products product) {
		loadProduct(product);
	}
	
	/**
	 * This sets certain Products properties to thie ShoppingCartItem object. This method is
	 * protected since we don't want this to be called outside of this class or it's children.
	 * <p>
	 * Using this second method, we keep similar code in one function instead of having it
	 * in two (or more) constructors, allowing easy editing in one place.
	 * 
	 * @param product	The Products object used to fill the properties 
	 */
	protected void loadProduct(Products product) {
		productId = product.getProductID();
		unitPrice = product.getUnitPrice();
		productName = product.getProductName();
		quantityPerUnit = product.getQuantityPerUnit();
	}
	
	public BigDecimal getTotalPrice() {
		return unitPrice.multiply(new BigDecimal(quantity));
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}
}