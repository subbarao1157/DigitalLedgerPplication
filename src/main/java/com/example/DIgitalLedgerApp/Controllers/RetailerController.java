package com.example.DIgitalLedgerApp.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.Models.Debt;
import com.example.DIgitalLedgerApp.Models.Retailer;
import com.example.DIgitalLedgerApp.Repos.CustomerRepo;
import com.example.DIgitalLedgerApp.ServiceLayer.CustomerService;
import com.example.DIgitalLedgerApp.ServiceLayer.DebtService;
import com.example.DIgitalLedgerApp.ServiceLayer.RetailerService;

@Controller
@RequestMapping("/retailer")
public class RetailerController {
	
	@Autowired
	RetailerService rs;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	CustomerRepo cr;
	
	@Autowired
	DebtService ds;
	
	
	@GetMapping("/")
	public String home() {
		return "RetailerHome";
	}
	
	@GetMapping("/profile")
	public String profile(Model model, Principal principal) {
		String username=principal.getName().toString();
		Retailer retailer=rs.getByUsername(username);
		model.addAttribute("Retailer", retailer);	
		return "RetailerProfile";
	}
	
	@GetMapping("/addDebt")
	public String adddebt() {	
		return "searchcustomer";
	}
	
	public static String generateRandomNumber() {
		int a=1000 + (int)(Math.random() * 9000);
		String b=String.valueOf(a);
	    return b;
	}

	
    @PostMapping("/submit")
	public String handleSubmit(@RequestParam("searchQuery") String searchQuery, Model model) {
	          
    	Customers cust=cs.getByMobile(searchQuery);
    	if(cust==null) {
    	     model.addAttribute("Notfound", searchQuery);
    	     return "searchcustomer";
    	}
    	cust.setPasskey(generateRandomNumber());
    	cr.save(cust);
    	model.addAttribute("customer", cust);
    	return "passkey";
	}
    
    
    @PostMapping("/verifyPasskey")
    public String verifypasskey(Model model,@RequestParam("userpass") String userpass,
    		                             @RequestParam("usernumber") String usernumber,
    		                             @RequestParam("amount") double amount,
    		                             @RequestParam("purchased") String purchased,
    		                             Principal principal) {
    	String name=principal.getName().toString();
    	boolean status= rs.verifyPasskey(usernumber,userpass,amount,name,purchased);
    	
    	if(status==true) {
    		
    		return "DebtAddedSucess";
    	}
    	
    	
    	return "/";
    }
    
    @GetMapping("/showDebts")
    public String showdebts(Principal principal,Model model) {
    	
    	String name=principal.getName().toString();
    	Long id=rs.getIdByusername(name);
    	double amount=0.0;
    	if (id != 0) {
            // Fetch debts related to this retailer
            List<Debt> debts = ds.findByRetailerId(id);
            for(Debt d:debts) {
            	amount +=d.getAmount();
            }
            model.addAttribute("debts", debts);
           model.addAttribute("totalamount",amount);
        }
    	return "ShowDebts";
    }
    
    @GetMapping("/raiseComplaint")
    public String raiseCompalint() {
    	return "RetailerComplaint";
    }


}
