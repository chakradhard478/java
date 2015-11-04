package org.chakri.java.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 						// (name="USER_DETAILS") // Different name for entity
@Table(name = "USER_DETAILS")	// Different name for the table
public class UserDetails 
{
	@Id @GeneratedValue
	private int userid;
	
	private String username;
	
//	@Temporal(TemporalType.DATE)		// Hibernate just saves the date not the time stamp
//	private Date joinedDate;
//	
//	private String address;
//	@Lob
//	private String description;
	
	
	@Id
//	@Column(name= "USER_ID")
	public int getUserid() {
		return userid;
	}
//	public Date getJoinedDate() {
//		return joinedDate;
//	}
//	public void setJoinedDate(Date joinedDate) {
//		this.joinedDate = joinedDate;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
//	@Column (name = "USER_NAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
