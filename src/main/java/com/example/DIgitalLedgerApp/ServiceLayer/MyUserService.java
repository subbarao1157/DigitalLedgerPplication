package com.example.DIgitalLedgerApp.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.Repos.CustomerRepo;

@Service
public class MyUserService implements UserDetailsService{
	
	@Autowired
	CustomerRepo cr;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Customers cust = cr.getByUsername(username);
	    
	    if (cust == null) {
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }
	    
	    return org.springframework.security.core.userdetails.User.builder()
	            .username(cust.getUsername())
	            .password(cust.getPassword()) // Make sure passwords are encrypted
	            .build();
	}

	
	

}
