package com.example.DIgitalLedgerApp.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.Repos.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo cr;
	
	public void addCustomer(Customers cust) {
		cr.save(cust);
		
	}

}
