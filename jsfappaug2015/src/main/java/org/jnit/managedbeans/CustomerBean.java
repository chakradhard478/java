package org.jnit.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jnit.model.Customer;
import org.jnit.service.CustomerDBService;

@ManagedBean
@SessionScoped//request(default-one instance per every request),viewscope(one instance per view),session scope(one instance per Httpsession), applicationscope(one single instance per application)
public class CustomerBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Customer> customers;
	private String city;

	private CustomerDBService customerService = new CustomerDBService();

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void searchCustomersByCity() {
		if (city != null && city.length() > 0) {
			List<Customer> customers = customerService
					.findCustomersByCity(getCity());
			setCustomers(customers);
		}
	}

}
