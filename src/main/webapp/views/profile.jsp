<%@page import="com.example.DIgitalLedgerApp.Models.Customers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="customerNavbar.jsp" %>
<%
    // Assuming the Customers object is set as an attribute in the request or session
    Customers customer = (Customers) request.getAttribute("customer");
    if (customer == null) {
        response.sendRedirect("login"); // Redirect if customer is not logged in
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
            <h2>Customer Profile</h2>
            <p><strong>UserName Name:</strong> <%= customer.getUsername() %></p>
            <p><strong>Email:</strong> <%= customer.getEmail() %></p>
            <p><strong>Phone Number:</strong> <%= customer.getMobileNumber() %></p>
            <p><strong>Address:</strong> <%= customer.getAddress() %></p>
            <% if (customer.getPasskey() != null && !customer.getPasskey().isEmpty()) { %>
                <p><strong>Pass Key:</strong> <%= customer.getPasskey() %></p>
            <% } %>
        </div>
    </div>
</body>
</html>
    