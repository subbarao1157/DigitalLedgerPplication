package com.example.DIgitalLedgerApp.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class DebtPayments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer debtId;
	private String name;
	private String email;
	private Integer amount;
	private String debtStatus;
	private String razorpayDebtId;
	private Long did;
	
	@OneToOne(mappedBy = "PaymentStatus",cascade = CascadeType.ALL)
	private Debt debt;

	public DebtPayments(Integer debtId, String name, String email, Integer amount, String debtStatus,
			String razorpayDebtId, Debt debt) {
		super();
		this.debtId = debtId;
		this.name = name;
		this.email = email;
		this.amount = amount;
		this.debtStatus = debtStatus;
		this.razorpayDebtId = razorpayDebtId;
		this.debt = debt;
		
	}

	public DebtPayments() {
		super();
	}

	public Integer getDebtId() {
		return debtId;
	}

	public void setDebtId(Integer debtId) {
		this.debtId = debtId;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDebtStatus() {
		return debtStatus;
	}

	public void setDebtStatus(String debtStatus) {
		this.debtStatus = debtStatus;
	}

	public String getRazorpayDebtId() {
		return razorpayDebtId;
	}

	public void setRazorpayDebtId(String razorpayDebtId) {
		this.razorpayDebtId = razorpayDebtId;
	}

	public Debt getDebt() {
		return debt;
	}

	public void setDebt(Debt debt) {
		this.debt = debt;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}
	
	
	
}
