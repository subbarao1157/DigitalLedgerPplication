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
    <table>
        <thead>
            <tr>
                <th>Retailer</th>
                <th>Amount</th>
                <th>Payment Status</th>
            </tr>
        </thead>
        <tbody>
            <% if (debts != null) { 
                for (Debt debt : debts) { 
                    if (debt.getPaymentStatus() != null && 
                        "PAYMENT DONE".equals(debt.getPaymentStatus().getDebtStatus()) && 
                        debt.getAddedAt() != null) {

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
                        <p><%= formattedDate %></p>
                    </td>
                    <td>
                        <p><%= debt.getPaymentStatus().getDebtStatus() %></p>
                    </td>
                </tr>
            <% 
                    } 
                } 
            } %>
        </tbody>
    </table>
</body>
</html>
