package com.example.DIgitalLedgerApp.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.Customers;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Long>{

	Customers getByUsername(String username);

	Customers getByMobileNumber(String searchQuery);

	Optional<Customers> getByEmail(String email);

}
