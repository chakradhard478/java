package org.jnit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="LOGIN")
@Entity
public class Login {
	
	@Id
	@Column(name="USER_NAME")
	private String userName;
	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Column(name="PASSWORD")
	private String password;
	
	private Login(){}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
