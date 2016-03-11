package com.training.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import com.training.domains.Service;
import com.training.ifaces.MyDAO;
import com.training.utils.ServiceRowMapper;

public class ServicedaoImplementation extends JdbcDaoSupport implements MyDAO<Service> {

	@Override
	public Service find(int key) {
		//String sql = "SELECT s.customerid,s.serviceid,s.itemid,c.customername,c.phonenumber,i.itemtype,i.itemname,s.problemdescription FROM SERVICE2016 S,CUSTOMER2016 C,ITEMS2016 I WHERE S.CUSTOMERID = C.CUSTOMERID AND S.ITEMID = I.ITEMID";
		String sql = "SELECT * from service2016 where serviceid=?";
		Service service = getJdbcTemplate().queryForObject(sql,new ServiceRowMapper(),key);
		return service;
	}

	@Override
	public boolean add(Service t) {
		boolean result = false;
		String sql = "INSERT INTO SERVICE2016 VALUES(?,?,?,?)";
		int rowInserted = getJdbcTemplate().update(sql,t.getServiceId(),t.getCustomer().getCustomerId(),t.getItems().getItemId(),t.getProblemDescription());
		if(rowInserted>0)
		{
			result = true;
		}
		return result;
	}

	@Override
	public List<Service> findAll() {
		String sql = "SELECT * FROM SERVICE2016";
		List<Service> service = getJdbcTemplate().query(sql,new ServiceRowMapper());
		return service;
	}

}
