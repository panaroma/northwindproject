package com.northwindx.model.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employees")
public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "EmployeeID")
	private Integer EmployeeID;
	@Basic(optional = false)
	@Column(name = "LastName")
	private String LastName;
	@Basic(optional = false)
	@Column(name = "FirstName")
	private String FirstName;
	@Column(name = "Title")
	private String Title;
	@Column(name = "TitleOfCourtesy")
	private String TitleOfCourtesy;
	@Column(name = "BirthDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date BirthDate;
	@Column(name = "HireDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date HireDate;
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
	@Column(name = "HomePhone")
	private String HomePhone;
	@Column(name = "Extension")
	private String Extension;
	@Lob
	@Column(name = "Photo")
	private byte[] Photo;
	@Lob
	@Column(name = "Notes")
	private String Notes;
	@Column(name = "ReportsTo")
	private Integer ReportsTo;
	@Column(name = "PhotoPath")
	private String PhotoPath;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Employee")
	private Collection<Orders> Order;
	
	public Employees() {}
	
	public Employees(Integer employeeID) {
		this.EmployeeID = employeeID;
	}
	
	public Employees(Integer employeeID, String lastName, String firstName) {
		this.EmployeeID = employeeID;
		this.LastName = lastName;
		this.FirstName = firstName;
	}
	
	public Integer getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getTitleOfCourtesy() {
		return TitleOfCourtesy;
	}
	public void setTitleOfCourtesy(String titleOfCourtesy) {
		TitleOfCourtesy = titleOfCourtesy;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	public Date getHireDate() {
		return HireDate;
	}
	public void setHireDate(Date hireDate) {
		HireDate = hireDate;
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
	public String getHomePhone() {
		return HomePhone;
	}
	public void setHomePhone(String homePhone) {
		HomePhone = homePhone;
	}
	public String getExtension() {
		return Extension;
	}
	public void setExtension(String extension) {
		Extension = extension;
	}
	public byte[] getPhoto() {
		return Photo;
	}
	public void setPhoto(byte[] photo) {
		Photo = photo;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public Integer getReportsTo() {
		return ReportsTo;
	}
	public void setReportsTo(Integer reportsTo) {
		ReportsTo = reportsTo;
	}
	public String getPhotoPath() {
		return PhotoPath;
	}
	public void setPhotoPath(String photoPath) {
		PhotoPath = photoPath;
	}
	public Collection<Orders> getOrder() {
		return Order;
	}
	public void setOrder(Collection<Orders> order) {
		Order = order;
	}
	
	@Override
	public int hashCode() {
	  int hash = 0;
	  hash += (EmployeeID != null
	      ? EmployeeID.hashCode() : 0);
	  return hash;
	}

	@Override
	public boolean equals(Object object) {
	  if (!(object instanceof Employees)) {
	    return false;
	  }
	  Employees other = (Employees) object;
	  if ((this.EmployeeID == null && other.EmployeeID != null)
	      || (this.EmployeeID != null && !this.EmployeeID
	          .equals(other.EmployeeID))) {
	    return false;
	  }
	  return true;
	}

	@Override
	public String toString() {
	  return "com.northwindx.model.jpa.Employees[employeeID="
	      + EmployeeID + "]";
	}
}
