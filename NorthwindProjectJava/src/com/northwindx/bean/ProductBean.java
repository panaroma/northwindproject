package com.northwindx.bean;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.northwindx.model.jpa.Categories;
import com.northwindx.model.jpa.Products;
import com.northwindx.util.PersistenceUtil;

@ManagedBean
@RequestScoped
public class ProductBean {
	
	private List<Products> productList;
	private String id = "";
	private Categories catName;
	
	public ProductBean() {
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		setId(request.getParameter("id"));
		
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		if(id == null || id.isEmpty()) {
			id = "1";
		}
		setProductList(em.createQuery("from Products where CategoryID = " + id, Products.class).getResultList());
		setCatName(em.createQuery("from Categories where CategoryID =" + id, Categories.class).getSingleResult());

		em.getTransaction().commit();
	}
	
	public List<Products> getProductList() {
		return productList;
	}

	public void setProductList(List<Products> productList) {
		this.productList = productList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Categories getCatName() {
		return catName;
	}

	public void setCatName(Object object) {
		this.catName = (Categories) object;
	}	
	
}
