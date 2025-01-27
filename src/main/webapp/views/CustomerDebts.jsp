<%@page import="java.util.List"%>
<%@page import="com.example.DIgitalLedgerApp.Models.Debt"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="customerNavbar.jsp" %>
<%
    List<Debt> debts = (List<Debt>) request.getAttribute("debts");
    double totalAmount = (request.getAttribute("totalamount") != null) ? (double) request.getAttribute("totalamount") : 0.0;
%>

<!DOCTYPE html>
<html>
<head>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>

    <title>Customer Debts</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Total Debt : ₹<%= String.format("%.2f", totalAmount) %></h1>
    <table>
        <thead>
            <tr>
                <th>Retailer</th>
                <th>Amount</th>
                <th>Payment</th>
            </tr>
        </thead>
        <tbody>
            <% if (debts != null) { 
                for (Debt debt : debts) { 
                    if (debt.getAddedAt() != null) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
                        String formattedDate = debt.getAddedAt().format(formatter);
            %>
                <tr>
                    <td>
                        <%= debt.getRetailer().getName() %> <br>
                        <p>Shop Name: <%= debt.getRetailer().getShopname() %></p>
                        <p>Proprietor Mobile: <%= debt.getRetailer().getMobile() %></p>
                    </td>
                    <td>
                        ₹<%= debt.getAmount() %> <br>
                        <p>Purchased: <%= debt.getPurchaseditems() %></p>
                        <p><%= formattedDate %> </p></p>
                    </td>
                    <td>
                        <button class="pay-btn" 
                                data-amount="<%= (int) (debt.getAmount() ) %>" 
                                data-name="<%= debt.getRetailer().getShopname() %>" 
                                data-email="<%= debt.getCustomer().getEmail() %>"
                                data-debtid="<%= debt.getId() %>">Tap To Pay</button>
                    </td>
                </tr>
            <% } 
                } 
            } %>
        </tbody>
    </table>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const payButtons = document.querySelectorAll('.pay-btn');

            payButtons.forEach(button => {
                button.addEventListener('click', async function () {
                    const amount = parseInt(this.getAttribute('data-amount'), 10); // Ensure integer
                    const name = this.getAttribute('data-name');
                    const email = this.getAttribute('data-email');
                    const did = this.getAttribute('data-debtid');
                    this.disabled = true; // Disable button during processing

                    try {
                        const order = await createOrder(name, email, amount,did);
                        

                        const options = {
                            "key": "rzp_test_XbynXsiUnj6nbC", // your Razorpay key id
                            "amount": order.amount,
                            "currency": "INR",
                            "name": name,
                            "description": "Payment for Debt",
                            "order_id": order.razorpayDebtId,
                            "callback_url": "http://localhost:2005/customer/paymentCallback",
                            "prefill": {
                                "name": name,
                                "email": email
                            },
                            "theme": {
                                "color": "#339900"
                            }
                        };

                        const rzp1 = new Razorpay(options);
                        rzp1.open();

                    } catch (error) {
                        alert("Failed to create order or process payment. Please try again.");
                        console.error(error);
                    } finally {
                        this.disabled = false; // Re-enable button after processing
                    }
                });
            });
        });

        async function createOrder(name, email, amount,did) {
            try {
                const response = await fetch("http://localhost:2005/customer/createOrder", {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        name: name,
                        email: email,
                        amount: amount,
                        did:did
                    })
                });

                if (!response.ok) {
                    console.error("Server Error:", response.status, response.statusText);
                    throw new Error("Failed to create order. Server responded with status " + response.status);
                }

                const data = await response.json();
                console.log("Order created successfully:", data); // Debug log
                return data;
            } catch (error) {
                console.error("Error in createOrder:", error);
                throw error;
            }
        }

    </script>
</body>
</html>
