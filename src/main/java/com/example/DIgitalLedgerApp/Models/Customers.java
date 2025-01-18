package com.example.DIgitalLedgerApp.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

	private String email;
    private String mobileNumber; // New field for search functionality
    private String password;
    private String passkey;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Debt> debts;
   
    
    
    public Customers() {
    	super();
	}

	public Customers(Long id, String username, String email, String mobileNumber, String password,String passkey,String address, List<Debt> debts) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.passkey=passkey;
		this.address=address;
		this.debts = debts;
		
	}

    public Long getId() {
    	return id;
    }
	public void setId(Long id) {
    	this.id = id;
    }
    
  
   
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getMobileNumber() {
    	return mobileNumber;
    }
    
    public void setMobileNumber(String mobileNumber) {
    	this.mobileNumber = mobileNumber;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    
    public String getPasskey() {
		return passkey;
	}

	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Debt> getDebts() {
    	return debts;
    }
    
    public void setDebts(List<Debt> debts) {
    	this.debts = debts;
    }
}
