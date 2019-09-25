package com.hadialaoui.spring.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAOService {
  private static List<Customer> customers = new ArrayList<Customer>();
  private static int customerCount = 4;
  
  static {
	  customers.add(new Customer(1, "Ahmed", new Date()));
	  customers.add(new Customer(2, "Meryam", new Date()));
	  customers.add(new Customer(3, "Mourad", new Date()));
	  customers.add(new Customer(4, "Zakaria", new Date()));
  }
  
  public Customer findOne(Integer id) {
	 for (Customer customer : customers) {
		if(customer.getId() == id) {
			return customer;
		}
	}
	  return null;
  }
  
  public Customer delete(Integer id) {
	  for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext();) {
		Customer customer = (Customer) iterator.next();
		if(customer.getId() == id) {
			iterator.remove();
			return customer;
		}
		
	}
		  return null;
	  }
  
  public List<Customer> findAll(){
	  return customers;
  }
  
  public void save(Customer customer) {
	  if(customer.getId()==null)
	  customer.setId(++customerCount);
	  customers.add(customer);
  }
}
