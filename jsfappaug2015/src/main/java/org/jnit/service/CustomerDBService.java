package org.jnit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.jnit.model.Customer;
import org.jnit.utilities.DBConnectionUtility;

public class CustomerDBService {

	public int saveCustomerToDB(Customer customer) {
		try(Connection conn = DBConnectionUtility.getConnection();) {			
			PreparedStatement pstmt = conn
					.prepareStatement("insert into customer(name,street,city,state,country,zipCode) values(?,?,?,?,?,?)");
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getStreet());
			pstmt.setString(3, customer.getCity());
			pstmt.setString(4, customer.getState());
			pstmt.setString(5, customer.getCountry());
			pstmt.setString(6, customer.getZipCode());
			return pstmt.executeUpdate();			

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"An error occured saving customer to db", e);
		}

	}
	
	public List<Customer>findCustomersByCity(String city){
		List<Customer>customers = new ArrayList<Customer>();
		Connection conn;
		try {
			conn = DBConnectionUtility.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from customer where city = ?");
			pstmt.setString(1, city);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setName(rs.getString("name"));
				c.setStreet(rs.getString("street"));
				customers.add(c);
			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
				
		return customers;
	}

}
