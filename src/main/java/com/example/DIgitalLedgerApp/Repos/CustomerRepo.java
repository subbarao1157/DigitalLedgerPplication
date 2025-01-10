package com.example.DIgitalLedgerApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.Customers;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Long>{

	Customers getByUsername(String username);

}
