package org.jnit.jsf;

import javax.faces.bean.ManagedBean;


import org.hibernate.Session;

@ManagedBean

public class Details{
	
	private String studentfirstname;
	private String studentlastname;
	private String homecountry;
	private String currentcity;
	private String zipcode;
	
	public String pagenavg1(){
		return "FirstPage";
	}
	
	public String pagenavg2(){
		return "search";
	}
	
	public String getStudentfirstname() {
		return studentfirstname;
	}
	public void setStudentfirstname(String studentfirstname) {
		this.studentfirstname = studentfirstname;
	}
	public String getStudentlastname() {
		return studentlastname;
	}
	public void setStudentlastname(String studentlastname) {
		this.studentlastname = studentlastname;
	}
	public String getHomecountry() {
		return homecountry;
	}
	public void setHomecountry(String homecountry) {
		this.homecountry = homecountry;
	}
	public String getCurrentcity() {
		return currentcity;
	}
	public void setCurrentcity(String currentcity) {
		this.currentcity = currentcity;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public void savedata(){
		  Session s= HibernateUtil.getsf().openSession();
		  s.beginTransaction();
		  
		  Details d = new Details();
		  d.setStudentlastname(this.getStudentlastname());
		  d.setStudentfirstname(this.getStudentfirstname());
		  d.setHomecountry(this.getHomecountry());
		  d.setCurrentcity(this.getCurrentcity());
		  d.setZipcode(this.getZipcode());
		  
		  s.save(d);
		  s.getTransaction().commit();
		  s.close();
		  
	}
	
	
}
