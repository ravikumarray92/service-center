package com.training.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.training.domains.Customer;

import com.training.ifaces.MyDAO;


public class CustomerdaoImplementation extends JdbcDaoSupport implements MyDAO<Customer> {

	@Override
	public Customer find(int key) {
		String sql = "SELECT * FROM CUSTOMER2016 WHERE  CUSTOMERID= ?";
		Customer cust = getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper<Customer>(Customer.class),key);
		return cust;
	}

	@Override
	public boolean add(Customer t) {
		boolean result = false;
		String sql = "INSERT INTO CUSTOMER2016 VALUES(?,?,?)";
		int rowInserted = getJdbcTemplate().update(sql,t.getCustomerId(),t.getCustomerName(),t.getPhoneNumber());
		if(rowInserted>0)
		{
			result = true;
		}
		return result;
	}

	@Override
	public List<Customer> findAll() {
		String sql = "SELECT * FROM CUSTOMER2016";
		List<Customer> invList = getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Customer>(Customer.class));
		return invList;
	}

	

}
