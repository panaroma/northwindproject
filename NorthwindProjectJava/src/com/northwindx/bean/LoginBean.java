package com.northwindx.bean;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.northwindx.model.Login;
import com.northwindx.model.jpa.Customers;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String name;
	private String password;
	private boolean rememberMe = true;
	private Customers customer = Login.getLoggedInUser();
	
	public LoginBean() {
		ExternalContext context = (ExternalContext) FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		if (request.getParameter("log") != null && request.getParameter("log").equals("out")) {
			try {
				Login.logout();
				context.redirect("default.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	
	public String validateLogin() {
		if (Login.login(name, password, rememberMe)) {
			return "default?faces-redirect=true";
		} else {
			return "login";
		}
	}
}
