package com.training.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.domains.Customer;


public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowCount) throws SQLException {
		Customer cust = new Customer();
		cust.setCustomerId(rs.getInt(1));
		cust.setCustomerName(rs.getString(2));
		cust.setPhoneNumber(rs.getLong(3));
		return cust;
	}

}
