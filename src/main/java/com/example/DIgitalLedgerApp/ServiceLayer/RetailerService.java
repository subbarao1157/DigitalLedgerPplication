package com.example.DIgitalLedgerApp.ServiceLayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.Models.Debt;
import com.example.DIgitalLedgerApp.Models.Retailer;
import com.example.DIgitalLedgerApp.Repos.CustomerRepo;
import com.example.DIgitalLedgerApp.Repos.DebtRepo;
import com.example.DIgitalLedgerApp.Repos.RetailerRepo;

@Service
public class RetailerService {
	
	@Autowired
	RetailerRepo rr;
	
	@Autowired
	CustomerRepo cr;
	
	@Autowired
	DebtRepo dr;
	
	public void addRetailer(Retailer retailer) {
		rr.save(retailer);
		
	}

	public Retailer getByUsername(String username) {
		// TODO Auto-generated method stub
		return rr.getByName(username).get();
	}
	
	public boolean verifyPasskey(String number,String userpass,double amount,String retailername,String purchased) {
		Customers cust=cr.getByMobileNumber(number);
		Retailer ret=rr.getByName(retailername).get();
		if(cust!=null  && ret!=null) {
			if( cust.getPasskey().equals(userpass)) {
				Debt debt=new Debt();
				debt.setAmount(amount);
				debt.setPurchaseditems(purchased);
				debt.setCustomer(cust);
				debt.setRetailer(ret);
				dr.save(debt);
				return true;
			}
		}
		return false;
	}

	public Long getIdByusername(String name) {
		// TODO Auto-generated method stub
		
		Retailer ret=rr.getByName(name).get();
		if(ret==null) {
			return (long) 0;
		}
		return ret.getId();
	}

	
	

}
