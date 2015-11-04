package org.jnit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
//OnetoOne
//OnetoMany
//ManyToMany - Task(many) and Reviewer(many)









import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findCustomerByCity",
	query = "select * from customer c where c.city = :city",
        resultClass = Customer.class
	),
	@NamedNativeQuery(
			name = "callFetchCustomers",
			query = "call fetchCustomers(:customerId)",
		        resultClass = Customer.class
	)
})
@Entity
@Table(name = "customer")
@Cacheable// enables caching for your customer objects
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
//ReadOnly -app only reads customer entities and not updates it
//Transactional - strictly transactional
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// GenerationType.Identity= hibernate uses database identity column to generate primary key
	// GenerationType.Auto = hibernate makes the decision on how to generate the primary key based on database type(recommended)
	// GenerationType.Table = hibernate will maintain a separates database table
	// for primary keys(keeps track of last used primary key)
	// GenerationType.Sequence(seqhilo) = hibernate uses a sequence object to get the primary key, calls next_val to get the next value
	private int customerId;

	//@Column(name="customerName")
	private String name;
	
	private String city;
	private String street;
	private String state;
	private String country;
	private String zipCode;

	// mapped by here tells hibernate where to find the configuration for the join column(the key/owner of the relationship is on the otherside)
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", optional=true)//optional here tells hibernate that association is optional
	//@NotFound(action = NotFoundAction.IGNORE)//if not found just ignore
	//cascade is a important attribute which tells what needs to happen when the customer is removed(do we need to keep phone info or remove it)
	//without cascade the reference objects also has to be saved with session.save
	//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private PhoneInformation phoneInfo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	@OrderColumn(name = "idx")
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<Order> ordersPlaced = new ArrayList<Order>();

	public List<Order> getOrdersPlaced() {
		return ordersPlaced;
	}

	public void setOrdersPlaced(List<Order> ordersPlaced) {
		this.ordersPlaced = ordersPlaced;
	}

	public PhoneInformation getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(PhoneInformation phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name
				+ ", city=" + city + ", street=" + street + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode
				+ ", phoneInfo=" + phoneInfo + "]";
	}
	



}
