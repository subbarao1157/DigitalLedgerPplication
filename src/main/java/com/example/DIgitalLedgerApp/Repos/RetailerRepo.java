package com.example.DIgitalLedgerApp.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.Retailer;

@Repository
public interface RetailerRepo extends JpaRepository<Retailer, Long>{

	Optional<Retailer> getByName(String username);

}
