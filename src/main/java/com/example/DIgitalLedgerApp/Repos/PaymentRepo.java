package com.example.DIgitalLedgerApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.PaymentEntity;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity , Long>{
	

}
