package org.jnit.bean;

import javax.faces.bean.ManagedBean;

import org.jnit.dao.LoginDAO;

@ManagedBean
public class LoginBean {

	private String userName;
	private String password;
	
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
	
	public String validate(){
		  LoginDAO dao = new LoginDAO();
		  boolean token = dao.loginValidator(userName, password);
		  if(token){
		   return "loginSuccess";
		  }
		  else{
		   return "loginFailed";
		  }
	
	
	
	
	}
}
