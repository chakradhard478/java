package com.demo.jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.domain.Customer;
import com.demo.hibernateDao.CustomerDao;

@Component
@Path("customer")
public class CustomerResource {

	@Autowired
	private CustomerDao customerDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId("1234");
		customer.setName("Peter");
		return customer;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Customer> getAllCustomer() {
		return customerDao.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getbyId/{customerId}")
	public Customer getCustbyId(
			@PathParam(value = "customerId") String customerId) {
		return customerDao.get(customerId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getbyCity/{city}")
	public List<Customer> getCustbyCity(@PathParam(value = "city") String city) {
		return customerDao.getbyCity(city);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delCust")
	public Response deleteCustomer(
			@QueryParam(value = "customerId") String customerId) {
		// Customer customer=new Customer();
		// customer.setCustomerId(customerId);
		// customerDao.deleteCust(customerId); this blocked code also work by
		// unblocking delete method from customerDao
		try {
			// customerDao.deleteCust(customerId);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();

		}

		return Response.status(Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateCust")
	public Response updateCustomer(Customer customer) {
		// customer.setCustomerId(customerId);
		try {
			customerDao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.OK).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertCust")
	public Response insertCustomer(Customer customer) {

		try {
			customerDao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.OK).build();

	}

}
