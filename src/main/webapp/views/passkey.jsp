<%@page import="com.example.DIgitalLedgerApp.Models.Customers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="RetailerNavbar.jsp" %>
<%
    // Assuming the Customers object is set as an attribute in the request or session
    Customers customer = (Customers) request.getAttribute("customer");
   
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
        </div>
        <form action="verifyPasskey" method="POST" style="display: flex; flex-direction: column; align-items: center;">
            <input type="text" name="userpass" placeholder="Enter pass key" required style="padding: 10px; font-size: 16px; margin-bottom: 10px; width: 300px; border-radius: 5px; border: 1px solid #ccc;">
            <input type="text" name="amount" placeholder="Enter Amount" required style="padding: 10px; font-size: 16px; margin-bottom: 10px; width: 300px; border-radius: 5px; border: 1px solid #ccc;"> 
            <input type="hidden" name="usernumber" value=<%= customer.getMobileNumber() %> />
            <button type="submit" style="padding: 10px 20px; font-size: 16px; cursor: pointer; background-color: #007BFF; color: white; border: none; border-radius: 5px;">Verify</button>
        </form>
    </div>
</body>
</html>
    