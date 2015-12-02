package com.northwindx.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.northwindx.model.jpa.Categories;
import com.northwindx.util.PersistenceUtil;

@ManagedBean
@RequestScoped
public class CategoriesBean {
	
	private List<Categories> categoriesList;

	public CategoriesBean() {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		setCategoriesList(em.createQuery("from Categories", Categories.class).getResultList());
		em.getTransaction().commit();
	}
	
	public List<Categories> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(List<Categories> categoriesList) {
		this.categoriesList = categoriesList;
	}
}
