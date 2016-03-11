package com.training.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.training.daos.CustomerdaoImplementation;
import com.training.daos.ItemsdaoImplementation;
import com.training.domains.Customer;
import com.training.domains.Items;
import com.training.domains.Service;



public class ServiceRowMapper implements RowMapper<Service> {
	@Override
	public Service mapRow(ResultSet rs, int rowCount) throws SQLException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		CustomerdaoImplementation cdao1=ctx.getBean(CustomerdaoImplementation.class);
		ItemsdaoImplementation idao1=ctx.getBean(ItemsdaoImplementation.class);
		
		Service s = new Service();
		
		Customer customer = cdao1.find(rs.getInt("customerid"));
		
		Items item = idao1.find(rs.getInt("itemid"));
				
		
		
		
		s.setServiceId(rs.getInt("serviceid"));
		
		
		
		
	
		s.setCustomer(customer);
	    s.setItems(item);
		s.setProblemDescription(rs.getString("problemdescription"));
		return s;
		
}
}