<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="RetailerNavbar.jsp" %>



<%@page import="com.example.DIgitalLedgerApp.Models.Retailer"%>
<%
    // Assuming the Customers object is set as an attribute in the request or session
    Retailer retailer = (Retailer) request.getAttribute("Retailer");
    if (retailer == null) {
        response.sendRedirect("login.jsp"); // Redirect if customer is not logged in
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            padding: 20px;
        }
        .profile-card {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        .profile-card h2 {
            margin-top: 0;
        }
        .profile-card p {
            margin: 8px 0;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="profile-card">
            <h2>Retailer Profile</h2>
            <p><strong>UserName:</strong> <%= retailer.getName() %></p>
            <p><strong>Email:</strong> <%= retailer.getEmail() %></p>
            <p><strong>ShopName:</strong> <%= retailer.getShopname() %></p>
            <p><strong>Phone Number:</strong> <%= retailer.getMobile() %></p>
            <p><strong>Address:</strong> <%= retailer.getShopAddress() %></p>
            <p><strong>Description:</strong> <%= retailer.getDescription() %></p>
        </div>
    </div>
</body>
</html>
    