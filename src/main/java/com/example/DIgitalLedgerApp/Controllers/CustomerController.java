package com.example.DIgitalLedgerApp.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DIgitalLedgerApp.Models.Customers;
import com.example.DIgitalLedgerApp.ServiceLayer.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	
	
	@GetMapping("/")
	public String custhome() {
		return "customerHome";
	}
	
	
	@GetMapping("/profile")
	public String profile(Model model,Principal principal,Authentication auth) {
		String username=principal.getName().toString();
		
		if(checknumber(username)) {
			DefaultOAuth2User user=(DefaultOAuth2User)auth.getPrincipal();
			String email=user.getAttribute("email");
			Customers cust1=cs.getbyemail(email);
			model.addAttribute("customer",cust1);
			return "profile";

		}
		else {
		Customers cust=cs.getCustomersByusername(username);
		model.addAttribute("customer",cust);
		System.out.println(principal.getName().toString() +" logged in");
		return "profile";
		}
	}
	
	private boolean checknumber(String str) {
		// TODO Auto-generated method stub
		 for (char c : str.toCharArray())
		    {
		        if (!Character.isDigit(c)) return false;
		    }
		    return true;
	}


	@GetMapping("/issue")
	public String issue() {
		return "Issue";
	}

}
