package com.northwindx.model;

import javax.servlet.http.Cookie;

import com.northwindx.model.jpa.Customers;

public class Login{

	/**
	 * Returns the currently logged in user based on a "oatmealRaisin" cookie.
	 * Returns null if a user is not logged in.
	 * 
	 * @return	the Customers object
	 */
	public static Customers getLoggedInUser() {
		Customers customer= null;
		Cookie cookie= getCookie("oatmealRaisin");
		
		
		
	}
	
	/**
	 * Method overload for login(String, String, boolean). 
	 * 
	 * @param username	the CustomerID of the customer trying to log in
	 * @param password	the Password of the customer trying to log in
	 * @return			a boolean that determines if the login was successful
	 */
	public static boolean login(String username, String password) {
		return login(username, password, false);
	}
	
	/**
	 * Determines if a user's credentials are correct and if so, sets a cookie variable.
	 * <p>
	 * Begin by loading the EntityManager to access the database. Start by trying to 
	 * find a row where where the CustomerID matches the given username. If we do have
	 * one (size() != 0) we then check if the given password matches the password we have
	 * stored. If it's a match, we create the cookie (see Day 5's State Tracking slides). If
	 * the rememberMe argument was true, we set the cookie to exist for a day. Otherwise the 
	 * cookie gets deleted at the end of the session (when the browser closes)
	 * 
	 * @param username		the customerID of the customer trying to log in
	 * @param password		the password of the customer trying to log in
	 * @param rememberMe 	whether or not to keep the cookie after the session
	 * @return				a boolean that determines if the login was successful
	 */
	public static boolean login(String username, String password, boolean rememberMe) {
		
	}
	
	/**
	 * Logs the user out by deleting the cookie. Setting the maxAge to 0 tells the browser
	 * to delete it.
	 */
	public static void logout() {
		
	}
}
