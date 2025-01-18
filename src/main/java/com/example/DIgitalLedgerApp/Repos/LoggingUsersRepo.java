package com.example.DIgitalLedgerApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.LoggingUsers;

@Repository
public interface LoggingUsersRepo extends JpaRepository<LoggingUsers, Long>{

	LoggingUsers getByUsername(String username);
	
}
