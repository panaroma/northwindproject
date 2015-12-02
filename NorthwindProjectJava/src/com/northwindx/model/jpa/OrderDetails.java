package com.northwindx.model.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected OrderDetailsPK orderDetailsPK;
	@Basic(optional = false)
	@Column(name = "UnitPrice")
	private BigDecimal UnitPrice;
	@Basic(optional = false)
	@Column(name = "Quantity")
	private short Quantity;
	@Basic(optional = false)
	@Column(name = "Discount")
	private Float Discount;
	
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Products Product;
	
	@JoinColumn(name = "OrderID", referencedColumnName = "OrderID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Orders Order;
	
	public OrderDetails() {}
	
	public OrderDetails(OrderDetailsPK orderDetailsPK) {
		this.orderDetailsPK = orderDetailsPK;
	}
	
	public OrderDetails(OrderDetailsPK orderDetailsPK, BigDecimal unitPrice, short quantity, Float discount) {
		this.orderDetailsPK = orderDetailsPK;
		this.UnitPrice = unitPrice;
		this.Quantity = quantity;
		this.Discount = discount;
	}
	
	public OrderDetails(int orderID, int productID) {
		this.orderDetailsPK = new OrderDetailsPK(orderID, productID);
	}

	public OrderDetailsPK getOrderDetailsPK() {
		return orderDetailsPK;
	}

	public void setOrderDetailsPK(OrderDetailsPK orderDetailsPK) {
		this.orderDetailsPK = orderDetailsPK;
	}

	public BigDecimal getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		UnitPrice = unitPrice;
	}

	public short getQuantity() {
		return Quantity;
	}

	public void setQuantity(short quantity) {
		Quantity = quantity;
	}

	public Float getDiscount() {
		return Discount;
	}

	public void setDiscount(Float discount) {
		Discount = discount;
	}

	public Orders getOrder() {
		return Order;
	}

	public void setOrder(Orders order) {
		Order = order;
	}
	
	public Products getProduct() {
		return Product;
	}

	public void setProduct(Products product) {
		Product = product;
	}
	
	@Override
	public int hashCode() {
	  int hash = 0;
	  hash += (orderDetailsPK != null
	      ? orderDetailsPK.hashCode() : 0);
	  return hash;
	}

	@Override
	public boolean equals(Object object) {
	  if (!(object instanceof OrderDetails)) {
	    return false;
	  }
	  OrderDetails other = (OrderDetails) object;
	  if ((this.orderDetailsPK == null && other.orderDetailsPK != null)
	      || (this.orderDetailsPK != null && !this.orderDetailsPK
	          .equals(other.orderDetailsPK))) {
	    return false;
	  }
	  return true;
	}

	@Override
	public String toString() {
	  return "com.northwindx.model.jpa.OrderDetails[orderDetailsPK="
	      + orderDetailsPK + "]";
	}
}
