package com.example.DIgitalLedgerApp.Controllers;



import java.security.Principal;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.Models.LoggingUsers;
import com.example.DIgitalLedgerApp.Models.Retailer;
import com.example.DIgitalLedgerApp.ServiceLayer.CustomerService;
import com.example.DIgitalLedgerApp.ServiceLayer.LoggingUserService;
import com.example.DIgitalLedgerApp.ServiceLayer.RetailerService;


@Controller
public class HomeController {
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	RetailerService rs;
	
	@Autowired
	LoggingUserService lus;
	
	
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
		return "CustomerRegister";
	}
	
	
	
	 @PostMapping("/registerCustomer")
	    public String registerCustomer(
	            @RequestParam String username,
	            @RequestParam String email,
	            @RequestParam String mobileNumber,
	            @RequestParam String password,
	            @RequestParam String passkey,
	            @RequestParam String address) {
		 
		 BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(7);
		 String encodedpassword=encoder.encode(password);

	        Customers customer = new Customers();
	        customer.setUsername(username);
	        customer.setEmail(email);
	        customer.setMobileNumber(mobileNumber);
	        
	        customer.setPassword(encodedpassword);
	        customer.setPasskey(passkey);
	        customer.setAddress(address);
	        
	         LoggingUsers lu=new LoggingUsers();
	         lu.setUsername(username);
	         lu.setPassword(encodedpassword);
	         lu.setRole("ROLE_CUSTOMER");
	         lus.addLoggingUser(lu);        
	         cs.addCustomer(customer);

	        return "redirect:/login"; 
	    }
	
	 
	 @PostMapping("/registerRetailer")
	    public String registerRetailer(
	            @RequestParam String name,
	            @RequestParam String email,
	            @RequestParam String shopname,
	            @RequestParam String description,
	            @RequestParam String mobile,
	            @RequestParam String password,
	            @RequestParam String shopAddress) {
		 BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(7);
		 String encodedpassword=encoder.encode(password);

	        Retailer retailer = new Retailer();
	        
	        retailer.setName(name);
	        retailer.setEmail(email);
	        retailer.setShopname(shopname);
	        retailer.setDescription(description);
	        retailer.setMobile(mobile);
	        retailer.setPassword(encodedpassword);
	        retailer.setShopAddress(shopAddress);
	        
	        LoggingUsers lu=new LoggingUsers();
	         lu.setUsername(name);
	         lu.setPassword(encodedpassword);
	         lu.setRole("ROLE_RETAILER");
	         lus.addLoggingUser(lu);     
	        
	        rs.addRetailer(retailer);

	        return "redirect:/login"; 
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