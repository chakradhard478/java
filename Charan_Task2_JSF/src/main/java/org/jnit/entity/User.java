package org.jnit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="FIRST_NAME")
	String firstname;
	@Column(name="LAST_NAME")
	String lastname;
	@Column(name="DOB")
	Date dob;
	@Column(name="ADDRESS")
	String address;
	@Column(name="STATE")
	String state;
	@Column(name="CITY")
	String city;
	@Column(name="ZIPCODE")
	int zipcode;
	
	public User(){}
	
	public User(String firstname, String lastname, Date dob, String address,
			String state, String city, int zipcode) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
