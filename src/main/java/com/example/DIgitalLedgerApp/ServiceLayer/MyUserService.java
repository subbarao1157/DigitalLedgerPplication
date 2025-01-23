package com.example.DIgitalLedgerApp.ServiceLayer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.DIgitalLedgerApp.Models.Customers;
//import com.example.DIgitalLedgerApp.Models.LoggingUsers;
//import com.example.DIgitalLedgerApp.Repos.CustomerRepo;
//import com.example.DIgitalLedgerApp.Repos.LoggingUsersRepo;
//
//@Service
//public class MyUserService implements UserDetailsService{
//	
//	@Autowired
//	LoggingUsersRepo lur;
//	
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	    LoggingUsers cust = lur.getByUsername(username);
//	    
//	    if (cust == null) {
//	        throw new UsernameNotFoundException("User not found with username: " + username);
//	    }
//	    
//	    return org.springframework.security.core.userdetails.User.builder()
//	            .username(cust.getUsername())
//	            .password(cust.getPassword()) // Make sure passwords are encrypted
//	            .build();
//	}
//}









import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.DIgitalLedgerApp.Models.LoggingUsers;
import com.example.DIgitalLedgerApp.Repos.LoggingUsersRepo;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private LoggingUsersRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user by username
        LoggingUsers appUser = userRepository.getByUsername(username);
        
        if (appUser == null) {
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }

        // Map role to GrantedAuthority
        GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRole());
        
        

        // Return UserDetails object with user name, password, and authorities
        return new User(appUser.getUsername(), appUser.getPassword(), List.of(authority));
    }
}
