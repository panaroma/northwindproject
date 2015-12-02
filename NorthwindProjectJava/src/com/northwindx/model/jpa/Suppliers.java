package com.northwindx.model.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Suppliers")
public class Suppliers implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "SupplierID")
	private Integer SupplierID;
	@Basic(optional = false)
	@Column(name = "CompanyName")
	private String CompanyName;
	@Column(name = "ContactName")
	private String ContactName;
	@Column(name = "ContactTitle")
	private String ContactTitle;
	@Column(name = "Address")
	private String Address;
	@Column(name = "City")
	private String City;
	@Column(name = "Region")
	private String Region;
	@Column(name = "PostalCode")
	private String PostalCode;
	@Column(name = "Country")
	private String Country;
	@Column(name = "Phone")
	private String Phone;
	@Column(name = "Fax")
	private String Fax;
	@OneToMany(mappedBy = "Supplier")
	private Collection<Products> Products;
	
	public Suppliers() {}
	
	public Suppliers(Integer supplierID) {
		this.SupplierID = supplierID;
	}
	
	public Suppliers(Integer supplierID, String companyName) {
		this.SupplierID = supplierID;
		this.CompanyName = companyName;
	}
	
	public Integer getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(Integer supplierID) {
		SupplierID = supplierID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getContactTitle() {
		return ContactTitle;
	}
	public void setContactTitle(String contactTitle) {
		ContactTitle = contactTitle;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getFax() {
		return Fax;
	}
	public void setFax(String fax) {
		Fax = fax;
	}
	public Collection<Products> getProducts() {
		return Products;
	}
	public void setProducts(Collection<Products> products) {
		Products = products;
	}
	
	@Override
	public int hashCode() {
	  int hash = 0;
	  hash += (SupplierID != null
	      ? SupplierID.hashCode() : 0);
	  return hash;
	}

	@Override
	public boolean equals(Object object) {
	  if (!(object instanceof Suppliers)) {
	    return false;
	  }
	  Suppliers other = (Suppliers) object;
	  if ((this.SupplierID == null && other.SupplierID != null)
	      || (this.SupplierID != null && !this.SupplierID
	          .equals(other.SupplierID))) {
	    return false;
	  }
	  return true;
	}

	@Override
	public String toString() {
	  return "com.northwindx.model.jpa.Suppliers[supplierID="
	      + SupplierID + "]";
	}
}
