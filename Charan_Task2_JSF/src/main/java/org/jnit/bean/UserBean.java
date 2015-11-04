package org.jnit.bean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.jnit.dao.UserDAO;
import org.jnit.entity.User;

@ManagedBean
public class UserBean {
	
	private String firstname;
	private String lastname;
	private Date dob;
	private String address;
	private String state;
	private String city;
	private int zipcode;
	
	
	
	

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

	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserBean() {
	}

	

	
	public String saveUser() {

		UserDAO userDao = new UserDAO();
		User user =new User(firstname,lastname,dob,address,state,city,zipcode);
		userDao.save(user);
		System.out.println("User successfully saved.");
		return "output";

	}

	public List<User> retreive() {
		UserDAO userDao = new UserDAO();
		return userDao.getallUsers();
	}
	
	public void search(){
		UserDAO userDao = new UserDAO();
		users = userDao.searchByCity(city);
		
	}
	
	public void updateInfo(){
		UserDAO userDao = new UserDAO();
		User user =new User(firstname,lastname,dob,address,state,city,zipcode);
		userDao.updateUser(user);
		
		}
	
	public String delete(){
		UserDAO userDao = new UserDAO();
		User user =new User(firstname,null,null,null,null,null,0);
		userDao.deleteUser(user);
		return "deletedUser";
		
		
		
	}
	

}
