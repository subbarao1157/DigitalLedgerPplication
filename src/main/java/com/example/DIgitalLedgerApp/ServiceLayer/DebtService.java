package com.example.DIgitalLedgerApp.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DIgitalLedgerApp.Models.Debt;
import com.example.DIgitalLedgerApp.Repos.DebtRepo;

@Service
public class DebtService {
	
	@Autowired
	DebtRepo dr;

	public List<Debt> findByRetailerId(Long id) {
		// TODO Auto-generated method stub
		return dr.findByRetailerId(id);
	}

	public List<Debt> getDebtsByCustomerUsername(String username) {
		// TODO Auto-generated method stub
		return dr.findByCustomerUsername(username);
	}

}
