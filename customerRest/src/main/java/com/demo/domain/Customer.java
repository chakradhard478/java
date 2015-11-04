package com.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer", catalog = "productDb")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customerId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerId;
	private String name;
	private String city;
	private String state;

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name
				+ ", city=" + city + ", state=" + state + "]";
	}

}
