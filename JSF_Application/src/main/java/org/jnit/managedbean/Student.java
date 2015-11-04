package org.jnit.managedbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_Details")
public class Student {

	@Id
	@Column(unique=true, nullable=false)
	private int sid;
	@Column(nullable=false)
	private String firstname;
	@Column(nullable=false)
	private String lastname;
	@Column(nullable=false)
	private String dob;  // try to convert into Date and use calender component
	@Column(nullable=false)
	private String country;
	@Column(nullable=false)
	private String state;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String zipcode;
	
	
	public Student(int sid, String firstname, String lastname, String dob, String country, String state, String city,
			String zipcode) {
		super();
		this.sid = sid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.country = country;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
