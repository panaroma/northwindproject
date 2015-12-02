package com.northwindx;

import java.util.List;

import javax.persistence.EntityManager;

import com.northwindx.model.jpa.OrderDetails;
import com.northwindx.util.PersistenceUtil;


public class App {

	public static void main(String[] args) {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		List<OrderDetails> odList = em.createQuery("from OrderDetails Where OrderID = " + 10248).getResultList();
		for(OrderDetails od : odList) {
			System.out.println(od.getProduct().getProductName());
		}
	}

}
