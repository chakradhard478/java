package org.jnit.managedbean;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

@ManagedBean
public class Studentbean {

	private int sid;
	private String firstname;
	private String lastname;
	private String dob; // try to convert into Date and use calender component
	private String country;
	private String state;
	private String city;
	private String zipcode;

	public void savedata() {
		Session session = HibernateUtil.getsf().openSession();
		session.beginTransaction();
		
		Student stu = new Student(sid, firstname, lastname, dob, country, state, city, zipcode);

		session.save(stu);
		
		session.getTransaction().commit();
		session.close();

	}
	

	public void searchdata() {

	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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
