package com.example.DIgitalLedgerApp.ServiceLayer;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.DIgitalLedgerApp.Models.Debt;
import com.example.DIgitalLedgerApp.Models.DebtPayments;
import com.example.DIgitalLedgerApp.Repos.DebtRepo;
import com.example.DIgitalLedgerApp.Repos.PaymentRepository;
import com.nimbusds.jose.shaded.gson.JsonObject;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.annotation.PostConstruct;

@Service
public class PaymentServiceLayer {

	@Autowired
	private PaymentRepository pr;
	
	@Autowired
	private DebtRepo dr;
	
	@Value("${razorpay.key.id}")
	private String razorpayId;
	@Value("${razorpay.key.secret}")
	private String razorpaySecret;
	
	private RazorpayClient razorpayclient;
	
	@PostConstruct
	public void init() throws RazorpayException {
		this.razorpayclient=new RazorpayClient(razorpayId, razorpaySecret);
	}
	
	public DebtPayments createOrder(DebtPayments dp) throws RazorpayException {
	    JSONObject options = new JSONObject();
	    options.put("amount", dp.getAmount() * 100); // Amount in paise
	    options.put("currency", "INR");
	    options.put("receipt", dp.getEmail());

	    try {
	        Order razorpayOrder = razorpayclient.orders.create(options);

	        if (razorpayOrder != null) {
	            System.out.println("Razorpay Order Created: " + razorpayOrder.toString()); // Debug log
	            
	            dp.setRazorpayDebtId(razorpayOrder.get("id")); // Set Razorpay Order ID
	            dp.setDebtStatus(razorpayOrder.get("status")); // Set Razorpay Order Status
	        } else {
	            throw new RazorpayException("Failed to create Razorpay order.");
	        }
	        pr.save(dp);
	        Debt d1=dr.getById(dp.getDid());
	        d1.setPaymentStatus(dp);
	        dr.save(d1);
	        return  pr.save(dp); // Save to database
	        
	    } catch (RazorpayException e) {
	        System.err.println("Error creating Razorpay order: " + e.getMessage());
	        throw e; // Re-throw exception to indicate failure
	    } catch (Exception ex) {
	        System.err.println("General error in createOrder: " + ex.getMessage());
	        throw new RuntimeException("Internal server error in payment processing.");
	    }
	}

	public DebtPayments updateStatus(Map<String, String> map) {
	    String razorpayId = map.get("razorpay_order_id");

	    // Fetch the order using the Razorpay debt ID
	    DebtPayments order = pr.findByRazorpayDebtId(razorpayId);

	    // Handle the case where no matching record is found
	    if (order == null) {
	        throw new IllegalArgumentException("No order found with Razorpay ID: " + razorpayId);
	    }

	    // Update the debt status
	    order.setDebtStatus("PAYMENT DONE");
	    
	    // Save the updated order to the database
	    return pr.save(order);
	}


	
	
	
	
}
