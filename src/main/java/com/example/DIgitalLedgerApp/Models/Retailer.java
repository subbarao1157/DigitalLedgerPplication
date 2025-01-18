package com.example.DIgitalLedgerApp.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String shopname;
    private String description;
    private String mobile;
    private String password;
    private String shopAddress;

    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL)
    private List<Debt> debts;
    
    


	public Retailer() {
		super();
	}

	

	public Retailer(Long id, String name, String email, String shopname, String description, String mobile,
			String password, String shopAddress, List<Debt> debts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.shopname = shopname;
		this.description = description;
		this.mobile = mobile;
		this.password = password;
		this.shopAddress = shopAddress;
		this.debts = debts;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public List<Debt> getDebts() {
		return debts;
	}

	public void setDebts(List<Debt> debts) {
		this.debts = debts;
	}
    
    
    

    // Getters and Setters
}