package com.training.domains;

import org.springframework.stereotype.Component;

@Component("service")
public class Service {

	private Customer customer;
	private Items items;
	private int serviceId;
	private String problemDescription;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	@Override
	public String toString() {
		return "Service [customer=" + customer + ", items=" + items + ", serviceId=" + serviceId
				+ ", problemDescription=" + problemDescription + "]";
	}
	public Service(Customer customer, Items items, int serviceId, String problemDescription) {
		super();
		this.customer = customer;
		this.items = items;
		this.serviceId = serviceId;
		this.problemDescription = problemDescription;
	}
	public Service() {
		super();
	}
	
}
