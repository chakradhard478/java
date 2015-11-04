package org.jnit.managedbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="login")
public class LoginBean {

	private String userName;
	private String password;
	private Date dob;
	private String state;
	private boolean active;
	private String gender;
	
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
	
	public String actionLogin(){
//		System.out.println(userName);
//		System.out.println(password);
//		System.out.println(dob);
//		System.out.println(state);
//		System.out.println(active);
//		System.out.println(gender);
		if(password.equals("admin123")){
			//return "success?faces-redirect=true";//explicit navigation
			return "success";//implicit navigation
		}else{
			return "login?faces-redirect=true";//explicit navigation
		}
	}
	
	public void actionClear(){
		setUserName(null);
		setPassword(null);
	}

}
