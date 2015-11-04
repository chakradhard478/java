package org.jnit.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="phoneInfo")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class PhoneInformation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int phoneId;
	private String home;
	private String work;
	private String cell;
	
	@OneToOne
	@JoinColumn(name="customerId")//indicates the phoneInformation entity is the owner of the relationship(because phone info table has the foreign key)
	private Customer customer;


	@Override
	public String toString() {
		return "PhoneInformation [phoneId=" + phoneId + ", home=" + home
				+ ", work=" + work + ", cell=" + cell + "]";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}
}
