package com.example.DIgitalLedgerApp.Controllers;



import java.security.Principal;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.ServiceLayer.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	CustomerService cs;
	
	
	
	@GetMapping("/")
	public String home() {
		return "publicHome";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginpage";
	}
	
	
	
//	@PostMapping("/registerCustomer")
//	public String addcust1(Customers cust) {
//		cs.addCustomer(cust);
//		return "about";
//	}
	
	@GetMapping("/addcustomer")
	public String addcust(Customers cust) {
		return "register1";
	}
	
	
	
	 @PostMapping("/registerCustomer")
	    public String registerCustomer(
	            @RequestParam String name,
	            @RequestParam String email,
	            @RequestParam String mobileNumber,
	            @RequestParam String password,
	            @RequestParam String passkey,
	            @RequestParam String address) {

	        Customers customer = new Customers();
	        customer.setUsername(name);
	        customer.setEmail(email);
	        customer.setMobileNumber(mobileNumber);
	        customer.setPassword(password);
	        customer.setPasskey(passkey);
	        customer.setAddress(address);

	        cs.addCustomer(customer);

	        return "redirect:/about"; 
	    }
	
	
	
	
//	@RequestMapping("/cutomerlogin")
//	public Principal custlogin(Principal customer) {
//		return customer;
//	}
//	
//	@RequestMapping("/retailerlogin")
//	public Principal retaillogin(Principal retailer) {
//		return retailer;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/register")
	public String chooseRegister() {
		return "chooseRegister";
	}
	@GetMapping("/customerRegister")
	public String CustomerRegister() {
		return "CustomerRegister";
	}
	@GetMapping("/retailerRegister")
	public String retailerRegister() {
		return "RetailerRegister";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

}

