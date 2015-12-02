package com.northwindx.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.northwindx.model.jpa.Products;

@ManagedBean
@RequestScoped
public class SpecialDealsBean {

	private List <Products> ProductsList = new ArrayList<>();

	public SpecialDealsBean() {

		// To retrieve the data from the Northwind database and display the Special deals in two rows of 3 products in each row
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String connectionURL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Northwind;";
			Properties connectionProps = new Properties();
			connectionProps.setProperty("user","sa");
			connectionProps.setProperty("password","P@ssword");
			Connection conn = DriverManager.getConnection(connectionURL, connectionProps);

			Statement stmt = null;
			// Query to get the top 6 products with the most stock (UnitsInStock) from the database.
			String query = "SELECT TOP (6) * FROM Products ORDER BY UnitsInStock";

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query); 

			Products product;

			while(rs.next()) {

				product = new Products();

				product.setProductID(rs.getInt("ProductID"));
				product.setProductName(rs.getString("ProductName"));
				product.setSupplierID(rs.getInt("SupplierID"));
				product.setCategoryID(rs.getInt("CategoryID"));
				product.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
				product.setUnitPrice(rs.getBigDecimal("UnitPrice"));
				product.setUnitsInStock(rs.getShort("UnitsInStock"));
				product.setUnitsOnOrder(rs.getShort("UnitsOnOrder"));
				product.setReorderLevel(rs.getShort("ReorderLevel"));
				product.setDiscontinued(rs.getBoolean("Discontinued"));

				ProductsList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Products> getProductsList() {
		return ProductsList;
	}

	public void setProductsList(List<Products> productsList) {
		ProductsList = productsList;
	}
}