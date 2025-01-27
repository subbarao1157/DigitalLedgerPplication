package com.example.DIgitalLedgerApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DIgitalLedgerApp.Models.DebtPayments;

@Repository
public interface PaymentRepository extends JpaRepository<DebtPayments, Integer> {

	DebtPayments findByRazorpayDebtId(String razorpayId);
	

}
