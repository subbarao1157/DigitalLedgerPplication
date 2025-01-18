package com.example.DIgitalLedgerApp.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DIgitalLedgerApp.Models.LoggingUsers;
import com.example.DIgitalLedgerApp.Repos.LoggingUsersRepo;

@Service
public class LoggingUserService {
	
	@Autowired
	LoggingUsersRepo lur;

	public void addLoggingUser(LoggingUsers lu) {
		// TODO Auto-generated method stub
		lur.save(lu);
	}
	
	

}
