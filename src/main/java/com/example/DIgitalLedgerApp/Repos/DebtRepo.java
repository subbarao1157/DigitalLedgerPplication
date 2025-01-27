package com.example.DIgitalLedgerApp.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.Debt;


@Repository
public interface DebtRepo extends JpaRepository<Debt, Long>{

	List<Debt> findByRetailerId(Long id);

	List<Debt> findByCustomerUsername(String username);

	Debt getById(Debt debt);



}
