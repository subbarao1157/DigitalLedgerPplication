package com.example.DIgitalLedgerApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.Debt;


@Repository
public interface DebtRepo extends JpaRepository<Debt, Long>{

}
