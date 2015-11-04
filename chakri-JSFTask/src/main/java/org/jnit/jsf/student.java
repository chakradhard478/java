package org.jnit.jsf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Details")
public class student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( name= "Student ID", unique= true, nullable= false)
	private int Sid;
	@Column(name = "Student First Name")
	private String studentfirstname;
	@Column(name = "Student Last Name")
	private String studentlastname;
	@Column(name = "Home Country")
	private String homecountry;
	@Column(name = "Current City")
	private String currentcity;
	@Column(name = "Zip-Code")
	private String zipcode;
	
	
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
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
	
}
