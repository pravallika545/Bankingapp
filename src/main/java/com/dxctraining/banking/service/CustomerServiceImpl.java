package com.dxctraining.bankingapp.service;

import java.util.*;
import com.dxctraining.bankingapp.dao.*;
import com.dxctraining.bankingapp.entities.*;
import com.dxctraining.bankingapp.exceptions.*;

import com.dxctraining.bankingapp.entities.Customer;

public class CustomerServiceImpl implements ICustomerService {
	
	private ICustomerDao dao = new CustomerDaoImpl();

	@Override
	public Customer findById(int id) {
		
		checkId(id);
		Customer customer = dao.findById(id);
		return customer;
	}
	

	private void checkId(int id) {
		
		if(id<1) {
			throw new InvalidCustomerArgumentException("id cant be negative, id passed="+id);
		}

	}


	@Override
	public List<Customer> findAll() {
		List<Customer> list =dao.findAll();
		return list;
	}

	@Override
	public Customer updateName(int id, String newName) {
		checkId(id);
		checkName(newName);
		Customer customer = dao.updateName(id, newName);
		return customer;
	}

	private void checkName(String name) {
		
		if(name==null||name.isEmpty()) {
			throw new InvalidCustomerArgumentException("name can't be null or empty");

		}
		
	}

	private void checkCustomer(Customer customer) {
		
		if(customer==null) {
			throw new InvalidCustomerArgumentException("Customer can't be null or empty");
		}
		
	}
	
	@Override
	public void add(Customer customer) {
		
		checkCustomer(customer);
		dao.add(customer);
	}

	@Override
	public Customer update(Customer customer) {
		
		checkCustomer(customer);
		customer=dao.Update(customer);
		return customer;
	}

	@Override
	public void delete(int id) {
		checkId(id);
		dao.delete(id);	
		
	}


	
	
}
