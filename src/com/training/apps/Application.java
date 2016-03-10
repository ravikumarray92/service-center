package com.training.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.daos.CustomerdaoImplementation;
import com.training.daos.ItemsdaoImplementation;
import com.training.daos.ServicedaoImplementation;
import com.training.domains.Customer;
import com.training.domains.Items;
import com.training.domains.Service;



public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		
		CustomerdaoImplementation obj1 = ctx.getBean("customerdao",CustomerdaoImplementation.class);
		ItemsdaoImplementation obj2 = ctx.getBean("itemsdao",ItemsdaoImplementation.class);
		ServicedaoImplementation obj3 = ctx.getBean("servicedao",ServicedaoImplementation.class);
		
		Customer cstmr = ctx.getBean(Customer.class);
		Items myitems = ctx.getBean("items",Items.class);
		Service myservices = ctx.getBean("service",Service.class);
		
		cstmr.setCustomerId(203);
		cstmr.setCustomerName("Rajesh");
		cstmr.setPhoneNumber(555555l);
		//boolean result1 = obj1.add(cstmr);
		//System.out.println("Added Into Customer2016 Table = "+ result1);
		
		
		myitems.setItemId(103);
		myitems.setItemType("TV");
		myitems.setItemName("Sony");
		//boolean result2 = obj2.add(myitems);
		//System.out.println("Added Into Items2016 Table = "+ result2);
		
		myservices.setCustomer(cstmr);
		myservices.setItems(myitems);
		myservices.setProblemDescription("Screen Not Working");
		myservices.setServiceId(101);
		boolean result3 = obj3.add(myservices);
		System.out.println("Added Into Services2016 Table = "+ result3);
		
		
	}

}
