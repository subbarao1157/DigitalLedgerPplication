package com.example.DIgitalLedgerApp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    
    @ManyToOne
    @JoinColumn(name = "retailer_id")
    private Retailer retailer;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    private String purchaseditems;
    
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime addedAt;
    
    @OneToOne
    @JoinColumn(name="PaymentStatus")
	private DebtPayments PaymentStatus;
    
    

   

    public Debt(Long id, double amount, Retailer retailer, Customers customer, String purchaseditems,
			LocalDateTime addedAt) {
		super();
		this.id = id;
		this.amount = amount;
		this.retailer = retailer;
		this.customer = customer;
		this.purchaseditems = purchaseditems;
		this.addedAt = addedAt;
	}

	public Debt() {
        super();
    }

    @PrePersist
    protected void onCreate() {
        this.addedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

	public String getPurchaseditems() {
		return purchaseditems;
	}

	public void setPurchaseditems(String purchaseditems) {
		this.purchaseditems = purchaseditems;
	}
	public void setPaymentStatus(DebtPayments paymentStatus) {
        this.PaymentStatus = paymentStatus;
        if (PaymentStatus != null) {
        	PaymentStatus.setDebt(this); // Ensure bidirectional consistency
        }
    }

	public DebtPayments getPaymentStatus() {
		return PaymentStatus;
	}
	
    
}
