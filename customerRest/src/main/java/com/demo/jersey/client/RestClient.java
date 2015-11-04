package com.demo.jersey.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.demo.domain.Customer;
import com.google.gson.Gson;

public class RestClient {

	private Gson gson = new Gson();

	public void getCustomer() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/customerRest/services/customer");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String output = response.readEntity(String.class);

		Customer customer = gson.fromJson(output, Customer.class);
		System.out.println(customer);
	}

	public void getAllCustomers() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/customerRest/services/customer/All");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String output = response.readEntity(String.class);
		List<Customer> customers = gson.fromJson(output, ArrayList.class);
		System.out.println(customers);
	}

	public void getCustomerById() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/customerRest/services/customer/getbyId/2");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String output = response.readEntity(String.class);

		Customer customer = gson.fromJson(output, Customer.class);
		System.out.println(customer);
	}

	public void getCustomersByCity() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/customerRest/services/customer/getbyCity/denton");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String output = response.readEntity(String.class);
		List<Customer> customers = gson.fromJson(output, ArrayList.class);
		System.out.println(customers);
	}

	public void deleteCustomer() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/customerRest/services/customer/delCust?customerId=");
		Response response = target.request(MediaType.APPLICATION_JSON).delete();
		System.out.println(response.getStatus());
		System.out.println(response.toString());
	}

	public void insertCustomer() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/customerRest/services/customer/insertCust");
		Customer customer = new Customer();
		customer.setCity("Parlin");
		customer.setName("Ravi");
		customer.setState("NJ");
		String customerJson = gson.toJson(customer);
		Response response = target.request(MediaType.APPLICATION_JSON).post(
				Entity.entity(customerJson, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.toString());

	}

	public void updateCustomer() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/customerRest/services/customer/updateCust");
		Customer customer = new Customer();
		customer.setCustomerId("9");// Existing Id
		customer.setCity("Parlin");
		customer.setName("Raj");
		customer.setState("NJ");
		String customerJson = gson.toJson(customer);
		Response response = target.request(MediaType.APPLICATION_JSON).put(
				Entity.entity(customerJson, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.toString());

	}

	public static void main(String[] args) {
		RestClient rc = new RestClient();
		// rc.getCustomer();
		// rc.getAllCustomers();
		// rc.getCustomerById();
		// rc.getCustomersByCity();		
		// rc.deleteCustomer();
		// rc.insertCustomer();
		rc.updateCustomer();
	}

}
