package com.training.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.training.domains.Items;
import com.training.domains.Service;
import com.training.ifaces.MyDAO;

public class ServicedaoImplementation extends JdbcDaoSupport implements MyDAO<Service> {

	@Override
	public Service find(int key) {
		String sql = "SELECT * FROM SERVICE2016 WHERE  SERVICEID= ?";
		Service service = getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper<Service>(Service.class),key);
		return service;
	}

	@Override
	public boolean add(Service t) {
		boolean result = false;
		String sql = "INSERT INTO SERVICE2016 VALUES(?,?,?,?,?,?,?)";
		int rowInserted = getJdbcTemplate().update(sql,t.getServiceId(),t.getCustomer().getCustomerId(),t.getCustomer().getCustomerName(),t.getItems().getItemId(),t.getItems().getItemName(),t.getItems().getItemType(),t.getProblemDescription());
		if(rowInserted>0)
		{
			result = true;
		}
		return result;
	}

	@Override
	public List<Service> findAll() {
		String sql = "SELECT * FROM SERVICE2016";
		List<Service> service = getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Service>(Service.class));
		return service;
	}

}
