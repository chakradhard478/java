package org.jnit.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="enrollment")
@SessionScoped
public class EnrollmentBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private Date dob;
	private String state;
	private boolean active;
	private String gender;
	private String email;
	private String creditCard;
	private static Map<String,String> countries;
	
	private String localeCode = "en"; 
	
	static{
		countries = new LinkedHashMap<String,String>();
		countries.put("United Kingdom", "en"); //label, value
		countries.put("French", "fr");
		countries.put("German", "de");
		countries.put("China", "zh_CN");
	}
	
	public Map<String,String> getCountryInMap() {
		return countries;
	}
	
	public void countryLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		setLocaleCode(e.getNewValue().toString());
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCreditCard() {
		return creditCard;
	}
	
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
	
	public void actionEnroll(){
		System.out.println(userName);
		System.out.println(password);
		System.out.println(dob);
		System.out.println(state);
		System.out.println(active);
		System.out.println(gender);
		System.out.println(email);
		System.out.println(creditCard);
	}
	
	public void executeBeforeAction(ActionEvent ae){
		System.out.println("Executing before action...");
	}

}


