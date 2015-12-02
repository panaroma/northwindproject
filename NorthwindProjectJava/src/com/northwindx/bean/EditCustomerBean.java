package com.northwindx.bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.northwindx.model.Login;
import com.northwindx.model.jpa.Customers;
import com.northwindx.util.PersistenceUtil;


@ManagedBean
@RequestScoped
public class EditCustomerBean {
	
	private Customers tempCustomer;
	
	public EditCustomerBean() {
		EntityManager em = PersistenceUtil.getEntityManager();
		Customers customer = Login.getLoggedInUser();
		em.getTransaction().begin();
		setTempCustomer(em.createQuery("from Customers Where CustomerID = '" + customer.getCustomerID() + "'", Customers.class).getResultList().get(0));
		em.getTransaction().commit();		
	}
	
	public Customers getTempCustomer() {
		return tempCustomer;
	}

	public void setTempCustomer(Customers tempCustomer) {
		this.tempCustomer = tempCustomer;
	}

	public void submitChanges()
	{	
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
//		Don't have to do anything else but commit the changes since tempCustomer is already a managed entity
		em.getTransaction().commit();
	}

}